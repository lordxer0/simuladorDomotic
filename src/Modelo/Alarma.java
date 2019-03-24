package Modelo;
public class Alarma {
   private int idalarma;
   private String tipoalarma;
   private String descripcionalarma;
   private String nombrealarma;

    public Alarma() {
    }

    public Alarma(int idalarma, String tipoalarma, String descripcionalarma, String nombrealarma) {
        this.idalarma = idalarma;
        this.tipoalarma = tipoalarma;
        this.descripcionalarma = descripcionalarma;
        this.nombrealarma = nombrealarma;
    }

    public int getIdalarma() {
        return idalarma;
    }

    public void setIdalarma(int idalarma) {
        this.idalarma = idalarma;
    }

    public String getTipoalarma() {
        return tipoalarma;
    }

    public void setTipoalarma(String tipoalarma) {
        this.tipoalarma = tipoalarma;
    }

    public String getDescripcionalarma() {
        return descripcionalarma;
    }

    public void setDescripcionalarma(String descripcionalarma) {
        this.descripcionalarma = descripcionalarma;
    }

    public String getNombrealarma() {
        return nombrealarma;
    }

    public void setNombrealarma(String nombrealarma) {
        this.nombrealarma = nombrealarma;
    }
   
    
}
