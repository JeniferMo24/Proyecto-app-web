/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import gestion.GananciaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import model.GananciaFecha;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
/**
 *
 * @author wmolina
 */
@Named(value = "chartDateView")
@SessionScoped
public class ChartDateView implements Serializable {
    private LineChartModel dateModel;
 
    @PostConstruct
    public void init() {
        createDateModel();
    }
 
    public LineChartModel getDateModel() {
        return dateModel;
    }
 
    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries Fechas = new LineChartSeries();
        Fechas.setLabel("Fecha");
       
         ArrayList<GananciaFecha> datos = GananciaGestion.getIngresos();
         int maximo=datos.get(0).getTotal();
         for(GananciaFecha dato:datos){
             Fechas.set(dato.getFecha(),dato.getTotal());
             maximo=maximo<dato.getTotal()?dato.getTotal():maximo;
         }
               
 
        dateModel.addSeries(Fechas);        
 
        dateModel.setTitle("Ingresos por fecha");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("Total");
        DateAxis axis = new DateAxis("Fechas");
        axis.setTickAngle(-50);
        axis.setMax(maximo*1.25);
        axis.setTickFormat("%b %#d, %y");
 
        dateModel.getAxes().put(AxisType.X, axis);
    
    }
}