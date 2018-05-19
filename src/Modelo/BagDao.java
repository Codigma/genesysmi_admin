/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class BagDao {
    
    
    public void InsertBag(BagVo bag){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO bag (id_user, art, art_name, color_art, color_name, "
                            + "id_size, size_name, price, quantity) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, bag.getId_user());
            preparedStatement.setString(2,bag.getArt());
            preparedStatement.setString(3, bag.getArt_name());
            preparedStatement.setString(4, bag.getColor_art());
            preparedStatement.setString(5, bag.getColor_name());
            preparedStatement.setInt(6, bag.getId_size());
            preparedStatement.setString(7, bag.getSize_name());
            
            
            preparedStatement.executeQuery();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
