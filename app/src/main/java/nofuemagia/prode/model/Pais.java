package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Paises")
public class Pais extends Model {

    @Column(name = "idPais")
    public long id;

    @Column(name = "nombre")
    public String nombre;

    public Pais() {
        super();
    }

    public Pais(String nombre) {
        super();
        this.nombre = nombre;
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