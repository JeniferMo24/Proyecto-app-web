
package model;

import java.util.Date;


public class GananciaFecha {
    
    private int total;
    private Date fecha;

    public GananciaFecha(int total, Date fecha) {
        this.total = total;
        this.fecha = fecha;
    }

    public GananciaFecha() {
    }
    

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



  
    

}
