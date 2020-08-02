
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Producto;

public class ProductoGestion {
    
    private static final String SQL_INSERT_PRODUCTO
            = "insert into tbProducto(nombreProducto,descripcionProducto,precio,cantidad,idCategoria_FK,idProveedor_FK,idUsuario_FK) values (?,?,?,?,?,?,?)";

    //Retorna true si logra insertar el proveedor, false si no lo logra
    public static boolean insertar(Producto producto) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_PRODUCTO);
            sentencia.setString(1, producto.getNombreProducto());
            sentencia.setString(2, producto.getDescripcionProducto());
            sentencia.setInt(3, producto.getPrecio());
            sentencia.setInt(4, producto.getCantidad());
            sentencia.setInt(5, producto.getIdCategoria_FK());
            sentencia.setInt(6, producto.getIdProveedor_FK());
            sentencia.setString(7, producto.getIdUsuario_FK());
            int fila = sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila > 0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }

    private static final String SQL_UPDATE_PRODUCTO
            = "update tbProducto set descripcionProducto=?, precio=?,"
            + "cantidad=?,idCategoria_FK=?, idProveedor_FK=?, idUsuario_FK=? where nombreProducto=?";

    //Retorna true si logra modificar el producto, false si no lo logra
    public static boolean modificar(Producto producto) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PRODUCTO);
            sentencia.setString(1, producto.getDescripcionProducto());
            sentencia.setInt(2, producto.getPrecio());
            sentencia.setInt(3, producto.getCantidad());
            sentencia.setInt(4, producto.getIdCategoria_FK());
            sentencia.setInt(5,producto.getIdProveedor_FK());
            sentencia.setString(6,producto.getIdUsuario_FK());
            sentencia.setString(7, producto.getNombreProducto());
            int fila = sentencia.executeUpdate(); //Retorna la cantidad de filas modificadas
            return fila > 0;  //retorna true si lo modificó
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }

    private static final String SQL_SELECT_PRODUCTO
            = "select nombreProducto,descripcionProducto,precio,cantidad,idCategoria_FK,idProveedor_FK,idUsuario_FK from tbProducto";

    public static ArrayList<Producto> getProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTO);
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Producto(
                                datos.getString(1), //nombre
                                datos.getString(2), //Descripcion
                                datos.getInt(3), //precio
                                datos.getInt(4), //Cantidad
                                datos.getInt(5), //idCategoria
                                datos.getInt(6),
                                datos.getString(7) //idProveedor
                      
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private static final String SQL_SELECT_PRODUCTOS
            = "select nombreProducto,descripcionProducto,precio,cantidad,idCategoria_FK,idProveedor_FK,idUsuario_FK from tbProducto";
//Retorna un proveedor si lo encuentra... null si no lo encuentra...

    public static Producto getProducto(String nombreProducto) {
        Producto producto = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            sentencia.setString(1, nombreProducto);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {  //Si entra al if... hay un proveedor...
                producto = new Producto(datos.getString(1), //nombre
                                datos.getString(2), //Descripcion
                                datos.getInt(3), //precio
                                datos.getInt(4), //Cantidad
                                datos.getInt(5), //idCategoria
                                datos.getInt(6),//idProveedor
                                datos.getString(7)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
}
