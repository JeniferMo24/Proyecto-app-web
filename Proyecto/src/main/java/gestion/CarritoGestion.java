package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrito;
import model.Conexion;
import model.Facturar;
import model.Producto;

public class CarritoGestion {

    public static int total1;
    public static String fecha1 = "2020-08-26";

    private static final String SQL_SELECT_CARRITO
            = "select cantidadCarrito,precio,nombre,total from tbCarrito";

    public static ArrayList<Carrito> getCarrito() {
        ArrayList<Carrito> listaCarrito = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_CARRITO);
            ResultSet datos = sentencia.executeQuery();
            total1 = 0;
            while (datos.next()) {
                listaCarrito.add(
                        new Carrito(
                                datos.getInt(1),
                                datos.getInt(2),
                                datos.getString(3),
                                datos.getInt(4)
                        )
                );
                
               
                total1 = (datos.getInt(2) * datos.getInt(1)) + total1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCarrito;
    }

    private static final String SQL_DELETE_CARRITO
            = "delete tbCarrito";

    public static boolean eliminar(Carrito carrito) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_CARRITO);
            int fila = sentencia.executeUpdate(); 
            return fila > 0;  
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }

    private static final String SQL_INSERT_FACTURA
            = "insert into tbfactura(totalFactura,fecha,idCarrito_FK,idPago_FK) values (?,?,?,?)";

    public static boolean insertar(Facturar facturar) {
        
        System.out.println(facturar);
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareStatement(SQL_INSERT_FACTURA);
            sentencia.setInt(1,total1);
            sentencia.setObject(2, new Date());
            sentencia.setInt(3, 46);
            sentencia.setInt(4, facturar.getIdPago_FK() );
            int fila = sentencia.executeUpdate();
            return fila > 0;  
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
}
