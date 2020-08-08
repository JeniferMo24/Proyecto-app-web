
package model;
public class ProductoVenta {
    private String nombreProducto;
    private String descripionProducto;
    private int precio;
    private int cantidad;
    private int idCategoria_FK;

    public ProductoVenta() {
    }

    public ProductoVenta(String nombreProducto, String descripionProducto, int precio, int cantidad, int idCategoria_FK) {
        this.nombreProducto = nombreProducto;
        this.descripionProducto = descripionProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idCategoria_FK = idCategoria_FK;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripionProducto() {
        return descripionProducto;
    }

    public void setDescripionProducto(String descripionProducto) {
        this.descripionProducto = descripionProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCategoria_FK() {
        return idCategoria_FK;
    }

    public void setIdCategoria_FK(int idCategoria_FK) {
        this.idCategoria_FK = idCategoria_FK;
    }
    
    
}
