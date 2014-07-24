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
 * @author Imprenta Laurita
 */
public class FCatalogo {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public ArrayList buscarLista() {

        ArrayList lista = new ArrayList();
        sSQL = "SELECT * FROM catalogo";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

        return lista;
    }
    
    
    public String busca(String catalogo) {
        String id = "";
        sSQL = "SELECT * FROM catalogo WHERE descripcion='" + catalogo + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                id = rs.getString("idcatalogo");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "error busca catalogo: "+e);
        }

        return id;
    }

}
