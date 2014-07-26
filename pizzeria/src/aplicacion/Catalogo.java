/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import com.mysql.jdbc.CallableStatement;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.imgscalr.Scalr;

/**
 *
 * @author Abimael
 */
public class Catalogo extends JPanel {

    GroupLayout jPanelLayout;
    JButton jbPaquete;
    JLabel lblPaquete;
    JLabel lblDelete;
    JLabel lblEdit;
    URL url;
    public Catalogo(String texto, String urlImage) {
        try {
            url = this.getClass().getResource(urlImage);
            BufferedImage thumbnail = Scalr.resize(getBufferedImage(url), 105);
            jbPaquete = new JButton(new ImageIcon(thumbnail));
            jPanelLayout = new GroupLayout(this);
            this.setLayout(jPanelLayout);
            lblPaquete = new JLabel(texto);
            lblPaquete.setFont(new Font("Book Antiqua", 0, 20));
            lblPaquete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbPaquete.setBackground(new Color(255, 255, 255));
            jbPaquete.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 3, true));
            jbPaquete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblEdit = new javax.swing.JLabel();
            lblDelete = new javax.swing.JLabel();
            lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
            lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete1.png"))); // NOI18N
            lblDelete.setVisible(false);
            lblEdit.setVisible(false);
            lblDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent eve){
                    mostrarOpciones(true);
                }
                @Override
                public void mouseExited(MouseEvent eve){
                    int px,py,mx,my;
                    px=getSize().width;
                    py=getSize().height;
                    mx=eve.getX();
                    my=eve.getY();
                    
                    if(mx>=px||mx<=0||my>=py||my<=0){
                        mostrarOpciones(false);
                    }
                }
            });
            lblDelete.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent eve){
                    eliminarCatalogo();
                }
            });
            lblEdit.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent eve){
                    editarCatalogo();
                }
            });
            jbPaquete.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jbPaqueteActionPerformed(evt);
                }
            });
            jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jbPaquete)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(lblPaquete)
                            .addContainerGap(599, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEdit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblDelete)
                            .addContainerGap())))
            );
            jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEdit)
                        .addComponent(lblDelete))
                    .addGap(29, 29, 29)
                    .addComponent(lblPaquete)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addComponent(jbPaquete)
                    .addGap(10, 10, Short.MAX_VALUE))
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private void showAlert(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }
    private void eliminarCatalogo(){
        if(JOptionPane.showConfirmDialog(this, "Desea eliminar este catalogo")==JOptionPane.OK_OPTION){
            BD.ConexionBD con = new BD.ConexionBD();
            java.sql.Connection jsc = con.conectar();
            if (jsc != null) {
            try {
                    CallableStatement cStmt = (CallableStatement) jsc.prepareCall("{ call sp_eliminarCatalogoPorId('" + 
                                        lblPaquete.getText() + "') }");
                    cStmt.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(VerClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "EL catalogo fue eliminado");
        }
    }
    private void editarCatalogo(){
        // TODO add your handling code here:
        File selectedFile= new File(url.getPath());
        JFrame frame = new JFrame("Nuevo Catalogo");
        frame.add(new NewCatalogo(this.lblPaquete.getText(),selectedFile));
        frame.setSize(750, 220);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                refreshPantalla();
            }
        });
    }
    @SuppressWarnings("empty-statement")
    void refreshPantalla(){
        try {
            this.getParent().getParent().getClass().getMethod("refreshPantalla").invoke(this.getParent().getParent());
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void mostrarOpciones(boolean flag){
        lblDelete.setVisible(flag);
        lblEdit.setVisible(flag);
        if(flag){
            setBackground(new Color(13167615));
        }else{
            setBackground(null);
        }
        
    }
    private BufferedImage getBufferedImage(URL url) {
        BufferedImage bufferReturn=null; //this.getClass().getResource("/Imagenes/question.png");
        if(url!=null){
            try{
                bufferReturn = ImageIO.read(url);
            } catch (IOException ex) {
                Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, "Ruta d invalida", ex);
            }
        }else{
            try{
                bufferReturn = ImageIO.read(this.getClass().getResource("/Imagenes/question.png"));
                this.url = this.getClass().getResource("/Imagenes/question.png");
            } catch (IOException ex) {
                Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, "Ruta invalida", ex);
            }
        }
        return bufferReturn;
        
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    private void jbPaqueteActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame frame = new JFrame(lblPaquete.getText());
        frame.add(new VisualizarCatalogo(lblPaquete.getText()));
        frame.setSize(849, 651);
        frame.setVisible(true);
        frame.setResizable(false);    
    }
}
