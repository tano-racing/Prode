package nofuemagia.prode.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.Util;
import nofuemagia.prode.fragments.SinTorneosFragment;
import nofuemagia.prode.fragments.TorneoFragment;
import nofuemagia.prode.model.Torneo;
import nofuemagia.prode.model.Usuario;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class PantallaPrincipal extends AppCompatActivity implements SinTorneosFragment.OnTorneoListener {


    private SharedPreferences preferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        preferences = getSharedPreferences(Util.PREFERENCES, MODE_PRIVATE);

        if (!InicioSesion())
            return;

        Usuario actual = Usuario.getUsuario(preferences.getString(Util.FBID, null));
        List<Torneo> torneos = Torneo.getTorneos(actual);
        if (torneos != null && torneos.size() > 0) {
            PonerTorneoFrag(torneos.get(0).getId());
        } else {
            Fragment frag = Fragment.instantiate(this, SinTorneosFragment.class.getName(), null);

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.frag_container_principal, frag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    private boolean InicioSesion() {
        //TODO CHEQUEAR CONEXCION CON LAS REDES
        if (!preferences.getBoolean(Util.TODO_LISTO, false)) {
            finish();
            Intent intent = new Intent(PantallaPrincipal.this, IniciarSesion.class);
            startActivity(intent);
            return false;
        }

        return true;
    }


    @Override
    public void TorneoCreado(Long id) {
        PonerTorneoFrag(id);
    }

    @Override
    public void UnidoAlTorneo(Long id) {

    }

    private void PonerTorneoFrag(Long id) {
        Bundle args = new Bundle();
        args.putLong("ID", id);
        Fragment frag = Fragment.instantiate(this, TorneoFragment.class.getName(), args);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.frag_container_principal, frag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
