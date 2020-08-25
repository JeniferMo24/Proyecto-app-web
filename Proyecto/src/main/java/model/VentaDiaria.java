
package model;

import java.util.Date;


public class VentaDiaria {
    
    private int total;
    private Date fecha;

    public VentaDiaria(int total, Date fecha) {
        this.total = total;
        this.fecha = fecha;
    }

    public VentaDiaria() {
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
