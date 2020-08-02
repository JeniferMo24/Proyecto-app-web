/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller
import gestion.ProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Producto;

/**
 *
 * @author Dell
 */
@Named(value = "productoController")
@SessionScoped
public class ProductoController extends Producto implements Serializable {

    /**
     * Creates a new instance of ProductoController
     */
    public ProductoController() {
    }
    public String inserta() {
        if (ProductoGestion.insertar(this)) {
            return "producto.xhtml";  //logró insertarlo
        } else {  //no logró insertarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","No es posible agregar producto");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProductoForm:nombre", mensaje);
            return "agregarProducto.xhtml";
        }
    }
    
    public String modifica() {
        if (ProductoGestion.modificar(this)) {
            return "producto.xhtml";  //logró modificarlo
        } else {  //no logró modificarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProductoForm:nombre", mensaje);
            return "editarProducto.xhtml";
        }
    }
    
    public String elimina() {
        if (ProductoGestion.eliminar(this)) {
            return "producto.xhtml";  //logró eliminarlo
        } else {  //no logró eliminarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProductoForm:nombre", mensaje);
            return "editarProducto.xhtml";
        }
    }
    
     public List<Producto> getProductos() {
        return ProductoGestion.getProductos();
    }
    
     public String edita(String nombreProducto) {
        Producto producto=ProductoGestion.getProducto(nombreProducto);
        if (producto!=null) {  //Si el estudiante existe lo puedo editar
            this.setNombreProducto(producto.getNombreProducto());
            this.setDescripcionProducto(producto.getDescripcionProducto());
            this.setPrecio(producto.getPrecio());
            this.setCantidad(producto.getCantidad());
            this.setIdCategoria_FK(producto.getIdCategoria_FK());
            this.setIdProveedor_FK(producto.getIdProveedor_FK());
            this.setIdUsuario_FK(producto.getIdUsuario_FK());
            
            return "producto.xhtml";
        } else {  //El estudiante no existe...
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "listForm:mensajes", mensaje);
            return "editarProducto.xhtml";
        }
    }
    
}
