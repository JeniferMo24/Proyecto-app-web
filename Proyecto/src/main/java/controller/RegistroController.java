package controller;

import gestion.RegistroGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Registro;


@Named(value = "registroController")
@SessionScoped
public class RegistroController extends Registro implements Serializable {

    

    public RegistroController() {
    }

    
    
    public String inserta() {
        if (RegistroGestion.insertar(this)) {
            return "index.xhtml";  
        } else { 
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre de usuario esté duplicada");
            FacesContext.getCurrentInstance().addMessage(
                    "registroUsuarioForm:nombreUsuario", mensaje);
            return "Registro.xhtml";
        }
    }
}
