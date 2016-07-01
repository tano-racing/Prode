package nofuemagia.prode;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.app.Application;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import nofuemagia.prode.model.Equipo;
import nofuemagia.prode.model.Liga;
import nofuemagia.prode.model.Pais;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        ActiveAndroid.initialize(this);
    }
}
