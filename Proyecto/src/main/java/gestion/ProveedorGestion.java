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
    
    private static final String SQL_INSERT_PROVEEDOR=
            "insert into proveedor values (?,?,?,?,?,)";
    //Retorna true si logra insertar el proveedor, false si no lo logra
    public static boolean insertar(Proveedor proveedor) {        
        try {
            PreparedStatement sentencia =            
                    Conexion.getConexion().prepareStatement(SQL_INSERT_PROVEEDOR);
            sentencia.setString(1,proveedor.getId());
            sentencia.setString(2,proveedor.getNombre());
            sentencia.setString(3,proveedor.getDireccion());
            sentencia.setString(4,proveedor.getTelefono());
            sentencia.setString(5,proveedor.getCorreo());
            int fila=sentencia.executeUpdate(); //en fila queda el número de fila donde 
            //se insertó el estudiante....
            return fila>0;  //retorna true si lo inserta
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }
    
    private static final String SQL_UPDATE_PROVEEDOR=
            "update proveedor set id=?, direccion=?, telefono=?,"
            + "correo=?, where nombre=?";
    //Retorna true si logra modificar el proveedor, false si no lo logra
    public static boolean modificar(Proveedor proveedor) {        
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PROVEEDOR);
            sentencia.setString(1,proveedor.getId());
            sentencia.setString(2,proveedor.getDireccion());
            sentencia.setString(3,proveedor.getTelefono());
            sentencia.setObject(4,proveedor.getCorreo());
            sentencia.setString(5,proveedor.getNombre());
            int fila=sentencia.executeUpdate(); //Retorna la cantidad de filas modificadas
            return fila>0;  //retorna true si lo modificó
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }
    
    private static final String SQL_DELETE_PROVEEDOR=
            "delete from proveedor where nombre=?";
    //Retorna true si logra eliminar el estudiante, false si no lo logra
    public static boolean eliminar(Proveedor proveedor) {
        try {
            PreparedStatement sentencia = 
                    Conexion.getConexion().prepareStatement(SQL_DELETE_PROVEEDOR);
            sentencia.setString(1,proveedor.getNombre());
            int fila=sentencia.executeUpdate(); //Retorna la cantidad de filas eliminadas
            return fila>0;  //retorna true si lo modificó
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  //retorna falso pues debió ocurrir un error...
    }    
    
    
    private static final String SQL_SELECT_PROVEEDORES = 
            "select * from proveedor";
    public static ArrayList<Proveedor> getProveedores() {
        ArrayList<Proveedor> lista = new ArrayList<>();        
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_PROVEEDORES);            
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                lista.add(
                        new Proveedor(
                                datos.getString(1), //id
                                datos.getString(2), //nombre
                                datos.getString(3), //Direccion
                                datos.getString(4), //Telefono
                                datos.getString(5) //Correo 
                        )                                
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorGestion.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }
}
