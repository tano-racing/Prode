package nofuemagia.prode;

import android.content.Context;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
public class Util {
    public static final String PREFERENCES = "PRODE_NOFUEMAGIA";
    public static final String FBID = "FBID";
    public static final String NOMBRE = "NOMBRE";
    public static final String EQUIPO = "EQUIPO";
    public static final String TODO_LISTO = "TODO_LISTO";

    public static int getResId(Context c, String resName, String pResourcename) {

        return c.getResources().getIdentifier(resName, pResourcename, c.getPackageName());

//        try {
//            Field idField = c.getDeclaredField(resName);
//            return idField.getInt(idField);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return -1;
//        }
    }
}
