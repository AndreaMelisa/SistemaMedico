package controlador;

import DAO.UsuarioDAO;
import modelo.Usuario;


public class Ctrl_usuario {

    private final UsuarioDAO usuarioDAO;

    public Ctrl_usuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticarUsuario(String usuario, String password) {
        if (usuario == null || usuario.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Usuario o contraseña no pueden estar vacíos");
        }

        Usuario usuarioAutenticado = usuarioDAO.iniciarSesion(usuario, password);

        if (usuarioAutenticado == null) {
            System.out.println("Credenciales inválidas o usuario inactivo");
        } else {
            System.out.println("Bienvenido " + usuarioAutenticado.getNombreUsuario());
        }

        return usuarioAutenticado;
    }
}
