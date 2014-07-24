/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.Pedido;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            JOptionPane.showConfirmDialog(null, "error busca catalogo: " + e);
        }

        return id;
    }

    //---------------------NUEVAS FUNCIONES MEJORADAS--------------------------------
    public Catalogo buscarCatalogo(int idcatalogo) throws SQLException {
        return buscarCatalogo(idcatalogo, null);
    }

    public Catalogo buscarCatalogo(int idcatalogo, Catalogo catalogo) throws SQLException {

        sSQL = "SELECT * FROM catalogo WHERE idcatalogo=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setInt(1, idcatalogo);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (catalogo == null) {
                catalogo = new Catalogo() {
                };
            }
            catalogo.setIdcatalogo(idcatalogo);
            catalogo.setDescripcion(rs.getString("descripcion"));
            catalogo.setImagen(rs.getString("imagen"));

        }
        pst.close();
        return catalogo;
    }

    public Catalogo buscarCatalogoNombre(String descripcion) throws SQLException {
        return buscarCatalogoNombre(descripcion, null);
    }

    public Catalogo buscarCatalogoNombre(String descripcion, Catalogo catalogo) throws SQLException {

        sSQL = "SELECT * FROM catalogo WHERE descripcion=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setString(1, descripcion);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (catalogo == null) {
                catalogo = new Catalogo() {
                };
            }
            catalogo.setIdcatalogo(rs.getInt("idcatalogo"));
            catalogo.setDescripcion(rs.getString("descripcion"));
            catalogo.setImagen(rs.getString("imagen"));

        }
        pst.close();
        return catalogo;
    }

    public ArrayList<Catalogo> mostrarCatalogo() throws SQLException {

        ArrayList<Catalogo> lista = new ArrayList<Catalogo>();

        sSQL = "SELECT * FROM catalogo";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Catalogo catalogo = new Catalogo() {
            };

            catalogo.setIdcatalogo(rs.getInt("idcatalogo"));
            catalogo.setDescripcion(rs.getString("descripcion"));
            catalogo.setImagen(rs.getString("imagen"));

            lista.add(catalogo);
        }

        pst.close();
        return lista;
    }

}
