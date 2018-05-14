package Vista;

import Controlador.Coordinador;
import Modelo.UsuarioVo;
import com.placeholder.PlaceHolder;

public class Login extends javax.swing.JFrame {
    
    private Coordinador miCoordinador;

    PlaceHolder hol;
    public Login() {
        initComponents();
        setLocationRelativeTo(null); 
        hol = new PlaceHolder(txtUser,"Ingresa tu Usuario");
        hol = new PlaceHolder(txtPass,"Ingresa tu Contraseña");
    }
    
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
        this.getUsuario(1);
    }
    
    public void getUsuario(Integer id_user){
        UsuarioVo usuario = miCoordinador.buscarUsuario(id_user);
        this.imprimirUsuario(usuario);
    }
    
    public void imprimirUsuario(UsuarioVo usuario){
        System.out.println(usuario.getFirstname());
        System.out.println(usuario.getLastname());
        System.out.println(usuario.getDirection());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jpTrasero = new javax.swing.JPanel();
        jpDelantero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnGo = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrador Login");
        setBackground(new java.awt.Color(51, 51, 51));
        setName("login"); // NOI18N
        setResizable(false);

        jpTrasero.setBackground(new java.awt.Color(237, 237, 237));
        jpTrasero.setForeground(java.awt.Color.gray);

        jpDelantero.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Contraseña");

        txtUser.setBackground(new java.awt.Color(242, 242, 242));
        txtUser.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtUser.setToolTipText("");
        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtUser.setCaretColor(new java.awt.Color(51, 51, 51));
        txtUser.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtUser.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        txtPass.setBackground(new java.awt.Color(242, 242, 242));
        txtPass.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtPass.setCaretColor(new java.awt.Color(51, 51, 51));
        txtPass.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        btnGo.setBackground(new java.awt.Color(0, 37, 145));
        btnGo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGo.setForeground(new java.awt.Color(255, 255, 255));
        btnGo.setText("Aceptar");

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setForeground(new java.awt.Color(0, 37, 145));
        btnCancel.setText("Cancelar");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Bienvenido al SPV");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO3.png"))); // NOI18N

        javax.swing.GroupLayout jpDelanteroLayout = new javax.swing.GroupLayout(jpDelantero);
        jpDelantero.setLayout(jpDelanteroLayout);
        jpDelanteroLayout.setHorizontalGroup(
            jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDelanteroLayout.createSequentialGroup()
                .addGroup(jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDelanteroLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDelanteroLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDelanteroLayout.createSequentialGroup()
                                .addGroup(jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpDelanteroLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDelanteroLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(19, 19, 19)
                                        .addComponent(txtPass)))
                                .addGap(8, 8, 8))
                            .addComponent(btnGo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDelanteroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(84, 84, 84))
            .addGroup(jpDelanteroLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDelanteroLayout.setVerticalGroup(
            jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDelanteroLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpDelanteroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnCancel)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpTraseroLayout = new javax.swing.GroupLayout(jpTrasero);
        jpTrasero.setLayout(jpTraseroLayout);
        jpTraseroLayout.setHorizontalGroup(
            jpTraseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTraseroLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jpDelantero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jpTraseroLayout.setVerticalGroup(
            jpTraseroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTraseroLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jpDelantero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTrasero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTrasero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpDelantero;
    private javax.swing.JPanel jpTrasero;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
