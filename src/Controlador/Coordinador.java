package Controlador;

import Modelo.ColorDao;
import Modelo.ColorVo;
import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Colores;
import Vista.Inicio;

public class Coordinador {
    
    private Login login;
    private Colores color;
    private Inicio inicio;

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
    
    public ColorVo buscarColor(String color_art){
    ColorDao dao = new ColorDao();
    return dao.getColor(color_art);
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
}
