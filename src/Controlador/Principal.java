package Controlador;

import Vista.Colores;
import Vista.Inicio;
import Vista.Login;
import Vista.Productos;

public class Principal {
    Coordinador miCoordinador;
    
    private void Iniciar(){
        /**Se instancian las clases*/
        Login login = new Login();
        Productos productos = new Productos();
        
        
<<<<<<< HEAD
        miCoordinador= new Coordinador();
=======
        Colores color = new Colores();
Inicio inicio = new Inicio();        
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
        
        /**Se establecen las relaciones entre clases*/
        
        login.setCoordinador(miCoordinador);
<<<<<<< HEAD
        productos.setCoordinador(miCoordinador);
        
        /*Se establecen relaciones con la clase coordinador*/
        miCoordinador.setLogin(login);
        miCoordinador.setProductos(productos);
        
        productos.setVisible(true);
=======
        color.setCoordinador(miCoordinador);
        inicio.setCoordinador(miCoordinador);
        
        /*Se establecen relaciones con la clase coordinador*/
        miCoordinador.setLogin(login);
        miCoordinador.setColor(color);
        miCoordinador.setInicio(inicio);
        
        login.setVisible(true);
       // inicio.setVisible(false);
       color.setVisible(true);
        
        
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.Iniciar();
            }
        });
    }
}
