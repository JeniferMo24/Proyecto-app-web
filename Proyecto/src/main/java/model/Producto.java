package model;


public class Producto {
    
   
    private String nombreProducto;
    private String descripcionProducto;
    private int precio;
    private int cantidad;
    private int idCategoria_FK;
    private int idProveedor_FK;
    private String idUsuario_FK;
    
    public Producto() {
    }

    public Producto(String nombreProducto, String descripcionProducto, int precio, int cantidad, int idCategoria_FK, int idProveedor_FK, String idUsuario_FK) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idCategoria_FK = idCategoria_FK;
        this.idProveedor_FK = idProveedor_FK;
        this.idUsuario_FK = idUsuario_FK;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
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

    public int getIdProveedor_FK() {
        return idProveedor_FK;
    }

    public void setIdProveedor_FK(int idProveedor_FK) {
        this.idProveedor_FK = idProveedor_FK;
    }

    public String getIdUsuario_FK() {
        return idUsuario_FK;
    }

    public void setIdUsuario_FK(String idUsuario_FK) {
        this.idUsuario_FK = idUsuario_FK;
    }

    
}