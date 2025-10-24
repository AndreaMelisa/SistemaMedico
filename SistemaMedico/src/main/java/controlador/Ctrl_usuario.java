package controlador;

import DAO.UsuarioDAO;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class Ctrl_usuario {

    private final UsuarioDAO usuarioDAO;

    public Ctrl_usuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario autenticarUsuario(String nombreUsuario, String password) {
        if (nombreUsuario == null || nombreUsuario.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Nombre de usuario o contraseña no pueden estar vacíos");
        }

        Usuario usuarioBD = usuarioDAO.obtenerUsuarioPorNombre(nombreUsuario);

        if (usuarioBD == null) {
            return null;
        }

        if (!BCrypt.checkpw(password, usuarioBD.getContraUsuario())) {
            return null;
        }

        if (!"Activo".equalsIgnoreCase(usuarioBD.getEstado())) {
            return null;
        }

        return usuarioBD;
    }
}
