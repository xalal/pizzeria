/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion.Pedido;

/**
 *
 * @author Imprenta Laurita
 */
public class Orden {
    private int idorden;
    private Pedido pedido;
    private Catalogo catalogo;
    private Producto producto;
    private int cantidad;
    private Double precio; //cambiar en BD a Double

    public Orden() {
    }

    public Orden(int idorden, Pedido pedido, Catalogo catalogo, Producto producto, int cantidad, Double precio) {
        this.idorden = idorden;
        this.pedido = pedido;
        this.catalogo = catalogo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    
    
}
