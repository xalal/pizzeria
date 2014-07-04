package aplicacion;

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DatosPedidos extends javax.swing.JPanel {
    
    public DatosPedidos() {
        initComponents();
       idPed.setVisible(false);
    }
    
    public void Datos(String Cliente,String Telefono,String Calle,String Numero,String Colonia,String Municipio,String Estado,String Fecha,String HrPed,String HrEnt,int contador,String idPedido){

        JCliente.setText(Cliente);
        JDescripcion.setText(HrEnt);
        JDireccion.setText("<html><body>Calle: "+Calle+"<br>Numero: "
                +Numero+"<br>Colonia: "
                +Colonia+"<br>Municipio: "
                +Municipio+"<br>Estado: "
                +Estado+"</body></html>");
        JHora.setText(Fecha+" "+HrPed);
        JTelefono.setText(Telefono);
        Pedido.setText("Pedido #"+contador);
        idPed.setText(idPedido);
    }
            
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        Pedido = new org.edisoncor.gui.label.LabelHeader();
        EtiHora = new javax.swing.JLabel();
        EtiCliente = new javax.swing.JLabel();
        JCliente = new javax.swing.JLabel();
        JHora = new javax.swing.JLabel();
        EtiTelefono = new javax.swing.JLabel();
        JTelefono = new javax.swing.JLabel();
        EtiDireccion = new javax.swing.JLabel();
        JDireccion = new javax.swing.JLabel();
        EtiDescripcion = new javax.swing.JLabel();
        JDescripcion = new javax.swing.JLabel();
        idPed = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnFinalizar.setBackground(new java.awt.Color(0, 255, 204));
        BtnFinalizar.setText("Finalizar");
        BtnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinalizarActionPerformed(evt);
            }
        });
        add(BtnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 74, 92, 30));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 29, 92, 34));

        Pedido.setText("Pedido # X");
        add(Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 179, 21));

        EtiHora.setText("Fecha y Hora:");
        add(EtiHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        EtiCliente.setText("Cliente:");
        add(EtiCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 68, -1));

        JCliente.setText("lusito Perez");
        add(JCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 282, -1));

        JHora.setText("12:00");
        add(JHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 265, -1));

        EtiTelefono.setText("Telefono:");
        add(EtiTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        JTelefono.setText("044-55-12-34-56-78");
        add(JTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 126, -1));

        EtiDireccion.setText("Direccion:");
        add(EtiDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        JDireccion.setText("Avenida siempre viva 123 ");
        add(JDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        EtiDescripcion.setText("Hora de Entrega:");
        add(EtiDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        JDescripcion.setText("aqui por ejemplo poner el pedido realizado: ");
        add(JDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));
        add(idPed, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 11, 36, 12));
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinalizarActionPerformed
        ConexionBD con = new ConexionBD();
        Connection cn = con.conectar();
        int valor = 1; //el valor 1 indica q se concluyo el pedido exitosamente
        try {
        PreparedStatement pst = cn.prepareStatement("UPDATE Pedido SET estatus='"+valor+"' WHERE idPedido='"+idPed.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
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
        PreparedStatement pst = cn.prepareStatement("UPDATE Pedido SET estatus='"+valor+"' WHERE idPedido='"+idPed.getText()+"'");
        pst.executeUpdate();
        this.removeAll();
        
        JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
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
    // End of variables declaration//GEN-END:variables
}
