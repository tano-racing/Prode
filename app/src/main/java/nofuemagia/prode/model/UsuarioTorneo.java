package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "UsuarioTorneo")
public class UsuarioTorneo extends Model {

    @Column(name = "usuarioId")
    public Usuario usuario;

    @Column(name = "torneoId")
    public Torneo torneo;

    public UsuarioTorneo() {

    }

    public UsuarioTorneo(Usuario usuario, Torneo torneo) {
        this.usuario = usuario;
        this.torneo = torneo;
    }
}
