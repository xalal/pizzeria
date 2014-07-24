/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.Pedido;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Roque
 */
public class FProducto {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public ArrayList buscarLista(String catalogo) {

        ArrayList lista = new ArrayList();
        sSQL = "SELECT * FROM " + catalogo;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

        return lista;
    }

    public Double damePrecio(String catalogo, String producto) {
        
        Double precio = 0.0;
        sSQL = "SELECT precio FROM " + catalogo + " WHERE nombre='" + producto + "'";
        System.out.println("producto dameprecio: " + sSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"dameprecio producto: "+ e);
        }

        return precio;
    }

    public String busca(String catalogo, String producto) {
        String id = "";
        
        sSQL = "SELECT * FROM " + catalogo + " WHERE nombre='" + producto + "'";
        System.out.println("producto busca: " + sSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "busca producto: " + e);
        }

        return id;
    }
}
