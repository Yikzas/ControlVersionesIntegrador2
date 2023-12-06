package ImplementsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Conexion.ConexionBD;
import Entidades.Cliente;
import Entidades.Registro;
import InterfacesDAO.DaoRegistro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoRegistroImpl implements DaoRegistro {

    private final ConexionBD conexion;
    private String mensaje;

    public DaoRegistroImpl() {
        conexion = new ConexionBD();
    }

    @Override
    public List<Registro> obtenerRegistros() {
        List<Registro> lista = null;
        String storedProcedure = "CALL ObtenerRegistros()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            ResultSet rs = cs.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Registro pedidos = new Registro();
                pedidos.setIDRegistro(rs.getInt(1));
                pedidos.setEstado(rs.getString(2));
                pedidos.setFechaEntrada(rs.getString(3));
                pedidos.setFechaSalida(rs.getString(4));
                pedidos.setHora(rs.getString(5));
                pedidos.setHorafp(rs.getString(6));
                pedidos.setDescuento(rs.getString(7));
                pedidos.setTotal(rs.getDouble(8));
                lista.add(pedidos);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Registro registroGet(Integer IDRegistro) {
        Registro pedidos = null;
        String storedProcedure = "CALL ObtenerRegistroPorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDRegistro);
            ResultSet rs = cs.executeQuery();
            pedidos = new Registro();
            if (rs.next()) {
                pedidos.setEstado(rs.getString(2));
                pedidos.setFechaEntrada(rs.getString(3));
                pedidos.setFechaSalida(rs.getString(4));
                pedidos.setHora(rs.getString(5));
                pedidos.setHorafp(rs.getString(6));
                pedidos.setDescuento(rs.getString(7));
                pedidos.setTotal(rs.getDouble(8));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return pedidos;
    }

    @Override
    public String registroIns(Registro registro) {
        String storedProcedure = "CALL InsertarRegistro(?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, registro.getEstado());
            cs.setString(2, registro.getFechaEntrada());
            cs.setString(3, registro.getFechaSalida());
            cs.setString(4, registro.getHora());
            cs.setString(5, registro.getHorafp());
            cs.setString(6, registro.getDescuento());
            cs.setDouble(7, registro.getTotal());
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
    public String registroUpd(Registro registro) {
        String storedProcedure = "CALL ActualizarRegistro(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, registro.getEstado());
            cs.setString(2, registro.getFechaEntrada());
            cs.setString(3, registro.getFechaSalida());
            cs.setString(4, registro.getHora());
            cs.setString(5, registro.getHorafp());
            cs.setString(6, registro.getDescuento());
            cs.setDouble(7, registro.getTotal());
            cs.setInt(8, registro.getIDRegistro());
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
    public String registroDel(Integer IDRegistro) {
        String storedProcedure = "CALL EliminarRegistro(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDRegistro);
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
    public String obtenerDescuentoRegistroPorID(Integer idRegistro) {
        String descuento = null;
        String storedProcedure = "CALL ObtenerDescuentoPorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                descuento = rs.getString("Descuento");
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return descuento;
    }

    @Override
    public boolean actualizarEstadoRegistro(int idRegistro, String nuevoEstado) {
        String storedProcedure = "CALL ActualizarEstadoRegistro(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            cs.setString(2, nuevoEstado);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarTotal(Integer idRegistro, double nuevoTotal) {
        String storedProcedure = "CALL ActualizarTotalRegistro(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            cs.setDouble(2, nuevoTotal);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            mensaje = e.getMessage();
            return false;
        }
    }

    @Override
    public List<Cliente> obtenerClientesPorIDRegistro(int idRegistro) {
        List<Cliente> clientes = new ArrayList<>();
        String storedProcedure = "CALL ObtenerClientesPorIDRegistro(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("IDCliente");
                Cliente cliente = obtenerClientePorID(idCliente);

                if (cliente != null) {
                    clientes.add(cliente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente obtenerClientePorID(int idCliente) {
        Cliente cliente = null;
        String storedProcedure = "CALL ObtenerClientePorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idCliente);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIDCliente(rs.getInt("IDCliente"));
                cliente.setNomCli(rs.getString("NomCli"));
                cliente.setApeCli(rs.getString("ApeCli"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNhospedajes(rs.getInt("nhospedajes"));
                cliente.setNum_Celular(rs.getString("num_Celular"));
                cliente.setCorreo(rs.getString("correoElec"));
                cliente.setSituacion(rs.getString("Situacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public boolean insertarRelacion(int idRegistro, int idCliente) {
        String storedProcedure = "CALL InsertarRelacion(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            cs.setInt(2, idCliente);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int obtenerUltimoIDRegistro() {
        int ultimoID = 0;
        String sql = "CALL ObtenerUltimoIDRegistro()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(sql); ResultSet rs = cs.executeQuery()) {
            if (rs.next()) {
                ultimoID = rs.getInt(1);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return ultimoID;
    }
    
    @Override
    public String getMensaje() {
        return mensaje;
    }
    
    @Override
    public double obtenerTotalRegistroPorID(Integer idRegistro) {
        double total = 0.0;
        String sql = "CALL ObtenerTotalRegistroPorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(sql)) {
            cs.setInt(1, idRegistro);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return total;
    }

    @Override
    public String obtenerFechaEntradaPorIDRegistro(int idRegistro) {
        String fechaEntrada = null;
        String obtenerFechaEntradaSP = "{CALL obtenerFechaEntradaPorIDRegistro(?)}";

        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(obtenerFechaEntradaSP)) {
            cs.setInt(1, idRegistro);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                fechaEntrada = rs.getString("FechaEntrada");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fechaEntrada;
    }

}
