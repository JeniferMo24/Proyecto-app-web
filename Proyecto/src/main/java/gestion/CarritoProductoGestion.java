
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CarritoProducto;
import model.Conexion;
import model.ProductoVenta;

public class CarritoProductoGestion {
    private static final String SQL_INSERT_CARRITOPRODUCTO
            = "insert into tbCarritoProducto (idProducto_FK,precio,nombre,cantidad) values (?,?,?,?)";
     private static final String SQL_INSERT_CARRITO
            = "insert into tbCarrito (idProducto,cantidad,precio,nombre) values (?,?,?,?)";
    public static boolean insertar(CarritoProducto carritoproducto) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITOPRODUCTO);
            sentencia.setInt(1, carritoproducto.getIdProducto_FK());
            sentencia.setInt(2, carritoproducto.getPrecio());
            sentencia.setString(3, carritoproducto.getNombre());
            sentencia.setInt(4, carritoproducto.getCantidad());
            int fila = sentencia.executeUpdate();
            PreparedStatement sentencia1 = Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITO);
            sentencia1.setInt(1,carritoproducto.getIdProducto_FK());
            sentencia1.setInt(2,carritoproducto.getCantidad());
            sentencia1.setInt(3,carritoproducto.getPrecio());
            
            
            return fila > 0;  
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }
    
     private static final String SQL_SELECT_PRODUCTOS
            = "select * from tbProducto where idProducto=?";

    public static ProductoVenta getProductoVenta(int idProducto) {
        ProductoVenta producto = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            sentencia.setInt(1, idProducto);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {  
                producto = new ProductoVenta(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getInt(6));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;

    }
}
