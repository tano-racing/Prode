package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Usuarios")
public class Usuario extends Model {

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "idUsuario")
    public String idUsuario;

    @Column(name = "idRemoto")
    public int idRemoto;

    public Usuario() {
        super();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRemoto() {
        return idRemoto;
    }

    public void setIdRemoto(int idRemoto) {
        this.idRemoto = idRemoto;
    }

    public static Usuario getUsuario(String fbid) {
        return new Select()
                .from(Usuario.class)
                .where("idUsuario = ?", fbid)
                .executeSingle();
    }
}
