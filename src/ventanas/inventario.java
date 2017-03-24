package ventanas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Font;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import src.Conexion;

/**
 *
 * @author ♥Eunice♥
 */
public class inventario extends javax.swing.JFrame {
  private Conexion c;
  private Statement sentencia=null;
  private DefaultTableModel modeloTabla;
 
  private DefaultListModel listaModelo;
  private String nombre,claveP, descriP, statusP, um_P, marcaP="", proveeP, margenUtiP;
  private int clave, stockMaxP, stockMinP,cantP;
  private float pventaP, pcompraP, pmayoreoP;
    /**
     * Creates new form inventario
     */
    
    public inventario(Conexion c) {
         this.c=c;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setResizable(false);
         
       
         consultaProductosAll(0,"");
         obtenerMuestra(0);
         obtenerMarcas();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        codigobarras = new javax.swing.JLabel();
        nombreproducto = new javax.swing.JLabel();
        precioventa = new javax.swing.JLabel();
        preciomayoreo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        unidadproducto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        stockMax = new javax.swing.JTextField();
        botonactualizar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        stockMin = new javax.swing.JTextField();
        cantidadproducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tfbuscar = new javax.swing.JTextField();
        botonbuscar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaproductos = new javax.swing.JList();
        botonexistenciam = new javax.swing.JButton();
        botonregresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel15.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        jLabel15.setText("Nombre");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Descrip", "Estatus", "Cant.", "Un. Med.", "Marca", "Proveed.", "P. Compra", "P Venta", "p Mayor", "IVA", "Marg Uti"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaproductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaproductos.setFillsViewportHeight(true);
        tablaproductos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaproductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaproductos);
        if (tablaproductos.getColumnModel().getColumnCount() > 0) {
            tablaproductos.getColumnModel().getColumn(0).setResizable(false);
            tablaproductos.getColumnModel().getColumn(1).setResizable(false);
            tablaproductos.getColumnModel().getColumn(2).setResizable(false);
            tablaproductos.getColumnModel().getColumn(3).setResizable(false);
            tablaproductos.getColumnModel().getColumn(4).setResizable(false);
            tablaproductos.getColumnModel().getColumn(5).setResizable(false);
            tablaproductos.getColumnModel().getColumn(6).setResizable(false);
            tablaproductos.getColumnModel().getColumn(7).setResizable(false);
            tablaproductos.getColumnModel().getColumn(8).setResizable(false);
            tablaproductos.getColumnModel().getColumn(9).setResizable(false);
            tablaproductos.getColumnModel().getColumn(10).setResizable(false);
            tablaproductos.getColumnModel().getColumn(11).setResizable(false);
            tablaproductos.getColumnModel().getColumn(12).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 980, 130));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detalles del producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigobarras.setBackground(new java.awt.Color(255, 255, 255));
        codigobarras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        codigobarras.setText(" jLabel4");
        jPanel4.add(codigobarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 250, 30));

        nombreproducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nombreproducto.setText("jLabel6");
        jPanel4.add(nombreproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 290, 30));

        precioventa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        precioventa.setText("jLabel7");
        jPanel4.add(precioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 290, 30));

        preciomayoreo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        preciomayoreo.setText("jLabel8");
        jPanel4.add(preciomayoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 290, 30));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Unidad de medida:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        unidadproducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        unidadproducto.setText("jLabel9");
        jPanel4.add(unidadproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 300, 30));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Existencia:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setText("Precio mayoreo:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel13.setText("Stock Min:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel17.setText("Código de barras:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        stockMax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMaxActionPerformed(evt);
            }
        });
        jPanel4.add(stockMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 70, 30));

        botonactualizar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonactualizar.setText("Actualizar");
        botonactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonactualizarActionPerformed(evt);
            }
        });
        jPanel4.add(botonactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 120, 40));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel16.setText("Precio venta:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel18.setText("Stock Max:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        stockMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(stockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 70, 30));

        cantidadproducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(cantidadproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 70, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 810, 360));
        jPanel4.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 1, 18))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tfbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botonbuscar.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        botonbuscar.setText("Buscar");
        botonbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonbuscarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel11.setText("Escriba nombre ó código de barras ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(tfbuscar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 366, 630, 110));

        listaproductos.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        listaproductos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "TODO" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaproductosMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(listaproductos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 290));

        botonexistenciam.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        botonexistenciam.setText("Existencia mín.");
        botonexistenciam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonexistenciamActionPerformed(evt);
            }
        });
        jPanel1.add(botonexistenciam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 160, 60));

        botonregresar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonregresar.setText("Regresar");
        botonregresar.setToolTipText("");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 420, 140, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Marcas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void consultaProductoUnitario(){
  String consultaAll="SELECT cant_prod from limpieza_ventas.Productos"
          + " WHERE clave_prod="+ Integer.parseInt(codigobarras.getText());
       
         try{
              sentencia = c.getConnection().createStatement();
              ResultSet rs=  sentencia.executeQuery(consultaAll);
        
              for (int i = 0; i < tablaproductos.getRowCount(); i++) {
                  if(Integer.parseInt(codigobarras.getText())==Integer.parseInt(tablaproductos.getValueAt(i,0).toString())){
                      if(rs!=null){
                  
                    while (rs.next()) {
                      
                       tablaproductos.setValueAt(rs.getInt(1),i , 4);
                      
                    } 
                     
                    sentencia.close();
                    }else{
                          JOptionPane.showMessageDialog(null, "No se encontraron registros");
                    }
              }
             }
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar inventario \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
  } 
   private void consultaProductosAll(int cons, String campo1){
       String [ ]consultaAll= new String [3];
       
       //Consulta de todos los productos
       consultaAll[0]="SELECT * from limpieza_ventas.Productos";
       //consulta para obtener los elementos por marca
       consultaAll[1]="SELECT * from limpieza_ventas.Productos WHERE marca_prod='"+campo1+"'";
       llenarTabla(consultaAll[cons]);
       
       
   }
   private void obtenerMuestra(int nofila){
        
        
         claveP =tablaproductos.getValueAt(nofila,0).toString();
         codigobarras.setText(tablaproductos.getValueAt(nofila,0).toString());
         nombreproducto.setText(tablaproductos.getValueAt(nofila, 1).toString());  
         precioventa.setText(tablaproductos.getValueAt(nofila,9).toString());
         preciomayoreo.setText(tablaproductos.getValueAt(nofila, 10).toString());
         unidadproducto.setText(tablaproductos.getValueAt(nofila, 5).toString());
         cantidadproducto.setText(String.valueOf(cantP));
         //cantidadproducto.setText(tablaproductos.getValueAt(nofila,4).toString());
         stockMax.setText(String.valueOf(stockMaxP));
         stockMin.setText(String.valueOf(stockMinP));
       
       
   } 
   private void obtenerMarcas(){
       String consultaMarcas= "Select DISTINCT marca_prod from limpieza_ventas.Productos";
       
       try{   
             
              listaModelo = new DefaultListModel();
             
              sentencia = c.getConnection().createStatement();
              ResultSet rs=  sentencia.executeQuery(consultaMarcas);
                    listaModelo.addElement("Todo");
                    
                    while (rs.next()) {
                     listaModelo.addElement(rs.getString(1));
                    }   
                    listaproductos.setModel(listaModelo);
                    rs.close();
                    sentencia.close();
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar Marcas \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
      
   }
   
   
   private void llenarTabla(String consulta){
    
         if(modeloTabla!=null){
         for (int i = 0; i < tablaproductos.getRowCount(); i++) {
           modeloTabla.removeRow(i);
           i-=1;
            }
         }
       
         try{ 
              modeloTabla = (DefaultTableModel) tablaproductos.getModel();
              Object [] fila = new Object [13];
              sentencia = c.getConnection().createStatement();
              ResultSet rs=  sentencia.executeQuery(consulta);
              
              String [] cadenas = new String [3];
              
              if(rs!=null){
                    int j=0;
                    while (rs.next()) {
                    //Clave
                    fila [0]= rs.getInt(2);
                    //Nombre
                    nombre= rs.getObject(3).toString().trim();
                    fila[1]= nombre;
                    //descripcion
                    fila [2]= rs.getString(4).trim();
                    //Estutus
                    fila [3]= rs.getString(5).trim();
                    //Cantidad
                    cantP= Integer.parseInt(rs.getObject(6).toString());
                   // fila [4]= Float.parseFloat(rs.getObject(6).toString());
                    //Unidad medida
                    fila [5]= rs.getString(18).trim();
                    //Marca
                    fila [6]= rs.getString(9).trim();
                    //Proveedor
                    fila [7]= rs.getString(10).trim();
                    //P Compra
                    fila [8]= Float.parseFloat(rs.getObject(11).toString());
                    //P Venta
                    fila [9]= Float.parseFloat(rs.getObject(12).toString());
                    //P Mayoreo
                    fila [10]= Float.parseFloat(rs.getObject(13).toString());
                    //IVA
                    fila [11]= Float.parseFloat(rs.getObject(15).toString());
                    //Margen Utilidad
                    fila [12]= rs.getString(16).trim();
                    
                    stockMaxP= rs.getInt(7);
                    stockMinP=rs.getInt(8);
                    //Agregamos la fila al modelo de la tabla
                    modeloTabla.addRow(fila);

                    tablaproductos.setModel(modeloTabla);
                    
                   /* for(int i=0;i<fila.length;i++){
                     tablaproductos.setValueAt(fila[i],j,i);
                    }
                    j++;*/
                    }   
                     System.out.println(modeloTabla.getColumnCount());
                    sentencia.close();
              }else{
                    JOptionPane.showMessageDialog(null, "No se encontraron registros");
              }
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cargar productor \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
   }
   private void busquedaGeneral(String marca){
     
       //SELECT * FROM `productos` WHERE (nombre_prod like '%j%' or CAST(clave_prod as CHAR) like '%123%')
       String busquedaQuery="SELECT * from limpieza_ventas.Productos WHERE (nombre_prod like '%"+tfbuscar.getText()+"%' OR"
              + " CAST(clave_prod as CHAR) like '%"+tfbuscar.getText()+"%' ) OR (marca_prod='"+marca+")";
          
       llenarTabla(busquedaQuery);
   
   }
    private void botonactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonactualizarActionPerformed
           String actualizaCant;
           
           actualizaCant="UPDATE limpieza_ventas.Productos SET cant_prod="+Float.parseFloat(cantidadproducto.getText())+
                   ", stock_max="+stockMax.getText()+", stock_min="+stockMin.getText()+" WHERE clave_prod="+Integer.parseInt(codigobarras.getText());
        
        
         try{
              sentencia = c.getConnection().createStatement();
              sentencia.executeUpdate(actualizaCant);
              consultaProductoUnitario();
              JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
              
              sentencia.close();
             
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar actualización \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
    }//GEN-LAST:event_botonactualizarActionPerformed
    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
          this.dispose();
    }//GEN-LAST:event_botonregresarActionPerformed
   
   
    private void botonbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonbuscarActionPerformed
       busquedaGeneral(marcaP);
    }//GEN-LAST:event_botonbuscarActionPerformed

    private void tablaproductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproductosMousePressed
       if (evt.getClickCount() > 1) {
        Point point = evt.getPoint();
        
        obtenerMuestra(tablaproductos.rowAtPoint(point));
    }
    }//GEN-LAST:event_tablaproductosMousePressed

    private void listaproductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaproductosMousePressed
        if (evt.getClickCount() > 1) {
         int index = listaproductos.locationToIndex(evt.getPoint());
	           
         if(index==0){
             consultaProductosAll(0,"");
         }else{
            consultaProductosAll(1, listaproductos.getSelectedValue().toString() );
            marcaP= listaproductos.getSelectedValue().toString();
            obtenerMuestra(0);
         }
        }
    }//GEN-LAST:event_listaproductosMousePressed

    private void botonexistenciamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonexistenciamActionPerformed
        String consultaAll, cadena="";
           
           consultaAll="SELECT * FROM limpieza_ventas.Productos";
        
        
         try{
              sentencia = c.getConnection().createStatement();
            
              ResultSet rs=  sentencia.executeQuery(consultaAll);
              
              while(rs.next()){
                  
                  if(rs.getInt(6)<=rs.getInt(8)){
                      cadena+= "-"+rs.getString(3)+"\n";
                  }
                  
                }             
              
              sentencia.close();
               JOptionPane.showMessageDialog(null, "Los siguientes productos estan en existencia minima: \n"+ cadena);
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE REALIZAR LA OPERACION \n "+ e.getMessage());
             System.out.println(e.getSQLState());
         }
        
    }//GEN-LAST:event_botonexistenciamActionPerformed

    private void stockMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMaxActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonactualizar;
    private javax.swing.JButton botonbuscar;
    private javax.swing.JButton botonexistenciam;
    private javax.swing.JButton botonregresar;
    private javax.swing.JTextField cantidadproducto;
    private javax.swing.JLabel codigobarras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaproductos;
    private javax.swing.JLabel nombreproducto;
    private javax.swing.JLabel preciomayoreo;
    private javax.swing.JLabel precioventa;
    private javax.swing.JTextField stockMax;
    private javax.swing.JTextField stockMin;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JTextField tfbuscar;
    private javax.swing.JLabel unidadproducto;
    // End of variables declaration//GEN-END:variables
}
