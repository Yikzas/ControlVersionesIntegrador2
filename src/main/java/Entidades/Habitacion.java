package Entidades;
public class Habitacion {
    private int IDHabitacion;
    private String descripcion;
    private int capacidad;
    private String tipo;
    private String estado;
    private double precio;
    private String imagen;
    
    public Habitacion() {
    }
    
    public Habitacion(int IDHabitacion, String descripcion, int capacidad, 
            String tipo, String estado, double precio, String imagen) {
        this.IDHabitacion = IDHabitacion;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estado = estado;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    public int getIDHabitacion() {
        return IDHabitacion;
    }
    
    public void setIDHabitacion(int IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }   

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
      
}

