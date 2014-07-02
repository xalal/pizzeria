package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class ConexionBD {

    public String puerto = "3306";
    public String nomservidor = "sql2.freemysqlhosting.net";
    public String db = "sql245039";// poner el nombre de la base de datos y listo para usar
    public String user = "sql245039";
    public String pass = "uI2*uT6*";
    Connection conn = null;

//metodo que realiza la conexion a la base de datos
    public Connection conectar() {
        try {
            String ruta = "jdbc:mysql://";
            String servidor = nomservidor + ":" + puerto + "/";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ruta + servidor + db, user, pass);

            if (conn != null) {
                System.out.println("Conección a base de datos listo...");
            } else if (conn == null) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } finally {
            return conn;
        }
    }

//metodo que para desconectarse de la base de datos
    public void desconectar() {
        conn = null;
        System.out.println("Desconexion a base de datos listo...");
    }
}
