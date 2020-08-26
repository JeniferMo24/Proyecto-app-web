
package model;


public class Registro {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String telefono;
    private String correo;
    private int idRol_FK=1;
   

    public Registro() {
    }

    public Registro(String idUsuario, String clave, String nombre, String telefono, String correo, int idRol_FK) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.idRol_FK = idRol_FK;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public int getIdRol_FK() {
        return idRol_FK;
    }

    public void setIdRol_FK(int idRol_FK) {
        this.idRol_FK = idRol_FK;
    }

    @Override
    public String toString() {
        return "Registro{" + "idUsuario=" + idUsuario + ", clave=" + clave + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", idRol_FK=" + idRol_FK + '}';
    }

   
    
    
}