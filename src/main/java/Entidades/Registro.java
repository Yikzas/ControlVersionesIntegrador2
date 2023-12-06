package Entidades;
public class Registro {
    private Integer IDRegistro;
    private String fechaEntrada;
    private String fechaSalida;
    private String hora;
    private String horafp; 
    private String descuento;    
    private String estado;
    private Double total;
    public Registro() {
    }
    public Registro(Integer IDRegistro, String fechaEntrada, String fechaSalida, 
            String hora, String horafp, String descuento, String estado, Double total) {
        this.IDRegistro = IDRegistro;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.hora = hora;
        this.horafp = horafp;
        this.descuento = descuento;
        this.estado = estado;
        this.total = total;
    }
    public Integer getIDRegistro() {
        return IDRegistro;
    }
    public void setIDRegistro(Integer IDRegistro) {
        this.IDRegistro = IDRegistro;
    }
    public String getFechaEntrada() {
        return fechaEntrada;
    }
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public String getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getHorafp() {
        return horafp;
    }
    public void setHorafp(String horafp) {
        this.horafp = horafp;
    }
    public String getDescuento() {
        return descuento;
    }
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }   
}


