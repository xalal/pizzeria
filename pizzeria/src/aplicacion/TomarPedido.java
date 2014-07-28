/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import aplicacion.Pedido.Cliente;
import aplicacion.Pedido.FCatalogo;
import aplicacion.Pedido.FCliente;
import aplicacion.Pedido.FOrden;
import aplicacion.Pedido.FPedido;
import aplicacion.Pedido.FProducto;
import aplicacion.Pedido.Orden;
import aplicacion.Pedido.Pedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maria
 */
public class TomarPedido extends javax.swing.JPanel {

    Calendar calendario;
    int dia, mes, año, hora, minutos, segundos;

    /**
     * Creates new form TomarPedido
     */
    public TomarPedido() {
        initComponents();
        //lbl_fechaActual.setText(fecha());
        //lbl_horaInicio.setText(hora());
 
        txt_telefonobuscar.requestFocus();
        ocultar_columnas();
        ArrayList catalogos = producto.getCatalogos();
        for (Object item : catalogos) {
            jcCatalogo.addItem(item);
        }

    }

    void ocultar_columnas() {
        tabla_articulos.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla_articulos.getColumnModel().getColumn(1).setMinWidth(0);
        tabla_articulos.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabla_articulos.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla_articulos.getColumnModel().getColumn(3).setMinWidth(0);
        tabla_articulos.getColumnModel().getColumn(3).setPreferredWidth(0);
    }
    
    
   

    public String fecha() {
        calendario = new java.util.GregorianCalendar();
        Date actual = new Date();
        calendario.setTime(actual);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = (calendario.get(Calendar.MONTH) + 1);
        año = calendario.get(Calendar.YEAR);

        String date = String.format("%02d-%02d-%02d", año, mes, dia);

        return date;
    }

    public String hora() {
        calendario = new java.util.GregorianCalendar();
        segundos = calendario.get(Calendar.SECOND);
        Date actual = new Date();
        calendario.setTime(actual);
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String hour = String.format("%02d:%02d:%02d", hora, minutos, segundos);

        return hour;
    }

    private String accion = "guardar";

    void inhabilitar() {
        txt_idcliente.setVisible(false);
        txt_idpedido.setVisible(false);

        txt_nombre.setEnabled(false);
        txt_telefono.setEnabled(false);
        txt_calle.setEnabled(false);
        txt_numero.setEnabled(false);
        txt_referencia1.setEnabled(false);
        txt_referencia2.setEnabled(false);
        txt_colonia.setEnabled(false);
        txt_municipio.setEnabled(false);
        txt_estado.setEnabled(false);

        btn_guardar.setEnabled(false);
        
        btn_agregar.setEnabled(false);
        btn_quitar.setEnabled(false);
        
        btn_confirmar.setEnabled(false);
        btn_cancelarTodo.setEnabled(false);
        

    }

    void habilitar() {
        txt_idcliente.setVisible(false);
        txt_idpedido.setVisible(false);

        txt_nombre.setEnabled(true);
        txt_telefono.setEnabled(true);
        txt_calle.setEnabled(true);
        txt_numero.setEnabled(true);
        txt_referencia1.setEnabled(true);
        txt_referencia2.setEnabled(true);
        txt_colonia.setEnabled(true);
        txt_municipio.setEnabled(true);
        txt_estado.setEnabled(true);

        btn_guardar.setEnabled(true);

        txt_idcliente.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_calle.setText("");
        txt_numero.setText("");
        txt_referencia1.setText("");
        txt_referencia2.setText("");
        txt_colonia.setText("");
        txt_municipio.setText("");
        txt_estado.setText("");
    }

