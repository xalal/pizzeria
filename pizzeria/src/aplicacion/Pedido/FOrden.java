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
import java.util.ArrayList;

/**
 *
 * @author Imprenta Laurita
 */
public class FOrden {

    private ConexionBD mysql = new ConexionBD();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    /*
     private int idorden;
     private TPedido ipedido;
     private TCatalogo icatalogo;
     private TProducto iproducto;
     private int cantidad;
     private Double precio; //cambiar en BD a Double
     */
    public void insertarOrden(Orden orden) throws SQLException {

        sSQL = "INSERT INTO orden ("
                + "idpedido,"
                + "idcatalogo,"
                + "idproducto,"
                + "cantidad,"
                + "precio "
                + ")"
                + " values (?,?,?,?,?)";

        PreparedStatement pst = cn.prepareStatement(sSQL);
        pst.setInt(1, orden.getPedido().getIdpedido());
        pst.setInt(2, orden.getCatalogo().getIdcatalogo());
        pst.setInt(3, orden.getProducto().getId());
        pst.setInt(4, orden.getCantidad());
        pst.setDouble(5, orden.getPrecio());

        pst.executeUpdate();
        pst.close();
    }

    //implementar eliminar orden
    
    
    
    
    
    public ArrayList<Orden> mostrarOrden(int idpedido) throws SQLException {

        ArrayList<Orden> lista = new ArrayList<Orden>();

        sSQL = "SELECT * FROM orden WHERE idpedido=?";

        PreparedStatement pst = cn.prepareStatement(sSQL);

        pst.setInt(1, idpedido);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Orden orden = new Orden() {
            };

            orden.setIdorden(rs.getInt("idorden"));

            FPedido pedido = new FPedido();
            orden.setPedido(pedido.buscarPedido(idpedido));

            FCatalogo fcatalogo = new FCatalogo();
            Catalogo catalogo = fcatalogo.buscarCatalogo(rs.getInt("idcatalogo"));
            orden.setCatalogo(catalogo);

            FProducto fproducto = new FProducto();
            orden.setProducto(fproducto.buscarProducto(catalogo.getDescripcion(), rs.getInt("idproducto")));

            orden.setCantidad(rs.getInt("cantidad"));
            orden.setPrecio(rs.getDouble("precio"));

            lista.add(orden);
        }

        pst.close();
        return lista;
    }

    
    
  

}
