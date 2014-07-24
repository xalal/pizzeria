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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roque
 */
public class FCliente {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Teléfono", "Calle", "Número", "Referencia 1", "Referencia 2", "Colonia", "Municipio", "Estado"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM cliente WHERE telefono LIKE '%" + buscar + "%' ORDER BY idcliente";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("calle");
                registro[4] = rs.getString("numero");
                registro[5] = rs.getString("referencia1");
                registro[6] = rs.getString("referencia2");
                registro[7] = rs.getString("colonia");
                registro[8] = rs.getString("municipio");
                registro[9] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Cliente dts) {
        sSQL = "INSERT INTO cliente ("
                + "nombre,"
                + "telefono,"
                + "calle,"
                + "numero,"
                + "referencia1,"
                + "referencia2,"
                + "colonia,"
                + "municipio,"
                + "estado"
                + ")"
                + " values (?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getCalle());
            pst.setString(4, dts.getNumero());
            pst.setString(5, dts.getReferencia1());
            pst.setString(6, dts.getReferencia2());
            pst.setString(7, dts.getColonia());
            pst.setString(8, dts.getMunicipio());
            pst.setString(9, dts.getEstado());

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

    public boolean editar(Cliente dts) {
        sSQL = "UPDATE cliente SET "
                + "nombre=?,"
                + "telefono=?,"
                + "calle=?,"
                + "numero=?,"
                + "referencia1=?,"
                + "referencia2=?,"
                + "colonia=?,"
                + "municipio=?,"
                + "estado=?"
                + " WHERE idcliente=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getTelefono());
            pst.setString(3, dts.getCalle());
            pst.setString(4, dts.getNumero());
            pst.setString(5, dts.getReferencia1());
            pst.setString(6, dts.getReferencia2());
            pst.setString(7, dts.getColonia());
            pst.setString(8, dts.getMunicipio());
            pst.setString(9, dts.getEstado());

            pst.setInt(10, dts.getIdcliente());

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

    public boolean eliminar(Cliente dts) {
        sSQL = "DELETE FROM cliente WHERE idcliente=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdcliente());

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

    public DefaultTableModel buscarTelefono(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Teléfono", "Calle", "Manzana", "No. Ext", "No. Int", "Colonia", "Municipio", "Estado"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM cliente WHERE telefono=" + buscar + " ORDER BY idcliente";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("calle");
                registro[4] = rs.getString("numero");
                registro[5] = rs.getString("referencia1");
                registro[6] = rs.getString("referencia2");
                registro[7] = rs.getString("colonia");
                registro[8] = rs.getString("municipio");
                registro[9] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    //---------------------NUEVAS FUNCIONES MEJORADAS--------------------------------
    public Cliente buscarCliente(int id) throws SQLException {
        return buscarCliente(id, null);
    }

    public Cliente buscarCliente(int idcliente, Cliente cliente) throws SQLException {

        sSQL = "SELECT * FROM cliente WHERE idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, idcliente);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if (cliente == null) {
                    cliente = new Cliente() {
                    };
                }
                cliente.setIdcliente(idcliente);
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setReferencia1(rs.getString("referencia1"));
                cliente.setReferencia2(rs.getString("referencia2"));
                cliente.setColonia(rs.getString("colonia"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setEstado(rs.getString("estado"));
            }
            pst.close();

        } catch (Exception e) {
            System.out.println("error buscar" + e);
        }

        return cliente;
    }

    public Cliente buscarClienteTelefono(String telefono) throws SQLException {
        return buscarClienteTelefono(telefono, null);
    }

    public Cliente buscarClienteTelefono(String telefono, Cliente cliente) throws SQLException {

        sSQL = "SELECT * FROM cliente WHERE telefono=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setString(1, telefono);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (cliente == null) {
                cliente = new Cliente() {
                };
            }
            cliente.setIdcliente(rs.getInt("idcliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCalle(rs.getString("calle"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setReferencia1(rs.getString("referencia1"));
            cliente.setReferencia2(rs.getString("referencia2"));
            cliente.setColonia(rs.getString("colonia"));
            cliente.setMunicipio(rs.getString("municipio"));
            cliente.setEstado(rs.getString("estado"));
        }
        pst.close();
        return cliente;
    }

    public ArrayList<Cliente> mostrarCliente() throws SQLException {

        ArrayList<Cliente> lista = new ArrayList<Cliente>();

        sSQL = "SELECT * FROM cliente";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente() {
            };

            cliente.setIdcliente(rs.getInt("idcliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCalle(rs.getString("calle"));
            cliente.setNumero(rs.getString("numero"));
            cliente.setReferencia1(rs.getString("referencia1"));
            cliente.setReferencia2(rs.getString("referencia2"));
            cliente.setColonia(rs.getString("colonia"));
            cliente.setMunicipio(rs.getString("municipio"));
            cliente.setEstado(rs.getString("estado"));

            lista.add(cliente);
        }

        pst.close();
        return lista;
    }

}
