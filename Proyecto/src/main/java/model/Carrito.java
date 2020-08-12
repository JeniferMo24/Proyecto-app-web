
package model;


public class Carrito {
    
    private int cantidadCarrito;
    private String nombreProducto;
    private int precio;
    private int total;

    public Carrito() {
    }

    public Carrito(int cantidadCarrito, String nombreProducto, int precio, int total) {
        this.cantidadCarrito = cantidadCarrito;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.total = total;
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

    public int getprecio() {
        return precio;
    }

    public void setPrecio(int Precio) {
        this.precio = Precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
   
    
    
    
    
    
}
