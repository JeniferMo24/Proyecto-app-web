
package model;
public class Usuario {
   private String idUsuario;
   private String nombre;
   private String telefono;
   private String correo;
   private int idRol_FK;
   private String clave;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nombre, String telefono, String correo, int idRol_FK, String clave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.idRol_FK = idRol_FK;
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

    public int getIdRol_FK() {
        return idRol_FK;
    }

    public void setIdRol_FK(int idRol_FK) {
        this.idRol_FK = idRol_FK;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", idRol_FK=" + idRol_FK + ", clave=" + clave + '}';
    }

   
}