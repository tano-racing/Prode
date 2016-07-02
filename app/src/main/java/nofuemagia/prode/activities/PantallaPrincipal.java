package nofuemagia.prode.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import nofuemagia.prode.R;
import nofuemagia.prode.Util;
import nofuemagia.prode.adapters.LigasAdapter;
import nofuemagia.prode.model.Liga;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class PantallaPrincipal extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        preferences = getSharedPreferences(Util.PREFERENCES, MODE_PRIVATE);

        revisarSiInicioSesion();

//        IconButton btnNuevo = (IconButton) findViewById(R.id.btn_nuevo);
//        btnNuevo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                elegirLiga(view);
//            }
//        });
//        IconButton btnUnirse = (IconButton) findViewById(R.id.btn_unirse);
    }

    private void revisarSiInicioSesion() {
        //TODO CHEQUEAR CONEXCION CON LAS REDES
        if (!preferences.getBoolean(Util.TODO_LISTO, false)) {
            finish();
            Intent intent = new Intent(PantallaPrincipal.this, IniciarSesion.class);
            startActivity(intent);
        }
    }

    public void elegirLiga(View v) {

        List<Liga> ligas = Liga.getTodas();

        final LigasAdapter adapter = new LigasAdapter(this, ligas);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Elegí una liga");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                /*Equipo equipo = adapter.getItem(which);
                guardarInformacion("0123456789", "Julián Patricio Lionti", equipo.getId().intValue());
                iniciarProde();*/
            }
        });
        builder.show();
    }
}
