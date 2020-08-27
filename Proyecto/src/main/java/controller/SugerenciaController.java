package controller;

import gestion.SugerenciaGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Sugerencia;

@Named(value = "sugerenciaController")
@SessionScoped
public class SugerenciaController extends Sugerencia implements Serializable {

    public SugerenciaController() {
    }

    public String inserta() {
        this.setAsunto("");
        this.setDescripcionSu("");
        this.setIdUsuario_FK("");
        if (SugerenciaGestion.insertar1(this)) {
            this.setAsunto("");
            this.setDescripcionSu("");
            this.setIdUsuario_FK("");

        }
        return "index.xhtml";
    }

}
