
package gestion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Sugerencia;

public class SugerenciaGestion {
    private static final String SQL_INSERT_SUGERENCIA=
            "insert into tbSugerencia (asunto,descripcionSu,idUsuario_FK) values (?,?,?)";
    public static boolean insertar(Sugerencia sugerencia) {        
        try {
            PreparedStatement sentencia =            
                    Conexion.getConexion().prepareStatement(SQL_INSERT_SUGERENCIA);
            sentencia.setString(1,sugerencia.getAsunto());
            sentencia.setString(2,sugerencia.getDescripcionSu());
            sentencia.setString(3,sugerencia.getIdUsuario_FK());
            int fila=sentencia.executeUpdate();  
            return fila>0; 
        } catch (SQLException ex) {
            Logger.getLogger(SugerenciaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
}
