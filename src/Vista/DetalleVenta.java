/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;



import Controlador.Coordinador;
import Modelo.BagDao;
import Modelo.BagVo;
import Modelo.ColorVo;
import Modelo.CreditoVo;
import Modelo.ProductoVo;
import Modelo.TallaVo;
import Modelo.VentaVo;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author bryan
 */
public class DetalleVenta extends javax.swing.JInternalFrame {
    
    
    
Date date = new Date();
DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm ");
    
DefaultTableModel modelo = new DefaultTableModel();
  String[] columnas = {"Codigo","Articulo","Color","Talla","Precio Unitario","Cantidad","Importe"};
  
    private Coordinador miCoordinador;
    
    public static ArrayList<BagVo> bag = new ArrayList<BagVo>();
    
    public int id_usuario;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
            asignarTamaño();
txtCode.requestFocus();
    }
   
    public void asignarTamaño(){
    tbVenta.getColumnModel().getColumn(0).setPreferredWidth(10);
    tbVenta.getColumnModel().getColumn(1).setPreferredWidth(250);
    tbVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
    tbVenta.getColumnModel().getColumn(3).setPreferredWidth(50);
    tbVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
    tbVenta.getColumnModel().getColumn(5).setPreferredWidth(20);
    tbVenta.getColumnModel().getColumn(6).setPreferredWidth(50);
    
    }
    
    public DetalleVenta() {
        
        initComponents();
        txtFecha.setText(hourdateFormat.format(date));
        modelo.setColumnIdentifiers(columnas);
        tbVenta.setModel(modelo);
        
        }
    
    public static void main(String wil[]){
        new DetalleVenta();
    

       

    }

        
   public void limpiarCamposProducto(){
   txtCode.setText("");
   lblArt.setText("");
   lblColor.setText("");
   lblTalla.setText("");
   lblPrecio.setText("");
   }
   
       
   public void limpiarCamposVenta(){
 txtVendedor.setText("");
 txtCliente.setText("");
 txtDireccion.setText("");
 txtMonedero.setText("");
   }
   
   public void agregarProducto(){
    

      //Ciclo para llenar tabla de productos
      for (int i =0; i<bag.size();i++){
       modelo.addRow(new Object[] {bag.get(i).getArt(),bag.get(i).getArt_name(),bag.get(i).getColor_name(),
       bag.get(i).getSize_name(),bag.get(i).getPrice(),bag.get(i).getQuantity(),bag.get(i).getImporte()
        });
      }
      //Asignamos los datos del Modelo a la tabla
      tbVenta.setModel(modelo);
   }
   
   private void limpiarTable(){
while(modelo.getRowCount()>0){
modelo.removeRow(0);
}
}
   
   
   public double calcularImporte(int cantidad,double precio){
   
   
   double importe =0;
   double cant = (double) cantidad;
   importe = cant * precio;
   
   return importe;
   }
   
   
   public void calcularTotal(){
   double total =0;
       for(int i =0 ; i<tbVenta.getRowCount();i++){
   total += (double) tbVenta.getValueAt(i, 6); 
   }
       lblTotal.setText(Double.toString(total));
   }
   
   public int codigoArt(String art){
   String codigo = art.trim();
   int cadena=0;
   if(codigo.length()>5){
   cadena = Integer.parseInt(codigo.substring(2, 7));
   }
   else if(codigo.length()==5){
   cadena = Integer.parseInt(codigo);
   }
   System.out.print(cadena);
   return cadena;
   }
   
   public String codigoArtCadena(String art){
   String codigo = art.trim();
   String cadena="";
   if(codigo.length()>5){
   cadena = codigo.substring(2, 7);
   }
   else if(codigo.length()==5){
   cadena = codigo;
   }
   System.out.print(cadena);
   return cadena;
   }
   
   public double dineroElectronicoVenta(){
   Double obtenido=0.0;
   Double total = Double.parseDouble(lblTotal.getText());
   Double porcen = Double.parseDouble(txtPorcen.getText());
       if(porcen <= 100){
   obtenido = (total * porcen)/100;
   
   }else{
        JOptionPane.showMessageDialog(null, "Ingrese un  porcentaje valido", "Dinero Electronico", JOptionPane.WARNING_MESSAGE);
       }
       System.out.print(obtenido);
       return obtenido;
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMonedero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtVendedor = new javax.swing.JTextField();
        txtPorcen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblArt = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnDescuento = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        lblTalla = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnCredit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(856, 514));

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbVenta.setFont(new java.awt.Font("GT Walsheim Regular", 0, 11)); // NOI18N
        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Articulo", "Color", "Talla", "Precio Unitario", "Cantidad", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVenta.setRowHeight(30);
        tbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVentaMouseClicked(evt);
            }
        });
        tbVenta.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbVentaInputMethodTextChanged(evt);
            }
        });
        tbVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbVentaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("GT Walsheim Bold", 0, 36)); // NOI18N
        jLabel1.setText("Total $");

        jLabel5.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        jLabel5.setText("IVA");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Vendedor:");

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fecha:");

        txtFecha.setBackground(new java.awt.Color(242, 242, 242));
        txtFecha.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Cliente:");

        jLabel15.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Dirección:");

        txtCliente.setBackground(new java.awt.Color(242, 242, 242));
        txtCliente.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDireccion.setBackground(new java.awt.Color(242, 242, 242));
        txtDireccion.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Monedero:");

        txtMonedero.setEditable(false);
        txtMonedero.setBackground(new java.awt.Color(242, 242, 242));
        txtMonedero.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtMonedero.setText("0.0");
        txtMonedero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconDollar.png"))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(41, 128, 185));
        btnBuscar.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtVendedor.setBackground(new java.awt.Color(242, 242, 242));
        txtVendedor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPorcen.setBackground(new java.awt.Color(242, 242, 242));
        txtPorcen.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtPorcen.setText("0");
        txtPorcen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPorcen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcenActionPerformed(evt);
            }
        });
        txtPorcen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcenKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Porcentaje:");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconPercentage.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPorcen)
                    .addComponent(txtMonedero, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(153, 153, 153))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txtVendedor)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonedero)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPorcen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap())))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("GT Walsheim Regular", 0, 14)); // NOI18N
        jLabel4.setText("Comentarios");

        jTextField2.setBackground(new java.awt.Color(242, 242, 242));
        jTextField2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(242, 242, 242));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Codigo:");

        txtCode.setBackground(new java.awt.Color(242, 242, 242));
        txtCode.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconSearch.png"))); // NOI18N
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Articulo:");

        lblArt.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblArt.setForeground(new java.awt.Color(255, 51, 51));

        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Precio  $");

        lblPrecio.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 51, 51));

        jButton3.setBackground(new java.awt.Color(192, 57, 43));
        jButton3.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDescuento.setBackground(new java.awt.Color(211, 84, 0));
        btnDescuento.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        btnDescuento.setForeground(new java.awt.Color(255, 255, 255));
        btnDescuento.setText("Descuento");
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });

        btnPagar.setBackground(new java.awt.Color(39, 174, 96));
        btnPagar.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Color:");

        lblColor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblColor.setForeground(new java.awt.Color(255, 51, 51));

        lblTalla.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblTalla.setForeground(new java.awt.Color(255, 51, 51));

        jLabel21.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Talla:");

        jButton2.setBackground(new java.awt.Color(41, 128, 185));
        jButton2.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnCredit.setBackground(new java.awt.Color(39, 174, 96));
        btnCredit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCredit.setForeground(new java.awt.Color(255, 255, 255));
        btnCredit.setText("Crédito");
        btnCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBuscar))
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        jLabel6.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel6.setText("Detalle de venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(555, 555, 555)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String codigo = txtCode.getText();
codigo = codigo.replaceAll(" ", "");
        if(codigo.length()==0){
         JOptionPane.showMessageDialog(null, "Ingrese un articulo valido", "Venta", JOptionPane.WARNING_MESSAGE);
        }
        else{
        limpiarCamposProducto();
limpiarTable();
agregarProducto();
calcularTotal();
//calcularImporte();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int seleccion = tbVenta.getSelectedRow();
        bag.remove(seleccion);
limpiarTable();
agregarProducto();
calcularTotal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
      if(txtCode.getText().trim().equals("")){
      JOptionPane.showMessageDialog(null,"Ingrese un codigo válido","ERROR",JOptionPane.INFORMATION_MESSAGE);
      }
      else{ 
          
          
        BagVo bagg = new BagVo();
       ArrayList<TallaVo> medida = miCoordinador.obtenerTallasProducto(codigoArt(txtCode.getText()));
       String [] medidas = new String[medida.size()];
       
       for(int i =0 ; i<medida.size();i++){
       medidas[i]=(medida.get(i).getSize_name());
       }
       
     String resp = (String) JOptionPane.showInputDialog(null, "Seleccione la talla disponible", "Talla", JOptionPane.DEFAULT_OPTION, null, medidas, "Selecciona");
     int auxtalla=0;
     for(int i =0 ; i<medida.size();i++){
       if(medidas[i]==resp){
       auxtalla= medida.get(i).getId_size();
       }
         
       }
     
     ProductoVo product = miCoordinador.getDetallesProducto(codigoArtCadena(txtCode.getText()));
     ArrayList <ColorVo> color = miCoordinador.obtenerColorProducto(codigoArtCadena(txtCode.getText()), auxtalla);
     String [] colores = new String[color.size()];
     
      for(int i =0 ; i<color.size();i++){
       colores[i]=(color.get(i).getColor_name());
       }
       
     String resp1 = (String) JOptionPane.showInputDialog(null, "Seleccione un color disponible", "Color", JOptionPane.DEFAULT_OPTION, null, colores, "Selecciona");
     String auxcolor=""; 
     for(int i =0 ; i<color.size();i++){
       if(colores[i]==resp1){
       auxcolor= color.get(i).getColor_art();
       }
         
       }
     
   
    
   String cantidades = (String) JOptionPane.showInputDialog(null, "Seleccione la cantidad del articulo",
  "Cantidad", JOptionPane.YES_NO_CANCEL_OPTION, null, new String [] {"1","2","3","4","5","6","7","8","9","10"}, "1");

  
  
     lblArt.setText(product.getArt_name());
     lblColor.setText(resp1);
     lblTalla.setText(resp);
     lblPrecio.setText(Double.toString(product.getPrice()));
     
     bagg.setId_user(id_usuario);
     bagg.setArt(codigoArtCadena(txtCode.getText()));
     bagg.setArt_name(product.getArt_name());
     bagg.setColor_art(auxcolor);
     bagg.setColor_name(resp1);
     bagg.setId_size(auxtalla);
     bagg.setSize_name(resp);
     bagg.setPrice(product.getPrice());
     bagg.setQuantity(Integer.parseInt(cantidades.trim()));
     bagg.setImporte(calcularImporte(Integer.parseInt(cantidades.trim()),product.getPrice()));
     bagg.setId_sale(miCoordinador.obtenerSiguienteId());
     
     
     
     
     
     bag.add(bagg);
     
      }
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBuscarMousePressed

    private void tbVentaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbVentaInputMethodTextChanged
   
    }//GEN-LAST:event_tbVentaInputMethodTextChanged

    private void tbVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbVentaKeyTyped
  
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVentaKeyTyped

    private void tbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentaMouseClicked
    
    }//GEN-LAST:event_tbVentaMouseClicked

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed

        int seleccion = tbVenta.getSelectedRow();
        
        if(seleccion >=0 ){
        String descuento;
    descuento = JOptionPane.showInputDialog(null, "Registre el nuevo costo");
    
    bag.get(seleccion).setImporte(Double.valueOf(descuento));
    
    limpiarTable();
    agregarProducto();
    calcularTotal();
        }
        else{
        JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla");
    }
 


       
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

