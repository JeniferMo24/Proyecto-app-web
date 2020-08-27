
package model;


public class Carrito {
    
    
    private int cantidadCarrito;
    private int precio;
    private String nombre;
    public Carrito() {
    }

    public Carrito(int cantidadCarrito, int precio, String nombre) {
        this.cantidadCarrito = cantidadCarrito;
        this.precio = precio*cantidadCarrito;
        this.nombre = nombre;
        
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

    

    
}