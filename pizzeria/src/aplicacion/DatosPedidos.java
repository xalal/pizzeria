package aplicacion;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DatosPedidos extends javax.swing.JPanel {

    public DatosPedidos() {
        initComponents();
        idPed.setVisible(false);

        btnCancelar.setOpaque(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);

        BtnFinalizar.setOpaque(false);
        BtnFinalizar.setContentAreaFilled(false);
        BtnFinalizar.setBorderPainted(false);

    }

    public void Datos(String Cliente, String Telefono, String Calle, String Numero, String Colonia, String Municipio, String Estado, String Fecha, String HrPed, String HrEnt, int contador, String idPedido) {

        JCliente.setText(Cliente);
        JDescripcion.setText(HrEnt);
        JDireccion.setText("<html><body>Calle: " + Calle + "<br>Numero: "
                + Numero + "<br>Colonia: "
                + Colonia + "<br>Municipio: "
                + Municipio + "<br>Estado: "
                + Estado + "</body></html>");
        JHora.setText(Fecha + " " + HrPed);
        JTelefono.setText(Telefono);
        Pedido.setText("Pedido #" + contador);
        idPed.setText(idPedido);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        JHora = new javax.swing.JLabel();
        JDescripcion = new javax.swing.JLabel();
        JCliente = new javax.swing.JLabel();
        JTelefono = new javax.swing.JLabel();
        JDireccion = new javax.swing.JLabel();
        EtiDireccion = new javax.swing.JLabel();
        EtiTelefono = new javax.swing.JLabel();
        EtiCliente = new javax.swing.JLabel();
        EtiDescripcion = new javax.swing.JLabel();
        EtiHora = new javax.swing.JLabel();
        Pedido = new org.edisoncor.gui.label.LabelHeader();
        btnCancelar = new javax.swing.JButton();
        BtnFinalizar = new javax.swing.JButton();
        idPed = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/notas.png"))); // NOI18N
        panelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JHora.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JHora.setText("12:00");
        panelImage1.add(JHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 21, 200, 30));

        JDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JDescripcion.setText("1:00 ");
        panelImage1.add(JDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 51, 70, 30));

        JCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JCliente.setText("lusito Perez");
        panelImage1.add(JCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 81, 250, 30));

        JTelefono.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JTelefono.setText("044-55-12-34-56-78");
        panelImage1.add(JTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 250, 30));

        JDireccion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        JDireccion.setText("Avenida siempre viva 123 ");
        panelImage1.add(JDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 400, -1));

        EtiDireccion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        EtiDireccion.setText("Direccion:");
        panelImage1.add(EtiDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 70, -1));

        EtiTelefono.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        EtiTelefono.setText("Telefono:");
        panelImage1.add(EtiTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 70, 30));

        EtiCliente.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        EtiCliente.setText("Cliente:");
        panelImage1.add(EtiCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 81, 70, 30));

        EtiDescripcion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        EtiDescripcion.setText("Hora de Entrega:");
        panelImage1.add(EtiDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 51, 120, 30));

        EtiHora.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        EtiHora.setText("Fecha y Hora:");
        panelImage1.add(EtiHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 21, 100, 30));

        Pedido.setText("Pedido # X");
        panelImage1.add(Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 179, 21));

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelImage1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 150, 34));

        BtnFinalizar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        BtnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OK.png"))); // NOI18N
        BtnFinalizar.setText("Finalizar");
        BtnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinalizarActionPerformed(evt);
            }
        });
        panelImage1.add(BtnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 150, 30));
        panelImage1.add(idPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 11, 36, 12));

        add(panelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 260));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinalizarActionPerformed
        ConexionBD con = new ConexionBD();
        Connection cn = con.conectar();
        int valor = 4; //el valor 4 indica q se concluyo el pedido exitosamente
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE pedido SET estatus='" + valor + "' WHERE idPedido='" + idPed.getText() + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
            this.removeAll();

        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error Datos No Guardados ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BtnFinalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ConexionBD con = new ConexionBD();
        Connection cn = con.conectar();
        int valor = 2;//el valor 2 indica que se concluyo el pedido pero no exitosamente (orden cancelada,no se encontro la direccion, fue una broma)
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE pedido SET estatus='" + valor + "' WHERE idPedido='" + idPed.getText() + "'");
            pst.executeUpdate();
            this.removeAll();

            JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error Datos No Guardados ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFinalizar;
    private javax.swing.JLabel EtiCliente;
    private javax.swing.JLabel EtiDescripcion;
    private javax.swing.JLabel EtiDireccion;
    private javax.swing.JLabel EtiHora;
    private javax.swing.JLabel EtiTelefono;
    private javax.swing.JLabel JCliente;
    private javax.swing.JLabel JDescripcion;
    private javax.swing.JLabel JDireccion;
    private javax.swing.JLabel JHora;
    private javax.swing.JLabel JTelefono;
    private org.edisoncor.gui.label.LabelHeader Pedido;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel idPed;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    // End of variables declaration//GEN-END:variables
}
