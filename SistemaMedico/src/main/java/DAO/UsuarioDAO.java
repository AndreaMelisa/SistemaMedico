package DAO;

import modelo.ConexionBD;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario iniciarSesion(String nombreUsuario, String contraUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM tb_usuarios WHERE nombre_usuario = ? AND contra_usuario = ? AND estado = 'Activo'";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contraUsuario);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setCorreoUsuario(rs.getString("correo_usuario"));
                usuario.setRol(rs.getString("rol"));
                usuario.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.err.println("Error al iniciar sesión: " + e.getMessage());
        }

        return usuario;
    }
}
