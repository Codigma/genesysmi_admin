package Controlador;

import Modelo.ProductoDao;
import Modelo.ProductoVo;
import Vista.Productos;
import Modelo.ColorDao;
import Modelo.ColorVo;
import Modelo.SubcategoryDao;
import Modelo.SubcategoryVo;
import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Colores;
import Vista.DetalleVenta;
import Vista.Inicio;
import Vista.Usuarios;
import Vista.Ventas;
import java.util.ArrayList;

public class Coordinador {
    
    private Login login;
    private Productos productos;
    private Colores color;
    private Inicio inicio;
    private Usuarios usuario;
    private Ventas venta;
    private DetalleVenta detalle;
    

    public Inicio getInicio() {
        return inicio;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }
    
    
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
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
    }
    
    public void agregarColor(ColorVo color){
    ColorDao cool = new ColorDao();
    cool.registrarColor(color);
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    
    public ProductoVo getSrcProducto(String art, String color_art){
        ProductoDao producto = new ProductoDao();
        return producto.getProducto(art, color_art);
    }
<<<<<<< HEAD

    public DetalleVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleVenta detalle) {
        this.detalle = detalle;
=======
    
    public ArrayList<SubcategoryVo> getSubcategories(Integer id_category){
        SubcategoryDao subcategories = new SubcategoryDao();
        return subcategories.getSubcategories(id_category);
>>>>>>> a9aa7bed18ab42c90ef29baa662c11f387040c07
    }
}
