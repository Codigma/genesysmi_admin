/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class ColorDao {
    
    public ColorVo getColor(String id){
            Conectarse conn = new Conectarse();
  
            ColorVo color = new ColorVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT color_art,color_name,color_hex_code "
                    + "FROM colors "
                    + "WHERE color_art = ? ");

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                color.setColor_hex_code(resultSet.getString(3));
                
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return color;
    }
    
    
       public ArrayList<ColorVo> getColores() {
        Conectarse conn = new Conectarse();
        //Arreglo de Colores 
        ArrayList<ColorVo> colores = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT color_art,color_name,color_hex_code "
                    + "FROM colors " );
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto color
                ColorVo color = new ColorVo();
                
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                color.setColor_hex_code(resultSet.getString(3));
                
                
                //Agregado del color al arreglo
                colores.add(color);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return colores;
    }
}
