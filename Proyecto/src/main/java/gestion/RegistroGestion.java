
package gestion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Registro;



public class RegistroGestion {
    private static final String SQL_INSERT_USUARIO=
            "insert into tbUsuario(idUsuario,clave,nombre,telefono,correo) values (?,?,?,?,?)";
    public static boolean insertar(Registro registro) {        
        try {
            PreparedStatement sentencia =            
                    Conexion.getConexion().prepareStatement(SQL_INSERT_USUARIO);
            sentencia.setString(1,registro.getClave());
            sentencia.setString(2,registro.getIdUsuario());
            sentencia.setString(3,registro.getNombre());
            sentencia.setString(4,registro.getTelefono());
            sentencia.setString(5,registro.getCorreo());
            
            int fila=sentencia.executeUpdate(); 
            return fila>0;  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
}
