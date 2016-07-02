package nofuemagia.prode.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jlionti on 01/07/2016. No Fue Magia
 */
@Table(name = "Usuarios")
public class Usuario extends Model {

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "idUsuario")
    public String idUsuario;

    public Usuario() {
        super();
    }

    public Usuario(String nombre, String idUsuario) {
        super();
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }
}
