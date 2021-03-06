/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.Conectarse;
import Modelo.ProductoVo;
import Modelo.SubcategoryVo;
import Modelo.VentaVo;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author bryan
 */
public class Reportes extends javax.swing.JInternalFrame {
   private Coordinador miCoordinador;
   DefaultComboBoxModel modeloSubcategory, modeloYears;
   private ProductoVo producto;
   private ArrayList<SubcategoryVo> subcategories;
   private ArrayList<VentaVo> years;

  
    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        lbCat.setEnabled(false);
        lbSub.setEnabled(false);
        lbano.setEnabled(false);
        cbxCategoria.setEnabled(false);
        cbxSubcategoria.setEnabled(false);
        cbxan.setEnabled(false);
        btnreporte.setEnabled(false);
        btnreporteventa.setEnabled(false);
        
        producto = new ProductoVo();
        subcategories = new ArrayList<>();
        
    }
   
     public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonreportes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbano = new javax.swing.JLabel();
        cbxan = new javax.swing.JComboBox<>();
        btnreporteventa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbVentas = new javax.swing.JRadioButton();
        rbInventario = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnreporte = new javax.swing.JButton();
        lbCat = new javax.swing.JLabel();
        lbSub = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxSubcategoria = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);

        lbano.setText("Año");

        cbxan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        cbxan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxanActionPerformed(evt);
            }
        });

        btnreporteventa.setText("Generar Reporte");
        btnreporteventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnreporteventa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbano, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(btnreporteventa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Reportes");

        GrupoBotonreportes.add(rbVentas);
        rbVentas.setText("Ventas");
        rbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVentasActionPerformed(evt);
            }
        });

        GrupoBotonreportes.add(rbInventario);
        rbInventario.setText("Inventario");
        rbInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInventarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de Reporte");

        jPanel2.setEnabled(false);

        btnreporte.setText("Generar Reporte");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });

        lbCat.setText("Categoria");

        lbSub.setText("Subcategoria");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Recién nacido/Ellas", "Recién nacido/Ellos", "Baby/Ellas", "Baby/Ellos", "Mini/Ellas", "Mini/Ellos", "Junior/Ellas", "Junior/Ellos", "Accesorios y regalos" }));
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        cbxSubcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        cbxSubcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSubcategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSub, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(lbCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCategoria, 0, 164, Short.MAX_VALUE)
                    .addComponent(cbxSubcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbInventario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rbVentas)
                        .addGap(78, 78, 78))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbInventario)
                    .addComponent(rbVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        
        Conectarse con = new Conectarse();
        Connection conn = (Connection) con.getConn();
        
        Integer cat_index = cbxCategoria.getSelectedIndex();
        Integer subcategory_index = cbxSubcategoria.getSelectedIndex();
        
        
        if(cat_index > 0){
            
             try {

            Integer subcat_index = subcategory_index - 1;
            Integer sub_index = subcategories.get(subcat_index).getId_subcategory();
            JasperReport reporte = null;
            String path = "src/Reportes/ReporteInventarioSub.jasper";
            String cat_nombre = cbxCategoria.getSelectedItem().toString();
            String sub_nombre = cbxSubcategoria.getSelectedItem().toString();
            //Filtro de parametros
            Map parametro = new HashMap();
            //nombre del parametro
            parametro.put("id_category",cat_index);
            parametro.put("id_subcategory",sub_index);
            parametro.put("category_name",cat_nombre);
            parametro.put("subcategory_name", sub_nombre);
           
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte,parametro,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }else if(cat_index == 0){
            
            try {
           
            JasperReport reporte2 = null;
            String path = "src/Reportes/ReporteInventario.jasper";
            
           
            reporte2 = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte2,null,conn);
            
            JasperViewer view2 = new JasperViewer(jprint,false);
            
            view2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view2.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
        
       
    }//GEN-LAST:event_btnreporteActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        
   
        Integer cat_index = cbxCategoria.getSelectedIndex();

        modeloSubcategory = new DefaultComboBoxModel();
        modeloSubcategory.addElement("Seleccionar...");

        Integer sub_index = 0;

        if (cat_index > 0) {
            producto.setId_category(cat_index);
            //txtp1.setText(producto.getId_category().toString());
            

            subcategories = miCoordinador.getSubcategories(cat_index);

            for (int i = 0; i < subcategories.size(); i++) {
                modeloSubcategory.addElement(subcategories.get(i).getSucategory_name());
                if (subcategories.get(i).getId_subcategory().equals(producto.getId_subcategory())) {
                    sub_index = i;
                }
            }
        } else {
            producto.setId_category(null);
        }
       
        cbxSubcategoria.setModel(modeloSubcategory);
        if (sub_index > 0) {
            cbxSubcategoria.setSelectedIndex(sub_index + 1);
        } else {
            cbxSubcategoria.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void cbxSubcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSubcategoriaActionPerformed
        /* Integer sub_index = cbxSubcategoria.getSelectedIndex();
        if (sub_index > 0) {
            producto.setId_subcategory(subcategories.get(sub_index - 1).getId_subcategory());
        } else {
            producto.setId_subcategory(null);
        }*/
    }//GEN-LAST:event_cbxSubcategoriaActionPerformed

    private void rbInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInventarioActionPerformed
        
        lbano.setEnabled(false);
        cbxan.setEnabled(false);
        btnreporteventa.setEnabled(false);
        lbCat.setEnabled(true);
        lbSub.setEnabled(true);
        cbxCategoria.setEnabled(true);
        cbxSubcategoria.setEnabled(true);
        btnreporte.setEnabled(true);
        
   
        
    }//GEN-LAST:event_rbInventarioActionPerformed

    private void rbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVentasActionPerformed
  
        lbCat.setEnabled(false);
        lbSub.setEnabled(false);
        cbxCategoria.setEnabled(false);
        cbxSubcategoria.setEnabled(false);
        btnreporte.setEnabled(false);
        lbano.setEnabled(true);
        cbxan.setEnabled(true);
        btnreporteventa.setEnabled(true);
        
         modeloYears = new DefaultComboBoxModel();
        modeloYears.addElement("Seleccionar...");
        
        years = miCoordinador.selectYears();
        
         for (int i =0; i<years.size();i++){
             
            modeloYears.addElement(years.get(i).getSales_years()); 
       
      }
         
        cbxan.setModel(modeloYears);
        
        
    }//GEN-LAST:event_rbVentasActionPerformed

    private void btnreporteventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteventaActionPerformed
        
        Conectarse con = new Conectarse();
        Connection conn = (Connection) con.getConn();

        String aux =(String) cbxan.getSelectedItem();
        try {

            JasperReport reportev = null;
            
            String path = "src/Reportes/ReporteVentas.jasper";
       
            Map parametrov = new HashMap();
            
            parametrov.put("sale_year",aux);
            
            reportev = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reportev,parametrov,conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnreporteventaActionPerformed

    private void cbxanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxanActionPerformed
      
       
    }//GEN-LAST:event_cbxanActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotonreportes;
    private javax.swing.JButton btnreporte;
    private javax.swing.JButton btnreporteventa;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxSubcategoria;
    private javax.swing.JComboBox<String> cbxan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbCat;
    private javax.swing.JLabel lbSub;
    private javax.swing.JLabel lbano;
    private javax.swing.JRadioButton rbInventario;
    private javax.swing.JRadioButton rbVentas;
    // End of variables declaration//GEN-END:variables
}
