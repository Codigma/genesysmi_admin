package Controlador;

import Vista.Colores;
import Vista.DetalleVenta;
import Vista.Inicio;
import Vista.Login;
import Vista.Productos;
import Vista.Reportes;
import Vista.Total;
import Vista.Usuarios;
import Vista.Ventas;
import Vista.VentaCredito;


public class Principal {
    Coordinador miCoordinador;
    
    private void Iniciar(){
        /**Se instancian las clases*/
        Login login = new Login();
        Productos productos = new Productos();
        Usuarios usuario = new Usuarios();
        Ventas venta = new Ventas();
        DetalleVenta detalle = new DetalleVenta();
        Reportes reportes = new Reportes();
        VentaCredito credito = new VentaCredito();
        Total total = new Total();
        
        miCoordinador= new Coordinador();
        Colores color = new Colores();
        Inicio inicio = new Inicio();        

        
        /**Se establecen las relaciones entre clases*/
        
        login.setCoordinador(miCoordinador);
        productos.setCoordinador(miCoordinador);
        usuario.setCoordinador(miCoordinador);
        venta.setCoordinador(miCoordinador);
        detalle.setCoordinador(miCoordinador);
        reportes.setCoordinador(miCoordinador);
        total.setCoordinador(miCoordinador);
        credito.setCoordinador(miCoordinador);
        
        /*Se establecen relaciones con la clase coordinador*/
        miCoordinador.setLogin(login);
        miCoordinador.setColor(color);
        miCoordinador.setProductos(productos);
        miCoordinador.setDetalle(detalle);
        
        
     
        color.setCoordinador(miCoordinador);
        inicio.setCoordinador(miCoordinador);
        
        /*Se establecen relaciones con la clase coordinador*/
        miCoordinador.setLogin(login);
        miCoordinador.setColor(color);
        miCoordinador.setInicio(inicio);
        miCoordinador.setUsuario(usuario);
        miCoordinador.setVenta(venta);
        miCoordinador.setTotal(total);
        miCoordinador.setReporte(reportes);
        miCoordinador.setCredito(credito);
       inicio.setVisible(true);
      //  color.setVisible(true);
   // usuario.setVisible(true);
     //  detalle.setVisible(true);
       // productos.setVisible(true);
       // reportes.setVisible(true);
       // total.setVisible(true);
//inicio.setVisible(true);

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
