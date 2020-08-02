/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Proveedor;

/**
 *
 * @author AleGamer
 */
public class ProveedorGestion {

    private static final String SQL_INSERT_PROVEEDOR
            = "insert into tbProveedor(nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor) values (?,?,?,?)";

    //Retorna true si logra insertar el proveedor, false si no lo logra
    public static boolean insertar(Proveedor proveedor) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_INSERT_PROVEEDOR);
            sentencia.setString(1, proveedor.getNombreProveedor());
            sentencia.setString(2, proveedor.getDireccionProveedor());
            sentencia.setString(3, proveedor.getTelefonoProveedor());
            sentencia.setString(4, proveedor.getCorreoProveedor());
            int fila = sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila > 0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }

    private static final String SQL_UPDATE_PROVEEDOR
            = "update tbProveedor set direccionProveedor=?, telefonoProveedor=?,"
            + "correoProveedor=? where nombreProveedor=?";

    //Retorna true si logra modificar el proveedor, false si no lo logra
    public static boolean modificar(Proveedor proveedor) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PROVEEDOR);
            sentencia.setString(1, proveedor.getDireccionProveedor());
            sentencia.setString(2, proveedor.getTelefonoProveedor());
            sentencia.setObject(3, proveedor.getCorreoProveedor());
            sentencia.setString(4, proveedor.getNombreProveedor());
            int fila = sentencia.executeUpdate(); //Retorna la cantidad de filas modificadas
            return fila > 0;  //retorna true si lo modificó
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }

    private static final String SQL_DELETE_PROVEEDOR
            = "delete from tbProveedor where nombreProveedor=?";

    //Retorna true si logra eliminar el estudiante, false si no lo logra
    public static boolean eliminar(Proveedor proveedor) {
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_DELETE_PROVEEDOR);
            sentencia.setString(1, proveedor.getNombreProveedor());
            int fila = sentencia.executeUpdate(); //Retorna la cantidad de filas eliminadas
            return fila > 0;  //retorna true si lo modificó
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }

    private static final String SQL_SELECT_PROVEEDORES
            = "select nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor from tbProveedor";

    public static ArrayList<Proveedor> getProveedores() {
        ArrayList<Proveedor> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_PROVEEDORES);
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Proveedor(
                                datos.getString(1), //nombre
                                datos.getString(2), //Direccion
                                datos.getString(3), //Telefono
                                datos.getString(4) //Correo
                      
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private static final String SQL_SELECT_PROVEEDOR
            = "select nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor from tbProveedor where nombreProveedor=?";
//Retorna un proveedor si lo encuentra... null si no lo encuentra...

    public static Proveedor getProveedor(String nombreProveedor) {
        Proveedor proveedor = null;
        try {
            PreparedStatement sentencia
                    = Conexion.getConexion().prepareStatement(SQL_SELECT_PROVEEDOR);
            sentencia.setString(1, nombreProveedor);
            ResultSet datos = sentencia.executeQuery();
            if (datos.next()) {  //Si entra al if... hay un proveedor...
                proveedor = new Proveedor(datos.getString(1), //id
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }
}
