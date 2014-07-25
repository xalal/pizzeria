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

/**
 *
 * @author Imprenta Laurita
 */
public class FPedido {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public int insertarPedido(Pedido pedido) throws SQLException {
        //devuelve el id del pedido;

        int key = -1;
        sSQL = "INSERT INTO pedido ( "
                + "estatus,"
                + "idcliente,"
                + "fechapedido,"
                + "hrpedido,"
                + "hrentrega "
                + ")"
                + " VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL, Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, pedido.getEstatus());
            pst.setInt(2, pedido.getCliente().getIdcliente());
            pst.setString(3, pedido.getFechaPedido());
            pst.setString(4, pedido.getHrpedido());
            pst.setString(5, pedido.getHrEntrega());
            
            

            System.out.println(sSQL);

            pst.executeUpdate();

            ResultSet keys = pst.getGeneratedKeys();
            while (keys.next()) {
                key = keys.getInt(1);
            }

            pst.close();

        } catch (Exception e) {
            System.out.println("error insert" + e);
        }

        return key;
    }

    public boolean editarPedido(Pedido pedido) throws SQLException {

        sSQL = "UPDATE pedido SET "
                + "estatus=?,"
                + "idcliente=?,"
                + "fechapedido=?,"
                + "hrpedido=?,"
                + "hrentrega=?"
                + " WHERE idpedido=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, pedido.getEstatus());
            pst.setInt(2, pedido.getCliente().getIdcliente());
            pst.setString(3, pedido.getFechaPedido());
            pst.setString(4, pedido.getHrpedido());
            pst.setString(5, pedido.getHrEntrega());

            pst.setInt(6, pedido.getIdpedido());

            int rowsUpdated = pst.executeUpdate();
            pst.close();

            return rowsUpdated > 0;

        } catch (Exception e) {
            System.out.println("error update" + e);
            return false;
        }
    }

    public boolean eliminarPedido(int idpedido) throws SQLException {
        sSQL = "DELETE FROM pedido WHERE idpedido=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, idpedido);

            int rowsUpdated = pst.executeUpdate();
            pst.close();

            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("error eliminar" + e);
            return false;
        }
    }

    public Pedido buscarPedido(int idpedido) throws SQLException {
        Pedido pedido = null;

        sSQL = "SELECT * FROM pedido WHERE idpedido=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setInt(1, idpedido);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            pedido = new Pedido() {
            };

            pedido.setIdpedido(idpedido);
            pedido.setEstatus(rs.getInt("estatus"));
            FCliente cliente = new FCliente();
            pedido.setCliente(cliente.buscarCliente(rs.getInt("idcliente")));
            pedido.setFechaPedido(rs.getString("fechapedido"));
            pedido.setHrpedido(rs.getString("hrpedido"));
            pedido.setHrEntrega(rs.getString("hrentrega"));
        }

        pst.close();
        return pedido;
    }

    public ArrayList<Pedido> mostrarPedido() throws SQLException {

        ArrayList<Pedido> lista = new ArrayList<Pedido>();

        sSQL = "SELECT * FROM pedido";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Pedido pedido = new Pedido() {
            };

            pedido.setIdpedido(rs.getInt("idpedido"));
            pedido.setEstatus(rs.getInt("estatus"));
            FCliente cliente = new FCliente();
            pedido.setCliente(cliente.buscarCliente(rs.getInt("idcliente")));
            pedido.setFechaPedido(rs.getString("fechapedido"));
            pedido.setHrpedido(rs.getString("hrpedido"));
            pedido.setHrEntrega(rs.getString("hrentrega"));

            lista.add(pedido);
        }

        pst.close();
        return lista;
    }

    public ArrayList<Pedido> mostrarPedido(int estatus) throws SQLException {

        ArrayList<Pedido> lista = new ArrayList<Pedido>();

        sSQL = "SELECT * FROM pedido WHERE estatus=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setInt(1, estatus);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Pedido pedido = new Pedido() {
            };

            pedido.setIdpedido(rs.getInt("idpedido"));
            pedido.setEstatus(rs.getInt("estatus"));
            FCliente cliente = new FCliente();
            pedido.setCliente(cliente.buscarCliente(rs.getInt("idcliente")));
            pedido.setFechaPedido(rs.getString("fechapedido"));
            pedido.setHrpedido(rs.getString("hrpedido"));
            pedido.setHrEntrega(rs.getString("hrentrega"));

            lista.add(pedido);
        }

        pst.close();
        return lista;
    }

}
