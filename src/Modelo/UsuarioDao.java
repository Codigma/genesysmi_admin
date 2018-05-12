package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    public UsuarioVo getUsuario(Integer id) {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        UsuarioVo usuario = new UsuarioVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, first_name, last_name, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date "
                    + "FROM users "
                    + "WHERE id_user = ?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getInt(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return usuario;
    }
    
    public ArrayList<UsuarioVo> getUsuarios() {
        Conectarse conn = new Conectarse();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, first_name, last_name, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date "
                    + "FROM users");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getInt(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
                
                //Agregado del usuario al arreglo
                usuarios.add(usuario);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return usuarios;
    }
}
