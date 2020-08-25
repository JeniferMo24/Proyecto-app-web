
package dashboard;

import gestion.GananciaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.VentaDiaria;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author wmolina
 */
@Named(value = "chartBarView")
@SessionScoped
public class ChartBarView implements Serializable {

    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel=new BarChartModel();
        ChartSeries fechas = new ChartSeries();
        fechas.setLabel("Ingresos");
        

        ArrayList<VentaDiaria> datos = GananciaGestion.getIngresos();
        
        for(VentaDiaria dato:datos){
            
            fechas.set(dato.getFecha(), dato.getTotal());
        }
        
        barModel.addSeries(fechas);      

        barModel.setTitle("Ganancias por Fecha");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Fecha");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ganancia");
        yAxis.setMin(0);
        yAxis.setMax(800000);
    }

}
