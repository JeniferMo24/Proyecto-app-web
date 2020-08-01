
package model;


public class Registro {
    private String idUsuario;
    private String nombre;
    private String telefono;
    private String correo;
    private String clave;

    public Registro() {
    }

    public Registro(String idUsuario, String nombre, String telefono, String correo, String clave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Registro{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", clave=" + clave + '}';
    }

    
}