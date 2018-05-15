package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {
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
}