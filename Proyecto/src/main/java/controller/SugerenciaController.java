/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//Producto Controller

import gestion.ProductoGestion;
import gestion.SugerenciaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Sugerencia;


/**
 *
 * @author Dell
 */
@Named(value = "sugerenciaController")
@SessionScoped
public class SugerenciaController extends Sugerencia implements Serializable {
    public SugerenciaController() {
    }
         public String inserta() {
        if (SugerenciaGestion.insertar(this)) {
            this.setAsunto("");
            this.setDescripcionSu("");
            this.setIdUsuario_FK("");
            return "sugerencia.xhtml";
        } else {  
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","No se puede agregar");
            FacesContext.getCurrentInstance().addMessage(
                    "sugerenciaForm:asunto", mensaje);
            return "sugerencia.xhtml";
        }
    }
    
    }

