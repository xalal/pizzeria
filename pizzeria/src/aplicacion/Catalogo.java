/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abimael
 */
public class Catalogo extends JPanel {

    GroupLayout jPanelLayout;
    JButton jbPaquete;
    JLabel lblPaquete;

    public Catalogo(String texto, String urlImage) {
        try {
            jbPaquete = new JButton(new ImageIcon(getClass().getResource(urlImage)));
            jPanelLayout = new GroupLayout(this);
            this.setLayout(jPanelLayout);
            lblPaquete = new JLabel(texto);
            lblPaquete.setFont(new Font("Book Antiqua", 0, 24));
            lblPaquete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbPaquete.setBackground(new Color(255, 255, 255));
            jbPaquete.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 3, true));
            jbPaquete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbPaquete.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbPaqueteActionPerformed(evt);
                }
            });
            jPanelLayout.setHorizontalGroup(
                    jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jbPaquete)
                            .addGap(18, 18, 18)
                            .addComponent(lblPaquete)
                            .addContainerGap(184, Short.MAX_VALUE))
            );
            jPanelLayout.setVerticalGroup(
                    jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                            .addComponent(jbPaquete)
                            .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(lblPaquete)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void jbPaqueteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JFrame frame = new JFrame(lblPaquete.getText());
        frame.add(new VisualizarCatalogo(lblPaquete.getText()));
        frame.setSize(849, 651);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
