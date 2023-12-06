package ImplementsDAO;
import Conexion.ConexionBD;
import Entidades.Habitacion;
import InterfacesDAO.DaoHabitacion;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoHabitacionImpl implements DaoHabitacion {  
    
    private final ConexionBD conexion;
    
    public DaoHabitacionImpl() {
        conexion = new ConexionBD();
    }   
    
    @Override
    public boolean actualizarEstadoPorID(int idHabitacion, String nuevoEstado) {
        String storedProcedure = "CALL ActualizarEstadoHabitacionPorID(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idHabitacion);
            cs.setString(2, nuevoEstado);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertarHabitacion(Habitacion habitacion) {
        String storedProcedure = "CALL InsertarHabitacion(?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setString(1, habitacion.getEstado());
            cs.setInt(2, habitacion.getCapacidad());
            cs.setString(3, habitacion.getDescripcion());
            cs.setString(4, habitacion.getTipo());
            cs.setDouble(5, habitacion.getPrecio());
            File imagenFile = new File(habitacion.getImagen());
            FileInputStream fis = new FileInputStream(imagenFile);
            cs.setBinaryStream(6, fis, (int) imagenFile.length());
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String actualizar(Habitacion habitacion) {
        String mensaje = "";
        String storedProcedure = "CALL ActualizarHabitacion(?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, habitacion.getIDHabitacion());
            cs.setString(2, habitacion.getEstado());
            cs.setInt(3, habitacion.getCapacidad());
            cs.setString(4, habitacion.getDescripcion());
            cs.setString(5, habitacion.getTipo());
            cs.setDouble(6, habitacion.getPrecio());
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas > 0) {
                mensaje = "Actualización exitosa";
            } else {
                mensaje = "No se pudo actualizar la habitación";
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error al actualizar la habitación: " + e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String obtenerEstadoPorID(int idHabitacion) {
        String storedProcedure = "CALL ObtenerEstadoHabitacionPorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idHabitacion);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("estado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertarRelacionHabitacionR(int idRegistro, int idHabitacion) {
        String storedProcedure = "CALL InsertarRelacionHabitacionRegistro(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idHabitacion);
            cs.setInt(2, idRegistro);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean eliminarRelacionHabitacionR(int idRegistro, int idHabitacion) {
        String storedProcedure = "CALL EliminarRelacionHabitacionRegistro(?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idRegistro);
            cs.setInt(2, idHabitacion);
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int obtenerIDRegistroPorIDHabitacion(int idHabitacion) {
        String storedProcedure = "CALL ObtenerIDRegistroPorIDHabitacion(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idHabitacion);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDRegistro");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Habitacion> habitacionSel() {
        List<Habitacion> lista = null;
        String storedProcedure = "CALL SeleccionarHabitaciones()";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure); ResultSet rs = cs.executeQuery()) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setIDHabitacion(rs.getInt(1));
                habitacion.setEstado(rs.getString(2));
                habitacion.setCapacidad(rs.getInt(3));
                habitacion.setDescripcion(rs.getString(4));
                habitacion.setTipo(rs.getString(5));
                habitacion.setPrecio(rs.getDouble(6));
                byte[] imageData = rs.getBytes(7);
                String encodedImage = Base64.getEncoder().encodeToString(imageData);
                habitacion.setImagen(encodedImage);
                lista.add(habitacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String eliminar(int id) {
        String mensaje = "";
        String storedProcedure = "CALL EliminarHabitacion(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, id);
            int filasAfectadas = cs.executeUpdate();
            if (filasAfectadas == 0) {
                mensaje = "Cero registros eliminados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String obtenerTipoPorID(int idHabitacion) {
        String storedProcedure = "CALL ObtenerTipoPorIDHabitacion(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, idHabitacion);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Habitacion getHabi(int IDHabitacion) {
        Habitacion habitacion = null;
        String storedProcedure = "CALL ObtenerHabitacionPorID(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDHabitacion);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                habitacion = new Habitacion();
                habitacion.setIDHabitacion(rs.getInt(1));
                habitacion.setEstado(rs.getString(2));
                habitacion.setCapacidad(rs.getInt(3));
                habitacion.setDescripcion(rs.getString(4));
                habitacion.setTipo(rs.getString(5));
                habitacion.setPrecio(rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habitacion;
    }

    @Override
    public String getImage(int IDHabitacion) {
        String storedProcedure = "CALL ObtenerImagenPorIDHabitacion(?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(storedProcedure)) {
            cs.setInt(1, IDHabitacion);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                byte[] imageData = rs.getBytes(1);
                return Base64.getEncoder().encodeToString(imageData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
