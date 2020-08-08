/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller

import gestion.ProductoVentaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.ProductoVenta;

/**
 *
 * @author Dell
 */
@Named(value = "productoVentaController")
@SessionScoped
public class ProductoVentaController extends ProductoVenta implements Serializable {

    /**
     * Creates a new instance of ProductoController
     */
    public ProductoVentaController() {
    }
    
    
    
 
     public List<ProductoVenta> getComputadoras() {
        return ProductoVentaGestion.getComputadoras();
    }
    
     
    
}
