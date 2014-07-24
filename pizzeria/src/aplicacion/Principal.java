package aplicacion;


import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Principal extends javax.swing.JFrame {

    Calendar calendario; 
    int dia, mes, año, hora, minutos, segundos;
    
    static Inicio ini;
    ModificarSistema mods;
    TomarPedido tped;
    VerClientes vcli;
    VerReportes vrep;

    
    public Principal() {
        initComponents();
        setTitle("Paulo's Pizza ");
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/grafCirculo.jpg")).getImage());
        ini = new Inicio();
        ini.setVisible(true);
        ini.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(ini, javax.swing.JLayeredPane.DEFAULT_LAYER );
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
        jPanel2 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        BtnCliente = new org.edisoncor.gui.button.ButtonPopup();
        BtnReporte = new org.edisoncor.gui.button.ButtonPopup();
        BtnPedido = new org.edisoncor.gui.button.ButtonPopup();
        BtnInicio = new org.edisoncor.gui.button.ButtonPopup();
        BtnSistema = new org.edisoncor.gui.button.ButtonPopup();

        buttonPopup4.setText("buttonPopup1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setOpaque(false);

        label.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cabecera.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLayeredPane1.setBackground(new java.awt.Color(61, 44, 37));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setOpaque(true);

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
                .addContainerGap()
                .addGroup(jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jcMousePanel2Layout.setVerticalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BtnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(BtnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(BtnSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane1)
                    .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSistemaActionPerformed
        jLayeredPane1.removeAll();
        mods = new ModificarSistema();
        mods.setVisible(true);
        mods.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(mods, javax.swing.JLayeredPane.DEFAULT_LAYER );
        
        
    }//GEN-LAST:event_BtnSistemaActionPerformed

    private void BtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioActionPerformed
        jLayeredPane1.removeAll();
        ini = new Inicio();
        ini.setVisible(true);
        ini.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(ini, javax.swing.JLayeredPane.DEFAULT_LAYER );
    }//GEN-LAST:event_BtnInicioActionPerformed

    private void BtnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPedidoActionPerformed
        jLayeredPane1.removeAll();
        tped = new TomarPedido();
        tped.setVisible(true);
        tped.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(tped, javax.swing.JLayeredPane.DEFAULT_LAYER );
    }//GEN-LAST:event_BtnPedidoActionPerformed

    private void BtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClienteActionPerformed
        jLayeredPane1.removeAll();
        vcli = new VerClientes();
        vcli.setVisible(true);
        vcli.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(vcli, javax.swing.JLayeredPane.DEFAULT_LAYER );
        
    }//GEN-LAST:event_BtnClienteActionPerformed

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        jLayeredPane1.removeAll();
        vrep = new VerReportes();
        vrep.setVisible(true);
        vrep.setBounds(10, 10, 860, 545);
        jLayeredPane1.add(vrep, javax.swing.JLayeredPane.DEFAULT_LAYER );
    }//GEN-LAST:event_BtnReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonPopup BtnCliente;
    private org.edisoncor.gui.button.ButtonPopup BtnInicio;
    private org.edisoncor.gui.button.ButtonPopup BtnPedido;
    private org.edisoncor.gui.button.ButtonPopup BtnReporte;
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
