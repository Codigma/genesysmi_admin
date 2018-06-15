/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.VentaVo;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luism
 */
public class Ventas extends javax.swing.JInternalFrame {
    
    
 DefaultTableModel modelo = new DefaultTableModel();
 DefaultTableModel modelo2 = new DefaultTableModel();
      String[] columnas = {"ID Venta","ID Cliente","Cliente","Subtotal","Envio","Total","Fecha"};
  String[] columnas2 = {"Cod. Artículo","Artículo","Color","Talla","Precio","Cantidad"};
      private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        llenarTablaVenta();
       
        
    }
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    /**
     * Creates new form Ventas
     */
    public Ventas() {
      
        initComponents();
       // setLocationRelativeTo(null);        // Centering on screen...
        //setSize(1280, 800); 
        modelo.setColumnIdentifiers(columnas);
        tbSale.setModel(modelo);
        modelo2.setColumnIdentifiers(columnas2);
        tbProducts.setModel(modelo2);
    }
public void llenarTablaVenta(){
    modelo.setColumnIdentifiers(columnas);
     ArrayList<VentaVo> venta = miCoordinador.obtenerVentas();
      
     for(int i = 0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),venta.get(i).getId_user(),venta.get(i).getFirstname()+" "+
        venta.get(i).getLastname(),venta.get(i).getSubtotal(),venta.get(i).getShip(),venta.get(i).getTotal(),
venta.get(i).getDate()});
}
      //Asignamos los datos del Modelo a la tabla
      tbSale.setModel(modelo);
}

public void llenarTablaVentaSinCliente(){
    modelo.setColumnIdentifiers(columnas);
     ArrayList<VentaVo> venta = miCoordinador.ventasSinCliente();
      
     for(int i = 0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),"","",
    venta.get(i).getSubtotal(),venta.get(i).getShip(),venta.get(i).getTotal(),
venta.get(i).getDate()});
}
      //Asignamos los datos del Modelo a la tabla
      tbSale.setModel(modelo);
}
    
public void llenarTablaProducto(int sale){
modelo2.setColumnIdentifiers(columnas2);
limpiarTabla(tbProducts);
ArrayList<BagVo> listado = miCoordinador.obtenerProductosVenta(sale);

for(int i =0; i<listado.size();i++){
modelo2.addRow(new Object[] {listado.get(i).getArt(),listado.get(i).getArt_name(),listado.get(i).getColor_name(),
listado.get(i).getSize_name(),listado.get(i).getPrice(),listado.get(i).getQuantity()});
}
tbProducts.setModel(modelo2);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        btnGenerate = new javax.swing.JButton();
        btnGenerate1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(890, 696));

        jPanel3.setBackground(new java.awt.Color(237, 237, 237));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        tbProducts.setBackground(new java.awt.Color(237, 237, 237));
        tbProducts.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod. Artículo", "Artículo", "Color", "Talla", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProducts.setGridColor(new java.awt.Color(204, 204, 204));
        tbProducts.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbProducts.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProducts);

        jLabel2.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel1.setText("Ventas");
        jLabel1.setAlignmentX(0.5F);

        tbSale.setBackground(new java.awt.Color(237, 237, 237));
        tbSale.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Subtotal", "Total", "Estado", "Fecha de Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSale.setGridColor(new java.awt.Color(204, 204, 204));
        tbSale.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbSale.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSale);

        btnGenerate.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Generar");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnGenerate1.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate1.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate1.setText("Sin Registrar");
        btnGenerate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate1)
                .addGap(242, 242, 242))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked
  
    }//GEN-LAST:event_tbProductsMouseClicked

    private void tbSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseClicked
int fila = tbSale.getSelectedRow();
         
         if ((fila > -1)){
            int aux = (int) modelo.getValueAt(fila, 0);
          llenarTablaProducto(aux);
          
          
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tbSaleMouseClicked

    private void btnGenerate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerate1ActionPerformed
limpiarTabla(tbSale);
llenarTablaVentaSinCliente();
    }//GEN-LAST:event_btnGenerate1ActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
  limpiarTabla(tbSale);
llenarTablaVenta();
    }//GEN-LAST:event_btnGenerateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbProducts;
    private javax.swing.JTable tbSale;
    // End of variables declaration//GEN-END:variables
}
