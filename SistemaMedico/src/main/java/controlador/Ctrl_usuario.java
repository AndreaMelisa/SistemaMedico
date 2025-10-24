package controlador;

import DAO.UsuarioDAO;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class Ctrl_usuario {

    private final UsuarioDAO usuarioDAO;

    public Ctrl_usuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticarUsuarioPorDni(String dni, String password) {
        if (dni == null || dni.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("DNI o contraseña no pueden estar vacíos");
        }

        Usuario usuario = usuarioDAO.obtenerUsuarioPorDni(dni);

        if (usuario == null || !usuarioDAO.verificarPassword(password, usuario.getContraUsuario())) {
            System.out.println("Credenciales inválidas o usuario inactivo");
            return null;
        }

        System.out.println("Bienvenido " + usuario.getNombreUsuario() + " " + usuario.getApellidoUsuario());
        return usuario;
    }
}
