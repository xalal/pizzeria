package aplicacion;

import BD.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;

public class Inicio extends javax.swing.JPanel {

    public Inicio() {
        initComponents();
        CargarBD();
    }

    public void CargarBD() {
        ConexionBD con = new ConexionBD();
        Connection cn = con.conectar();
        java.sql.Connection jsc = con.conectar();
        if (jsc != null) {
            try {
                int contador = 0;
                ResultSet rs;
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall("{ call sp_mostrarPedidos() }");
                cStmt.execute();
                rs = cStmt.getResultSet();
                while (rs.next()) {
                    String nombre =  rs.getString("nombreCliente"); //se obtiene la hora
                    String telefono =  rs.getString("telefonoCliente");//se obtiene el cliente
                    String calle = rs.getString("calleCliente");//se obtiene la direccion
                    String numero =  rs.getString("numeroCliente"); //se obtiene la descripcion
                    String colonia = rs.getString("coloniaCliente");//se obtiene otro dato
                    String municipio = rs.getString("municipioCliente");//se obtiene otro dato
                    String estado =  rs.getString("estadoCliente");//se obtiene otro dato
                    String fechaPedido = rs.getString("fechaPedido");//se obtiene otro dato
                    String hrPedido = rs.getString("hrPedido");//se obtiene otro dato
                    String hrEntrega = rs.getString("hrEntrega");
                    String ped = rs.getString("idPedido");
                    DatosPedidos form = new DatosPedidos();
                    contador++;
                    form.Datos(nombre, telefono, calle, numero, colonia, municipio, estado, fechaPedido, hrPedido, hrEntrega, contador, ped);
                    jPanel1.add(form);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la conexion ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedidos.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
