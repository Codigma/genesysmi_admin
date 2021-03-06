package Controlador;
//
import Modelo.BagDao;
import Modelo.BagVo;
import Modelo.ProductoDao;
import Modelo.ProductoVo;
import Vista.Productos;
import Modelo.ColorDao;
import Modelo.ColorVo;
import Modelo.CreditoDao;
import Modelo.CreditoVo;
import Modelo.LocalDao;
import Modelo.LocalVo;
import Modelo.SubcategoryDao;
import Modelo.SubcategoryVo;
import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.TallaDao;
import Modelo.TallaVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Colores;
import Vista.DetalleVenta;
import Vista.Inicio;
import Vista.Usuarios;
import Vista.Ventas;
import java.util.ArrayList;
import Modelo.VentaDao;
import Modelo.VentaVo;
import Vista.Reportes;
import Vista.Total;
import Vista.VentaCredito;

public class Coordinador {
    
    private Login login;
    private Productos productos;
    private Colores color;
    private Inicio inicio;
    private Usuarios usuario;
    private Ventas venta;
    private DetalleVenta detalle;
    private Total total;
    private Reportes reporte;
    private VentaCredito credito;

    public VentaCredito getCredito() {
        return credito;
    }

    public void setCredito(VentaCredito credito) {
        this.credito = credito;
    }

    public Reportes getReporte() {
        return reporte;
    }

    public void setReporte(Reportes reporte) {
        this.reporte = reporte;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

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
    
 public ProductoVo getDetallesProductoColor(String art, String color){
        ProductoDao producto = new ProductoDao();
        return producto.getDetallesProductoColor(art,color);
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

    public DetalleVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleVenta detalle) {
        this.detalle = detalle;
    }
    
    public ArrayList<SubcategoryVo> getSubcategories(Integer id_category){
        SubcategoryDao subcategories = new SubcategoryDao();
        return subcategories.getSubcategories(id_category);
    }
    
    public ArrayList<TallaVo> getTallas(Integer id_category, Integer id_type_product){
        TallaDao tallas = new TallaDao();
        return tallas.getTallas(id_category, id_type_product);
    }
    
    public ProductoVo getAmountProducto(String art, String color_art, Integer id_size){
        ProductoDao producto = new ProductoDao();
        return producto.getAmountProducto(art, color_art, id_size);
    }
    
    public void InsertProductDetails(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.InsertProductDetails(producto);
    }
    
    public void UpdateProductDetails(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductDetails(producto);
    }
    
    public void InsertProduct(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.InsertProduct(producto);
    }
    
    public void UpdateProduct(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.UpdateProduct(producto);
    }
    
    public void InsertProductSizes(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.InsertProductSizes(producto);
    }
    
    public void UpdateProductSizes(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductSizes(producto);
    }
    
      public ArrayList<UsuarioVo> buscarUsuarios(){
    UsuarioDao usuarios = new UsuarioDao();
    return usuarios.getUsuarios();
    }
      
      public ArrayList<TallaVo> obtenerTallasProducto (String talla){
      TallaDao tall = new TallaDao();
      return tall.obtener_tallas(talla);
      
      }
      
      public ArrayList<ColorVo> obtenerColorProducto (String art, int talla){
ColorDao color = new ColorDao();
return color.getColorArt(art, talla);
      }
      
      public int obtenerSiguienteId(){
      VentaDao venta = new VentaDao();
      return venta.getLastId();
      }
      
         public void InsertBag(BagVo bag){
        BagDao dao = new BagDao();
        dao.InsertBag(bag); }
         
         public void InsertVenta(VentaVo venta){
         VentaDao dao = new VentaDao();
         dao.InsertCompra(venta);
         }
         
         
           public void UpdateProductSizesSales(ProductoVo producto){
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductSizesSale(producto);
    }
           
           
                 public void ActualizarMonedero(UsuarioVo usuario){
        UsuarioDao dao = new UsuarioDao();
        dao.UpdateMonedero(usuario);
    }
         public ArrayList<VentaVo> selectYears(){
                 VentaDao year = new VentaDao();
                 return year.getYears();
                     
                 }
         
    public ArrayList<VentaVo> obtenerVentas (){
VentaDao dao = new VentaDao();
return dao.getSales();
}

    public ArrayList<BagVo> obtenerProductosVenta(int id){
    BagDao dao = new BagDao();
    return dao.getProductsSale(id);
    }
    
    public void ingresarCredito(VentaVo credit){
    VentaDao compra = new VentaDao();
    compra.InsertCompraCredito(credit);
    }
    
    public ArrayList<VentaVo> ventasSinCliente(){
           VentaDao sincliente = new VentaDao();
           return sincliente.getSalesNoClient();
                     
                 }
    
    
    public ArrayList<VentaVo> ventasCredito(){
           VentaDao credito = new VentaDao();
    return credito.getSalesCredit();
                     
                 }
    
    public void pagarDeuda(VentaVo venta){
    VentaDao cred = new VentaDao();
    cred.UpdateDeuda(venta);
    }
    
       public ArrayList<LocalVo> obtenerLocales (){
LocalDao dao = new LocalDao();
return dao.getLocales();
}
       
       public ArrayList<ProductoVo> getProductoTienda(int local, String art){
       ProductoDao pro = new ProductoDao();
       return pro.getProductoTienda(local, art);
       
       }
       
       public ArrayList<ProductoVo> getProductoTiendaCategory(int local, int categoria, int subcategoria){
       ProductoDao pro = new ProductoDao();
       return pro.getProductoTiendaCategory(local, categoria, subcategoria);
                     }
       
       public ArrayList<ColorVo> getColorsArt (String art){
ColorDao dao = new ColorDao();
return dao.getColorsArt(art);
}
       
       public ArrayList<TallaVo> getTallasColor(String art, String color){
       TallaDao talla = new TallaDao();
       return talla.getTallasColor(art, color);
       }
       
       public ArrayList<VentaVo> getSalesOnline(){
       VentaDao vent = new VentaDao();
       return vent.getSalesOnline();
       }
       
       public ArrayList<BagVo> getProductsSaleOnline(int id){
    BagDao dao = new BagDao();
    return dao.getProductsSaleOnline(id);
    }
       
       public VentaVo getSalesOnlineId(int id){
       VentaDao vent = new VentaDao();
       return vent.getSalesOnlineId(id);
       }
       
       public ArrayList<UsuarioVo> getEstados(){
       UsuarioDao user = new UsuarioDao();
       return user.getEstados();
       }
       
        public ArrayList<UsuarioVo> getLocalidadesPorEstado(int id){
       UsuarioDao user = new UsuarioDao();
       return user.getLocalidadesPorEstado(id);
       
       
       }
        
         public void agregarUsuario(UsuarioVo usuario){
    UsuarioDao usu = new UsuarioDao();
    usu.agregarUsuario(usuario);
    }
         public ArrayList<UsuarioVo> getUsuariosBusqueda(String name){
       UsuarioDao user = new UsuarioDao();
       return user.getUsuariosBusqueda(name);
         }
         
         public ArrayList<VentaVo> salesCreditId(int id){
           VentaDao credi = new VentaDao();
    return credi.getSalesCreditId(id);
                     
                 }
}
