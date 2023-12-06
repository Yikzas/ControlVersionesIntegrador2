package Entidades;

public class Empleado {

    private String codEmpleado;
    private String nombre;
    private String apellido;
    private Double Salario;
    private String cargo;
    private String user;
    private String pass;
    private String estado;

    public Empleado() {
    }

    public Empleado(String codEmpleado, String nombre, String apellido, Double Salario, String cargo, String user, String pass, String estado) {
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Salario = Salario;
        this.cargo = cargo;
        this.user = user;
        this.pass = pass;
        this.estado = estado;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }      

}
