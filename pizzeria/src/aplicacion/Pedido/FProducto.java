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
        //System.out.println("producto dameprecio: " + sSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "dameprecio producto: " + e);
        }

        return precio;
    }

    public String busca(String catalogo, String producto) {
        String id = "";

        sSQL = "SELECT * FROM " + catalogo + " WHERE nombre='" + producto + "'";
        //System.out.println("producto busca: " + sSQL);

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

    //---------------------NUEVAS FUNCIONES MEJORADAS--------------------------------
    public Producto buscarProducto(String catalogo, int producto) throws SQLException {
        return buscarProducto(catalogo, producto, null);
    }

    public Producto buscarProducto(String catalogo, int idproducto, Producto producto) throws SQLException {
       
        sSQL = "SELECT * FROM " + catalogo + " WHERE id=?";
        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setInt(1, idproducto);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (producto == null) {
                producto = new Producto() {
                };
            }
            producto.setTabla(catalogo);
            producto.setId(idproducto);
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getDouble("precio"));

        }

        return producto;
    }

    public Producto buscarProductoNombre(String catalogo, String producto) throws SQLException {
        return buscarProducto(catalogo, producto, null);
    }

    public Producto buscarProducto(String catalogo, String nombre, Producto producto) throws SQLException {

        sSQL = "SELECT * FROM ? WHERE nombre=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setString(1, catalogo);
        pst.setString(2, nombre);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (producto == null) {
                producto = new Producto() {
                };
            }
            producto.setTabla(catalogo);
            producto.setId(rs.getInt("id"));
            producto.setNombre(nombre);
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getDouble("precio"));

        }
        pst.close();
        return producto;
    }

    public ArrayList<Producto> mostrarProducto(String catalogo) throws SQLException {

        ArrayList<Producto> lista = new ArrayList<Producto>();

        sSQL = "SELECT * FROM ?";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setString(1, catalogo);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto() {
            };

            producto.setTabla(catalogo);
            producto.setId(rs.getInt("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getDouble("precio"));

            lista.add(producto);
        }

        pst.close();
        return lista;
    }

}
