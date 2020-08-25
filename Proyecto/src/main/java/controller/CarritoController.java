/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller

import gestion.CarritoGestion;
import gestion.CarritoProductoGestion;
import gestion.ProductoGestion;
import gestion.ProductoVentaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Carrito;
import model.CarritoProducto;
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
            return "agregarCarrito.xhtml";
        }
    }

    public String edita(int idProducto_FK) {
        CarritoProducto producto = CarritoGestion.getCarritoProducto(idProducto_FK);
        if (producto != null) {
            this.setIdProducto(idProducto_FK);
            this.setPrecio(producto.getPrecio());
            this.setCantidad(producto.getCantidad());
            this.setNombre(producto.getNombre());
            CarritoGestion.insertar(this);
            return "carrito.xhtml";// AQUI
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Es posible que la identificación no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "listForm:mensajes", mensaje);
            return "MenuCliente.xhtml";
        }
    }

}
