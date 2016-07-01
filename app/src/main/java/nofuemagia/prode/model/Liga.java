package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Ligas", id="idLiga")
public class Liga extends Model {

    @Column(name = "idLiga")
    private long id;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "paisId")
    public Pais pais;

    public Liga() {
        super();
    }

    public Liga(String nombre, Pais pais) {
        super();
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    /*public Pais getPais() {
        return pais;
    }*/

    public static List<Liga> getTodas() {
        return new Select()
                .from(Liga.class)
                .execute();
    }

    public static Liga getLiga(Pais pais, String nombre) {
        return new Select()
                .from(Liga.class)
                .where("nombre = ? AND paisId = ?", nombre, pais.getId())
                .executeSingle();
    }
}
