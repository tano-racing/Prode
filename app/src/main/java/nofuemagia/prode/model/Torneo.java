package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Torneos")
public class Torneo extends Model {

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "ligaId")
    public Liga liga;

    @Column(name = "creadorId")
    public Usuario usuario;

    @Column(name = "sincronizado")
    public int sincronizado;

    public Torneo() {
        super();
    }

    public Torneo(String nombre, Liga liga, Usuario usuario, int sincronizado) {
        this.nombre = nombre;
        this.liga = liga;
        this.usuario = usuario;
        this.sincronizado = sincronizado;
    }

    public String getNombre() {
        return nombre;
    }

    public Liga getLiga() {
        return liga;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int isSincronizado() {
        return sincronizado;
    }

    public static List<Torneo> getTorneos(Usuario fbid) {
        // TODO LOS TORNEOS MIOS Y LOS QUE PARTICIPO

        return new Select()
                .from(Torneo.class)
                .where("creadorId = ?", fbid.getId())
                .execute();
    }
}