    public void buscarCliente(String telefono) {
        try {
            DefaultTableModel modelo;

            FCliente func = new FCliente();
            Cliente datos = new Cliente();

            datos.setTelefono(telefono);

            modelo = func.buscarTelefono(datos.getTelefono());

            tablacliente.setModel(modelo);

            if (func.totalregistros > 0) {
                //el usuario si existe
                btn_guardar.setText("Editar");
                habilitar();
                accion = "editar";

                txt_idcliente.setText(tablacliente.getValueAt(0, 0).toString());
                txt_nombre.setText(tablacliente.getValueAt(0, 1).toString());
                txt_telefono.setText(tablacliente.getValueAt(0, 2).toString());
                txt_calle.setText(tablacliente.getValueAt(0, 3).toString());
                txt_numero.setText(tablacliente.getValueAt(0, 4).toString());
                txt_referencia1.setText(tablacliente.getValueAt(0, 5).toString());
                txt_referencia2.setText(tablacliente.getValueAt(0, 6).toString());
                txt_colonia.setText(tablacliente.getValueAt(0, 7).toString());
                txt_municipio.setText(tablacliente.getValueAt(0, 8).toString());
                txt_estado.setText(tablacliente.getValueAt(0, 9).toString());

            } else {
                habilitar();
                btn_guardar.setText("Guardar");
                accion = "guardar";

                txt_telefono.setText(txt_telefonobuscar.getText());

            }

        } catch (Exception e) {
        }

        // txt_telefono.setText(telefono);
    }

