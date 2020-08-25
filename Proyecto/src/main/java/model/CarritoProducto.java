
package model;
public class CarritoProducto {
    private int idProducto_FK;
    private int precio;
    private String nombre;
    private int cantidad;

    public CarritoProducto() {
    }

    public CarritoProducto(int idProducto_FK, int precio, String nombre, int cantidad) {
        this.idProducto_FK = idProducto_FK;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getIdProducto_FK() {
        return idProducto_FK;
    }

    public void setIdProducto_FK(int idProducto_FK) {
        this.idProducto_FK = idProducto_FK;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
