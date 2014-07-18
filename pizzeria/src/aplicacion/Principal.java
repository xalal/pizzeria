package aplicacion;


import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

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
        ini.setVisible(true);
        ini.setBounds(10, 10, 860, 545);
        setTitle("Paulo's Pizza ");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/grafCirculo.jpg")).getImage());
        jLayeredPane1.add(ini, javax.swing.JLayeredPane.DEFAULT_LAYER );
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
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        BtnCliente = new org.edisoncor.gui.button.ButtonPopup();
        BtnReporte = new org.edisoncor.gui.button.ButtonPopup();
        BtnPedido = new org.edisoncor.gui.button.ButtonPopup();
        BtnInicio = new org.edisoncor.gui.button.ButtonPopup();
        BtnSistema = new org.edisoncor.gui.button.ButtonPopup();
        BtnSalir = new org.edisoncor.gui.button.ButtonPopup();
        jPanel2 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        buttonPopup4.setText("buttonPopup1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(238, 171, 52));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 750));

        jLayeredPane1.setBackground(new java.awt.Color(217, 147, 40));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setOpaque(true);

        jcMousePanel2.setModo(2);

        BtnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Man_Icon_64.png"))); // NOI18N
        BtnCliente.setText("CLIENTE");
        BtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClienteActionPerformed(evt);
            }
        });

        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Column_chart_Icon_64.png"))); // NOI18N
        BtnReporte.setText("REPORTE");
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });

        BtnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_Male_User_Icon_64 (2).png"))); // NOI18N
        BtnPedido.setText("PEDIDO");
        BtnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPedidoActionPerformed(evt);
            }
        });

        BtnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User_Files_Icon_64.png"))); // NOI18N
        BtnInicio.setText("INICIO");
        BtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioActionPerformed(evt);
            }
        });

        BtnSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Woody_user_Icon_64.png"))); // NOI18N
        BtnSistema.setText("SISTEMA");
        BtnSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSistemaActionPerformed(evt);
            }
        });

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Woody_user_Icon_64.png"))); // NOI18N
        BtnSalir.setText("SALIR");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel2Layout = new javax.swing.GroupLayout(jcMousePanel2);
        jcMousePanel2.setLayout(jcMousePanel2Layout);
        jcMousePanel2Layout.setHorizontalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnReporte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jcMousePanel2Layout.setVerticalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(238, 171, 52));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        label.setBackground(new java.awt.Color(255, 255, 0));
        label.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cabecera.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcMousePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnSalirActionPerformed

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
    private org.edisoncor.gui.button.ButtonPopup BtnSalir;
    private org.edisoncor.gui.button.ButtonPopup BtnSistema;
    private org.edisoncor.gui.button.ButtonPopup buttonPopup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