    void setArticuloTabla(String cantidad, String catalogo, String producto, String precio, String total) {
        try {
            String[] registro = new String[7];

            FCatalogo func1 = new FCatalogo();
            FProducto func2 = new FProducto();

            registro[0] = cantidad;
            registro[1] = func1.busca(catalogo);
            registro[2] = catalogo;
            registro[3] = func2.busca(catalogo, producto);
            registro[4] = producto;
            registro[5] = precio;
            registro[6] = total;
            DefaultTableModel model = (DefaultTableModel) tabla_articulos.getModel();
            model.addRow(registro);

            calcularTotal();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }

    void calcularTotal() {
        DefaultTableModel model = (DefaultTableModel) tabla_articulos.getModel();
        Double total = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            total += Double.parseDouble(tabla_articulos.getValueAt(i, 6).toString());
        }
        txt_total.setText(total.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_precioproducto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        txt_totalproducto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jcCatalogo = new javax.swing.JComboBox();
        jcProducto = new javax.swing.JComboBox();
        txt_idpedido = new javax.swing.JTextField();
        tituloCatalogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        txt_calle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_colonia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_municipio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_estado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_referencia1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_referencia2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();
        txt_idcliente = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_articulos = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_telefonobuscar = new javax.swing.JTextField();
        btn_buscaCliente = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_quitar = new javax.swing.JButton();
        btn_cancelarTodo = new javax.swing.JButton();
        btn_confirmar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_agregar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(882, 567));
        setPreferredSize(new java.awt.Dimension(882, 567));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futura Bk BT", 0, 11))); // NOI18N

        jLabel4.setText("Catalogo:");

        jLabel6.setText("Producto:");

        jLabel12.setText("Precio U:");

        txt_precioproducto.setText("0");

        jLabel14.setText("Cantidad:");

        txt_cantidad.setText("1");
        txt_cantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cantidadFocusLost(evt);
            }
        });
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        txt_totalproducto.setText("0.00");

        jLabel17.setText("Total $");

        jcCatalogo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un Catalogo" }));
        jcCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCatalogoActionPerformed(evt);
            }
        });

        jcProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un Producto" }));
        jcProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProductoActionPerformed(evt);
            }
        });

        txt_idpedido.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        txt_idpedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_idpedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idpedidoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_precioproducto)
                            .addComponent(txt_totalproducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_cantidad)))
                    .addComponent(jcCatalogo, 0, 190, Short.MAX_VALUE)
                    .addComponent(jcProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_idpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txt_idpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_precioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_totalproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        tituloCatalogo.setBackground(new java.awt.Color(79, 53, 32));
        tituloCatalogo.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        tituloCatalogo.setForeground(new java.awt.Color(255, 255, 255));
        tituloCatalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCatalogo.setText("TOMAR PEDIDO");
        tituloCatalogo.setOpaque(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futura Bk BT", 0, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico16_usuario.png"))); // NOI18N
        jLabel3.setText("Nombre:");

        txt_nombre.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futura Bk BT", 0, 11))); // NOI18N

        txt_calle.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_calle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_calleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico16_direccion.png"))); // NOI18N
        jLabel5.setText("Calle:");

        jLabel7.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel7.setText("Número:");

        txt_numero.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numeroActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel9.setText("Colonia:");

        txt_colonia.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_colonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coloniaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel10.setText("Municipio:");

        txt_municipio.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_municipioActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel11.setText("Estado:");

        txt_estado.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel13.setText("Referencia 1:");

        txt_referencia1.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_referencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_referencia1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel15.setText("Referencia 2:");

        txt_referencia2.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_referencia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_referencia2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_calle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_colonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_municipio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_estado))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_referencia2)
                            .addComponent(txt_referencia1))))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_referencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_referencia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablacliente);

        btn_guardar.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico16_guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico16_telefono.png"))); // NOI18N
        jLabel8.setText("Teléfono:");

        txt_telefono.setFont(new java.awt.Font("Futura Bk BT", 0, 11)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futura Bk BT", 0, 11))); // NOI18N

        tabla_articulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant", "IDCat", "Catalogo", "IDPro", "Producto", "Precio U", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla_articulos);
        if (tabla_articulos.getColumnModel().getColumnCount() > 0) {
            tabla_articulos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla_articulos.getColumnModel().getColumn(2).setPreferredWidth(15);
            tabla_articulos.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabla_articulos.getColumnModel().getColumn(5).setPreferredWidth(20);
            tabla_articulos.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        txt_total.setBackground(new java.awt.Color(255, 0, 0));
        txt_total.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        txt_total.setForeground(new java.awt.Color(255, 255, 255));
        txt_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total.setText("00.00");

        jLabel16.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        jLabel16.setText("Total:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico24_telefono.png"))); // NOI18N
        jLabel1.setText("Buscar Teléfono:");

        txt_telefonobuscar.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        txt_telefonobuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telefonobuscarKeyReleased(evt);
            }
        });

        btn_buscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico24_lupa.png"))); // NOI18N
        btn_buscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscaClienteActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico128_carrito.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_telefonobuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_telefonobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENÚ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futura Bk BT", 0, 11))); // NOI18N

        btn_quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico2$_eliminarPedido.png"))); // NOI18N
        btn_quitar.setText("Quitar >>");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

        btn_cancelarTodo.setText("Cancelar Todo");

        btn_confirmar.setBackground(new java.awt.Color(0, 204, 0));
        btn_confirmar.setText("Confirmar Pedido");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico24_agregarPedido.png"))); // NOI18N
        btn_agregar.setText("<< Agregar");
        btn_agregar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_quitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_cancelarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_quitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelarTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tituloCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tituloCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
        txt_nombre.transferFocus();
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_calleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_calleActionPerformed
        // TODO add your handling code here:
        txt_calle.transferFocus();
    }//GEN-LAST:event_txt_calleActionPerformed

    private void txt_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numeroActionPerformed
        // TODO add your handling code here:
        txt_numero.transferFocus();
    }//GEN-LAST:event_txt_numeroActionPerformed

    private void txt_coloniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coloniaActionPerformed
        // TODO add your handling code here:
        txt_colonia.transferFocus();
    }//GEN-LAST:event_txt_coloniaActionPerformed

    private void txt_municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_municipioActionPerformed
        // TODO add your handling code here:
        txt_municipio.transferFocus();
    }//GEN-LAST:event_txt_municipioActionPerformed

    private void txt_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoActionPerformed

    private void txt_referencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_referencia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_referencia1ActionPerformed

    private void txt_referencia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_referencia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_referencia2ActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if (txt_nombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(txt_telefonobuscar, "Debes ingresar la NOMBRE");
            txt_nombre.requestFocus();
            return;
        }

        if (txt_telefonobuscar.getText().length() == 0) {
            JOptionPane.showMessageDialog(txt_telefonobuscar, "Debes ingresar la TELÉFONO");
            txt_telefonobuscar.requestFocus();
            return;
        }

        if (txt_calle.getText().length() == 0) {
            JOptionPane.showMessageDialog(txt_calle, "Debes ingresar la CALLE");
            txt_calle.requestFocus();
            return;
        }

        if (txt_colonia.getText().length() == 0) {
            //JOptionPane.showConfirmDialog(rootPane, );
            JOptionPane.showMessageDialog(txt_colonia, "Debes ingresar la COLONIA");
            txt_colonia.requestFocus();
            return;
        }

        Cliente datos = new Cliente();
        FCliente funcion = new FCliente();

        datos.setNombre(txt_nombre.getText());
        datos.setTelefono(txt_telefonobuscar.getText());
        datos.setCalle(txt_calle.getText());

        datos.setNumero(txt_numero.getText());
        datos.setReferencia1(txt_referencia1.getText());
        datos.setReferencia2(txt_referencia2.getText());

        datos.setColonia(txt_colonia.getText());
        datos.setMunicipio(txt_municipio.getText());
        datos.setEstado(txt_estado.getText());

        if (accion.equals("guardar")) {
            if (funcion.insertar(datos)) {

                JOptionPane.showMessageDialog(txt_idcliente, "El CLIENTE fue actualizado.");
                // registrar pedido
            }

        } else if (accion.equals("editar")) {
            datos.setIdcliente(Integer.parseInt(txt_idcliente.getText()));

            if (funcion.editar(datos)) {
                JOptionPane.showMessageDialog(txt_idcliente, "El CLIENTE fue actualizado.");
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_idpedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpedidoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idpedidoKeyReleased

    private void txt_telefonobuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonobuscarKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_telefonobuscarKeyReleased

    private void btn_buscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscaClienteActionPerformed
        // TODO add your handling code here:

        if (txt_telefonobuscar.getText().length() == 0) {

            JOptionPane.showMessageDialog(txt_telefonobuscar, "Campo Vacio");

            txt_telefonobuscar.requestFocus();
            return;
        }

        buscarCliente(txt_telefonobuscar.getText());
    }//GEN-LAST:event_btn_buscaClienteActionPerformed

    private void jcCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCatalogoActionPerformed
        // TODO add your handling code here:
        if (!"Seleccione un Catalogo".equals(jcCatalogo.getSelectedItem().toString())) {
            ArrayList productos = producto.getProductos(jcCatalogo.getSelectedItem().toString());
            jcProducto.removeAllItems();
            jcProducto.addItem("Seleccione un Producto");
            for (Object item : productos) {
                jcProducto.addItem(item);
            }
        }
    }//GEN-LAST:event_jcCatalogoActionPerformed
    private void jcProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProductoActionPerformed
        // TODO add your handling code here:
        if (jcProducto.getItemCount() > 0) {
            String c = jcCatalogo.getSelectedItem().toString();
            String p = jcProducto.getSelectedItem().toString();
            if (!"Seleccione un Producto".equals(p)) {
                precio = producto.getPrecioProducto(c, p);
                txt_precioproducto.setText(Double.toString(precio));
                txt_totalproducto.setText(Double.toString(precio * Integer.parseInt(txt_cantidad.getText())));
                
                btn_agregar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jcProductoActionPerformed

    private void txt_cantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cantidadFocusLost
        // TODO add your handling code here:
        txt_totalproducto.setText(Double.toString(precio * Integer.parseInt(txt_cantidad.getText())));
    }//GEN-LAST:event_txt_cantidadFocusLost

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabla_articulos.getModel();

        model.removeRow(tabla_articulos.getSelectedRow());
        calcularTotal();

    }//GEN-LAST:event_btn_quitarActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        // TODO add your handling code here:
        //confirmar que idcliente lleno
        //confirmar que haya articulos en la tabla
        //confirmar ventana de confirmacion de pedido

        if (txt_idcliente.getText().length() == 0 && txt_telefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(btn_buscaCliente, "Falta BUSCAR cliente.");
            txt_telefonobuscar.requestFocus();
            return;
        }
        if (txt_idcliente.getText().length() != 0 && txt_telefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(txt_telefono, "Falta TELEFONO de cliente.");
            txt_telefono.requestFocus();
            return;
        }
        if (txt_idcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(btn_guardar, "Falta GUARDAR cliente.");
            btn_guardar.requestFocus();
            return;
        }

        //System.out.println(tabla_articulos.getRowCount());
        if (tabla_articulos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(tabla_articulos, "No hay articulos seleccionados\npara venta.");
            return;
        }

        int pregunta1 = JOptionPane.showConfirmDialog(null, "Estas seguro de aceptar el pedido?");
        if (pregunta1 == JOptionPane.YES_OPTION) {

            // hacer las consultas a la base de datos
            /*
             private int idpedido;
             private int estatus;
             private Cliente cliente;
             private Date fechaPedido;
             private Time hrpedido;
             private Time hrEntrega;
             */
            //1 insertar pedido
            //sacar datos primero
            int idpedido = 2;
            FPedido fpedido = new FPedido();
            FOrden forden = new FOrden();
            FCatalogo fcatalogo = new FCatalogo();
            FProducto fproducto = new FProducto();

            try {
                Pedido pedido = new Pedido();

                int estatus = 1; //activo
                String fecha = fecha();
                String hora = hora();

                FCliente fcliente = new FCliente();
                Cliente cliente = new Cliente();
                int idcliente = Integer.parseInt(txt_idcliente.getText());
                cliente = fcliente.buscarCliente(idcliente);

                pedido.setEstatus(estatus);
                pedido.setCliente(cliente);
                pedido.setFechaPedido(fecha);
                pedido.setHrpedido(hora);
                pedido.setHrEntrega(hora);

                //insertar pedido y devolver el idpedido
                idpedido = fpedido.insertarPedido(pedido);
                //JOptionPane.showMessageDialog(null, "idpedido: " + idpedido);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error cliente: " + e);
                idpedido = -1;
            }

            if (idpedido > 0) {
                try {

                    Pedido pedido = fpedido.buscarPedido(idpedido);

                    //2 sacar idpedido
                    for (int fila = 0; fila < tabla_articulos.getRowCount(); fila++) {

                        // id pedido
                        int idcatalogo = Integer.parseInt(tabla_articulos.getValueAt(fila, 1).toString());
                        String nomCatalogo = tabla_articulos.getValueAt(fila, 2).toString();
                        int idproducto = Integer.parseInt(tabla_articulos.getValueAt(fila, 3).toString());
                        int cantidad = Integer.parseInt(tabla_articulos.getValueAt(fila, 0).toString());
                        Double precio = Double.parseDouble(tabla_articulos.getValueAt(fila, 6).toString());

                        Orden orden = new Orden();
                        orden.setPedido(pedido);
                        orden.setCatalogo(fcatalogo.buscarCatalogo(idcatalogo));
                        orden.setProducto(fproducto.buscarProducto(nomCatalogo, idproducto));
                        orden.setCantidad(cantidad);
                        orden.setPrecio(precio);

                        /*
                         System.out.println(orden.getCantidad()); // cantidad
                         System.out.println(orden.getCatalogo().getIdcatalogo()); // id catalogo 
                         System.out.println(orden.getCatalogo().getDescripcion()); // nombre catalogo
                         System.out.println(orden.getProducto().getId()); // id producto
                         System.out.println(orden.getProducto().getNombre()); // nombre producto
                         System.out.println(orden.getPrecio()); // precio u
                         */
                        forden.insertarOrden(orden);
                        //JOptionPane.showMessageDialog(null, "se inserto orden en pedido: " + pedido.getIdpedido());

                      

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error pedido: " + e);
                    //eliminar pedido
                }

            }

            //calcularTotal();
            //3 insertar ordenes
            //4 mostrar si quiere imprimir el ticket
            //5 regresar a inicio
        }

    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        String cantidad = txt_cantidad.getText();
        String catalogo = jcCatalogo.getSelectedItem().toString();
        String producto = jcProducto.getSelectedItem().toString();
        String precio = txt_precioproducto.getText();
        String total = txt_totalproducto.getText();

        setArticuloTabla(cantidad, catalogo, producto, precio, total);
    }//GEN-LAST:event_btn_agregarActionPerformed
    aplicacion.Pedido.AbiProducto producto = new aplicacion.Pedido.AbiProducto();
    double precio = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscaCliente;
    private javax.swing.JButton btn_cancelarTodo;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcCatalogo;
    private javax.swing.JComboBox jcProducto;
    private javax.swing.JTable tabla_articulos;
    private javax.swing.JTable tablacliente;
    private javax.swing.JLabel tituloCatalogo;
    private javax.swing.JTextField txt_calle;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_colonia;
    private javax.swing.JTextField txt_estado;
    private javax.swing.JTextField txt_idcliente;
    private javax.swing.JTextField txt_idpedido;
    private javax.swing.JTextField txt_municipio;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_precioproducto;
    private javax.swing.JTextField txt_referencia1;
    private javax.swing.JTextField txt_referencia2;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_telefonobuscar;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalproducto;
    // End of variables declaration//GEN-END:variables

}
