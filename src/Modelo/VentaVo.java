/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luism
 */
public class VentaVo {
    private int id_sale;
    private int id_user;
    private double subtotal;
    private double ship;
    private double total;
    private String sales_years;

    public int getId_sale() {
        return id_sale;
    }

    public String getSales_years() {
        return sales_years;
    }

    public void setSales_years(String sales_years) {
        this.sales_years = sales_years;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getShip() {
        return ship;
    }

    public void setShip(double ship) {
        this.ship = ship;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

<<<<<<< HEAD

    
=======
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
>>>>>>> c73930c7fe62a76177a1f8737c26c233a485907b
}
