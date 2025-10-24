package DAO;

import modelo.ConexionBD;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM tb_usuarios WHERE nombre_usuario = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setCorreoUsuario(rs.getString("correo_usuario"));
<<<<<<< HEAD
                usuario.setDniUsuario(rs.getString("dni_usuario")); // Nuevo campo
=======
>>>>>>> c23387e9d63452cfbb49a3c62e0c115b5dd1710f
                usuario.setContraUsuario(rs.getString("contra_usuario"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
        }

        return usuario;
    }

    public boolean verificarPassword(String passwordIngresada, String passwordHasheada) {
        return BCrypt.checkpw(passwordIngresada, passwordHasheada);
    }

    public boolean registrarUsuario(Usuario usuario, String passwordPlano) {
<<<<<<< HEAD
        String sql = "INSERT INTO tb_usuarios (nombre_usuario, correo_usuario, contra_usuario, dni_usuario, rol, estado) VALUES (?, ?, ?, ?, ?, ?)";

        String hash = BCrypt.hashpw(passwordPlano, BCrypt.gensalt());

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
=======
        String sql = "INSERT INTO tb_usuarios (nombre_usuario, correo_usuario, contra_usuario, rol, estado) VALUES (?, ?, ?, ?, ?)";

        // Generamos hash de la contraseña
        String hash = BCrypt.hashpw(passwordPlano, BCrypt.gensalt());

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
>>>>>>> c23387e9d63452cfbb49a3c62e0c115b5dd1710f

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreoUsuario());
            stmt.setString(3, hash);
<<<<<<< HEAD
            stmt.setString(4, usuario.getDniUsuario());
            stmt.setString(5, usuario.getRol());
            stmt.setString(6, usuario.getEstado() != null ? usuario.getEstado() : "Activo");
=======
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getEstado() != null ? usuario.getEstado() : "Activo");
>>>>>>> c23387e9d63452cfbb49a3c62e0c115b5dd1710f

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

}
