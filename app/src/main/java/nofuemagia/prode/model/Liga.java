package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@DatabaseTable(tableName = "Equipos")
public class Liga {

    @DatabaseField(generatedId = true)
    private long idLiga;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public Pais pais;

    public Liga() {
        super();
    }

    public Liga(String nombre, Pais pais) {
        super();
        this.nombre = nombre;
        this.pais = pais;
    }

    public long getIdLiga() {
        return idLiga;
    }

    public String getNombre() {
        return nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public static List<Liga> getTodas() {
        return new Select()
                .from(Liga.class)
                .execute();
    }

    public static Liga getLiga(Pais pais, String nombre) {
        return new Select()
                .from(Liga.class)
                .where("nombre = ? AND paisId = ?", nombre, pais.getIdPais())
                .executeSingle();
    }
}
