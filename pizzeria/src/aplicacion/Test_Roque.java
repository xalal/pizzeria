/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.Pedido.Cliente;
import aplicacion.Pedido.FCatalogo;
import aplicacion.Pedido.FCliente;
import aplicacion.Pedido.FOrden;
import aplicacion.Pedido.FPedido;
import aplicacion.Pedido.FProducto;
import aplicacion.Pedido.Orden;
import aplicacion.Pedido.Pedido;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author Imprenta Laurita
 */
public class Test_Roque {

    public static void main(String[] args) throws SQLException {
        
        //funciones principales
        FPedido fpedido = new FPedido();
        FCliente fcliente = new FCliente();
        FOrden forden = new FOrden();
        FCatalogo fcatalogo = new FCatalogo();
        FProducto fproducto = new FProducto();
        //objetos
        Pedido pedido = new Pedido();
                
        
  
        
        /*
         //imprime nombre de clientes
         FCliente funcc = new FCliente();
         for (Cliente cliente : funcc.mostrarCliente()) {
         System.out.println(cliente.getNombre());
         }
         */

        /*
         //imprime todos los pedidos
         FPedido funcp = new FPedido();
         for (Pedido pedido:funcp.mostrarPedido()) {
         System.out.print(pedido.getIdpedido() + ", ");              //id pedido
         System.out.print(pedido.getEstatus() + ", ");               //estatus
         System.out.print(pedido.getCliente().getNombre() + ", ");   //nombre cliente
         System.out.print(pedido.getFechaPedido() + ", ");           //fecha pedido
         System.out.print(pedido.getHrpedido()+ ", ");               //hora pedido
         System.out.println(pedido.getHrEntrega()+ ", ");            //hora entrega
            
         }
         */
        /*
         //imprime todos los pedidos en estado 0
         FPedido funcp = new FPedido();
         for (Pedido pedido:funcp.mostrarPedido(0)) {
         System.out.print(pedido.getIdpedido() + ", ");              //id pedido
         System.out.print(pedido.getEstatus() + ", ");               //estatus
         System.out.print(pedido.getCliente().getNombre() + ", ");   //nombre cliente
         System.out.print(pedido.getFechaPedido() + ", ");           //fecha pedido
         System.out.print(pedido.getHrpedido()+ ", ");               //hora pedido
         System.out.println(pedido.getHrEntrega()+ ", ");            //hora entrega
         }
        
        
         */
        
        /*
        //imprimir un pedido con sus ordenes
        FPedido funcp = new FPedido();
        Pedido pedido = funcp.buscarPedido(3);

        System.out.print(pedido.getIdpedido() + ", ");              //id pedido
        System.out.print(pedido.getEstatus() + ", ");               //estatus
        System.out.print(pedido.getCliente().getNombre() + ", ");   //nombre cliente
        System.out.print(pedido.getFechaPedido() + ", ");           //fecha pedido
        System.out.print(pedido.getHrpedido() + ", ");               //hora pedido
        System.out.println(pedido.getHrEntrega() + ", ");            //hora entrega

        System.out.println("ORDENES: Articulos");
        FOrden funco = new FOrden();
        for (Orden orden : funco.mostrarOrden(pedido.getIdpedido())) {
            System.out.print("_____" + orden.getIdorden() + ", ");
            System.out.print(orden.getCatalogo().getDescripcion() + ", ");
            System.out.print(orden.getProducto().getNombre() + ", ");
            System.out.print(orden.getCantidad() + ", ");
            System.out.println(orden.getPrecio());

        }

        */
        
        
        /*
         //insertar una orden
        
         FPedido funcp = new FPedido();
         FOrden funco = new FOrden();
         FCatalogo funcc = new FCatalogo();
         FProducto funcpr = new FProducto();
        
         Orden orden = new Orden();
         orden.setPedido(funcp.buscarPedido(3));
         orden.setCatalogo(funcc.buscarCatalogo(2));
         orden.setProducto(funcpr.buscarProducto("pizza", 1));
         orden.setCantidad(1);
         orden.setPrecio(99.9);
     
         funco.insertarOrden(orden);

         */
        
        
        
        
        //insertar pedido
        
        /*
        
        
        int estatus = 0;
        pedido.setEstatus(estatus);
        pedido.setCliente(fcliente.buscarCliente(2));
        pedido.setFechaPedido(new Date(2014,7,24));
        pedido.setHrpedido(new Time(00, 00, 00));
        pedido.setHrEntrega(new Time(00, 00, 00));
        
        pedido.setIdpedido(fpedido.insertarPedido(pedido));
        
        System.out.println("id pedido: " + pedido.getIdpedido());
        */
    }

}
