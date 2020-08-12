/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller

import gestion.CarritoGestion;
import gestion.ProductoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Carrito;
import model.ProductoVenta;

/**
 *
 * @author Dell
 */
@Named(value = "carritoController")
@SessionScoped
public class CarritoController extends Carrito implements Serializable {

    /**
     * Creates a new instance of ProductoController
     */
    public CarritoController() {
    }

     public List<Carrito> getCarrito() {
        return CarritoGestion.getCarrito();
    }
    
    }

