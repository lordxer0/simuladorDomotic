package Modelo;
public class Ambiente {
    private int idambiente;
    private String nombre;
    private String ubicacion;
    private String estado;
    private String tipoambiente;
    private Sede idsede;

    public Ambiente() {
    }

    public Ambiente(int idambiente, String nombre, String ubicacion, String estado, String tipoambiente, Sede idsede) {
        this.idambiente = idambiente;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipoambiente = tipoambiente;
        this.idsede = idsede;
    }
       

    public int getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(int idambiente) {
        this.idambiente = idambiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoambiente() {
        return tipoambiente;
    }

    public void setTipoambiente(String tipoambiente) {
        this.tipoambiente = tipoambiente;
    }

    public Sede getIdsede() {
        return idsede;
    }

    public void setIdsede(Sede idsede) {
        this.idsede = idsede;
    }
    
    
}
