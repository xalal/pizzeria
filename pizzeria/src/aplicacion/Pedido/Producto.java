/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion.Pedido;

import BD.ConexionBD;
import aplicacion.VerClientes;
import com.mysql.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Abimael
 */
public class Producto {
    BD.ConexionBD con = new ConexionBD();
    java.sql.Connection jsc = con.conectar();
    public  ArrayList getCatalogos(){
        //sp_mostrarCatalogos
        ArrayList catalogos=new ArrayList();
        if (jsc != null) {
            try {
                ResultSet rs;
                String store="{ call sp_mostrarCatalogos() }";
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall(store);
                cStmt.execute();
                rs = cStmt.getResultSet();
                while (rs.next()) {
                    catalogos.add((Object)rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catalogos;
    }
    public ArrayList getProductos(String catalogo){
        ArrayList productos=new ArrayList();
       if (jsc != null) {
            try {
                ResultSet rs;
                String store="{ call sp_mostrarProductos('"+catalogo+"') }";
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall(store);
                cStmt.execute();
                rs = cStmt.getResultSet();
                while (rs.next()) {
                    productos.add((Object)rs.getString("nombre"));
                    productos.add((Object)rs.getString("id"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return productos;
    }
    public double getPrecioProducto(String catalogo, int producto){
        double precio=0;
        if (jsc != null) {
            try {
                ResultSet rs;
                String store="{ call obtenerPrecioProducto('"+catalogo+"',"+producto+") }";
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall(store);
                cStmt.execute();
                rs = cStmt.getResultSet();
                while (rs.next()) {
                    precio=rs.getDouble("precio");
                }
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return precio;
    }
}
