package Modelo;
public class Sensores {
   private int idsensor;
   private String tiposensor;
   private String nombresensor;
   private Ambiente idambiente;

    public Sensores() {
    }
   
   

    public Sensores(int idsensor, String tiposensor, String nombresensor, Ambiente idambiente) {
        this.idsensor = idsensor;
        this.tiposensor = tiposensor;
        this.nombresensor = nombresensor;
        this.idambiente = idambiente;
    }

    public int getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(int idsensor) {
        this.idsensor = idsensor;
    }

    public String getTiposensor() {
        return tiposensor;
    }

    public void setTiposensor(String tiposensor) {
        this.tiposensor = tiposensor;
    }

    public String getNombresensor() {
        return nombresensor;
    }

    public void setNombresensor(String nombresensor) {
        this.nombresensor = nombresensor;
    }

    public Ambiente getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(Ambiente idambiente) {
        this.idambiente = idambiente;
    }
   
   
}
