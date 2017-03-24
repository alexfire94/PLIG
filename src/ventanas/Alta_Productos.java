package ventanas;




import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.Conexion;
import src.ConversionMayusculas;
import src.Validaciones;

/**
 *
 * @author CarlosAlberto
 */
public class Alta_Productos extends javax.swing.JFrame {

    private DefaultComboBoxModel modeloTipoVenta, modeloUM;
    private Conexion c;
    private Statement sentencia=null;
    Validaciones v = new Validaciones();
    
    /**
     * Creates new form Alta_Productos
     */
    public Alta_Productos(Conexion c) {
         
          this.c=c;
        
        
         
        initComponents();
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          this.setResizable(false);
          limpiaCampos();
          validaciones();
     

    }

    public final void cargarTipoVentas() {
        String[] tipo = {"Selecciona opcion","Pieza", "A Granel"};
        modeloTipoVenta = new DefaultComboBoxModel(tipo);
        this.comboTipoVenta.setModel(modeloTipoVenta);
    }

    public final void cargarUM() {
        String[] granel = {"Litro", "Mililitro", "Kilogramo", "Gramos", "Galón"};
        String[] pieza = {"Pieza", "Caja"};

        String datos = this.comboTipoVenta.getSelectedItem().toString();

        if (datos.equals("A Granel")) {
            modeloUM = new DefaultComboBoxModel(granel);
            this.comboUM.setModel(modeloUM);
        } else if (datos.equals("Pieza")) {
            modeloUM = new DefaultComboBoxModel(pieza);
            this.comboUM.setModel(modeloUM);
        }
    }
    
