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
import model.ProductoVenta;


public class ProductoVentaGestion {
    private static final String SQL_SELECT_PRODUCTOCOMPU
            = "select nombreProducto,descripcionProducto,precio,cantidad,idCategoria_FK from tbProducto where idCategoria_FK=2 ";

    public static ArrayList<ProductoVenta> getComputadoras() {
        ArrayList<ProductoVenta> listaCompu = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOCOMPU);
            ResultSet datos = sentencia.executeQuery();
            while (datos.next()) {
                listaCompu.add(
                        new ProductoVenta(
                            datos.getString(1),
                            datos.getString(2),
                            datos.getInt(3),
                            datos.getInt(4),
                            datos.getInt(5)
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoVentaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompu;
    }
}
