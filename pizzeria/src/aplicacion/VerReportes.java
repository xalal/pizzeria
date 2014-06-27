/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author Maria
 */
public class VerReportes extends javax.swing.JPanel {

    /**
     * Creates new form VerReportes
     */
    public VerReportes() {
        initComponents();
        bgFiltros.add(jrbPorDia);
        bgFiltros.add(jrbPorSemana);
        bgFiltros.add(jrbPorMes);
        bgFiltros.add(jrbPorAño);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        tituloReportes = new javax.swing.JLabel();
        jrbPorDia = new javax.swing.JRadioButton();
        jrbPorSemana = new javax.swing.JRadioButton();
        jrbPorMes = new javax.swing.JRadioButton();
        jrbPorAño = new javax.swing.JRadioButton();
        lblImagen = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        jdcElegirDia = new com.toedter.calendar.JDateChooser();
        jmcElegirMes = new com.toedter.calendar.JMonthChooser();
        jycElegirAño = new com.toedter.calendar.JYearChooser();
        jycElegirAñoSemana = new com.toedter.calendar.JYearChooser();
        jmcElegirMesSemana = new com.toedter.calendar.JMonthChooser();
        jspNumeroSemana = new com.toedter.components.JSpinField();

        setBackground(new java.awt.Color(255, 255, 255));

        tituloReportes.setBackground(new java.awt.Color(51, 51, 255));
        tituloReportes.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        tituloReportes.setForeground(new java.awt.Color(204, 255, 204));
        tituloReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloReportes.setText("Reportes de Ventas");
        tituloReportes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        tituloReportes.setOpaque(true);

        jrbPorDia.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorDia.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorDia.setSelected(true);
        jrbPorDia.setActionCommand("porDia");
        jrbPorDia.setLabel("Por día");
        jrbPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorDiaActionPerformed(evt);
            }
        });

        jrbPorSemana.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorSemana.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorSemana.setText("Por semana");
        jrbPorSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorSemanaActionPerformed(evt);
            }
        });

        jrbPorMes.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorMes.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorMes.setText("Por mes");
        jrbPorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorMesActionPerformed(evt);
            }
        });

        jrbPorAño.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorAño.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorAño.setText("Por Año");
        jrbPorAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorAñoActionPerformed(evt);
            }
        });

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grafCirculo.jpg"))); // NOI18N
        lblImagen.setToolTipText("");

        lblSubtitulo.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblSubtitulo.setText("Selecciona el periodo que deseas consultar.");

        jmcElegirMes.setEnabled(false);

        jycElegirAño.setEnabled(false);

        jycElegirAñoSemana.setEnabled(false);

        jmcElegirMesSemana.setEnabled(false);

        jspNumeroSemana.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbPorDia)
                            .addComponent(jrbPorMes)
                            .addComponent(jrbPorAño)
                            .addComponent(jrbPorSemana))
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jycElegirAñoSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jmcElegirMesSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jspNumeroSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jmcElegirMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcElegirDia, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jycElegirAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubtitulo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jrbPorDia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrbPorSemana)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrbPorMes))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jdcElegirDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jycElegirAñoSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jmcElegirMesSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jspNumeroSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jmcElegirMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addComponent(jrbPorAño))
                            .addComponent(jycElegirAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblImagen)))
                .addContainerGap(634, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jrbPorSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorSemanaActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(true);
        jmcElegirMesSemana.setEnabled(true);
        jspNumeroSemana.setEnabled(true);
        jmcElegirMes.setEnabled(false);
        jycElegirAño.setEnabled(false);
        
    }//GEN-LAST:event_jrbPorSemanaActionPerformed

    private void jrbPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorDiaActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(true);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(false);
        jycElegirAño.setEnabled(false);
    }//GEN-LAST:event_jrbPorDiaActionPerformed

    private void jrbPorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorMesActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(true);
        jycElegirAño.setEnabled(false);
    }//GEN-LAST:event_jrbPorMesActionPerformed

    private void jrbPorAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorAñoActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(false);
        jycElegirAño.setEnabled(true);
    }//GEN-LAST:event_jrbPorAñoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltros;
    private com.toedter.calendar.JDateChooser jdcElegirDia;
    private com.toedter.calendar.JMonthChooser jmcElegirMes;
    private com.toedter.calendar.JMonthChooser jmcElegirMesSemana;
    private javax.swing.JRadioButton jrbPorAño;
    private javax.swing.JRadioButton jrbPorDia;
    private javax.swing.JRadioButton jrbPorMes;
    private javax.swing.JRadioButton jrbPorSemana;
    private com.toedter.components.JSpinField jspNumeroSemana;
    private com.toedter.calendar.JYearChooser jycElegirAño;
    private com.toedter.calendar.JYearChooser jycElegirAñoSemana;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel tituloReportes;
    // End of variables declaration//GEN-END:variables
}
