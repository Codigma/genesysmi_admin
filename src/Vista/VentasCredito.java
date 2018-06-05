
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.VentaVo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luism
 */
public class VentasCredito extends javax.swing.JFrame {
    
    
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
    public VentasCredito() {
        initComponents();
        setLocationRelativeTo(null);        // Centering on screen...
        setSize(1280, 800); 
        modelo.setColumnIdentifiers(columnas);                
        tbCredito.setModel(modelo);
        modelo2.setColumnIdentifiers(columnas2);
        tbProductos.setModel(modelo2);
    }
public void llenarTablaVenta(){
    modelo.setColumnIdentifiers(columnas);
     ArrayList<VentaVo> venta = miCoordinador.ventasCredito();
      
     for(int i = 0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),venta.get(i).getId_user(),venta.get(i).getFirstname()+" "+
        venta.get(i).getLastname(),venta.get(i).getSubtotal(),venta.get(i).getShip(),venta.get(i).getTotal(),
venta.get(i).getDate()});
}
      //Asignamos los datos del Modelo a la tabla
      tbCredito.setModel(modelo);
}
    
public void llenarTablaProducto(int sale){
modelo2.setColumnIdentifiers(columnas2);
limpiarTabla(tbProductos);
ArrayList<BagVo> listado = miCoordinador.obtenerProductosVenta(sale);

for(int i =0; i<listado.size();i++){
modelo2.addRow(new Object[] {listado.get(i).getArt(),listado.get(i).getArt_name(),listado.get(i).getColor_name(),
listado.get(i).getSize_name(),listado.get(i).getPrice(),listado.get(i).getQuantity()});
}
tbProductos.setModel(modelo2);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCredit = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();
        btnGenerate1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(237, 237, 237));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        tbProductos.setBackground(new java.awt.Color(237, 237, 237));
        tbProductos.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.setGridColor(new java.awt.Color(204, 204, 204));
        tbProductos.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbProductos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductos);

        jLabel2.setFont(new java.awt.Font("Avenir", 1, 22)); // NOI18N
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(566, 566, 566)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Avenir", 1, 22)); // NOI18N
        jLabel1.setText("Ventas a crédito");
        jLabel1.setAlignmentX(0.5F);

        tbCredit.setBackground(new java.awt.Color(237, 237, 237));
        tbCredit.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbCredit.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCredit.setGridColor(new java.awt.Color(204, 204, 204));
        tbCredit.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbCredit.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCreditMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCredit);

        btnPagar.setBackground(new java.awt.Color(0, 37, 145));
        btnPagar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnGenerate1.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate1.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate1.setText("Generar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel1)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(551, 551, 551))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(457, 457, 457)
                    .addComponent(btnGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(792, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(317, Short.MAX_VALUE)
                    .addComponent(btnGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
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

        jPanel3.getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        if(1 >=0 ){
            String descuento;
            descuento = JOptionPane.showInputDialog(null, "Registre el nuevo costo");

        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla");
        }

        }                  // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed

    private void tbCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCreditMouseClicked
    }//GEN-LAST:event_tbCreditMouseClicked
    private void tbCreditMouseClicked(java.awt.event.MouseEvent evt) {                                      


}
    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked

    }//GEN-LAST:event_tbProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate1;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCredit;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
