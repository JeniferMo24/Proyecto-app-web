/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller

import gestion.CarritoGestion;
import gestion.ProductoGestion;
import gestion.ProductoVentaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Carrito;
import model.Producto;
import model.ProductoVenta;


@Named(value = "carritoController")
@SessionScoped
public class CarritoController extends Carrito implements Serializable {

    /**
     * Creates a new instance of ProductoController
     */
    public CarritoController() {
    }

  

    public String insertar() {
        if (CarritoGestion.insertar(this)) {
            return "carrito.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible producto esté duplicada");
            FacesContext.getCurrentInstance().addMessage(
                    "editaCarritoForm:producto", mensaje);
            return "edita.xhtml";
        }
    }

    public String edita(int idProducto) {
        ProductoVenta producto = CarritoGestion.getProductoVenta(idProducto);
        if (producto != null) { 
            this.setIdProducto_FK(idProducto);
            this.setCantidadCarrito(producto.getCantidad());
            this.setNombreProducto(producto.getNombreProducto());
            this.setPrecio(producto.getPrecio());
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