    public final void validaciones(){
            v.validarSoloNumeros(this.txtClave);
            v.validarSoloLetras(this.txtProducto);
            /*DESCRIPCION NO TIENE VALIDACION*/
            /*ESTATUS TAMPOCO TIENE VALIDACION*/
            v.validarSoloNumeros(this.txtCantidad);
            v.limitarCaracteres(this.txtCantidad, 3);
            v.validarSoloNumeros(this.txtStockMax);
            v.limitarCaracteres(this.txtStockMax, 3);
            v.validarSoloNumeros(this.txtStockMin);
            v.limitarCaracteres(this.txtStockMin, 3);
            v.validarSoloLetras(this.txtMarca);
            v.validarSoloLetras(this.txtProveedor);
            v.validarSoloNumeros(this.txtPCompra);
            v.limitarCaracteres(this.txtPCompra, 5);
            v.validarSoloNumeros(this.txtPVenta);
            v.limitarCaracteres(this.txtPVenta,5);
            v.validarSoloNumeros(this.txtPMayoreo);
            v.limitarCaracteres(this.txtPMayoreo, 5);
            v.validarSoloNumeros(this.txtIVA);
            v.limitarCaracteres(this.txtIVA, 4);
            v.validarSoloNumeros(this.txtUtilidad);
            v.limitarCaracteres(this.txtUtilidad, 4);
            /*UM NO TIENE VALIDACION*/
            
            
            this.txtDescripcion.setDocument(new ConversionMayusculas());
            this.txtMarca.setDocument(new ConversionMayusculas());
            this.txtProducto.setDocument(new ConversionMayusculas());
            this.txtProveedor.setDocument(new ConversionMayusculas());
            
            
            
                    
            
        //VALIDACIONES FIN

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecDis = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        rbDisponible = new javax.swing.JRadioButton();
        rbNoDisponible = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtStockMax = new javax.swing.JTextField();
        txtStockMin = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        txtPCompra = new javax.swing.JTextField();
        txtPVenta = new javax.swing.JTextField();
        txtPMayoreo = new javax.swing.JTextField();
        txtCosteCompra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        txtUtilidad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        comboUM = new javax.swing.JComboBox<>();
        botonLimpiar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        comboTipoVenta = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alta Productos");
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alta de productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("*Clave:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("*Producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("*Estatus:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 200, 30));
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, 30));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 200, 60));

        selecDis.add(rbDisponible);
        rbDisponible.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbDisponible.setText("Disponible");
        rbDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisponibleActionPerformed(evt);
            }
        });
        jPanel1.add(rbDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        selecDis.add(rbNoDisponible);
        rbNoDisponible.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbNoDisponible.setText("No disponible");
        rbNoDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoDisponibleActionPerformed(evt);
            }
        });
        jPanel1.add(rbNoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setText("*Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setText("Stock máx:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setText("Stock min:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 30));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 150, 30));
        jPanel1.add(txtStockMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 150, 30));
        jPanel1.add(txtStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 150, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 730, 20));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel8.setText("*Proveedor:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel9.setText("*Precio de compra:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel10.setText("*Precio de venta:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 371, -1, 40));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel11.setText("Precio mayoreo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 30));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setText("Total de compra:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));
        jPanel1.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 220, 30));
        jPanel1.add(txtPCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 130, 30));
        jPanel1.add(txtPVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 130, 30));

        txtPMayoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPMayoreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPMayoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 130, 30));
        jPanel1.add(txtCosteCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 130, 30));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setText("IVA:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, 20));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setText("utilidad:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 70, 20));
        jPanel1.add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 70, 30));
        jPanel1.add(txtUtilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 80, 30));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel15.setText("Se vende por:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel16.setText("*Marca:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, 30));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel17.setText("UM:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, 40));
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 150, 30));

        jPanel1.add(comboUM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 210, 30));

        botonLimpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setActionCommand("");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(botonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 120, 50));

        botonGuardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 100, 50));

        comboTipoVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoVentaItemStateChanged(evt);
            }
        });
        comboTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoVentaActionPerformed(evt);
            }
        });
        jPanel1.add(comboTipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 210, 30));

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel18.setText("Margen de");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisponibleActionPerformed
            rbNoDisponible.setSelected(false);
    }//GEN-LAST:event_rbDisponibleActionPerformed

    private void rbNoDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoDisponibleActionPerformed
           rbDisponible.setSelected(false);
    }//GEN-LAST:event_rbNoDisponibleActionPerformed

    private void comboTipoVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoVentaItemStateChanged


    }//GEN-LAST:event_comboTipoVentaItemStateChanged

    private void comboTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoVentaActionPerformed
          cargarUM();
    }//GEN-LAST:event_comboTipoVentaActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
                 limpiaCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
                 if(compruebaCamposVacios()){
                   funcionAltaProductos();
                 }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void txtPMayoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPMayoreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPMayoreoActionPerformed

    public void limpiaCampos(){
                 cargarTipoVentas();
                 txtClave.setText("");
                 txtProducto.setText("");
                 txtDescripcion.setText("");
                 txtProveedor.setText("");
                 txtPCompra.setText("");
                 txtPVenta.setText("");
                 txtPMayoreo.setText("");
                 txtCosteCompra.setText("");
                 txtIVA.setText("");
                 txtUtilidad.setText("");
                 txtCantidad.setText("");
                 txtStockMax.setText("");
                 txtStockMin.setText("");
                 txtMarca.setText("");
                 rbDisponible.setSelected(false);
                 rbNoDisponible.setSelected(false);
                 
    }
    
    
    private boolean compruebaCamposVacios(){
           boolean valor=true;
           String campos="";
        //-------------------------------------------
        if (txtClave.getText().equals(""))
            campos+="- CLAVE \n";
        if (txtProducto.getText().equals(""))
            campos+="- PRODUCTO \n";
        if (txtDescripcion.getText().equals(""))
            campos+="- DESCRIPCION \n";
        if (txtCantidad.getText().equals(""))
            campos+="- CANTIDAD \n";
        if (txtStockMax.getText().equals(""))
            campos+="- STOCK MAX \n";
        if (txtStockMin.getText().equals(""))
            campos+="- STOCK MIN \n";
        if (txtMarca.getText().equals(""))
            campos+="- MARCA \n";
        if (!rbDisponible.isSelected() && !rbNoDisponible.isSelected())
            campos+="- STATUS (Seleccionar una opción) \n";
        
        if (txtProveedor.getText().equals(""))
            campos+="- PROVEEDOR \n";
        if (txtPCompra.getText().equals(""))
            campos+="- PRECIO COMPRA \n";
        if (txtPVenta.getText().equals(""))
            campos+="- PRECIO VENTA \n";
        if (txtPMayoreo.getText().equals(""))
            campos+="- PRECIO MAYOREO \n";
        if (txtCosteCompra.getText().equals(""))
            campos+="- COSTE COMPRA \n";
        if (txtIVA.getText().equals(""))
            campos+="- IVA \n";
        if (txtUtilidad.getText().equals("")){
            campos+="- UTILIDAD \n";}
        if (comboTipoVenta.getSelectedIndex()==0)
            campos+="- SELECCIONA TIPO DE VENTA \n";
        
       
        if(campos!=""){
        JOptionPane.showMessageDialog(null, "Complete los siguientes campos: \n"+ campos);
        valor=false;
        }
    return valor;
    }
    
    
    
   private void funcionAltaProductos(){
         String insertar, disponibilidad="";
         
        
         if(rbDisponible.isSelected()){
             disponibilidad= rbDisponible.getText();
        }else if(rbNoDisponible.isSelected()){
            disponibilidad=rbNoDisponible.getText();
        }
         System.out.println("Antes del insert");
         insertar="INSERT INTO limpieza_ventas.Productos"
                 + "(clave_prod,"
                 + "nombre_prod,"
                 + "descrip_prod,"
                 + "estatus_prod,"
                 + "cant_prod,"
                 + "stock_max,"
                 + "stock_min,"
                 + "marca_prod,"
                 + "prov_idProv,"
                 + "precio_compra,"
                 + "precio_venta,"
                 + "precio_mayoreo,"
                 + "iva,"
                 + "mu_pv,"
                 + "unidad_medida) "
                 + "VALUES("
                 +  txtClave.getText()+","
                 +"'"+txtProducto.getText()+"',"
                 +"'"+txtDescripcion.getText()+"',"
                 + "'"+ disponibilidad +"',"
                 +  txtCantidad.getText()+","
                 +  txtStockMax.getText()+","
                 +  txtStockMin.getText()+","
                 + "'"+ txtMarca.getText()+"',"
                 + "'"+ txtProveedor.getText()+"',"
                 +  txtPCompra.getText()+","
                 +  txtPVenta.getText()+","
                 +  txtPMayoreo.getText()+","
                 +  txtIVA.getText()+","
                 +  "'"+txtUtilidad.getText()+"',"
                 + "'"+ comboUM.getSelectedItem().toString()+"');";
                 
               System.out.println("Despues del insert");
              System.out.println(insertar);
         
         try{
              sentencia = c.getConnection().createStatement();
              sentencia.executeUpdate(insertar);
              JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
              
              sentencia.close();
             
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar el alta \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
         
        
   }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JComboBox<String> comboTipoVenta;
    private javax.swing.JComboBox<String> comboUM;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbDisponible;
    private javax.swing.JRadioButton rbNoDisponible;
    public static javax.swing.ButtonGroup selecDis;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCosteCompra;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPCompra;
    private javax.swing.JTextField txtPMayoreo;
    private javax.swing.JTextField txtPVenta;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtStockMax;
    private javax.swing.JTextField txtStockMin;
    private javax.swing.JTextField txtUtilidad;
    // End of variables declaration//GEN-END:variables
}