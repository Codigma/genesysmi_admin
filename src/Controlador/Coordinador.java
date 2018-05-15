package Controlador;

import Modelo.ProductoDao;
import Modelo.ProductoVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Productos;

public class Coordinador {
    private Login login;
    private Productos productos;
    
    
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    
    public UsuarioVo buscarUsuario(Integer id_user) {
        UsuarioDao usuario = new UsuarioDao();
        return usuario.getUsuario(id_user);
    }
    
    public ProductoVo getDetallesProducto(String art){
        ProductoDao producto = new ProductoDao();
        return producto.getDetallesProducto(art);
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
