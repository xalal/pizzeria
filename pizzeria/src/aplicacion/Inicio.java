package aplicacion;

import javax.swing.*;
import BD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inicio extends javax.swing.JPanel {
    
    public Inicio() {
        initComponents();
        CargarBD();
     }
    
    public void CargarBD(){
        ConexionBD con = new ConexionBD();
        Connection cn = con.conectar();
        String[] registros = new String[11];
        String sql = "select cliente.*,pedido.fechaPedido,hrPedido,hrEntrega,idPedido "
                + "from cliente,pedido "
                + "where cliente.idCliente = pedido.idCliente "
                +"and pedido.estatus = '0'"
                + "ORDER BY pedido.hrPedido ASC";  

        try {
            int contador = 0;          
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
               String nombre = registros[0] = rs.getString("cliente.nombre"); //se obtiene la hora
               String telefono = registros[1] = rs.getString("cliente.telefono");//se obtiene el cliente
               String calle = registros[2] = rs.getString("cliente.calle");//se obtiene la direccion
               String numero = registros[3] = rs.getString("cliente.numero"); //se obtiene la descripcion
               String colonia = registros[4] = rs.getString("cliente.colonia");//se obtiene otro dato
               String municipio = registros[5] = rs.getString("cliente.municipio");//se obtiene otro dato
               String estado = registros[6] = rs.getString("cliente.estado");//se obtiene otro dato
               String fechaPedido = registros[7] = rs.getString("pedido.fechaPedido");//se obtiene otro dato
               String hrPedido = registros[8] = rs.getString("pedido.hrPedido");//se obtiene otro dato
               String hrEntrega = registros[9] = rs.getString("pedido.hrEntrega");
               String ped = registros[10] = rs.getString("pedido.idPedido");
                DatosPedidos form = new DatosPedidos(); 
                contador++;
                form.Datos(nombre,telefono,calle,numero,colonia,municipio,estado,fechaPedido,hrPedido,hrEntrega,contador,ped);
                jPanel1.add(form);
                       
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion ", "Error", JOptionPane.ERROR_MESSAGE);
          } finally{
            con.desconectar();
            }     
    }
    
    @SuppressWarnings("unchecked")
    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedidos.png"))); // NOI18N

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
