package Entidades;
public class Boleta {
    private int IDBoleta;
    private int IDRegistro;
    private String CodEmpleado;
    private String hora;
    private String fecha;   
    public Boleta() {      
    }   
    public Boleta(int IDBoleta, int IDRegistro, String CodEmpleado, String hora, String fecha) {
        this.IDBoleta = IDBoleta;
        this.IDRegistro = IDRegistro;
        this.CodEmpleado = CodEmpleado;
        this.hora = hora;
        this.fecha = fecha;
    }    
    public int getIDBoleta() {
        return IDBoleta;
    }   
    public void setIDBoleta(int IDBoleta) {
        this.IDBoleta = IDBoleta;
    }   
    public int getIDRegistro() {
        return IDRegistro;
    }   
    public void setIDRegistro(int IDPedido) {
        this.IDRegistro = IDPedido;
    }   
    public String getCodEmpleado() {
        return CodEmpleado;
    }   
    public void setCodEmpleado(String CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }    
    public String getHora() {
        return hora;
    }    
    public void setHora(String hora) {
        this.hora = hora;
    }    
    public String getFecha() {
        return fecha;
    }    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }   
}
    
