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
import model.Facturar;
import model.Producto;
import model.ProductoVenta;

@Named(value = "facturaController")
@SessionScoped
public class FacturaController extends Facturar implements Serializable {

    public FacturaController() {
    }

    

    public String inserta() {
        if (CarritoGestion.insertar(this)) {
            return "mensajefactura.xhtml";  
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "No es posible eliminar");
            FacesContext.getCurrentInstance().addMessage(
                    "CarritoForm:nombre", mensaje);
            return "MenuCliente.xhtml";
        }
    }
}
