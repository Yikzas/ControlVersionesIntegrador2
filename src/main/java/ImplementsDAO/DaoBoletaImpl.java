package ImplementsDAO;
import InterfacesDAO.DaoBoleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Conexion.ConexionBD;
import Entidades.Boleta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
public class DaoBoletaImpl implements DaoBoleta {  
    private final ConexionBD conexion;

    public DaoBoletaImpl() {
        conexion = new ConexionBD();
    }

    @Override
    public boolean insertarBoletaVenta(Boleta boleta) {
        String sql = "CALL InsertarBoletaVenta(?, ?, ?, ?)";
        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(sql)) {
            cs.setInt(1, boleta.getIDRegistro());
            cs.setString(2, boleta.getCodEmpleado());
            cs.setString(3, boleta.getHora());
            cs.setString(4, boleta.getFecha());
            int filasAfectadas = cs.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int obtenerUltimoIDBoletaVenta() {
        int ultimoID = 0;
        String sql = "CALL ObtenerUltimoIDBoletaVenta(?)";

        try (Connection cn = conexion.getConexion(); CallableStatement cs = cn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            ultimoID = cs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimoID;
    }

}

