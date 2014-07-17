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
public class TCliente {
    private int idcliente;
    private String nombre;
    private String telefono;
    private String calle;
    private String numero;
    private String referencia1;
    private String referencia2;
    private String colonia;
    private String municipio;
    private String estado;

    public TCliente() {
    }

    public TCliente(int idcliente, String nombre, String telefono, String calle, String numero, String referencia1, String referencia2, String colonia, String municipio, String estado) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.referencia1 = referencia1;
        this.referencia2 = referencia2;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}
