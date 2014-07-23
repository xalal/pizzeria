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
    public String nomservidor = "www.db4free.net";
    public String db = "pizzeria";// poner el nombre de la base de datos y listo para usar
    public String user = "xalal1234";
    public String pass = "xalal1234";
    private static Connection conn = null;
    private boolean flag=true;
    private static ConexionBD dbConnectionSingleton = null;
//metodo que realiza la conexion a la base de datos
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            flag = false;
        }
        if (flag) {
            openConexion();
        }
        
    }
    private void openConexion(){
        if (conn == null) {
            try {
                String ruta = "jdbc:mysql://";
                String servidor = nomservidor + ":" + puerto + "/";
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ruta + servidor + db, user, pass);
                if (conn != null) {
                    System.out.println("Conección a base de datos listo...");
                } else{
                    throw new SQLException();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                flag = false;
            } catch (ClassNotFoundException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
                flag = false;
            }
        }
    }
    public Connection conectar() {
        if (conn == null) {
            openConexion();
        }
        return conn;
    }
    public static ConexionBD getInstance() {
        if (dbConnectionSingleton == null) {
            dbConnectionSingleton = new ConexionBD();
        }
        return dbConnectionSingleton;
    }
    public boolean getConnectionStatus() {
        return flag;
    }
//metodo que para desconectarse de la base de datos
//    public void desconectar() {
//        conn = null;
//        System.out.println("Desconexion a base de datos listo...");
//    }
}
