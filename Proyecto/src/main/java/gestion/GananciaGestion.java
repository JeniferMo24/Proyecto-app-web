package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.VentaDiaria;


public class GananciaGestion {
    
    
    private static final String SQL_INGRESOS = "SELECT (fecha)'Fecha_de_Venta', total from tbGanancia group by fecha ,total";
    
    public static ArrayList<VentaDiaria> getIngresos(){
        ArrayList<VentaDiaria> datos = new ArrayList<>();
         try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INGRESOS);            
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                datos.add(
                        new VentaDiaria(                                
                                rs.getInt(1), //Total 
                                rs.getDate(2) //Fecha
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(GananciaGestion.class.getName()).log(Level.SEVERE, null, ex);// EstudianteGestion?
        }        
        return datos;
    }
    //Fin
    
}
