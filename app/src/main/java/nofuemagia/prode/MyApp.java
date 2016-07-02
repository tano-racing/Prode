package nofuemagia.prode;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.app.Application;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import nofuemagia.prode.model.Equipo;
import nofuemagia.prode.model.Liga;
import nofuemagia.prode.model.Pais;
import nofuemagia.prode.model.Torneo;
import nofuemagia.prode.model.Usuario;
import nofuemagia.prode.model.UsuarioTorneo;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        Configuration.Builder config = new Configuration.Builder(this);
        config.addModelClass(Equipo.class);
        config.addModelClass(Liga.class);
        config.addModelClass(Pais.class);
        config.addModelClass(Torneo.class);
        config.addModelClass(Usuario.class);
        config.addModelClass(UsuarioTorneo.class);
        ActiveAndroid.initialize(config.create());
    }
}
