package nofuemagia.prode.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.Util;
import nofuemagia.prode.model.Liga;
import nofuemagia.prode.model.Torneo;
import nofuemagia.prode.model.Usuario;
import nofuemagia.prode.model.UsuarioTorneo;

/**
 * Created by Tano on 01/07/2016.
 */
public class SinTorneosFragment extends Fragment {

    private OnTorneoListener onTorneoListener;

    public interface OnTorneoListener {
        void TorneoCreado(Long id);

        void Error(String mensaje);

        void UnidoAlTorneo(Long id);
    }

    private EditText etNombreTorneo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sin_torneos, container, false);

        Button btnNuevo = (Button) v.findViewById(R.id.btn_nuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elegirLiga(view);
            }
        });
        Button btnUnirse = (Button) v.findViewById(R.id.btn_unirse);
        btnUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unirseLiga(view);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onTorneoListener = (OnTorneoListener) context;
    }

    public void elegirLiga(View v) {

        final List<Liga> ligas = Liga.getTodas();
        CharSequence[] ligasStrings = new CharSequence[ligas.size()];

        for (int i = 0; i < ligas.size(); i++)
            ligasStrings[i] = String.format("%s (%s)", ligas.get(i).getNombre(), ligas.get(i).getPais().getNombre());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Nuevo Torneo")
                .setIcon(new IconDrawable(getContext(), FontAwesomeIcons.fa_plus).colorRes(R.color.colorAccent).actionBarSize())
                .setItems(ligasStrings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View mView = inflater.inflate(R.layout.dialog_nombre_torneo, null);
                        etNombreTorneo = (EditText) mView.findViewById(R.id.et_nombre_torneo);
                        etNombreTorneo.setTag(ligas.get(i));

                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
                        builder.setTitle("Nuevo Torneo")
                                .setView(mView)
                                .setIcon(new IconDrawable(getContext(), FontAwesomeIcons.fa_plus).colorRes(R.color.colorAccent).actionBarSize())
                                .setPositiveButton(android.R.string.ok, torneoClick)
                                .show();
                    }
                })
                .show();
    }

    private DialogInterface.OnClickListener torneoClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            System.out.println(etNombreTorneo.getText().toString());
            GuardarTorneo((Liga) etNombreTorneo.getTag(), etNombreTorneo.getText().toString());
        }
    };

    private void GuardarTorneo(Liga liga, String nombreTorneo) {

        SharedPreferences preferences = getContext().getSharedPreferences(Util.PREFERENCES, Context.MODE_PRIVATE);

        Usuario actual = Usuario.getUsuario(preferences.getString(Util.FBID, null));

        ActiveAndroid.beginTransaction();

        Torneo nuevo = new Torneo();
        nuevo.setLiga(liga);
        nuevo.setNombre(nombreTorneo);
        nuevo.setUsuario(actual);
        nuevo.setSincronizado(0);
        nuevo.save();

        UsuarioTorneo participante = new UsuarioTorneo();
        participante.setUsuario(actual);
        participante.setTorneo(nuevo);
        participante.setPuntos(0);
        participante.setPronosticosAcertados(0);
        participante.setPronosticosTotales(0);
        participante.save();

        if (participante.getId() != -1) {
            ActiveAndroid.setTransactionSuccessful();
            ActiveAndroid.endTransaction();

            onTorneoListener.TorneoCreado(nuevo.getId());
        } else {
            onTorneoListener.Error("Error desconocido");
        }
    }

    private void unirseLiga(View view) {
        onTorneoListener.UnidoAlTorneo(0L);
    }
}
