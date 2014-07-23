/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion.Pedido;

import java.util.ArrayList;
/**
 *
 * @author Abimael
 */
public class Producto {
    public  ArrayList getCatalogos(){
        ArrayList catalogos=new ArrayList();
        catalogos.add("----");
        catalogos.add("----");
        catalogos.add("----");
        return catalogos;
    }
    public ArrayList getProductos(String catalogo){
        ArrayList productos=new ArrayList();
        productos.add("----");
        productos.add("----");
        productos.add("----");
        return productos;
    }
    public double getPrecioProducto(String catalogo, String producto){
        double precio=2.4;
        return precio;
    }
}
