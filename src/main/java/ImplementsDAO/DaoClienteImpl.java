package ImplementsDAO;
import InterfacesDAO.DaoCliente;
import Conexion.ConexionBD;
import Entidades.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DaoClienteImpl implements DaoCliente {
    
    private final ConexionBD conexion;
    private String mensaje;
    
    public DaoClienteImpl() {
       conexion = new ConexionBD();
    }
    
    @Override
    public List<Cliente> clienteSel() {
        List<Cliente> lista = null;
        String storedProcedure = "CALL ObtenerClientes()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            ResultSet rs = cs.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIDCliente(rs.getInt(1));
                cliente.setNomCli(rs.getString(2));
                cliente.setApeCli(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setNhospedajes(rs.getInt(5));
                cliente.setNum_Celular(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setSituacion(rs.getString(8));
                lista.add(cliente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Cliente clienteGet(Integer IDCliente) {
        Cliente cliente = null;
        String storedProcedure = "CALL ObtenerClientePorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDCliente);
            ResultSet rs = cs.executeQuery();
            cliente = new Cliente();
            if (rs.next()) {
                cliente.setNomCli(rs.getString(2));
                cliente.setApeCli(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setNhospedajes(rs.getInt(5));
                cliente.setNum_Celular(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setSituacion(rs.getString(8));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cliente;
    }

    @Override
    public String clienteIns(Cliente cliente) {
        String storedProcedure = "CALL InsertarCliente(?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, cliente.getNomCli());
            cs.setString(2, cliente.getApeCli());
            cs.setString(3, cliente.getDni());
            cs.setInt(4, cliente.getNhospedajes());
            cs.setString(5, cliente.getNum_Celular());
            cs.setString(6, cliente.getCorreo());
            cs.setString(7, cliente.getSituacion());
            int resultado = cs.executeUpdate();
            if (resultado == 0) {
                mensaje = "Cero registros agregados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String clienteUpd(Cliente cliente) {
        String storedProcedure = "CALL ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, cliente.getIDCliente());
            cs.setString(2, cliente.getNomCli());
            cs.setString(3, cliente.getApeCli());
            cs.setString(4, cliente.getDni());
            cs.setInt(5, cliente.getNhospedajes());
            cs.setString(6, cliente.getNum_Celular());
            cs.setString(7, cliente.getCorreo());
            cs.setString(8, cliente.getSituacion());
            int resultado = cs.executeUpdate();
            if (resultado == 0) {
                mensaje = "Cero registros actualizados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String clienteDel(Integer IDCliente) {
        String storedProcedure = "CALL EliminarCliente(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDCliente);
            int resultado = cs.executeUpdate();
            if (resultado == 0) {
                mensaje = "Cero registros eliminados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public Cliente clienteGetByDNI(String dni) {
        Cliente cliente = null;
        String storedProcedure = "CALL ObtenerClientePorDNI(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, dni);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIDCliente(rs.getInt(1));
                cliente.setNomCli(rs.getString(2));
                cliente.setApeCli(rs.getString(3));
                cliente.setDni(rs.getString(4));
                cliente.setNhospedajes(rs.getInt(5));
                cliente.setNum_Celular(rs.getString(6));
                cliente.setCorreo(rs.getString(7));
                cliente.setSituacion(rs.getString(8));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cliente;
    }

    @Override
    public boolean clienteExists(String dni) {
        boolean exists = false;
        String storedProcedure = "CALL ExisteClientePorDNI(?, ?)";

        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, dni);
            cs.registerOutParameter(2, Types.BOOLEAN);
            cs.execute();
            exists = cs.getBoolean(2);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return exists;
    }
    
    @Override
    public String getMensaje() {
        return mensaje;
    }    

}
