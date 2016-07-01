package nofuemagia.prode.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */

@DatabaseTable(tableName = "Equipos")
public class Equipo {

    @DatabaseField(generatedId = true)
    private long idEquipo;

    @DatabaseField
    public String nombre;

    @DatabaseField
    public Liga liga;

    public Equipo() {
        super();
    }

    public Equipo(String nombre, Liga liga) {
        super();
        this.nombre = nombre;
        this.liga = liga;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Liga getLiga() {
        return liga;
    }

    public static List<Equipo> getEquipos(Liga liga) {
        return new Select()
                .from(Equipo.class)
                .where("ligaId = ?", liga.getId())
                .orderBy("nombre ASC")
                .execute();
    }
}
