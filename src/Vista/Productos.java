package Vista;

import Controlador.Coordinador;
import Modelo.ColorVo;
import Modelo.ProductoVo;
import Modelo.SubcategoryVo;
import Modelo.TallaVo;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
=======
import javax.imageio.ImageIO;
>>>>>>> ec8fb6c62a6b522638d0ba472509b02bfbbceab5
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

public class Productos extends javax.swing.JFrame {

    private Coordinador miCoordinador;
    DefaultComboBoxModel modeloColor;
    DefaultComboBoxModel modeloSubcategory;
    DefaultComboBoxModel modeloTalla;

    private ArrayList<ColorVo> colores;
    private ProductoVo producto;
    private ArrayList<SubcategoryVo> subcategories;
    private ArrayList<TallaVo> tallas;

    private boolean isArt;
    private boolean isColor;
    private boolean isSize;

    private File src1File;
    private String src1Name;
    private String src2File;
    private String src2Name;
    private String src3File;
    private String src3Name;

    public Productos() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1280, 800);

        colores = new ArrayList<>();
        producto = new ProductoVo();
        subcategories = new ArrayList<>();
        tallas = new ArrayList<>();

        isArt = false;
        isColor = false;
        isSize = false;
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public void getColores() {
        colores = miCoordinador.buscarColores();
        this.SetColores(colores);
    }

    public void SetColores(ArrayList<ColorVo> colors) {
        for (int i = 0; i < colors.size(); i++) {
            modeloColor.addElement(" " + colors.get(i).getColor_art() + " - " + colors.get(i).getColor_name());
        }
        ColoriarComboBox();
    }

    public void ColoriarComboBox() {

        try {
            comboColor.setRenderer(new Coloriar<String>());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class Coloriar<String> extends JLabel implements ListCellRenderer {

        public Coloriar() {
            super();
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());

            Object texto = modeloColor.getElementAt(index);

            if (texto != null && index > 0) {
                Color color = Color.decode(colores.get(index - 1).getColor_hex_code());
                setBackground(Color.WHITE);
                setForeground(color);

                if (isSelected) {
                    setBackground(color);
                    setForeground(Color.WHITE);
                    txtBackColor.setBackground(color);
                }
            } else {
                setForeground(Color.BLACK);
            }
            return this;
        }
    }

    public void getDetallesProducto(String art) {
        ProductoVo product = miCoordinador.getDetallesProducto(art);
        if (product.getArt() != null) {
            producto = product;
            this.SetDetallesProducto(producto);
            isArt = true;
        } else {
            System.out.println("producto no encontrado");
        }
    }

    public void SetDetallesProducto(ProductoVo producto) {
        txtName.setText(producto.getArt_name());
        txtPrice.setText(producto.getPrice().toString());
        txtDescrip.setText(producto.getDescription());
        txtCompo.setText(producto.getComposition());
        comboCategory.setSelectedIndex(producto.getId_category());
        comboType.setSelectedIndex(producto.getId_type_product());
    }

    public void SetTallas() {
        Integer id_cat = producto.getId_category();
        Integer id_type = producto.getId_type_product();
        String color_art = producto.getColor_art();

        modeloTalla = new DefaultComboBoxModel();
        modeloTalla.addElement("Seleccionar...");

        producto.setId_size(null);

        if (id_cat != null && id_type != null && color_art != null) {
            tallas = miCoordinador.getTallas(id_cat, id_type);

            for (int i = 0; i < tallas.size(); i++) {
                modeloTalla.addElement(tallas.get(i).getSize_name());
            }
        }
        comboSize.setModel(modeloTalla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboCategory = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboSub = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescrip = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCompo = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        comboSize = new javax.swing.JComboBox<>();
        txtCant = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnImage1 = new javax.swing.JButton();
        checkSrc1 = new javax.swing.JCheckBox();
        btnImage2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        checkSrc2 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        btnImage3 = new javax.swing.JButton();
        checkSrc3 = new javax.swing.JCheckBox();
        txtBackColor = new javax.swing.JTextField();
        comboColor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Avenir", 1, 22)); // NOI18N
        jLabel3.setText("Agregar/Editar producto");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(242, 242, 242));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buacar producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 10), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Artículo:");

        txtCode.setBackground(new java.awt.Color(242, 242, 242));
        txtCode.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCode.setCaretColor(new java.awt.Color(51, 51, 51));
        txtCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(0, 37, 145));
        btnBuscar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(414, 414, 414))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(242, 242, 242));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 10), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Categoría:");

        comboCategory.setBackground(new java.awt.Color(237, 237, 237));
        comboCategory.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboCategory.setForeground(new java.awt.Color(51, 51, 51));
        comboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Recién nacido/Ellas", "Recién nacido/Ellos", "Baby/Ellas", "Baby/Ellos", "Mini/Ellas", "Mini/Ellos", "Junior/Ellas", "Junior/Ellos", "Accesorios y regalos" }));
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Subcategoría:");

        comboSub.setBackground(new java.awt.Color(237, 237, 237));
        comboSub.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboSub.setForeground(new java.awt.Color(51, 51, 51));
        comboSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo de producto:");

        comboType.setBackground(new java.awt.Color(237, 237, 237));
        comboType.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboType.setForeground(new java.awt.Color(51, 51, 51));
        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ropa", "Zapatos", "Otro" }));
        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });

        txtDescrip.setBackground(new java.awt.Color(242, 242, 242));
        txtDescrip.setColumns(20);
        txtDescrip.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtDescrip.setLineWrap(true);
        txtDescrip.setRows(5);
        txtDescrip.setWrapStyleWord(true);
        txtDescrip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDescrip.setCaretColor(new java.awt.Color(51, 51, 51));
        txtDescrip.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(txtDescrip);

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Descripción:");

        txtCompo.setBackground(new java.awt.Color(242, 242, 242));
        txtCompo.setColumns(20);
        txtCompo.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCompo.setLineWrap(true);
        txtCompo.setRows(5);
        txtCompo.setWrapStyleWord(true);
        txtCompo.setAutoscrolls(false);
        txtCompo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCompo.setCaretColor(new java.awt.Color(51, 51, 51));
        txtCompo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(txtCompo);

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Composición:");

        btnAdd.setBackground(new java.awt.Color(0, 37, 145));
        btnAdd.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(237, 237, 237));
        btnCancel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 37, 145));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Talla:");

        comboSize.setBackground(new java.awt.Color(237, 237, 237));
        comboSize.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboSize.setForeground(new java.awt.Color(51, 51, 51));
        comboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSizeActionPerformed(evt);
            }
        });

        txtCant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCant.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cantidad:");

        txtName.setBackground(new java.awt.Color(242, 242, 242));
        txtName.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.setCaretColor(new java.awt.Color(51, 51, 51));
        txtName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre:");

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Precio:");

        txtPrice.setBackground(new java.awt.Color(242, 242, 242));
        txtPrice.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrice.setCaretColor(new java.awt.Color(51, 51, 51));
        txtPrice.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(390, 390, 390))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(383, 383, 383))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSub, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(comboSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Color:");

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Imagen #1");

        btnImage1.setBackground(new java.awt.Color(237, 237, 237));
        btnImage1.setForeground(new java.awt.Color(51, 51, 51));
        btnImage1.setText("Examinar");
        btnImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage1ActionPerformed(evt);
            }
        });

        checkSrc1.setEnabled(false);

        btnImage2.setBackground(new java.awt.Color(237, 237, 237));
        btnImage2.setForeground(new java.awt.Color(51, 51, 51));
        btnImage2.setText("Examinar");
        btnImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage2ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Imagen #2");

        checkSrc2.setEnabled(false);

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Imagen #3");

        btnImage3.setBackground(new java.awt.Color(237, 237, 237));
        btnImage3.setForeground(new java.awt.Color(51, 51, 51));
        btnImage3.setText("Examinar");
        btnImage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage3ActionPerformed(evt);
            }
        });

        checkSrc3.setEnabled(false);

        txtBackColor.setEditable(false);
        txtBackColor.setAutoscrolls(false);
        txtBackColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboColor.setBackground(new java.awt.Color(237, 237, 237));
        comboColor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboColor.setForeground(new java.awt.Color(51, 51, 51));
        comboColor.setMaximumRowCount(12);
        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(565, 565, 565)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel15)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(btnImage1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(checkSrc1)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnImage2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(checkSrc2)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnImage3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(checkSrc3)
                                        .addGap(25, 25, 25)))))))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImage3)
                            .addComponent(btnImage2)
                            .addComponent(btnImage1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkSrc1)
                            .addComponent(checkSrc2)
                            .addComponent(checkSrc3))))
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       FTPUploader ftpUploader;
        // TODO add your handling code here:
        txtCode.setText(producto.getArt());

        producto.setArt_name(txtName.getText());
        producto.setComposition(txtCompo.getText());
        producto.setDescription(txtDescrip.getText());

        String textPrice = txtPrice.getText();
        if (!textPrice.equals("")) {
            producto.setPrice(Double.parseDouble(textPrice));
        } else {
            producto.setPrice(null);
        }

        String textCant = txtCant.getText();
        Integer amount = 0;
        if (!textCant.equals("")) {
            amount = Integer.parseInt(textCant);
        }

        //Aquí ocurre la magia
        if (producto.getArt() != null && !producto.getArt_name().equals("")
                && producto.getColor_art() != null && !producto.getComposition().equals("")
                && !producto.getDescription().equals("") && producto.getId_category() != null
                && producto.getId_size() != null && producto.getId_subcategory() != null
                && producto.getId_type_product() != null && producto.getPrice() != null
                && producto.getSrc1() != null && amount >= 0) {

            //Rutas para el src
            String category = comboCategory.getItemAt(comboCategory.getSelectedIndex());
            String subcategory = comboSub.getItemAt(comboSub.getSelectedIndex());
            String color = colores.get(comboColor.getSelectedIndex() - 1).getColor_name();

            String path = category + "/" + subcategory;
            String src = producto.getArt_name() + "-" + color + "-";
            
            

            if (src1File != null) {
<<<<<<< HEAD
                try {
                    ftpUploader = new FTPUploader("www.genesysmi.com", "genesysmi@genesysmi.com", "65i1r3WqQd",src1File.getPath(),src+src1File.getName(),"/img/products/" + path+"/");
                } catch (Exception ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
               // FTPClient cliente = new FTPClient("/img/products/" + path, src1File, src, true);
                //producto.setSrc1(path + "/" + src + src1Name);
=======
                FTPClient cliente = new FTPClient("/img/products/" + path, src1File, src, true);
                
                producto.setSrc1(path + "/" + src + src1Name);
>>>>>>> ec8fb6c62a6b522638d0ba472509b02bfbbceab5
            }
            if (src2File != null) {
                FTPClient cliente = new FTPClient("/img/products/" + path+"/", new File(src2File), src, true);
                producto.setSrc2(path + "/" + src + src2Name);
            }
            if (src3File != null) {
                FTPClient cliente = new FTPClient("/img/products/" + path, new File(src3File), src, true);
                producto.setSrc3(path + "/" + src + src3Name);
            }

            if (isArt) {
                miCoordinador.UpdateProductDetails(producto);
                if (isColor) {
                    miCoordinador.UpdateProduct(producto);
                    if (isSize) {
                        producto.setAmount(amount);
                        miCoordinador.UpdateProductSizes(producto);
                    } else {
                        producto.setAmount(amount);
                        miCoordinador.InsertProductSizes(producto);
                    }
                } else {
                    miCoordinador.InsertProduct(producto);
                    miCoordinador.InsertProductSizes(producto);
                }
            } else {
                miCoordinador.InsertProductDetails(producto);
                miCoordinador.InsertProduct(producto);
                miCoordinador.InsertProductSizes(producto);
            }

            txtCode.setText("");
            btnBuscar.doClick();

        } else {
            JOptionPane.showMessageDialog(null, "Completa todos los campos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String art = txtCode.getText();
        producto = new ProductoVo();

        modeloColor = new DefaultComboBoxModel();
        comboColor.setModel(modeloColor);
        modeloColor.addElement(" Seleccionar...");

        txtBackColor.setBackground(Color.WHITE);

        comboColor.setSelectedIndex(0);
        comboCategory.setSelectedIndex(0);
        comboType.setSelectedIndex(0);

        txtName.setText("");
        txtPrice.setText("");
        txtDescrip.setText("");
        txtCompo.setText("");

        isArt = false;
        isColor = false;
        isSize = false;

        if (!art.equals("")) {
            producto.setArt(art);

            this.getColores();
            this.getDetallesProducto(art);
        } else {
            producto.setArt(null);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        // TODO add your handling code here:
        Integer cat_index = comboCategory.getSelectedIndex();

        modeloSubcategory = new DefaultComboBoxModel();
        modeloSubcategory.addElement("Seleccionar...");

        Integer sub_index = 0;

        if (cat_index > 0) {
            producto.setId_category(cat_index);

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
        SetTallas();

        comboSub.setModel(modeloSubcategory);
        if (sub_index > 0) {
            comboSub.setSelectedIndex(sub_index + 1);
        } else {
            comboSub.setSelectedIndex(0);
        }
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void comboColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColorActionPerformed
        // TODO add your handling code here:
        isColor = false;
        int color_index = comboColor.getSelectedIndex();
        if (color_index > 0) {
            producto.setColor_art(colores.get(color_index - 1).getColor_art());

            ProductoVo product = miCoordinador.getSrcProducto(producto.getArt(), producto.getColor_art());

            producto.setSrc1(product.getSrc1());
            producto.setSrc2(product.getSrc2());
            producto.setSrc3(product.getSrc3());

            if (producto.getSrc1() != null) {

                isColor = true;

                checkSrc1.setSelected(true);
            } else {
                checkSrc1.setSelected(false);
            }
            if (producto.getSrc2() != null) {
                checkSrc2.setSelected(true);
            } else {
                checkSrc2.setSelected(false);
            }
            if (producto.getSrc3() != null) {
                checkSrc3.setSelected(true);
            } else {
                checkSrc3.setSelected(false);
            }
        } else {
            producto.setColor_art(null);
            producto.setSrc1(null);
            producto.setSrc2(null);
            producto.setSrc3(null);
            checkSrc1.setSelected(false);
            checkSrc2.setSelected(false);
            checkSrc3.setSelected(false);
        }
        SetTallas();
    }//GEN-LAST:event_comboColorActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
        // TODO add your handling code here:
        Integer type_index = comboType.getSelectedIndex();
        if (type_index > 0) {
            producto.setId_type_product(type_index);
        } else {
            producto.setId_type_product(null);
        }
        SetTallas();
    }//GEN-LAST:event_comboTypeActionPerformed

    private void comboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSizeActionPerformed
        // TODO add your handling code here:
        Integer size_index = comboSize.getSelectedIndex();
        if (size_index > 0) {
            producto.setId_size(tallas.get(size_index - 1).getId_size());

            ProductoVo product = miCoordinador.getAmountProducto(producto.getArt(), producto.getColor_art(), producto.getId_size());
            Integer amount = product.getAmount();
            if (amount != null) {
                producto.setAmount(amount);
                txtCant.setText(amount.toString());
                isSize = true;
            } else {
                isSize = false;
                txtCant.setText("0");
                producto.setAmount(null);
            }
        } else {
            producto.setId_size(null);
        }
    }//GEN-LAST:event_comboSizeActionPerformed

    private void comboSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubActionPerformed
        // TODO add your handling code here:
        Integer sub_index = comboSub.getSelectedIndex();
        if (sub_index > 0) {
            producto.setId_subcategory(subcategories.get(sub_index - 1).getId_subcategory());
        } else {
            producto.setId_subcategory(null);
        }
    }//GEN-LAST:event_comboSubActionPerformed

    private void btnImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage1ActionPerformed
        // TODO add your handling code here:
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            src1File = dir.getSelectedFile();
            String fileName = dir.getName(dir.getSelectedFile());

            src1Name = fileName;
            checkSrc1.setSelected(true);
        } else {
            checkSrc1.setSelected(false);
        }
    }//GEN-LAST:event_btnImage1ActionPerformed

    private void btnImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage2ActionPerformed
        // TODO add your handling code here:
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String file = dir.getSelectedFile().getPath();
            String fileName = dir.getName(dir.getSelectedFile());

            src2File = file;
            src2Name = fileName;
            checkSrc2.setSelected(true);
        } else {
            checkSrc2.setSelected(false);
        }
    }//GEN-LAST:event_btnImage2ActionPerformed

    private void btnImage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage3ActionPerformed
        // TODO add your handling code here:
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String file = dir.getSelectedFile().getPath();
            String fileName = dir.getName(dir.getSelectedFile());

            src3File = file;
            src3Name = fileName;
            checkSrc3.setSelected(true);
        } else {
            checkSrc3.setSelected(false);
        }
    }//GEN-LAST:event_btnImage3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImage1;
    private javax.swing.JButton btnImage2;
    private javax.swing.JButton btnImage3;
    private javax.swing.JCheckBox checkSrc1;
    private javax.swing.JCheckBox checkSrc2;
    private javax.swing.JCheckBox checkSrc3;
    private javax.swing.JComboBox<String> comboCategory;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboSize;
    private javax.swing.JComboBox<String> comboSub;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBackColor;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtCompo;
    private javax.swing.JTextArea txtDescrip;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
