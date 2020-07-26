package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;

public class UsuarioGestion {

    private static final String SQL_SELECT_USUARIO = "select * from tbUsuario where idUsuario=?";

    public static Usuario valida(String idUsuario, String clave) {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIO);
            sentencia.setString(1, idUsuario);
            ResultSet rs = sentencia.executeQuery();
            if (rs != null && rs.next() && rs.getString(6).equals(clave)) {
                usuario = new Usuario(
                        idUsuario,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        clave);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
