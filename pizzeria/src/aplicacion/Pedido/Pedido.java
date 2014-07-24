/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.Pedido;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Imprenta Laurita
 */
public class Pedido {

    private int idpedido;
    private int estatus;
    private Cliente cliente;
    private Date fechaPedido;
    private Time hrpedido;
    private Time hrEntrega;

    public Pedido() {
    }

    public Pedido(int idpedido, int estatus, Cliente cliente, Date fechaPedido, Time hrpedido, Time hrEntrega) {
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

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Time getHrpedido() {
        return hrpedido;
    }

    public void setHrpedido(Time hrpedido) {
        this.hrpedido = hrpedido;
    }

    public Time getHrEntrega() {
        return hrEntrega;
    }

    public void setHrEntrega(Time hrEntrega) {
        this.hrEntrega = hrEntrega;
    }

}