BagVo aux = new BagVo();
        for (int t = 0; t < bag.size(); t++){
        aux.setId_user(bag.get(t).getId_user());
        aux.setArt(bag.get(t).getArt());
        aux.setArt_name(bag.get(t).getArt_name());
        aux.setColor_art(bag.get(t).getColor_art());
        aux.setColor_name(bag.get(t).getColor_name());
        aux.setId_size(bag.get(t).getId_size());
        aux.setSize_name(bag.get(t).getSize_name());
        aux.setPrice(bag.get(t).getPrice());
        aux.setQuantity(bag.get(t).getQuantity());
        aux.setId_sale(bag.get(t).getId_sale());
      //   miCoordinador.InsertBag(aux);
        }

        
ArrayList<ProductoVo> registro = new ArrayList<>();  


for(int c = 0; c <bag.size();c++){
ProductoVo aux1 = new ProductoVo();

aux1.setAmount(bag.get(c).getQuantity());
aux1.setArt(bag.get(c).getArt());
aux1.setColor_art(bag.get(c).getColor_art());
aux1.setId_size(bag.get(c).getId_size());

registro.add(aux1);
 
}
        
 
if(id_usuario != 0){
miCoordinador.getTotal().dineroelectronico = dineroElectronicoVenta();
} 
  
        
miCoordinador.getTotal().bolsa = (ArrayList) bag.clone();
miCoordinador.getTotal().product =  (ArrayList) registro.clone();
miCoordinador.getTotal().lblCliente.setText(txtCliente.getText());
miCoordinador.getTotal().lblVendedor.setText(txtVendedor.getText());
miCoordinador.getTotal().lblPagar.setText(lblTotal.getText());
miCoordinador.getTotal().lblDinero.setText(txtMonedero.getText());
miCoordinador.getTotal().comprador.setId_user(id_usuario);
miCoordinador.getTotal().venta.setId_user(id_usuario);

 


        miCoordinador.getTotal().setVisible(true);     
