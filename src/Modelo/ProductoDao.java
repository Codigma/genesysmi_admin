package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDao {
    Texto aux = new Texto();
    public ProductoVo getDetallesProducto(String art) {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        ProductoVo producto = new ProductoVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT pd.art, pd.name AS art_name, pd.price, pd.id_category, pd.id_subcategory, "
                            + "pd.description, pd.composition, pd.id_type_product, "
                            + "cat.name AS category_name, sub.name AS subcategory_name, "
                            + "tp.name AS type_product_name "
                    + "FROM product_details AS pd "
                    + "INNER JOIN categories AS cat ON cat.id_category = pd.id_category "
                    + "INNER JOIN subcategories AS sub ON sub.id_category = cat.id_category "
                    + "INNER JOIN type_product AS tp ON tp.id_type_product = pd.id_type_product "
                    + "WHERE pd.art = ?");

            preparedStatement.setString(1, art);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                producto.setArt(resultSet.getString(1));
                producto.setArt_name(resultSet.getString(2));
                producto.setPrice(resultSet.getDouble(3));
                producto.setId_category(resultSet.getInt(4));
                producto.setId_subcategory(resultSet.getInt(5));
                producto.setDescription(resultSet.getString(6));
                producto.setComposition(resultSet.getString(7));
                producto.setId_type_product(resultSet.getInt(8));
                producto.setCategory_name(resultSet.getString(9));
                producto.setSubcategory_name(resultSet.getString(10));
                producto.setType_product_name(resultSet.getString(11));
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return producto;
    }
    
    public ProductoVo getProducto(String art, String color_art) {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        ProductoVo producto = new ProductoVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT src1, src2, src3 "
                    + "FROM products "
                    + "WHERE art = ? AND color_art = ?");

            preparedStatement.setString(1, art);
            preparedStatement.setString(2, color_art);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                producto.setSrc1(resultSet.getString(1));
                producto.setSrc2(resultSet.getString(2));
                producto.setSrc3(resultSet.getString(3));
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return producto;
    }
    
    public ProductoVo getAmountProducto(String art, String color_art, Integer id_size) {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        ProductoVo producto = new ProductoVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT art, color_art, id_size, amount, id_local "
                    + "FROM product_sizes "
                    + "WHERE art = ? AND color_art = ? AND id_size = ?");

            preparedStatement.setString(1, art);
            preparedStatement.setString(2, color_art);
            preparedStatement.setInt(3, id_size);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                producto.setAmount(resultSet.getInt(4));
                producto.setId_local(resultSet.getInt(5));
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return producto;
    }
    
    public void InsertProductDetails(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO product_details (art, name, price, id_category, id_subcategory, "
                            + "description, composition, id_type_product) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getArt_name());
            preparedStatement.setDouble(3, producto.getPrice());
            preparedStatement.setInt(4, producto.getId_category());
            preparedStatement.setInt(5, producto.getId_subcategory());
            preparedStatement.setString(6, producto.getDescription());
            preparedStatement.setString(7, producto.getComposition());
            preparedStatement.setInt(8, producto.getId_type_product());
            
String consulta = "INSERT INTO product_details (art, name, price, id_category, id_subcategory, description, composition, id_type_product) VALUES ('"+producto.getArt()+"', '"+producto.getArt_name()+"', '"+producto.getPrice()+"', '"+producto.getId_category()+"', '"+producto.getId_subcategory()+"', '"+producto.getDescription()+"', '"+producto.getComposition()+"', '"+producto.getId_type_product()+"');";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateProductDetails(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE product_details SET art = ?, name = ?, price = ?, "
                            + "id_category = ?, id_subcategory = ?, "
                            + "description = ?, composition = ?, id_type_product = ? "
                    + "WHERE art = ?");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getArt_name());
            preparedStatement.setDouble(3, producto.getPrice());
            preparedStatement.setInt(4, producto.getId_category());
            preparedStatement.setInt(5, producto.getId_subcategory());
            preparedStatement.setString(6, producto.getDescription());
            preparedStatement.setString(7, producto.getComposition());
            preparedStatement.setInt(8, producto.getId_type_product());
            preparedStatement.setString(9, producto.getArt());
            
String consulta ="UPDATE product_details SET art = '"+producto.getArt()+"', name = '"+producto.getArt_name()+"', price = '"+producto.getPrice()+"', id_category = '"+producto.getId_category()+"', id_subcategory = '"+producto.getId_subcategory()+"', description = '"+producto.getDescription()+"', composition = '"+producto.getComposition()+"', id_type_product = '"+producto.getId_type_product()+"' WHERE art = '"+producto.getArt()+"';";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void InsertProduct(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO products (art, color_art, src1, src2, src3, src4, src5) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getColor_art());
            preparedStatement.setString(3, producto.getSrc1());
            preparedStatement.setString(4, producto.getSrc2());
            preparedStatement.setString(5, producto.getSrc3());
            preparedStatement.setString(6, null);
            preparedStatement.setString(7, null);
            
String consulta = "INSERT INTO products (art, color_art, src1, src2, src3, src4, src5) VALUES ('"+producto.getArt()+"', '"+producto.getColor_art()+"', '"+producto.getSrc1()+"', '"+producto.getSrc2()+"', '"+producto.getSrc3()+"', '"+null+"', '"+null+"');";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateProduct(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE products SET art = ?, color_art = ?, src1 = ?, "
                            + "src2 = ?, src3 = ? "
                    + "WHERE art = ? AND color_art = ?");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getColor_art());
            preparedStatement.setString(3, producto.getSrc1());
            preparedStatement.setString(4, producto.getSrc2());
            preparedStatement.setString(5, producto.getSrc3());
            preparedStatement.setString(6, producto.getArt());
            preparedStatement.setString(7, producto.getColor_art());
            
