package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

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
    public boolean sincronizado;

    public Torneo() {
        super();
    }

    public Torneo(String nombre, Liga liga, Usuario usuario, boolean sincronizado) {
        this.nombre = nombre;
        this.liga = liga;
        this.usuario = usuario;
        this.sincronizado = sincronizado;
    }
}
