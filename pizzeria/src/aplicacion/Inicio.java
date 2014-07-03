package aplicacion;

import javax.swing.*;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inicio extends javax.swing.JPanel {
    ConexionBD con = new ConexionBD();
    
    public Inicio() {
        initComponents();
//        jPanel1.add(new DatosPedidos());
//        jPanel1.add(new DatosPedidos());
//        jPanel1.add(new DatosPedidos());
        
        CargarBD();
     }

//    private void CargarElementos(){
//      
//    JLabel orden = new JLabel();
//    JButton bo = new JButton();
//    JButton bu = new JButton();
//    orden.setText("pedido # x \n descripcion: \t producto 1 \n\t producto numero 2");
//    orden.setBounds(10, 10, 200,20);
//    bo.setBounds(300,10,50,20);
//    bu.setBounds(300,30,50,20);
//    orden.setVisible(true); 
//    jPanel1.add(orden);
//    jPanel1.add(bo);
//    jPanel1.add(bu);
//    
//    }
    
    private void CargarBD(){
        Connection cn = con.conectar();
        String[] registros = new String[5];
        String sql = "select * from Cliente";
        
//        DatosPedidos obj = new DatosPedidos();
//        jPanel1.add(new DatosPedidos());
        try {
             DatosPedidos form = new DatosPedidos();
             jPanel1.add(form);
             
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("DB.Hora"); //se obtiene la hora
                registros[1] = rs.getString("BD.Cliente");//se obtiene el cliente
                registros[2] = rs.getString("BD.Direccion");//se obtiene la direccion
                registros[3] = rs.getString("BD.Descripcion"); //se obtiene la descripcion
                registros[4] = rs.getString("BD.OtroDato");//se obtiene otro dato
                
                form.Cliente = registros[0];
                form.Descripcion = registros[1];
                form.Direccion = registros[2];
                form.Telefono =registros[3];
                form.hora = registros[4];
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion ", "Error", JOptionPane.ERROR_MESSAGE);
          } finally{
            con.desconectar();
            }
            
    con.desconectar();
    }
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pizza logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
