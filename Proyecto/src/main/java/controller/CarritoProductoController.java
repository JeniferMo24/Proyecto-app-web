/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller


import gestion.CarritoProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.CarritoProducto;
import model.ProductoVenta;


@Named(value = "carritoProductoController")
@SessionScoped
public class CarritoProductoController extends CarritoProducto implements Serializable {

    
    public CarritoProductoController() {
    }

    

    public String insertar() {
        if (CarritoProductoGestion.insertar(this)) {
            return "mensaje.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible producto esté duplicada");
            FacesContext.getCurrentInstance().addMessage(
                    "editaCarritoForm:producto", mensaje);
            return "agregarCarrito.xhtml";
        }
    }

    public String edita(int idProducto) {
        ProductoVenta producto = CarritoProductoGestion.getProductoVenta(idProducto);
        if (producto != null) { 
            this.setIdProducto_FK(idProducto);
            this.setPrecio(producto.getPrecio());
            this.setNombre(producto.getNombreProducto());
            this.setCantidad(producto.getCantidad());
            return "agregarCarrito.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Es posible que la identificación no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "listForm:mensajes", mensaje);
            return "MenuCliente.xhtml";
        }
    }

}
