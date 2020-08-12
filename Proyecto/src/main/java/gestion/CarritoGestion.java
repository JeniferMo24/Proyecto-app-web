
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
    
    
    
    private static final String SQL_SELECT_CARRITO= 
            "select tbCarrito.cantidadcantidadCarrito,tbProducto.nombreProducto,tbProducto.precio,tbCarrito.total from tbCarrito,tbProducto where tbProducto.idProducto=tbCarrito.idProducto_FK";
    public static ArrayList<Carrito> getCarrito() {
        ArrayList<Carrito> lista = new ArrayList<>();        
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_CARRITO);            
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Carrito(
                                datos.getInt(1), 
                                datos.getString(2), 
                                datos.getInt(3), 
                                datos.getInt(4))       
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }
    private static final String SQL_INSERT_CARRITO
            = "insert into tbCarrito(idProducto_FK) values (?) where tbProducto.idProducto=?";

    //Retorna true si logra insertar el proveedor, false si no lo logra
    public static boolean insertar(Carrito carrito) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_CARRITO);
            sentencia.setInt(1, carrito.getCantidadCarrito());
            sentencia.setInt(3, carrito.getTotal());
            int fila = sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila > 0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }



    private static final String SQL_DELETE_PRODUCTO
            = "delete from tbProducto where nombreProducto=?";

    //Retorna true si logra eliminar el producto, false si no lo logra
    public static boolean eliminar(Producto producto) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_PRODUCTO);
            sentencia.setString(1, producto.getNombreProducto());
            int fila = sentencia.executeUpdate(); //Retorna la cantidad de filas eliminadas
            return fila > 0;  //retorna true si lo modificó
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
            Logger.getLogger(ProductoVentaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
        
    }
    
    
}










