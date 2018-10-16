package tienda.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Conexion {

    protected Connection cn = null;
    protected String url = "jdbc:mysql://localhost/tienda";
    protected String usuario = "root";
    protected String clave = "12345678";
    protected PreparedStatement stm;
    protected ResultSet rs;

    public Connection abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            System.out.println("cn:"+ex);
        }
        return cn;
    }

     protected void cerrar(Connection con) throws RuntimeException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException se) {
            System.err.println("Error: cerrarConexion: " + se);
        }
    }

    protected void cerrar(ResultSet rs) throws RuntimeException {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException se) {
            System.err.println("Error: cerrarResultSet: " + se);
        }
    }

    protected void cerrar(PreparedStatement stmt)
            throws RuntimeException {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
            System.err.println("Error: cerrarStatement: " + se);
        }
    }
}
