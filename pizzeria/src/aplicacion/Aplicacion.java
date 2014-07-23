/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import BD.ConexionBD;
import Validar.Validacion;
import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Aplicacion {
    
    static public BD.ConexionBD con = new ConexionBD();
    static public Connection cn = con.conectar();
        
    public static void main(String[] args) {
         int a = 0;
        String b = null,c = null;
        String query ="call sp_mostrarActivacion()";
       if(con!=null){
            try { 
                ResultSet rs;
                CallableStatement CS = (CallableStatement) cn.prepareCall(query);
                CS.execute();
                rs = CS.getResultSet();
                 while (rs.next()){
                 a= rs.getInt("id");
                 b = rs.getString("nombre");
                 c = rs.getString("compania");
                 }                

                    if(a!=0 && !b.equals("NombreXalalSoftware") && !c.equals("CompañiaXalalSoftware")){
                       Principal obj = new Principal();
                       obj.setVisible(true);
                       con.desconectar();
                    }else{
                        Validacion val = new Validacion();
                        val.setVisible(true); 
                        con.desconectar();
                    }  
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en la conexion."+ex, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }else{
           JOptionPane.showMessageDialog(null, "Eror en la conexion.", "ERROR", JOptionPane.WARNING_MESSAGE);
       }
    }   
}
