package nofuemagia.prode.activities;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.Util;
import nofuemagia.prode.adapters.EquiposAdapter;
import nofuemagia.prode.model.Equipo;
import nofuemagia.prode.model.Liga;
import nofuemagia.prode.model.Pais;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);

            ActionBar actionBar = getActionBar();
            if (actionBar != null)
                actionBar.hide();
        }
    }

    public void iniciarSesion(View v) {
        if (v.getId() == R.id.btn_facebook) {
            System.out.println(getString(R.string.iniciar_sesion_con_facebook));
        } else if (v.getId() == R.id.btn_google) {
            System.out.println(getString(R.string.iniciar_sesion_con_facebook));
        } else if (v.getId() == R.id.btn_twitter) {
            System.out.println(getString(R.string.iniciar_sesion_con_facebook));
        }


        //TODO: EN EL CALLBACK MOSTRAR LA LISTA DE EQUIPOS
        mostrarListaEquipos();
    }

    private void mostrarListaEquipos() {

        Pais argentina = Pais.getPais("Argentina");
        Liga primera = Liga.getLiga(argentina, "Primera Division");
        List<Equipo> equipos = Equipo.getEquipos(primera);

        final EquiposAdapter adapter = new EquiposAdapter(this, equipos);
//        CharSequence[] equiposStrings = new CharSequence[equipos.size()];
//
//        for (int i = 0; i < equipos.size(); i++)
//            equiposStrings[i] = equipos.get(i).getNombre();

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("¿De que cuadro sos hincha?")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Equipo equipo = adapter.getItem(i);
                        guardarInformacion("0123456789", "Julián Patricio Lionti", equipo.getId().intValue());
                        iniciarProde();
                    }
                })
                .show();


    }

    private void iniciarProde() {
        finish();
        Intent intent = new Intent(IniciarSesion.this, PantallaPrincipal.class);
        startActivity(intent);
    }

    private void guardarInformacion(String id, String nombre, int idEquipo) {
        SharedPreferences preferences = getSharedPreferences(Util.PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Util.FBID, id);
        editor.putString(Util.NOMBRE, nombre);
        editor.putInt(Util.EQUIPO, idEquipo);
        editor.putBoolean(Util.TODO_LISTO, true);
        editor.apply();
    }
}