String consulta ="UPDATE products SET art = '"+producto.getArt()+"', color_art = '"+producto.getColor_art()+"', src1 = '"+producto.getSrc1()+"', src2 = '"+producto.getSrc2()+"', src3 = '"+producto.getSrc3()+"' WHERE art = '"+producto.getArt()+"' AND color_art = '"+producto.getColor_art()+"';";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void InsertProductSizes(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO product_sizes (art, color_art, id_size, amount, id_local) "
                    + "VALUES (?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getColor_art());
            preparedStatement.setInt(3, producto.getId_size());
            preparedStatement.setInt(4, producto.getAmount());
            preparedStatement.setInt(5, producto.getId_local());
            
String consulta = "INSERT INTO product_sizes (art, color_art, id_size, amount, id_local) VALUES ('"+producto.getArt()+"', '"+producto.getColor_art()+"', '"+producto.getId_size()+"', '"+producto.getAmount()+"', '"+producto.getId_local()+"');";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void UpdateProductSizes(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE product_sizes SET art = ?, color_art = ?, "
                            + "id_size = ?, amount= ?, id_local=? "
                    + "WHERE art = ? AND color_art = ? AND id_size = ?");
            
            preparedStatement.setString(1, producto.getArt());
            preparedStatement.setString(2, producto.getColor_art());
            preparedStatement.setInt(3, producto.getId_size());
            preparedStatement.setInt(4, producto.getAmount());
            preparedStatement.setInt(5, producto.getId_local());
            preparedStatement.setString(6, producto.getArt());
            preparedStatement.setString(7, producto.getColor_art());
            preparedStatement.setInt(8, producto.getId_size());
            
String consulta = "UPDATE product_sizes SET art = '"+producto.getArt()+"', color_art = '"+producto.getColor_art()+"', id_size = '"+producto.getId_size()+"', amount= '"+producto.getAmount()+"', id_local='"+producto.getId_local()+"' WHERE art = '"+producto.getArt()+"' AND color_art = '"+producto.getColor_art()+"' AND id_size = '"+producto.getId_size()+"';";
   aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void UpdateProductSizesSale(ProductoVo producto){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE product_sizes SET amount=amount-? "
                    + "WHERE art = ? AND color_art = ? AND id_size = ?");
            
            preparedStatement.setInt(1, producto.getAmount());
            preparedStatement.setString(2, producto.getArt());
            preparedStatement.setString(3, producto.getColor_art());
            preparedStatement.setInt(4, producto.getId_size());
            
String consulta = "UPDATE product_sizes SET amount=amount-'"+producto.getAmount()+"' WHERE art = '"+producto.getArt()+"' AND color_art = '"+producto.getColor_art()+"' AND id_size = '"+producto.getId_size()+"';";
            aux.escribir(consulta);
            preparedStatement.executeUpdate();
            
            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
   public ProductoVo getDetallesProductoColor(String art, String color) {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        ProductoVo producto = new ProductoVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
               "SELECT pd.art, pd.name AS art_name, pd.price, pd.id_category, pd.id_subcategory,"
            + " pd.description, pd.composition, pd.id_type_product, cat.name AS category_name, "
            + "sub.name AS subcategory_name, tp.name AS type_product_name, pr.src1 AS src1 "
            + "FROM product_details AS pd "
            + "INNER JOIN categories AS cat ON cat.id_category = pd.id_category"
            + " INNER JOIN subcategories AS sub ON sub.id_subcategory = pd.id_subcategory "
            + "INNER JOIN type_product AS tp ON tp.id_type_product = pd.id_type_product "
            + "INNER JOIN products as pr ON pr.art = pd.art "
            + "WHERE pd.art = ? AND pr.color_art = ? ");    

            preparedStatement.setString(1, art);
            preparedStatement.setString(2, color);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                producto.setArt(resultSet.getString(1));
                producto.setArt_name(resultSet.getString(2));
                producto.setPrice(resultSet.getDouble(3));
                producto.setId_category(resultSet.getInt(4));
                producto.setId_subcategory(resultSet.getInt(5));
                producto.setDescription(resultSet.getString(6));
                producto.setComposition(resultSet.getString(7));
                producto.setId_type_product(resultSet.getInt(8));
                producto.setCategory_name(resultSet.getString(9));
                producto.setSubcategory_name(resultSet.getString(10));
                producto.setType_product_name(resultSet.getString(11));
                producto.setSrc1(resultSet.getString(12));
                
                
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return producto;
    }  
   
   public ArrayList<ProductoVo> getProductoTienda(int local,String art) {
        ConecRemoto conn = new ConecRemoto();

        //Objeto de tipo Producto 
        ArrayList<ProductoVo> productos = new ArrayList<ProductoVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
"SELECT pz.art,pd.name, color.color_name, sz.name, pz.amount "
        + "FROM `product_sizes` as pz "
        + "INNER JOIN colors as color on color.color_art = pz.color_art "
        + "INNER JOIN sizes as sz on sz.id_size = pz.id_size "
        + "INNER JOIN product_details as pd on pd.art = pz.art "
        + "WHERE id_local = ? and pz.art = ? ");

            preparedStatement.setInt(1, local);
            preparedStatement.setString(2, art);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                ProductoVo product = new ProductoVo();
                
                product.setArt(resultSet.getString(1));
                product.setArt_name(resultSet.getString(2));
                product.setColor_name(resultSet.getString(3));
                product.setSize_name(resultSet.getString(4));
                product.setAmount(resultSet.getInt(5));
                
                productos.add(product);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        //Retorna el arreglo
        return productos;
    }
   
   public ArrayList<ProductoVo> getProductoTiendaCategory(int local,int id_categoria, int id_subcategoria) {
        ConecRemoto conn = new ConecRemoto();

        //Objeto de tipo Producto 
        ArrayList<ProductoVo> productos = new ArrayList<ProductoVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
"SELECT pz.art,pd.name, color.color_name, sz.name, pz.amount "
        + "FROM `product_sizes` as pz "
        + "INNER JOIN colors as color on color.color_art = pz.color_art "
        + "INNER JOIN sizes as sz on sz.id_size = pz.id_size "
        + "INNER JOIN product_details as pd on pd.art = pz.art "
        + "WHERE id_local = ? and pd.id_category = ? AND pd.id_subcategory=?");

            preparedStatement.setInt(1, local);
            preparedStatement.setInt(2, id_categoria);
            preparedStatement.setInt(3, id_subcategoria);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                ProductoVo product = new ProductoVo();
                
                product.setArt(resultSet.getString(1));
                product.setArt_name(resultSet.getString(2));
                product.setColor_name(resultSet.getString(3));
                product.setSize_name(resultSet.getString(4));
                product.setAmount(resultSet.getInt(5));
                
                productos.add(product);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        //Retorna el arreglo
        return productos;
    }
}
