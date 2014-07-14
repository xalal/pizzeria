package aplicacion;

import java.util.Calendar;
import javax.swing.Timer;
import java.util.Date;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    Calendar calendario; 
    int dia, mes, año, hora, minutos, segundos;
    
    static Inicio ini = new Inicio();
    ModificarSistema mods = new ModificarSistema();
    TomarPedido tped = new TomarPedido();
    VerClientes vcli = new VerClientes();
    VerReportes vrep = new VerReportes();
    

    
    public Principal() {
        initComponents();
        setTitle("Pizzeria \"nombre de la pizzeria\" ");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/grafCirculo.jpg")).getImage());
        jLayeredPane1.add(ini, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(mods, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(tped, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(vcli, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.add(vrep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        reloj();
    } 
    
    
    public void reloj() { 
        calendario = new java.util.GregorianCalendar(); 
        segundos = calendario.get(Calendar.SECOND); 
        Timer timer = new Timer(1000, new ActionListener() { 
        @ Override 
        public void actionPerformed(java.awt.event.ActionEvent ae) { 
        Date actual = new Date(); 
        calendario.setTime(actual); 
        dia = calendario.get(Calendar.DAY_OF_MONTH); 
        mes = (calendario.get(Calendar.MONTH) + 1); 
        año = calendario.get(Calendar.YEAR); 
        hora = calendario.get(Calendar.HOUR_OF_DAY); 
        minutos = calendario.get(Calendar.MINUTE); 
        segundos = calendario.get(Calendar.SECOND); 
        String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
        String date = String.format("%02d / %02d / %02d", dia, mes, año); 
        label.setText("<html><center>" + hour + "<br>" + date); 
            }     
        }); 
        timer.start(); 
    } 
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPopup4 = new org.edisoncor.gui.button.ButtonPopup();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        BtnCliente = new org.edisoncor.gui.button.ButtonPopup();
        BtnReporte = new org.edisoncor.gui.button.ButtonPopup();
        BtnPedido = new org.edisoncor.gui.button.ButtonPopup();
        BtnInicio = new org.edisoncor.gui.button.ButtonPopup();
        BtnSistema = new org.edisoncor.gui.button.ButtonPopup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        buttonPopup4.setText("buttonPopup1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcMousePanel1.setColor1(new java.awt.Color(102, 255, 255));
        jcMousePanel1.setColor2(new java.awt.Color(102, 255, 255));
        jcMousePanel1.setModo(3);

        jcMousePanel2.setModo(2);

        BtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Man_Icon_64.png"))); // NOI18N
        BtnCliente.setText("CLIENTE");
        BtnCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClienteActionPerformed(evt);
            }
        });

        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Column_chart_Icon_64.png"))); // NOI18N
        BtnReporte.setText("REPORTE");
        BtnReporte.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });

        BtnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_Male_User_Icon_64 (2).png"))); // NOI18N
        BtnPedido.setText("PEDIDO");
        BtnPedido.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPedidoActionPerformed(evt);
            }
        });

        BtnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User_Files_Icon_64.png"))); // NOI18N
        BtnInicio.setText("INICIO");
        BtnInicio.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioActionPerformed(evt);
            }
        });

        BtnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Woody_user_Icon_64.png"))); // NOI18N
        BtnSistema.setText("SISTEMA");
        BtnSistema.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel2Layout = new javax.swing.GroupLayout(jcMousePanel2);
        jcMousePanel2.setLayout(jcMousePanel2Layout);
        jcMousePanel2Layout.setHorizontalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jcMousePanel2Layout.setVerticalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(BtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BtnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BtnSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cabecera.jpg"))); // NOI18N

        label.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSistemaActionPerformed
        
        ini.setVisible(false);
        mods.setVisible(true);
        tped.setVisible(false);
        vcli.setVisible(false);
        vrep.setVisible(false);
        mods.setBounds(10, 10, 860, 545);
        
        
    }//GEN-LAST:event_BtnSistemaActionPerformed

    private void BtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioActionPerformed
        
        ini.setVisible(true);
        mods.setVisible(false);
        tped.setVisible(false);
        vcli.setVisible(false);
        vrep.setVisible(false);
       ini.setBounds(10, 10, 860, 545);
    }//GEN-LAST:event_BtnInicioActionPerformed

    private void BtnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPedidoActionPerformed
        ini.setVisible(false);
        mods.setVisible(false);
        tped.setVisible(true);
        vcli.setVisible(false);
        vrep.setVisible(false);
        tped.setBounds(10, 10, 860, 545);
        
    }//GEN-LAST:event_BtnPedidoActionPerformed

    private void BtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClienteActionPerformed
        ini.setVisible(false);
        mods.setVisible(false);
        tped.setVisible(false);
        vcli.setVisible(true);
        vrep.setVisible(false);
        vcli.setBounds(10, 10, 860, 545);
        
    }//GEN-LAST:event_BtnClienteActionPerformed

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        ini.setVisible(false);
        mods.setVisible(false);
        tped.setVisible(false);
        vcli.setVisible(false);
        vrep.setVisible(true);
       vrep.setBounds(10, 10, 860, 545);
        
    }//GEN-LAST:event_BtnReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonPopup BtnCliente;
    private org.edisoncor.gui.button.ButtonPopup BtnInicio;
    private org.edisoncor.gui.button.ButtonPopup BtnPedido;
    private org.edisoncor.gui.button.ButtonPopup BtnReporte;
    private org.edisoncor.gui.button.ButtonPopup BtnSistema;
    private org.edisoncor.gui.button.ButtonPopup buttonPopup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
