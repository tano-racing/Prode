package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "UsuarioTorneo")
public class UsuarioTorneo extends Model {

    @Column(name = "usuarioId")
    public Usuario usuario;

    @Column(name = "torneoId")
    public Torneo torneo;

    @Column(name = "puntos")
    public int puntos;

    @Column(name = "pronosticosAcertados")
    public int pronosticosAcertados;

    @Column(name = "pronosticosTotales")
    public int pronosticosTotales;


    public UsuarioTorneo() {

    }

    public UsuarioTorneo(Usuario usuario, Torneo torneo) {
        this.usuario = usuario;
        this.torneo = torneo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPronosticosAcertados(int pronosticosAcertados) {
        this.pronosticosAcertados = pronosticosAcertados;
    }

    public void setPronosticosTotales(int pronosticosTotales) {
        this.pronosticosTotales = pronosticosTotales;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPronosticosAcertados() {
        return pronosticosAcertados;
    }

    public int getPronosticosTotales() {
        return pronosticosTotales;
    }

    public static List<UsuarioTorneo> getParticipantes(Long id) {
        return new Select().from(UsuarioTorneo.class).where("torneoId = ?", id).execute();
    }
}
