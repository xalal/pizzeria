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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imprenta Laurita
 */
public class FProducto {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String tabla, String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Descripción", "Precio"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * "
                + "FROM " + tabla
                + " WHERE nombre LIKE '%" + buscar + "%' "
                + "ORDER BY nombre DESC";

        System.out.println(sSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("precio");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    /*
     public boolean insertar(TProducto dts) {
     sSQL = "INSERT INTO producto ("
     + "idcatalogo,"
     + "nombreproducto,"
     + "descripcion,"
     + "precio"
     + ")"
     + " values (?,?,?,?)";
     try {

     PreparedStatement pst = cn.prepareStatement(sSQL);
     pst.setInt(1, dts.getIdCatalogo());
     pst.setString(2, dts.getNombreproducto());
     pst.setString(3, dts.getDescripcion());
     pst.setDouble(4, dts.getPrecio());

     int n = pst.executeUpdate();

     if (n != 0) {
     return true;
     } else {
     return false;
     }

     } catch (Exception e) {
     JOptionPane.showConfirmDialog(null, e);
     return false;
     }
     }

   
     public boolean editar(TProducto dts) {
     sSQL = "UPDATE producto SET "
     + "nombreproducto=?,"
     + "descripcion=?,"
     + "precio=? "
     + "WHERE idproducto=?";

     try {
     PreparedStatement pst = cn.prepareStatement(sSQL);
     pst.setString(1, dts.getNombreproducto());
     pst.setString(2, dts.getDescripcion());
     pst.setDouble(3, dts.getPrecio());

     pst.setInt(4, dts.getIdproducto());

     int n = pst.executeUpdate();

     if (n != 0) {
     return true;
     } else {
     return false;
     }

     } catch (Exception e) {
     JOptionPane.showConfirmDialog(null, e);
     return false;
     }
     }

     public boolean eliminar(TProducto dts) {
     sSQL = "DELETE FROM producto WHERE idproducto=?";

     try {

     PreparedStatement pst = cn.prepareStatement(sSQL);

     pst.setInt(1, dts.getIdproducto());

     int n = pst.executeUpdate();

     if (n != 0) {
     return true;
     } else {
     return false;
     }

     } catch (Exception e) {
     JOptionPane.showConfirmDialog(null, e);
     return false;
     }
     }
     */
}
