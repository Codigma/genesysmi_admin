package Controlador;

<<<<<<< HEAD
import Modelo.ProductoDao;
import Modelo.ProductoVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Productos;
=======
import Modelo.ColorDao;
import Modelo.ColorVo;
import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Colores;
import Vista.Inicio;
<<<<<<< HEAD
import java.sql.Array;
import java.util.ArrayList;
=======
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
>>>>>>> a35f281bc25ce14b74dfdb5fca1bc771500c2561

public class Coordinador {
    
    private Login login;
<<<<<<< HEAD
    private Productos productos;
=======
    private Colores color;
    private Inicio inicio;
    

    public Inicio getInicio() {
        return inicio;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
    
    
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
<<<<<<< HEAD
=======
    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }
    
    
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
    
    public UsuarioVo buscarUsuario(Integer id_user) {
        UsuarioDao usuario = new UsuarioDao();
        return usuario.getUsuario(id_user);
    }
    
<<<<<<< HEAD
    public ProductoVo getDetallesProducto(String art){
        ProductoDao producto = new ProductoDao();
        return producto.getDetallesProducto(art);
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
=======
    public ColorVo buscarColor(String color_art){
    ColorDao dao = new ColorDao();
    return dao.getColor(color_art);    
    }
    
    public ArrayList<ColorVo> buscarColores(){
    ColorDao color = new ColorDao();
    return color.getColores();
    }
    
    
    public SystemVo buscarUser(String user,String password){
    SystemDao system = new SystemDao();
    return system.getUser(user, password);
        
    }
    
    public void mostrarColores(){
    getColor().setVisible(true);
    }
    
    public void mostrarPrincipal(){
    getInicio().setVisible(true);
    getLogin().dispose();
>>>>>>> fe44f12e9afc602f3a728d462431762e700846a1
    }
}
