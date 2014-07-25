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
public class Pedido {

    private int idpedido;
    private int estatus;
    private Cliente cliente;
    private String fechaPedido;
    private String hrpedido;
    private String hrEntrega;

    public Pedido() {
    }

    public Pedido(int idpedido, int estatus, Cliente cliente, String fechaPedido, String hrpedido, String hrEntrega) {
        this.idpedido = idpedido;
        this.estatus = estatus;
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.hrpedido = hrpedido;
        this.hrEntrega = hrEntrega;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getHrpedido() {
        return hrpedido;
    }

    public void setHrpedido(String hrpedido) {
        this.hrpedido = hrpedido;
    }

    public String getHrEntrega() {
        return hrEntrega;
    }

    public void setHrEntrega(String hrEntrega) {
        this.hrEntrega = hrEntrega;
    }

}
