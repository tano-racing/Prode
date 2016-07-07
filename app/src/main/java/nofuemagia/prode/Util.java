package nofuemagia.prode;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class Util {
    public static final String PREFERENCES = "PRODE_NOFUEMAGIA";
    public static final String FBID = "FBID";
    public static final String NOMBRE = "NOMBRE";
    public static final String EQUIPO = "EQUIPO";
    public static final String TODO_LISTO = "TODO_LISTO";


    public static final String URL = "http://nofuemagia.ueuo.com/Prode/backend/";
    public static final String URL_USUARIOS = "usuarios/crearUsuario.php";
    public static final String URL_TORNEOS = "torneos/crearTorneo.php";


    public static int getResId(Context c, String resName, String pResourcename) {
        return c.getResources().getIdentifier(resName, pResourcename, c.getPackageName());
    }

    public static Account CreateSyncAccount(Context context) {
        Resources res = context.getResources();
        Account newAccount = new Account(res.getString(R.string.app_name), res.getString(R.string.account_type));
        AccountManager accountManager = (AccountManager) context.getSystemService(context.ACCOUNT_SERVICE);
        accountManager.addAccountExplicitly(newAccount, null, null); //boolean
        return newAccount;
    }

}
