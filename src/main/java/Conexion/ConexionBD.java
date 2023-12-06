package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3307/hotelito";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public Connection getConexion() throws SQLException {
        Connection c = null;
        try {
            Class.forName(DRIVER);
            c = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return c;
    }
}


