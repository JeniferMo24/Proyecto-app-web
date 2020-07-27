package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    

    public UsuarioController() {
    }

    public String valida() {

        Usuario usuario = UsuarioGestion.valida(this.getIdUsuario(), this.getClave());
        if (usuario != null) {
            if (usuario.getIdRol_FK() == 2) {
                this.setNombre(usuario.getNombre());
                this.setIdRol_FK(usuario.getIdRol_FK());
                return "MenuAdmin.xhtml";
            } else {
                return "MenuCliente.xhtml";
            }

        } else {
            return "index.xhtml";
        }

    }
    
    public String inserta() {
        if (UsuarioGestion.insertar(this)) {
            return "index.xhtml";  
        } else { 
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Error","Es posible que el nombre de usuario esté duplicada");
            FacesContext.getCurrentInstance().addMessage(
                    "editaUsuarioForm:NombreUsuario", mensaje);
            return "Registro.xhtml";
        }
    }
}
