
package model;


public class Carrito {
    
    private int idProducto;
    private int cantidad;
    private int precio;
    private String nombre;

    public Carrito() {
    }

    public Carrito(int idProducto, int cantidad, int precio, String nombre) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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