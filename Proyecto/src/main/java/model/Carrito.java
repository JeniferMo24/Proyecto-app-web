
package model;


public class Carrito {
    
  
    private int cantidadCarrito;
    private String nombreProducto;
    private int precio;
    private int total;
    private int idProducto_FK;

    public Carrito() {
    }

    public Carrito(int cantidadCarrito, String nombreProducto, int precio, int total, int idProducto_FK) {
        this.cantidadCarrito = cantidadCarrito;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.total = total;
        this.idProducto_FK = idProducto_FK;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdProducto_FK() {
        return idProducto_FK;
    }

    public void setIdProducto_FK(int idProducto_FK) {
        this.idProducto_FK = idProducto_FK;
    }

    
}
