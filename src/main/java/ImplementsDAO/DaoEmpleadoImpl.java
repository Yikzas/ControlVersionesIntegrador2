package ImplementsDAO;
import InterfacesDAO.DaoEmpleado;
import Conexion.ConexionBD;
import Entidades.Acciones;
import Entidades.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleadoImpl implements DaoEmpleado {

    private final ConexionBD conexion;
    private String mensaje;

    public DaoEmpleadoImpl() {
       conexion = new ConexionBD();
    }

    @Override
    public List<Empleado> empleadoSel() {
        List<Empleado> lista = null;
        String storedProcedure = "CALL SeleccionarEmpleados()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure); ResultSet rs = cs.executeQuery()) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodEmpleado(rs.getString(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setSalario(rs.getDouble(4));
                empleado.setCargo(rs.getString(5));
                empleado.setUser(rs.getString(6));
                empleado.setPass(rs.getString(7));
                empleado.setEstado(rs.getString(8));
                lista.add(empleado);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Empleado empleadoGet(String cargo, String user, String pass) {
        Empleado empleado = null;
        String storedProcedure = "CALL ObtenerEmpleadoPorCredenciales(?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, cargo);
            cs.setString(2, user);
            cs.setString(3, pass);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setSalario(rs.getDouble(4));
                empleado.setCargo(rs.getString(5));
                empleado.setUser(rs.getString(6));
                empleado.setPass(rs.getString(7));
                empleado.setEstado(rs.getString(8));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return empleado;
    }

    @Override
    public String empleadoIns(Empleado empleado) {
        String storedProcedure = "CALL InsertarEmpleado(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, empleado.getCodEmpleado());
            cs.setString(2, empleado.getNombre());
            cs.setString(3, empleado.getApellido());
            cs.setDouble(4, empleado.getSalario());
            cs.setString(5, empleado.getCargo());
            cs.setString(6, empleado.getUser());
            cs.setString(7, empleado.getPass());
            cs.setString(8, empleado.getEstado());
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
    public String empleadoUpd(Empleado empleado) {
        String storedProcedure = "CALL ActualizarEmpleado(?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, empleado.getNombre());
            cs.setString(2, empleado.getApellido());
            cs.setDouble(3, empleado.getSalario());
            cs.setString(4, empleado.getCargo());
            cs.setString(5, empleado.getUser());
            cs.setString(6, empleado.getPass());
            cs.setString(7, empleado.getCodEmpleado());
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
    public String empleadoDel(String codEmpleado) {
        String storedProcedure = "CALL EliminarEmpleado(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, codEmpleado);
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
    public String obtenerCodPorCredenciales(String user, String pass) {
        String storedProcedure = "CALL ObtenerCodEmpleadoPorCredenciales(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, user);
            cs.setString(2, pass);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("CodEmpleado");
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return null;
    }

    @Override
    public String llevarCodAuxiliar(String codEmp) {
        String storedProcedure = "CALL InsertarCodAuxiliar(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, codEmp);
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                return "Código de empleado insertado con éxito en guardempl.";
            } else {
                return "Error al insertar el código de empleado en guardempl.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error SQL: " + e.getMessage();
        }
    }

    @Override
    public String obtenerCodAuxiliar() {
        String storedProcedure = "CALL ObtenerCodAuxiliar()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("CodEmpl");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void eliminarCodAuxiliar() {
        String storedProcedure = "CALL EliminarCodAuxiliar()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.executeUpdate();
            System.out.println("Se ha eliminado el valor de CodEmpl correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEstadoEmpleado(String codEmpleado, String nuevoEstado) {
        String storedProcedure = "CALL ActualizarEstadoEmpleado(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, codEmpleado);
            cs.setString(2, nuevoEstado);
            cs.executeUpdate();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public List<Acciones> listaAccion() {
        List<Acciones> lista = null;
        String storedProcedure = "CALL ObtenerListaAcciones()";

        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            ResultSet rs = cs.executeQuery();
            lista = new ArrayList<>();

            while (rs.next()) {
                Acciones acciones = new Acciones();
                acciones.setId(rs.getInt(1));
                acciones.setAccion(rs.getString(2));
                acciones.setFecha(rs.getString(3));
                lista.add(acciones);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return lista;
    }

}
