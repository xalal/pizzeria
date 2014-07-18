/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class ModificarSistema extends javax.swing.JPanel {

    public ModificarSistema() {
        initComponents();
        llenarPanel();
    }
    private void llenarPanel(){
        BD.ConexionBD connect = new BD.ConexionBD();
        java.sql.Connection jsc = connect.conectar();
        if (jsc != null) {
            try {
                Statement st;
                ResultSet rs;
                st = (Statement) jsc.createStatement();
                rs = st.executeQuery("select * from catalogo");
                while (rs.next()) {
                    String descripcion=rs.getString("descripcion");
                    String imagen =rs.getString("imagen");
                    jPanel2.add(new Catalogo(descripcion,imagen));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModificarSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Conexion fallida");
        }
    }
    private void llenarPanel3(){
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setPreferredSize(new java.awt.Dimension(130, 134));
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPaquete1)
                .addGap(24, 24, 24)
                .addComponent(lblPaquete1)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblPaquete1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbPaquete1)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel2.add(jPanel3);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloConfigurar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblPaquete1 = new javax.swing.JLabel();
        jbPaquete1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(851, 549));

        tituloConfigurar.setBackground(new java.awt.Color(204, 102, 0));
        tituloConfigurar.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        tituloConfigurar.setForeground(new java.awt.Color(255, 255, 255));
        tituloConfigurar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloConfigurar.setText("Modificar Sistema");
        tituloConfigurar.setOpaque(true);

        jPanel2.setLayout(new java.awt.GridLayout(4, 3));

        jPanel3.setPreferredSize(new java.awt.Dimension(100, 134));

        lblPaquete1.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblPaquete1.setLabelFor(jbPaquete1);
        lblPaquete1.setText("Agregar");
        lblPaquete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbPaquete1.setBackground(new java.awt.Color(255, 255, 255));
        jbPaquete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        jbPaquete1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jbPaquete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbPaquete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPaquete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPaquete1)
                .addGap(24, 24, 24)
                .addComponent(lblPaquete1)
                .addContainerGap(558, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblPaquete1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbPaquete1)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
            .addComponent(tituloConfigurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbPaquete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPaquete1ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Nuevo Catalogo");
        frame.add(new NewCatalogo());
        frame.setSize(750, 220);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                refreshPantalla();
            }
        });
    }//GEN-LAST:event_jbPaquete1ActionPerformed

    @SuppressWarnings("empty-statement")
    private void refreshPantalla(){
        this.jPanel2.removeAll();
        llenarPanel3();
        llenarPanel();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbPaquete1;
    private javax.swing.JLabel lblPaquete1;
    private javax.swing.JLabel tituloConfigurar;
    // End of variables declaration//GEN-END:variables
}
