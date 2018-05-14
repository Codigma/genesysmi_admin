package Controlador;

import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;

public class Coordinador {
    private Login login;
    
    
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
}