miCoordinador.getTotal().venta.setSubtotal(Double.parseDouble(lblTotal.getText()));


limpiarTable();
limpiarCamposVenta();
lblTotal.setText("0.00");
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditActionPerformed
VentaVo credito = new VentaVo();

        BagVo aux = new BagVo();
        for (int t = 0; t < bag.size(); t++){
        aux.setId_user(bag.get(t).getId_user());
        aux.setArt(bag.get(t).getArt());
        aux.setArt_name(bag.get(t).getArt_name());
        aux.setColor_art(bag.get(t).getColor_art());
        aux.setColor_name(bag.get(t).getColor_name());
        aux.setId_size(bag.get(t).getId_size());
        aux.setSize_name(bag.get(t).getSize_name());
        aux.setPrice(bag.get(t).getPrice());
        aux.setQuantity(bag.get(t).getQuantity());
        aux.setId_sale(bag.get(t).getId_sale());
        miCoordinador.InsertBag(aux);
        }

        
ArrayList<ProductoVo> registro = new ArrayList<>();  


for(int c = 0; c <bag.size();c++){
ProductoVo aux1 = new ProductoVo();

aux1.setAmount(bag.get(c).getQuantity());
aux1.setArt(bag.get(c).getArt());
aux1.setColor_art(bag.get(c).getColor_art());
aux1.setId_size(bag.get(c).getId_size());

registro.add(aux1);
 
}

        int confirmado = JOptionPane.showConfirmDialog(null,
   "Su pago total es de:"+" "+lblTotal.getText()+ " " + "¿Desea dar un adelanto?");
        
