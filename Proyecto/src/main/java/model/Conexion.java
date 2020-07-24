/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AleGamer
 */

    public class Conexion {
    private static Conexion conexion;
    private static final String DBURL="jdbc:derby://localhost:1527/OneTechnology";
    private static Connection conn;

    private Conexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").getDeclaredConstructor().newInstance();
            conn=DriverManager.getConnection(DBURL,"admin","admin");
        } catch (ClassNotFoundException | NoSuchMethodException | 
                SecurityException | InstantiationException | 
                IllegalAccessException | IllegalArgumentException | 
                InvocationTargetException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized Connection getConexion() {
        if (conexion==null) {
            conexion = new Conexion();
        }
        return conn;
    }
    
}

    

