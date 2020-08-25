package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrito;
import model.CarritoProducto;
import model.Conexion;
import model.Producto;
import model.ProductoVenta;

public class CarritoGestion {

    private static final String SQL_INSERT_CARRITO
            = "insert into tbCarrito (cantidad,precio,nombre) values (?,?,?)";

    public static boolean insertar(Carrito carrito) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITO);
            sentencia.setInt(1, carrito.getCantidad());
            sentencia.setInt(2, carrito.getPrecio());
            sentencia.setString(3, carrito.getNombre());
            int fila = sentencia.executeUpdate();
            return fila > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_SELECT_PRODUCTOS
            = "select precio,nombre,cantidad from tbCarritoProducto where idProducto_FK=?";

    public static CarritoProducto getCarritoProducto(int idProducto_FK) {
        CarritoProducto carritoproducto = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            sentencia.setInt(1, idProducto_FK);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {  
                carritoproducto = new CarritoProducto(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carritoproducto;

    }

}
