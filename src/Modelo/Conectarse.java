package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectarse {
    private Connection conn = null;
    private final String host = "danielbenito.com";
    private final String db = "itlac_genesysmi";
    private final String user = "itlac_kevin";
    private final String pass = "1,FWwSff;}%0";

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
            System.out.println("Conexión a la base de datos "+db+" OK");
            }
        } catch (Exception e) {
            System.out.println("error en la conexión a la base de datos\n");
            System.out.println(e);  
        }
    }
}
