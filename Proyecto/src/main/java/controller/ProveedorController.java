/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ProveedorGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Proveedor;

/**
 *
 * @author AleGamer
 */
@Named(value = "proveedorControllers")
@SessionScoped
public class ProveedorController extends Proveedor implements Serializable{

    /**
     * Creates a new instance of proveedorControllers
     */
    public ProveedorController() {
        
    }
    
    public String inserta() {
        if (ProveedorGestion.insertar(this)) {
            return "proveedor.xhtml";  //logró insertarlo
        } else {  //no logró insertarlo correctamente
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","No es posible agregar proveedor");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProveedorForm:id", mensaje);
            return "agregarProveedor.xhtml";
        }
    }
    
    public String modifica() {
        if (ProveedorGestion.modifica(this)) {
            return "proveedor.xhtml";  //logró modificarlo
        } else {  //no logró modificarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProveedorForm:id", mensaje);
            return "agregarProveedor.xhtml";
        }
    }
    
    public String elimina() {
        if (ProveedorGestion.eliminar(this)) {
            return "proveedor.xhtml";  //logró eliminarlo
        } else {  //no logró eliminarlo
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "editaProveedorForm:nombre", mensaje);
            return "agregarProveedor.xhtml";
        }
    }
    
     public List<Proveedor> getProvedores() {
        return ProveedorGestion.getProveedores();
    }
    
     public String edita(String nombreProveedor) {
        Proveedor proveedor=ProveedorGestion.getProveedor(nombreProveedor);
        if (proveedor!=null) {  //Si el estudiante existe lo puedo editar
            this.setNombreProveedor(proveedor.getNombreProveedor());
            this.setDireccionProveedor(proveedor.getDireccionProveedor());
            this.setTelefonoProveedor(proveedor.getTelefonoProveedor());
            this.setCorreoProveedor(proveedor.getCorreoProveedor());
            
            return "agregarProveedor.xhtml";
        } else {  //El estudiante no existe...
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre no esté");
            FacesContext.getCurrentInstance().addMessage(
                    "listForm:mensajes", mensaje);
            return "proveedor.xhtml";
        }
    }
}
