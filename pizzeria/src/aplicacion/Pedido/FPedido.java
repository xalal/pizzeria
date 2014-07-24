/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.Pedido;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void insertarPedido(Pedido pedido) throws SQLException {

        sSQL = "INSERT INTO cliente ("
                + "estatus,"
                + "idcliente,"
                + "fechapedido,"
                + "hrpedido,"
                + "hrentrega "
                + ")"
                + " values (?,?,?,?,?)";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setInt(1, pedido.getEstatus());
        pst.setInt(2, pedido.getCliente().getIdcliente());
        pst.setDate(3, pedido.getFechaPedido());
        pst.setTime(4, pedido.getHrpedido());
        pst.setTime(5, pedido.getHrEntrega());

        pst.executeUpdate();
        pst.close();
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
            pedido.setFechaPedido((java.sql.Date) rs.getDate("fechapedido"));
            pedido.setHrpedido((java.sql.Time) rs.getTime("hrpedido"));
            pedido.setHrEntrega((java.sql.Time) rs.getTime("hrentrega"));
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
            pedido.setFechaPedido((java.sql.Date) rs.getDate("fechapedido"));
            pedido.setHrpedido((java.sql.Time) rs.getTime("hrpedido"));
            pedido.setHrEntrega((java.sql.Time) rs.getTime("hrentrega"));

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
            pedido.setFechaPedido((java.sql.Date) rs.getDate("fechapedido"));
            pedido.setHrpedido((java.sql.Time) rs.getTime("hrpedido"));
            pedido.setHrEntrega((java.sql.Time) rs.getTime("hrentrega"));

            lista.add(pedido);
        }

        pst.close();
        return lista;
    }

}
