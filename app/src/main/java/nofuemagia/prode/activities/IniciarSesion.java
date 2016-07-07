package nofuemagia.prode.activities;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import nofuemagia.prode.R;
import nofuemagia.prode.Util;
import nofuemagia.prode.adapters.EquiposAdapter;
import nofuemagia.prode.model.Equipo;
import nofuemagia.prode.model.Liga;
import nofuemagia.prode.model.Pais;
import nofuemagia.prode.model.Usuario;
import nofuemagia.prode.sync.SyncAdapter;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("¿De que cuadro sos hincha?")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Equipo equipo = adapter.getItem(i);

                        dialogInterface.dismiss();
                        guardarInformacion("0987654321", "Otro usuario", equipo.getId().intValue());
                    }
                })
                .show();


    }

    private void iniciarProde() {
        finish();
        Intent intent = new Intent(IniciarSesion.this, PantallaPrincipal.class);
        startActivity(intent);
    }

    private void guardarInformacion(final String id, final String nombre, final int idEquipo) {
        final ProgressDialog dialog = ProgressDialog.show(this, getString(R.string.app_name), getString(R.string.creando_usuario), false);
        dialog.setProgress(0);

        RequestParams params = new RequestParams();
        params.put("nombre", nombre);
        params.put("idUsuario", id);

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Util.URL + Util.URL_USUARIOS, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {
                    int idRemoto = response.getInt("idRemoto");

                    Usuario actual = new Usuario();
                    actual.setNombre(nombre);
                    actual.setIdUsuario(id);
                    actual.setIdRemoto(idRemoto);
                    actual.save();

                    SharedPreferences preferences = getSharedPreferences(Util.PREFERENCES, MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(Util.FBID, id);
                    editor.putString(Util.NOMBRE, nombre);
                    editor.putInt(Util.EQUIPO, idEquipo);
                    editor.putBoolean(Util.TODO_LISTO, true);
                    editor.apply();

                    dialog.dismiss();

                    iniciarProde();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println(responseString);
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                dialog.setMax((int) totalSize);
                dialog.setProgress((int) bytesWritten);
            }
        });
    }
}
