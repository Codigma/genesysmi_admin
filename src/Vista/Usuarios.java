/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.ColorVo;
import Modelo.ProductoVo;
import Modelo.TallaVo;
import Modelo.UsuarioVo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.DetalleVenta;

/**
 *
 * @author luism
 */
public class Usuarios extends javax.swing.JInternalFrame {
  private Coordinador miCoordinador;
  DefaultTableModel modelo = new DefaultTableModel(){
  public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
  };
      String[] columnas = {"ID","Nombre(s)","Apellidos","Email","Estado","Localidad","Codigo Postal","Direccion","Telefono","RFC","Registro","Dinero"};
     
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
asignarTamaño();
        imprimirUsuarios();

        
    }
    /**
     * Create new form Usuarios
     */
    public Usuarios() {
        initComponents();
       // setLocationRelativeTo(null);        // Centering on screen...
       // setSize(1300, 800); 
          modelo.setColumnIdentifiers(columnas);
        tbUsers.setModel(modelo);
        
    }

    public void imprimirUsuarios(){
      modelo.setColumnIdentifiers(columnas);
      asignarTamaño(); 
      ArrayList<UsuarioVo> user = miCoordinador.buscarUsuarios();
      

      
      
      for (int i =0; i<user.size();i++){
       modelo.addRow(new Object[] {user.get(i).getId_user(),user.get(i).getFirstname(),user.get(i).getLastname(),user.get(i).getEmail(),
       user.get(i).getEstado(),user.get(i).getLocalidad(),user.get(i).getCp(),user.get(i).getDirection(),
       user.get(i).getPhone(),user.get(i).getRfc(),user.get(i).getRegister_date(),user.get(i).getMoney()});
      }
      //Asignamos los datos del Modelo a la tabla
      tbUsers.setModel(modelo);
    }
    
      public void asignarTamaño(){
    tbUsers.getColumnModel().getColumn(0).setPreferredWidth(50);
    tbUsers.getColumnModel().getColumn(1).setPreferredWidth(150);
    tbUsers.getColumnModel().getColumn(2).setPreferredWidth(150);
    tbUsers.getColumnModel().getColumn(3).setPreferredWidth(200);
    tbUsers.getColumnModel().getColumn(4).setPreferredWidth(120);
    tbUsers.getColumnModel().getColumn(5).setPreferredWidth(120);
    tbUsers.getColumnModel().getColumn(6).setPreferredWidth(60);
    tbUsers.getColumnModel().getColumn(7).setPreferredWidth(200);
    tbUsers.getColumnModel().getColumn(8).setPreferredWidth(100);
    tbUsers.getColumnModel().getColumn(9).setPreferredWidth(130);
    tbUsers.getColumnModel().getColumn(10).setPreferredWidth(150);
    tbUsers.getColumnModel().getColumn(11).setPreferredWidth(80);
    
    
    
   
    
    }
    
         private void limpiarTable(){
while(modelo.getRowCount()>0){
modelo.removeRow(0);
}
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnGenerate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSearch1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        tbUsers.setBackground(new java.awt.Color(237, 237, 237));
        tbUsers.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre(s)", "Apellidos", "Email", "País", "Estado", "Localidad", "Código Postal", "Dirección", "Teléfono", "RFC", "Fecha de registro"
            }
        ));
        tbUsers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbUsers.setGridColor(new java.awt.Color(255, 255, 255));
        tbUsers.setRowHeight(20);
        tbUsers.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbUsers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsers);

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Buscar por ID:");

        txtSearch.setBackground(new java.awt.Color(242, 242, 242));
        txtSearch.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.setCaretColor(new java.awt.Color(51, 51, 51));
        txtSearch.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        btnGenerate.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Generar");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 37, 145));
        btnSearch.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel2.setText("Usuarios registrados");

        txtSearch1.setBackground(new java.awt.Color(242, 242, 242));
        txtSearch1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch1.setCaretColor(new java.awt.Color(51, 51, 51));
        txtSearch1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearch1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Buscar por nombre:");

        btnSearch1.setBackground(new java.awt.Color(0, 37, 145));
        btnSearch1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setText("Buscar");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
limpiarTable();
//        int aux = Integer.parseInt(txtSearch.getText());
        String name = txtSearch1.getText().trim();
        
        modelo.setColumnIdentifiers(columnas);
        
        if(!name.isEmpty()){
            ArrayList<UsuarioVo> users = miCoordinador.getUsuariosBusqueda(name);
        for(int i=0;i<users.size();i++){
        modelo.addRow(new Object[]{users.get(i).getId_user(),users.get(i).getFirstname(),users.get(i).getLastname(),users.get(i).getEmail(),
          users.get(i).getEstado(),users.get(i).getLocalidad(),users.get(i).getCp(),users.get(i).getDirection(),users.get(i).getPhone(),users.get(i).getRfc(),users.get(i).getRegister_date(),users.get(i).getMoney()});
        }
        asignarTamaño();
      tbUsers.setModel(modelo);
        }
        else{
        JOptionPane.showMessageDialog(null, "No se encontró ningún resultado");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
     int fila = tbUsers.getSelectedRow();
      //DetalleVenta venta = new DetalleVenta(); 

               if ((fila > -1)){
          int id = (int) tbUsers.getValueAt(fila, 0);
                   String cliente = (String) modelo.getValueAt(fila, 1) + " " + (String)(String) modelo.getValueAt(fila, 2) ;
          String direccion = (String)modelo.getValueAt(fila, 7);
          double electronico = (double)modelo.getValueAt(fila, 11);
             miCoordinador.getDetalle().id_usuario = id;
             
             miCoordinador.getDetalle().txtCliente.setText(cliente);
             miCoordinador.getDetalle().txtDireccion.setText(direccion);
             miCoordinador.getDetalle().txtMonedero.setText(Double.toString(electronico));
             miCoordinador.getDetalle().btnCredit.setEnabled(true);
             
             
            
             
          
          
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsersMouseClicked

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
limpiarTable();        
imprimirUsuarios();
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
  char c=evt.getKeyChar();
   int ascii = (int)c;
        if(ascii<48 || ascii>57) {
            getToolkit().beep();

            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyTyped

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
limpiarTable();
        int aux = Integer.parseInt(txtSearch.getText());
        //String name = txtSearch1.getText().trim();
        
        modelo.setColumnIdentifiers(columnas);
        
        
        if(aux > 0){
                    UsuarioVo user = miCoordinador.buscarUsuario(aux);

            modelo.addRow(new Object[] {user.getId_user(),user.getFirstname(),user.getLastname(),user.getEmail(),
          user.getEstado(),user.getLocalidad(),user.getCp(),user.getDirection(),user.getPhone(),user.getRfc(),user.getRegister_date(),user.getMoney()});
      asignarTamaño();
      tbUsers.setModel(modelo);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "No se encontró ningún resultado");
            System.out.print("Vacío");
        }
      
         // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbUsers;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
