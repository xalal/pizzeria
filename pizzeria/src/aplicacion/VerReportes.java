package aplicacion;

import BD.ConexionBD;
import com.mysql.jdbc.CallableStatement;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Maria
 */
public class VerReportes extends javax.swing.JPanel {

    /**
     * Creates new form VerReportes
     */
    BD.ConexionBD con = new ConexionBD();
    DefaultCategoryDataset datos ; 
    Date date = new Date();
    java.sql.Connection jsc = con.conectar();
    public VerReportes() {
        initComponents();
        initComponentsByUser();
    }

    private void initComponentsByUser() {
        bgFiltros.add(jrbPorDia);
        bgFiltros.add(jrbPorSemana);
        bgFiltros.add(jrbPorMes);
        bgFiltros.add(jrbPorAño);
        setWeeksofMonth();
    }

    private void setWeeksofMonth() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Calendar.YEAR, jycElegirAñoSemana.getYear());
        cal.set(Calendar.MONTH, jmcElegirMesSemana.getMonth());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        if (jspNumeroSemana.getValue() > cal.getActualMaximum(Calendar.WEEK_OF_MONTH)) {
            jspNumeroSemana.setValue(cal.getActualMaximum(Calendar.WEEK_OF_MONTH));
        }
        jspNumeroSemana.setMaximum(cal.getActualMaximum(Calendar.WEEK_OF_MONTH));
    }

    private void graficar(String store) {
        JFreeChart grafica;
        Object [] columns={"Nombre del Producto","Ventas"};
        Object [][] data=new Object[5][2];
        if (jsc != null) {
            try {
                ResultSet rs;
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall(store);
                cStmt.execute();
                rs = cStmt.getResultSet();
                datos=new DefaultCategoryDataset();
                int i=0;
                while (rs.next()) {
                    data[i][0]=(Object)rs.getString("nombreProducto");
                    data[i][1]=(Object)rs.getString("ventas");
                    i++;
                    datos.addValue(rs.getInt("ventas"), "Pizzeria", rs.getString("nombreProducto"));
                }
                DefaultTableModel temp = new DefaultTableModel(data, columns);
                jTable2.setModel(temp);
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        grafica = ChartFactory.createBarChart("Vista Ejemplo", "Negocio 1", "Vistas", datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panelAux = new ChartPanel(grafica);
        jPanelDatosGraf.removeAll();
        jPanelDatosGraf.add(panelAux, BorderLayout.CENTER);
        jPanelDatosGraf.validate();
        
    }

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
        jycElegirAñoMes = new com.toedter.calendar.JYearChooser();
        jsPanelGraficas = new javax.swing.JScrollPane();
        jPanelGraficas = new javax.swing.JPanel();
        lblTituloPedidos = new javax.swing.JLabel();
        jPanelDatosGraf = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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
        jrbPorSemana.setActionCommand("porSemana");
        jrbPorSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorSemanaActionPerformed(evt);
            }
        });

        jrbPorMes.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorMes.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorMes.setText("Por mes");
        jrbPorMes.setActionCommand("porMes");
        jrbPorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorMesActionPerformed(evt);
            }
        });

        jrbPorAño.setBackground(new java.awt.Color(255, 255, 255));
        jrbPorAño.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jrbPorAño.setText("Por Año");
        jrbPorAño.setActionCommand("porAnio");
        jrbPorAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorAñoActionPerformed(evt);
            }
        });

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grafCirculo.jpg"))); // NOI18N
        lblImagen.setToolTipText("");

        lblSubtitulo.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        lblSubtitulo.setText("Selecciona el periodo que deseas consultar.");

        jdcElegirDia.setDate(new java.util.Date());
        jdcElegirDia.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcElegirDiaPropertyChange(evt);
            }
        });

        jmcElegirMes.setEnabled(false);
        jmcElegirMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcElegirMesPropertyChange(evt);
            }
        });

        jycElegirAño.setEnabled(false);
        jycElegirAño.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycElegirAñoPropertyChange(evt);
            }
        });

        jycElegirAñoSemana.setEnabled(false);
        jycElegirAñoSemana.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycElegirAñoSemanaPropertyChange(evt);
            }
        });

        jmcElegirMesSemana.setEnabled(false);
        jmcElegirMesSemana.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jmcElegirMesSemanaPropertyChange(evt);
            }
        });

        jspNumeroSemana.setEnabled(false);
        jspNumeroSemana.setMaximum(10);
        jspNumeroSemana.setMinimum(1);
        jspNumeroSemana.setValue(1);
        jspNumeroSemana.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jspNumeroSemanaPropertyChange(evt);
            }
        });

        jycElegirAñoMes.setEnabled(false);
        jycElegirAñoMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycElegirAñoMesPropertyChange(evt);
            }
        });

        jsPanelGraficas.setBorder(null);

        jPanelGraficas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGraficas.setPreferredSize(new java.awt.Dimension(829, 350));

        lblTituloPedidos.setBackground(new java.awt.Color(51, 51, 255));
        lblTituloPedidos.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblTituloPedidos.setForeground(new java.awt.Color(204, 255, 204));
        lblTituloPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPedidos.setText("Pedidos realizados en el periodo");
        lblTituloPedidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lblTituloPedidos.setOpaque(true);

        jPanelDatosGraf.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatosGraf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelDatosGraf.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanelGraficasLayout = new javax.swing.GroupLayout(jPanelGraficas);
        jPanelGraficas.setLayout(jPanelGraficasLayout);
        jPanelGraficasLayout.setHorizontalGroup(
            jPanelGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficasLayout.createSequentialGroup()
                .addGroup(jPanelGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGraficasLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(lblTituloPedidos))
                    .addGroup(jPanelGraficasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanelDatosGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelGraficasLayout.setVerticalGroup(
            jPanelGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficasLayout.createSequentialGroup()
                .addComponent(lblTituloPedidos)
                .addGap(18, 18, 18)
                .addComponent(jPanelDatosGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jsPanelGraficas.setViewportView(jPanelGraficas);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productos", "Ventas"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsPanelGraficas, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbPorAño)
                                    .addComponent(jrbPorSemana)
                                    .addComponent(jrbPorMes)
                                    .addComponent(jrbPorDia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcElegirDia, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jycElegirAñoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jmcElegirMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jycElegirAño, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jycElegirAñoSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jmcElegirMesSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jspNumeroSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSubtitulo)
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtitulo)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jrbPorDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbPorSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbPorMes)
                                .addGap(7, 7, 7)
                                .addComponent(jrbPorAño))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jdcElegirDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jycElegirAñoSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jmcElegirMesSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jspNumeroSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jmcElegirMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jycElegirAñoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(7, 7, 7)
                                    .addComponent(jycElegirAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsPanelGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jrbPorSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorSemanaActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(true);
        jmcElegirMesSemana.setEnabled(true);
        jspNumeroSemana.setEnabled(true);
        jmcElegirMes.setEnabled(false);
        jycElegirAñoMes.setEnabled(false);
        jycElegirAño.setEnabled(false);


    }//GEN-LAST:event_jrbPorSemanaActionPerformed

    private void jrbPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorDiaActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(true);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(false);
        jycElegirAñoMes.setEnabled(false);
        jycElegirAño.setEnabled(false);
    }//GEN-LAST:event_jrbPorDiaActionPerformed

    private void jrbPorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorMesActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(true);
        jycElegirAñoMes.setEnabled(true);
        jycElegirAño.setEnabled(false);
    }//GEN-LAST:event_jrbPorMesActionPerformed

    private void jrbPorAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorAñoActionPerformed
        // TODO add your handling code here:
        jdcElegirDia.setEnabled(false);
        jycElegirAñoSemana.setEnabled(false);
        jmcElegirMesSemana.setEnabled(false);
        jspNumeroSemana.setEnabled(false);
        jmcElegirMes.setEnabled(false);
        jycElegirAñoMes.setEnabled(false);
        jycElegirAño.setEnabled(true);
    }//GEN-LAST:event_jrbPorAñoActionPerformed

    private void jycElegirAñoSemanaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycElegirAñoSemanaPropertyChange
        // TODO add your handling code here:
        setWeeksofMonth();
    }//GEN-LAST:event_jycElegirAñoSemanaPropertyChange

    private void jmcElegirMesSemanaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcElegirMesSemanaPropertyChange
        // TODO add your handling code here:
        setWeeksofMonth();
    }//GEN-LAST:event_jmcElegirMesSemanaPropertyChange

    private void jdcElegirDiaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcElegirDiaPropertyChange
        // TODO add your handling code here:
        DateFormat df = DateFormat.getDateInstance();
        if (jdcElegirDia.getDate() != null) {
            date = jdcElegirDia.getDate();
        }
        String fecha = df.format(date);
        String sp="{ call sp_mostrarEstadisticaPorDia('" + fecha + "') }";
        graficar(sp);
    }//GEN-LAST:event_jdcElegirDiaPropertyChange

    private void jspNumeroSemanaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jspNumeroSemanaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jspNumeroSemanaPropertyChange

    private void jycElegirAñoMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycElegirAñoMesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jycElegirAñoMesPropertyChange

    private void jmcElegirMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jmcElegirMesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jmcElegirMesPropertyChange

    private void jycElegirAñoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycElegirAñoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jycElegirAñoPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltros;
    private javax.swing.JPanel jPanelDatosGraf;
    private javax.swing.JPanel jPanelGraficas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser jdcElegirDia;
    private com.toedter.calendar.JMonthChooser jmcElegirMes;
    private com.toedter.calendar.JMonthChooser jmcElegirMesSemana;
    private javax.swing.JRadioButton jrbPorAño;
    private javax.swing.JRadioButton jrbPorDia;
    private javax.swing.JRadioButton jrbPorMes;
    private javax.swing.JRadioButton jrbPorSemana;
    private javax.swing.JScrollPane jsPanelGraficas;
    private com.toedter.components.JSpinField jspNumeroSemana;
    private com.toedter.calendar.JYearChooser jycElegirAño;
    private com.toedter.calendar.JYearChooser jycElegirAñoMes;
    private com.toedter.calendar.JYearChooser jycElegirAñoSemana;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTituloPedidos;
    private javax.swing.JLabel tituloReportes;
    // End of variables declaration//GEN-END:variables
}
