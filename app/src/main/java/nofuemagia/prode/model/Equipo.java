package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Equipos", id = "idEquipo")
public class Equipo extends Model {

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "ligaId")
    public Liga liga;

    public Equipo() {
        super();
    }

    public Equipo(String nombre, Liga liga) {
        super();
        this.nombre = nombre;
        this.liga = liga;
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
