package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.Usuario;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    public UsuarioController() {
    }

    public String valida() {

        Usuario usuario = UsuarioGestion.valida(this.getIdUsuario(), this.getClave());
        this.setIdUsuario("");
        this.setClave("");
        if (usuario != null) {

            switch (usuario.getIdRol_FK()) {
                case 2:
                    this.setNombre(usuario.getNombre());
                    return "MenuAdmin.xhtml";
                case 3:
                    this.setNombre(usuario.getNombre());
                    return "MenuReportes.xhtml";
                default:
                    this.setNombre(usuario.getNombre());
                    return "MenuCliente.xhtml";
            }

        } else {
            return "index.xhtml";
        }

    }
}
