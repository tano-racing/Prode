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

    @Column(name = "idRemoto")
    public int idRemoto;

    public Torneo() {
        super();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdRemoto(int idRemoto) {
        this.idRemoto = idRemoto;
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

    public int getIdRemoto() {
        return idRemoto;
    }

    public static List<Torneo> getTorneos(Usuario fbid) {
        // TODO LOS TORNEOS MIOS Y LOS QUE PARTICIPO

        return new Select()
                .from(Torneo.class)
                .where("creadorId = ?", fbid.getId())
                .execute();
    }
}
