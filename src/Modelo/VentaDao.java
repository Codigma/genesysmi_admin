/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class VentaDao {
int aux=0;

    public int getLastId() {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        VentaVo venta = new VentaVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
  "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'genesysmi' AND TABLE_NAME = 'sales' ");

        
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                venta.setId_sale(resultSet.getInt(1));
            }
            //aux = venta.getId_sale();
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return venta.getId_sale();
    }
    
    
     public void InsertCompra(VentaVo venta){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO sales (id_user, subtotal, ship, total ) "                         
                    + "VALUES (?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
