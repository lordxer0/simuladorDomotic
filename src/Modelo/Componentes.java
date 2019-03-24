package Modelo;
public class Componentes {
    private int idcomponente;
    private String estado;
    private String tipo;
    private String nombre;
    private Alarma alarma;
    private Ambiente idambiente;
    private Movimiento idmovimiento;
    private int identificador;
    private String abrir_cerrar;
    public Componentes() {
    }

    public Componentes(int idcomponente, String estado, String tipo, String nombre, Ambiente idambiente, Movimiento idmovimiento, int identificador, String abrir_cerrar) {
        this.idcomponente = idcomponente;
        this.estado = estado;
        this.tipo = tipo;
        this.nombre = nombre;
        this.idambiente = idambiente;
        this.idmovimiento = idmovimiento;
        this.identificador = identificador;
        this.abrir_cerrar = abrir_cerrar;
    }

   

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdcomponente() {
        return idcomponente;
    }

    public void setIdcomponente(int idcomponente) {
        this.idcomponente = idcomponente;
    }

    public Ambiente getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(Ambiente idambiente) {
        this.idambiente = idambiente;
    }

    public Movimiento getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(Movimiento idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getAbrir_cerrar() {
        return abrir_cerrar;
    }

    public void setAbrir_cerrar(String abrir_cerrar) {
        this.abrir_cerrar = abrir_cerrar;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
   
    
}
