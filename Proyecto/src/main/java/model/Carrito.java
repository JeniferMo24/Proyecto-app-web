
package model;


public class Carrito {
    
    private int cantidadCarrito;
    private int idProducto_FK;
    private int total;

    public Carrito() {
    }

    public Carrito(int cantidadCarrito, int idProducto_FK, int total) {
        this.cantidadCarrito = cantidadCarrito;
        this.idProducto_FK = idProducto_FK;
        this.total = total;
    }

    public int getCantidadCarrito() {
        return cantidadCarrito;
    }

    public void setCantidadCarrito(int cantidadCarrito) {
        this.cantidadCarrito = cantidadCarrito;
    }

    public int getIdProducto_FK() {
        return idProducto_FK;
    }

    public void setIdProducto_FK(int idProducto_FK) {
        this.idProducto_FK = idProducto_FK;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
    
    
    
}
