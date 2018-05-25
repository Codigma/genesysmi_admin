 package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectarse {
    private Connection conn = null;
    /*
    private final String host = "codigma.com.mx";
    private final String db = "codigmac_genesysmi";
    private final String user = "codigmac_codigma";
    private final String pass = "departamento03";
*/
    
        private final String host = "localhost";
    private final String db = "genesysmi";
    private final String user = "root";
    private final String pass = "";
    
    public Conectarse() {
        MySQLAccess();
    }
    
    private void MySQLAccess() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user,pass);
            // Check the state of connection
            if (conn!=null){
            System.out.println("Conexión exitosa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error en al conexión","ERROR",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);  
        }
    }

    public Connection getConn() {
        return conn;
    }
}
