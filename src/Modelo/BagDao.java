/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class BagDao {
Texto escrib = new Texto();    
    
    public void InsertBag(BagVo bag){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO bag (id_user, art, art_name, color_art, color_name, "
                            + "id_size, size_name, src, price, quantity, id_sale) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, bag.getId_user());
            preparedStatement.setString(2,bag.getArt());
            preparedStatement.setString(3, bag.getArt_name());
            preparedStatement.setString(4, bag.getColor_art());
            preparedStatement.setString(5, bag.getColor_name());
            preparedStatement.setInt(6, bag.getId_size());
            preparedStatement.setString(7, bag.getSize_name());
            preparedStatement.setString(8, bag.getSrc());
            preparedStatement.setDouble(9, bag.getPrice());
            preparedStatement.setInt(10, bag.getQuantity());
            preparedStatement.setInt(11, bag.getId_sale());
            
String consulta =" insert into bag (id_user, art, art_name, color_art, color_name, id_size, size_name, src, price, quantity, id_sale) VALUES ('"+bag.getId_user()+"','"+bag.getArt()+"' , '"+bag.getArt_name()+"', '"+bag.getColor_art()+"', '"+bag.getColor_name()+"', '"+bag.getId_size()+"', '"+bag.getSize_name()+"', '"+bag.getSrc()+"', '"+bag.getPrice()+"', '"+bag.getQuantity()+"', '"+bag.getId_sale()+"');";
            escrib.escribir(consulta);
            
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
       public ArrayList<BagVo> getProductsSale(int id) {
        Conectarse conn = new Conectarse();
        ArrayList<BagVo> listado = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
             "SELECT * FROM bag WHERE id_sale = ? ");

        preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                BagVo product = new BagVo();
                product.setId_bag(resultSet.getInt(1));
                product.setId_user(resultSet.getInt(2));
                product.setArt(resultSet.getString(3));
                product.setArt_name(resultSet.getString(4));
                product.setColor_art(resultSet.getString(5));
                product.setColor_name(resultSet.getString(6));
                product.setId_size(resultSet.getInt(7));
                product.setSize_name(resultSet.getString(8));
                product.setSrc(resultSet.getString(9));
                product.setPrice(resultSet.getDouble(10));
                product.setQuantity(resultSet.getInt(11));
                product.setId_sale(resultSet.getInt(12));
                
               
                listado.add(product);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return listado;
        
    }
}
