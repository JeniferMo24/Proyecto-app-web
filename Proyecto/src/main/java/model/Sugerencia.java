
package model;
public class Sugerencia {
    private String asunto;
    private String descripcionSu;
    private String idUsuario_FK;

    public Sugerencia() {
    }

    public Sugerencia(String asunto, String descripcionSu, String idUsuario_FK) {
        this.asunto = asunto;
        this.descripcionSu = descripcionSu;
        this.idUsuario_FK = idUsuario_FK;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcionSu() {
        return descripcionSu;
    }

    public void setDescripcionSu(String descripcionSu) {
        this.descripcionSu = descripcionSu;
    }

    public String getIdUsuario_FK() {
        return idUsuario_FK;
    }

    public void setIdUsuario_FK(String idUsuario_FK) {
        this.idUsuario_FK = idUsuario_FK;
    }

    @Override
    public String toString() {
        return "Sugerencia{" + "asunto=" + asunto + ", descripcionSu=" + descripcionSu + ", idUsuario_FK=" + idUsuario_FK + '}';
    }
    
    
}