switch(confirmado){
    case 0:
    String adelanto = JOptionPane.showInputDialog(null,"Adelanto $$",JOptionPane.QUESTION_MESSAGE);    
    
    if(Double.parseDouble(lblTotal.getText()) >= Double.parseDouble(adelanto)){
    double total = Double.parseDouble(lblTotal.getText()) - Double.parseDouble(adelanto);
    
    
    credito.setId_user(id_usuario);
    credito.setSubtotal(Double.parseDouble(lblTotal.getText()));
    credito.setShip(0);
    credito.setTotal(total);
    credito.setCredito(1);
    
    if(credito.getId_user()!=0){
    miCoordinador.ingresarCredito(credito);
      
    for(int v = 0; v < registro.size(); v++){
        miCoordinador.UpdateProductSizesSales(registro.get(v));
        }
    JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
    
    
   limpiarTable();
limpiarCamposVenta();
lblTotal.setText("0.00");

    }
    else{
    JOptionPane.showMessageDialog(null, "Seleccione un usuario válido"); 
    }
     
    }
    
    else{
    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida, menor al total");
    }
    
           

   break;
   
    case 1:
   
   credito.setId_user(id_usuario);
    credito.setSubtotal(Double.parseDouble(lblTotal.getText()));
    credito.setShip(0);
    credito.setTotal(Double.parseDouble(lblTotal.getText()));
    credito.setCredito(1);
    
    if(credito.getId_user()!=0){
    miCoordinador.ingresarCredito(credito);
    for(int v = 0; v < registro.size(); v++){
        miCoordinador.UpdateProductSizesSales(registro.get(v));
        }
    JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
    
    
     limpiarTable();
limpiarCamposVenta();
lblTotal.setText("0.00");
    }
    else{
    JOptionPane.showMessageDialog(null, "Seleccione un usuario válido"); 
    }
   
    
     
    
break;
    case 2:
        System.out.println("Cancelado");
        break;
}    
 
    }//GEN-LAST:event_btnCreditActionPerformed

    private void txtPorcenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcenKeyTyped
        char c=evt.getKeyChar();

        if(Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if(txtPorcen.getText().length()>=3){
            getToolkit().beep();

            evt.consume();

        }

        // &&
    }//GEN-LAST:event_txtPorcenKeyTyped

    private void txtPorcenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcenActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        miCoordinador.getUsuario().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed
   
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCredit;
    private javax.swing.JButton btnDescuento;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTalla;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbVenta;
    public javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCode;
    public javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtMonedero;
    private javax.swing.JTextField txtPorcen;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
