package Modelo;
public class Movimiento {
    private int idmovimiento;
    private String hora;
    private String tipomovimiento;
    private String fecha;
    private Sensores idsensores;
    private Alarma idalarma;

    public Movimiento() {
    }

    public Movimiento(int idmovimiento, String hora, String tipomovimiento, String fecha, Sensores idsensores, Alarma idalarma) {
        this.idmovimiento = idmovimiento;
        this.hora = hora;
        this.tipomovimiento = tipomovimiento;
        this.fecha = fecha;
        this.idsensores = idsensores;
        this.idalarma = idalarma;
    }

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Sensores getIdsensores() {
        return idsensores;
    }

    public void setIdsensores(Sensores idsensores) {
        this.idsensores = idsensores;
    }

    public Alarma getIdalarma() {
        return idalarma;
    }

    public void setIdalarma(Alarma idalarma) {
        this.idalarma = idalarma;
    }
    
    
}
