package nofuemagia.prode.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@DatabaseTable(tableName = "Paises")
public class Pais {

    @DatabaseField(generatedId = true)
    private long idPais;

    @DatabaseField
    public String nombre;

    public Pais() {
        super();
    }

    public Pais(String nombre) {
        super();
        this.nombre = nombre;
    }

    public long getIdPais() {
        return idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public static List<Pais> getPaises() {
        return new Select()
                .from(Pais.class)
                .execute();
    }

    public static Pais getPais(String nombre) {
        return new Select()
                .from(Pais.class)
                .where("nombre = ?", nombre)
                .executeSingle();
    }
}