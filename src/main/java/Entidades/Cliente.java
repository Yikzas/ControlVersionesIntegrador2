package Entidades;
public class Cliente {
    private Integer IDCliente;
    private String NomCli;
    private String ApeCli;
    private String dni;
    private String num_Celular;
    private String correo;
    private int nhospedajes;
    private String Situacion;
    public Cliente() {
    }
    public Cliente(Integer IDCliente, String NomCli, String ApeCli, String dni, 
            String num_Celular, String correo, int nhospedajes, String Situacion) {
        this.IDCliente = IDCliente;
        this.NomCli = NomCli;
        this.ApeCli = ApeCli;
        this.dni = dni;
        this.num_Celular = num_Celular;
        this.correo = correo;
        this.nhospedajes = nhospedajes;
        this.Situacion = Situacion;
    }
    public Integer getIDCliente() {
        return IDCliente;
    }
    public void setIDCliente(Integer IDCliente) {
        this.IDCliente = IDCliente;
    }
    public String getNomCli() {
        return NomCli;
    }
    public void setNomCli(String NomCli) {
        this.NomCli = NomCli;
    }
    public String getApeCli() {
        return ApeCli;
    }
    public void setApeCli(String ApeCli) {
        this.ApeCli = ApeCli;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNum_Celular() {
        return num_Celular;
    }

    public void setNum_Celular(String num_Celular) {
        this.num_Celular = num_Celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNhospedajes() {
        return nhospedajes;
    }

    public void setNhospedajes(int nhospedajes) {
        this.nhospedajes = nhospedajes;
    }

    public String getSituacion() {
        return Situacion;
    }

    public void setSituacion(String Situacion) {
        this.Situacion = Situacion;
    }  
}
