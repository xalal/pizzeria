/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import BD.ConexionBD;
import com.mysql.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria
 */
public class VerClientes extends javax.swing.JPanel {

    BD.ConexionBD con = new ConexionBD();
    java.sql.Connection jsc = con.conectar();
    DefaultTableModel modelo;
    int fs = -1;

    /**
     * Creates new form VerClientes
     */
    public VerClientes() {
        initComponents();
        cargarDatos();
        capturarSeleccion();
    }

    private void capturarSeleccion() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getSource() == jTable1.getSelectionModel() && event.getFirstIndex() >= 0) {
                    // Determine the selected item
                    fs = jTable1.getSelectedRow();
                    textNombre.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 0));
                    textTelefono.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 1));
                    textTelefono.setEnabled(false);
                    textCalle.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 2));
                    textNumero.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 3));
                    textColonia.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 4));
                    textMunicipio.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 5));
                    textEstado.setText((String) modelo.getValueAt(jTable1.getSelectedRow(), 6));
                    textReferencia1.setText((String) modelo.getValueAt(jTable1.getSelectedRow(),7));
                    textReferencia2.setText((String) modelo.getValueAt(jTable1.getSelectedRow(),8));
                    Agregar.setEnabled(false);
                    Actualizar.setEnabled(true);
                }
            }
        });
    }

    private void cargarDatos() {
        if (jsc != null) {
            try {
                ResultSet rs;
                CallableStatement cStmt = (CallableStatement) jsc.prepareCall("{ call sp_mostrarClientes() }");
                cStmt.execute();
                rs = cStmt.getResultSet();
                modelo = (DefaultTableModel) jTable1.getModel();
                while (rs.next()) {
                    modelo.addRow(new Object[]{rs.getString("nombre"), rs.getString("telefono"),
                        rs.getString("calle"), rs.getString("numero"), rs.getString("colonia"),
                        rs.getString("municipio"), rs.getString("estado"), rs.getString("referencia1"), 
                        rs.getString("referencia2")});
                }
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        calle = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        colonia = new javax.swing.JLabel();
        municipio = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textCalle = new javax.swing.JTextField();
        textNumero = new javax.swing.JTextField();
        textColonia = new javax.swing.JTextField();
        textMunicipio = new javax.swing.JTextField();
        textEstado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Agregar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        tituloCatalogo = new javax.swing.JLabel();
        Agregar1 = new javax.swing.JButton();
        referencia1 = new javax.swing.JLabel();
        referencia2 = new javax.swing.JLabel();
        textReferencia1 = new javax.swing.JTextField();
        textReferencia2 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        nombre.setText("Nombre");

        telefono.setText("Telefono");

        calle.setText("Calle");

        numero.setText("Numero");

        colonia.setText("Colonia");

        municipio.setText("Municipio");

        estado.setText("Estado");

        textTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textTelefonoFocusLost(evt);
            }
        });
        textTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTelefonoKeyTyped(evt);
            }
        });

        textNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNumeroKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono", "Calle", "Numero", "Colonia", "Municipio", "Estado", "Referencia1", "Referencia2"
            }
        ));
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.setEnabled(false);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        tituloCatalogo.setBackground(new java.awt.Color(204, 102, 0));
        tituloCatalogo.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        tituloCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        tituloCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCatalogo.setText("Clientes");
        tituloCatalogo.setOpaque(true);

        Agregar1.setText("Limpiar");
        Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar1ActionPerformed(evt);
            }
        });

        referencia1.setText("Referencia 1");

        referencia2.setText("Referencia 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(737, 737, 737))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(referencia1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre)
                                    .addComponent(telefono)
                                    .addComponent(numero)
                                    .addComponent(municipio))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                            .addComponent(textTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textMunicipio)
                                            .addComponent(textReferencia1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(colonia)
                                            .addComponent(calle)
                                            .addComponent(estado)
                                            .addComponent(referencia2))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textReferencia2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(textColonia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                                .addComponent(textCalle, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textEstado))))
                                    .addComponent(textNombre))))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(Agregar)
                        .addGap(126, 126, 126)
                        .addComponent(Actualizar)
                        .addGap(127, 127, 127)
                        .addComponent(Agregar1)
                        .addGap(128, 128, 128)
                        .addComponent(Eliminar)
                        .addContainerGap(170, Short.MAX_VALUE))))
            .addComponent(tituloCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tituloCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calle))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numero)
                    .addComponent(textNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colonia)
                    .addComponent(textColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(municipio)
                    .addComponent(textMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado)
                    .addComponent(textEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referencia1)
                    .addComponent(referencia2)
                    .addComponent(textReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textReferencia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Agregar)
                    .addComponent(Actualizar)
                    .addComponent(Eliminar)
                    .addComponent(Agregar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        Object[] datos = {
            textNombre.getText(),
            textTelefono.getText(),
            textCalle.getText(),
            textNumero.getText(),
            textColonia.getText(),
            textMunicipio.getText(),
            textEstado.getText(),
            textReferencia1.getText(),
            textReferencia2.getText()};
        CallableStatement cStmt;
        try {
            cStmt = (CallableStatement) jsc.prepareCall("{ call sp_agregarCliente( ?,?,?,?,?,?,?,?,? ) }");
            cStmt.setString("p_nombre", textNombre.getText());
            cStmt.setString("p_telefono", textTelefono.getText());
            cStmt.setString("p_calle", textCalle.getText());
            cStmt.setInt("p_numero", Integer.parseInt(textNumero.getText().trim()));
            cStmt.setString("p_colonia", textColonia.getText());
            cStmt.setString("p_municipio", textMunicipio.getText());
            cStmt.setString("p_estado", textEstado.getText());
            cStmt.setString("p_referencia1", textReferencia1.getText());
            cStmt.setString("p_referencia2", textReferencia2.getText());
            if (cStmt.executeUpdate() != CallableStatement.EXECUTE_FAILED) {
                JOptionPane.showMessageDialog(this, "El cliente se agregó correctamente");
                limpiarCampos();
                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.addRow(datos);
                jTable1.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        if (fs >= 0) {
            try {
                if (JOptionPane.showConfirmDialog(this,
                        "Esta seguro de eliminar el cliente seleccionado") == JOptionPane.YES_OPTION) {
                    String phone = (String) modelo.getValueAt(jTable1.getSelectedRow(), 1);
                    CallableStatement cStmt = (CallableStatement) jsc.prepareCall("{ call sp_eliminarClientePorTelefono( ? ) }");
                    cStmt.setString(1, phone);
                    if (cStmt.executeUpdate() != CallableStatement.EXECUTE_FAILED) {
                        JOptionPane.showMessageDialog(this, "El cliente se eliminó correctamente");
                        limpiarCampos();
                        modelo.removeRow(jTable1.getSelectedRow());
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun registro");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        CallableStatement cStmt;
        try {
            cStmt = (CallableStatement) jsc.prepareCall("{ call sp_modificarCliente( ?,?,?,?,?,?,?,?,? ) }");
            cStmt.setString("p_nombre", textNombre.getText());
            cStmt.setString("p_telefono", textTelefono.getText());
            cStmt.setString("p_calle", textCalle.getText());
            cStmt.setInt("p_numero", Integer.parseInt(textNumero.getText().trim()));
            cStmt.setString("p_colonia", textColonia.getText());
            cStmt.setString("p_municipio", textMunicipio.getText());
            cStmt.setString("p_estado", textEstado.getText());
            cStmt.setString("p_referencia1", textReferencia1.getText());
            cStmt.setString("p_referencia2", textReferencia2.getText());
            if (cStmt.executeUpdate() != CallableStatement.EXECUTE_FAILED) {
                JOptionPane.showMessageDialog(this, "El cliente se actualizó correctamente");
                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setValueAt(textNombre.getText(), fs, 0);
                modelo.setValueAt(textTelefono.getText(), fs, 1);
                modelo.setValueAt(textCalle.getText(), fs, 2);
                modelo.setValueAt(textNumero.getText(), fs, 3);
                modelo.setValueAt(textColonia.getText(), fs, 4);
                modelo.setValueAt(textMunicipio.getText(), fs, 5);
                modelo.setValueAt(textEstado.getText(), fs, 6);
                modelo.setValueAt(textReferencia1.getText(), fs, 7);
                modelo.setValueAt(textReferencia2.getText(), fs, 8);
                jTable1.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el cliente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed
    private void limpiarCampos() {
        textNombre.setText("");
        textTelefono.setText("");
        textTelefono.setEnabled(true);
        textCalle.setText("");
        textNumero.setText("");
        textColonia.setText("");
        textMunicipio.setText("");
        textEstado.setText("");
        textReferencia1.setText("");
        textReferencia2.setText("");
    }
    private void Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar1ActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        Agregar.setEnabled(true);
        Actualizar.setEnabled(false);
    }//GEN-LAST:event_Agregar1ActionPerformed

    private void textTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTelefonoFocusLost
        // TODO add your handling code here:
        if (!"".equals(textTelefono.getText())) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (!jTable1.getValueAt(i, 0).toString().equals(textNombre.getText())
                    && jTable1.getValueAt(i, 1).toString().equals(textTelefono.getText())) {
                    
                    JOptionPane.showMessageDialog(this, "El telefono ya se encuentra asignado al cliente "+
                                                        jTable1.getValueAt(i, 0).toString());
                    jTable1.getSelectionModel().setSelectionInterval(i, i);
                    i = jTable1.getRowCount() + 1;
                }
            }
        }
    }//GEN-LAST:event_textTelefonoFocusLost

    private void textNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumeroKeyTyped
        char c=evt.getKeyChar();
        if(c<'0' || c>'9' ) evt.consume();
// TODO add your handling code here:
    }//GEN-LAST:event_textNumeroKeyTyped

    private void textTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefonoKeyTyped
        char c=evt.getKeyChar();
        if(c<'0' || c>'9' ) evt.consume();
// TODO add your handling code here:
    }//GEN-LAST:event_textTelefonoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar1;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel calle;
    private javax.swing.JLabel colonia;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel municipio;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel referencia1;
    private javax.swing.JLabel referencia2;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField textCalle;
    private javax.swing.JTextField textColonia;
    private javax.swing.JTextField textEstado;
    private javax.swing.JTextField textMunicipio;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textReferencia1;
    private javax.swing.JTextField textReferencia2;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JLabel tituloCatalogo;
    // End of variables declaration//GEN-END:variables
}
