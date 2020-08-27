
package model;

import java.util.Date;


public class Facturar {
    private int totalFactura;
    private Date fecha;
    private int idCarrito_FK;
    private int idPago_FK;

    public Facturar() {
    }

    public Facturar(int totalFactura, Date fecha, int idCarrito_FK, int idPago_FK) {
        this.totalFactura = totalFactura;
        this.fecha = fecha;
        this.idCarrito_FK = idCarrito_FK;
        this.idPago_FK = idPago_FK;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCarrito_FK() {
        return idCarrito_FK;
    }

    public void setIdCarrito_FK(int idCarrito_FK) {
        this.idCarrito_FK = idCarrito_FK;
    }

    public int getIdPago_FK() {
        return idPago_FK;
    }

    public void setIdPago_FK(int idPago_FK) {
        this.idPago_FK = idPago_FK;
    }

    @Override
    public String toString() {
        return "Facturar{" + "totalFactura=" + totalFactura + ", fecha=" + fecha + ", idCarrito_FK=" + idCarrito_FK + ", idPago_FK=" + idPago_FK + '}';
    }

    
    
   
   
    
    
}
