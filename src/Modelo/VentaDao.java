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
                    "INSERT INTO sales (id_user, subtotal, ship, total, credito ) "                         
                    + "VALUES (?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            preparedStatement.setInt(5, 0);
            
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     

        public ArrayList<VentaVo> getYears() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> years = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
              "SELECT DISTINCT YEAR(date_sale_test) AS sales_year FROM sales_test");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo year = new VentaVo();
                year.setSales_years(resultSet.getString(1));
                
                years.add(year);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return years;
        
    }
        
        public ArrayList<VentaVo> getSales() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
              "SELECT sales.*,u.firstname,u.lastname "
            +"FROM sales "
            +"INNER JOIN users as u on u.id_user = sales.id_user "
            +"where credito = 0");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));
                
                
                
                
                sales.add(sale);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return sales;
        
    }
        
        public ArrayList<VentaVo> getSalesNoClient() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
              "SELECT * FROM sales "
            +"where credito = 0 and id_user = 0 ");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));

                sales.add(sale);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return sales;
        
    }
        
         public void InsertCompraCredito(VentaVo venta){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO sales (id_user, subtotal, ship, total, credito ) "                         
                    + "VALUES (?, ?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            preparedStatement.setInt(5, 1);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        }
         
         
          public ArrayList<VentaVo> getSalesCredit() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
              "SELECT sales.*,u.firstname,u.lastname "
            +"FROM sales "
            +"INNER JOIN users as u on u.id_user = sales.id_user "
            +"where credito = 1 and total>0");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));
                
                
                
                
                sales.add(sale);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return sales;
        
    }
}
