package Entidades;

public class Acciones {
    private int id;
    private String accion;
    private String fecha;

    public Acciones() {
    }

    public Acciones(int id, String accion, String fecha) {
        this.id = id;
        this.accion = accion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
       
}
