package Validar;

import aplicacion.Aplicacion;
import com.mysql.jdbc.CallableStatement;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.security.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Validacion extends javax.swing.JFrame {
    String macadd;
    String ser;
    String serial;
    Timer timer;

    public Validacion(){
        initComponents();
        setLocationRelativeTo(null);
        conseguirMAC();
        generarSerial();
        Txtarchivo();
        EnviarDatos();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PbCarga = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCompañia = new javax.swing.JTextField();
        ID1 = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcMousePanel1.setColor1(new java.awt.Color(204, 255, 255));
        jcMousePanel1.setModo(3);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel2.setText("Sistema de Gestion de Pizzeria");

        PbCarga.setStringPainted(true);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel3.setText("Informacion de Registro");

        jLabel4.setText("Nombre de Usuario:");

        jLabel5.setText("Compañia:");

        jLabel6.setText("Numero de Producto:   (XXXX-XXXX-XXXX-XXXX)");

        txtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCompañia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCompañia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompañiaKeyTyped(evt);
            }
        });

        ID1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ID1KeyTyped(evt);
            }
        });

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xalal.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(PbCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCompañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(PbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    public void conseguirMAC(){
		NetworkInterface a;
		try {
			a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			byte[] mac = a.getHardwareAddress();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			macadd=sb.toString();
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}    
    
    public void generarSerial(){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(macadd.getBytes());
			byte bytes[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				String hex = Integer.toHexString(0xff & bytes[i]);
				if (hex.length() == 1)
					sb.append('0');
				sb.append(hex);
			}
			ser=sb.toString().toUpperCase();
			ser=ser.substring(0, 16);
                        serial= ser.substring(0, 4)+"-"+ser.substring(4, 8)+"-"+ser.substring(8, 12)+"-"+ser.substring(12, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}    
        
    public void Txtarchivo() {
        
        File folder= new File("C:\\XalalSoftware");
        folder.mkdir();
        File archivo;
        archivo = new File("C:\\XalalSoftware\\Licencia.txt");
        
        try{

        FileWriter archivoMod = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(archivoMod);
        PrintWriter wr = new PrintWriter(bw); 
        wr.write("Grupo Xalal Software \n");
        wr.write("Licencia Unica para 1 Equipo\n");
        wr.append("--------------------------------------------\n");
        wr.append("Codigo de Activacion: "+serial+"\n"); 
        wr.append("--------------------------------------------");
        wr.close();
        bw.close();

        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Eror de permisos. "+e, "ERROR", JOptionPane.WARNING_MESSAGE);
        };
              
    }     
    
    public void startTimer() {
    if (timer == null) {
      timer = new Timer(60, new ActionListener() {
          int progress = 0;
          public void actionPerformed(ActionEvent A) {
            progress += 1;
            PbCarga.setValue(progress);

            // Once we hit 100%, remove the glass pane and reset the
            // progress bar stuff
            if (progress >= 100) {
              progress = 0;
              timer.stop();
              PbCarga.setValue(100);
              JOptionPane.showMessageDialog(null, "Registro Exitoso", "FELICITACIONES", JOptionPane.WARNING_MESSAGE);
                       aplicacion.Principal obj = new aplicacion.Principal();
                       obj.setVisible(true);
                       dispose();
            }
          }
        });
    }

    
    if (timer.isRunning()) {
      timer.stop();
    }
    timer.start();
  }    

    public void EnviarDatos(){
        String nombre = "NombreXalalSoftware";
        String compañia = "CompañiaXalalSoftware";
        int indice = 1;
        if(Aplicacion.con!=null){
            try { 
                CallableStatement CS = (CallableStatement) Aplicacion.cn.prepareCall("call sp_agregarActivacion(?,?,?,?,?)");
                CS.setInt(1,indice);
                CS.setString(2,nombre);
                CS.setString(3,compañia);
                CS.setString(4,macadd.toUpperCase());
                CS.setString(5,serial.toUpperCase());
                CS.execute();
            } catch (SQLException ex) {
                System.out.println("esta aplicacion ya fue ejecutada anteriormente");   
            }
        }  
    }
    
    public void ActualizarDatos(){
        if(Aplicacion.con!=null){
            try { 
                CallableStatement CS = (CallableStatement) Aplicacion.cn.prepareCall("call sp_actualizarActivacion(?,?)");
                CS.setString(1,txtNombre.getText());
                CS.setString(2,txtCompañia.getText());
                CS.execute();
                startTimer(); 
                Aplicacion.con.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Eror en la conexion. "+ex, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }  
    }
    
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        String serial = null;
        String addmac = null;
        
        if(Aplicacion.con!=null){
            try { 
                ResultSet rs;
                CallableStatement CS = (CallableStatement) Aplicacion.cn.prepareCall("call sp_mostrarActivacion()");
                CS.execute();
                rs = CS.getResultSet();
                 while (rs.next()){
                addmac = rs.getString("addmac");
                serial = rs.getString("serial");
                 }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Eror en la conexion. "+ex, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
              
        if(!txtNombre.getText().equals("") && !txtNombre.getText().equals(" ") && !txtCompañia.getText().equals("") && !txtCompañia.getText().equals(" ")){
              if(!ID1.getText().equals("")&&!ID1.getText().equals(" ") ){
                   if (ID1.getText().toUpperCase().equals(serial) && macadd.equals(addmac)){
                       ActualizarDatos();   
                   }else{
                       JOptionPane.showMessageDialog(null, "Numero de licencia incorrecta", "ERROR", JOptionPane.WARNING_MESSAGE); 
                   }
               }else{
                   JOptionPane.showMessageDialog(null,"Ingrese el codigo de activacion", "ERROR", JOptionPane.WARNING_MESSAGE);
               }                         
        } else {
            JOptionPane.showMessageDialog(null,"Los campos de Nombre de Usuario y Compañia no deben estar vacios", "ERROR", JOptionPane.WARNING_MESSAGE);    
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void ID1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ID1KeyTyped
        if (ID1.getText().length()== 19){
        evt.consume();
        Toolkit.getDefaultToolkit().beep();}
    }//GEN-LAST:event_ID1KeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length()== 80){
        evt.consume();
        Toolkit.getDefaultToolkit().beep();}
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCompañiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompañiaKeyTyped
        if (txtCompañia.getText().length()== 80){
        evt.consume();
        Toolkit.getDefaultToolkit().beep();}       
        
    }//GEN-LAST:event_txtCompañiaKeyTyped


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
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new Validacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID1;
    private javax.swing.JProgressBar PbCarga;
    private javax.swing.JToggleButton btnFinalizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JTextField txtCompañia;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
