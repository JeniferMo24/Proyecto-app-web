
package model;


public class Carrito {
    
    
    private int cantidadCarrito;
    private int precio;
    private String nombre;
    private int total;
    public Carrito() {
    }

    public Carrito(int cantidadCarrito, int precio, String nombre,int total) {
        this.cantidadCarrito = cantidadCarrito;
        this.precio = precio*cantidadCarrito;
        this.nombre = nombre;
        this.total=total+precio;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}