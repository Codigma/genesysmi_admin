package Vista;

import Controlador.Coordinador;
import Modelo.ConecRemoto;
import Modelo.HiloSync;
import Vista.Prueba.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Inicio extends javax.swing.JFrame {

    ConecRemoto remoto = new ConecRemoto();
    
private Coordinador miCoordinador;
    private Dimension dim;
File documento = new File("src/Modelo/Consulta.txt");
    
public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;

    }

    public Inicio() {
        this.setResizable(false);
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
    }
 
    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
                JOptionPane.showMessageDialog(this, "Otra ventana se encuentra \nya  abierta !!!", "Aviso", 0,
                        new ImageIcon(getClass().getResource("/Imagenes/adver1.png")));
            }
            i++;
        }
        return cerrado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProduct = new javax.swing.JMenu();
        addProduct = new javax.swing.JMenuItem();
        searchProduct = new javax.swing.JMenuItem();
        updateProduct = new javax.swing.JMenuItem();
        menuColors = new javax.swing.JMenu();
        itemViewColor = new javax.swing.JMenuItem();
        itemAddColor = new javax.swing.JMenuItem();
        menuUsers = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSale = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemSale = new javax.swing.JMenuItem();
        itemCredit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        inventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(263, 25));

        menuProduct.setText("Productos");
        menuProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        addProduct.setText("Añadir nuevo");
        addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductMouseClicked(evt);
            }
        });
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        menuProduct.add(addProduct);

        searchProduct.setText("Buscar producto");
        searchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchProductMouseClicked(evt);
            }
        });
        searchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductActionPerformed(evt);
            }
        });
        menuProduct.add(searchProduct);

        updateProduct.setText("Actulizar producto");
        updateProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateProductMouseClicked(evt);
            }
        });
        updateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductActionPerformed(evt);
            }
        });
        menuProduct.add(updateProduct);

        jMenuBar1.add(menuProduct);
        menuProduct.getAccessibleContext().setAccessibleDescription("");

        menuColors.setText("Colores");
        menuColors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuColors.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemViewColor.setText("Ver Lista");
        itemViewColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemViewColorActionPerformed(evt);
            }
        });
        menuColors.add(itemViewColor);

        itemAddColor.setText("Agregar Color");
        itemAddColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddColorActionPerformed(evt);
            }
        });
        menuColors.add(itemAddColor);

        jMenuBar1.add(menuColors);

        menuUsers.setText("Usuarios");
        menuUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem1.setText("Lista Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuUsers.add(jMenuItem1);

        jMenuBar1.add(menuUsers);

        menuSale.setText("Ventas");
        menuSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem2.setText("Realizar Venta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuSale.add(jMenuItem2);

        itemSale.setText("Lista de Ventas");
        itemSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaleActionPerformed(evt);
            }
        });
        menuSale.add(itemSale);

        itemCredit.setText("Lista de Créditos");
        itemCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreditActionPerformed(evt);
            }
        });
        menuSale.add(itemCredit);

        jMenuBar1.add(menuSale);

        jMenu1.setText("Reportes");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inventario.setText("Inventarios");
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });
        jMenu1.add(inventario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Productos pt;
    private void updateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductActionPerformed

        if (estacerrado(pt)) {

            pt = new Productos();
            pt.setCoordinador(miCoordinador);
            
            escritorio.add(pt).setLocation(25, 3);
            pt.show(true);

            try {
                pt.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateProductActionPerformed
    DetalleVenta dv;
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (estacerrado(dv)) {
            dv = new DetalleVenta();
            dv.setCoordinador(miCoordinador);
            escritorio.add(dv).setLocation(25, 3);
            dv.show(true);

            try {
                dv.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// miCoordinador.getDetalle().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    Reportes rp;
    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        if (estacerrado(dv)) {
            rp = new Reportes();
            rp.setCoordinador(miCoordinador);
            escritorio.add(rp).setLocation(300, 30);
            rp.show(true);

        }
    }//GEN-LAST:event_inventarioActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        if (estacerrado(pt)) {

            pt = new Productos();
            pt.setCoordinador(miCoordinador);
            escritorio.add(pt).setLocation(25, 3);
            pt.show(true);

            try {
                pt.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//miCoordinador.getProductos().setVisible(true); 
    }//GEN-LAST:event_addProductActionPerformed

    private void addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductMouseClicked

    private void searchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchProductMouseClicked

    }//GEN-LAST:event_searchProductMouseClicked

    private void updateProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductMouseClicked

    }//GEN-LAST:event_updateProductMouseClicked

    private void searchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductActionPerformed
        if (estacerrado(pt)) {

            pt = new Productos();
            pt.setCoordinador(miCoordinador);
            escritorio.add(pt).setLocation(25, 3);
            pt.show(true);

            try {
                pt.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_searchProductActionPerformed

    Colores cl;
    private void itemViewColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemViewColorActionPerformed
        if (estacerrado(cl)) {
            cl = new Colores();
            cl.setCoordinador(miCoordinador);
            escritorio.add(cl).setLocation(25, 3);
            dim = super.getToolkit().getScreenSize();
            super.setSize(dim);
            cl.show(true);
            try {
                cl.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_itemViewColorActionPerformed
    Usuarios us;
    Ventas vt;
    VentaCredito vc;
    private void itemAddColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddColorActionPerformed
        if (estacerrado(cl)) {
            cl = new Colores();
            cl.setCoordinador(miCoordinador);
            escritorio.add(cl).setLocation(25, 3);
            cl.show(true);
            try {
                cl.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_itemAddColorActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (estacerrado(us)) {
            us = new Usuarios();
            us.setCoordinador(miCoordinador);
            escritorio.add(us).setLocation(25, 3);
            us.show(true);
            try {
                us.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void itemSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaleActionPerformed
        if (estacerrado(vt)) {
            vt = new Ventas();
            vt.setCoordinador(miCoordinador);
            escritorio.add(vt).setLocation(25, 3);
            vt.show(true);

            try {
                vt.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_itemSaleActionPerformed
    private void itemCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreditActionPerformed
        if (estacerrado(vc)) {
            vc = new VentaCredito();
            vc.setCoordinador(miCoordinador);
            escritorio.add(vc).setLocation(25, 3);
            vc.show(true);
            try {
                vc.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_itemCreditActionPerformed

    
   
    
    
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Esta a punto de salir\nde la aplicación.\n¿Desea continuar?", "Cerrar", JOptionPane.YES_NO_OPTION, 0,
                new ImageIcon(getClass().getResource("/Imagenes/adver1.png"))) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ProgramadorDeTareas.ejecutaTareaCadaXTiempo(1, ProgramadorDeTareas.MINUTOS);
        HiloSync.ejecutaTareaCadaXTiempo();
    }//GEN-LAST:event_formWindowOpened


    /**
     * @param args the command line arguments
     */
  
   

    
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
       /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);

            }
        });
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addProduct;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem inventario;
    private javax.swing.JMenuItem itemAddColor;
    private javax.swing.JMenuItem itemCredit;
    private javax.swing.JMenuItem itemSale;
    private javax.swing.JMenuItem itemViewColor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuColors;
    private javax.swing.JMenu menuProduct;
    private javax.swing.JMenu menuSale;
    private javax.swing.JMenu menuUsers;
    private javax.swing.JMenuItem searchProduct;
    private javax.swing.JMenuItem updateProduct;
    // End of variables declaration//GEN-END:variables

 
  
}
