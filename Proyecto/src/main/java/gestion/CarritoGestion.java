
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrito;
import model.Conexion;
import model.Producto;
import model.ProductoVenta;


public class CarritoGestion {
    
    
    
    private static final String SQL_INSERT_CARRITO=
            "insert into tbCarrito values (?,?,?,?,?,?,?)";
    //Retorna true si logra insertar el estudiante, false si no lo logra
    public static boolean insertar(Carrito carrito) {        
        try {
            PreparedStatement sentencia =            
                    Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITO);
            sentencia.setInt(1,carrito.getCantidadCarrito());
            sentencia.setString(2,carrito.getNombreProducto());
            sentencia.setInt(3,carrito.getPrecio());
            sentencia.setInt(4,carrito.getTotal()*carrito.getCantidadCarrito());
            sentencia.setInt(5,carrito.getIdProducto_FK());
            int fila=sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila>0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }
    
    
    
    
    private static final String SQL_INSERT_CARRITOS
            = "insert into tbCarrito(idProducto_FK) values (?)";

    //Retorna true si logra insertar el proveedor, false si no lo logra
    public static boolean edita(int idProducto) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITOS);
            sentencia.setInt(1, idProducto);

            int fila = sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila > 0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }


    

    private static final String SQL_SELECT_PRODUCTOS
            = "select nombreProducto from tbProducto where nombreProducto=?";
    public static ProductoVenta getProductoVenta(int idProducto) {
        ProductoVenta producto = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            sentencia.setInt(1, idProducto);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {  //Si entra al if... hay un proveedor...
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










