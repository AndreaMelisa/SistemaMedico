package DAO;

import modelo.ConexionBD;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public Usuario obtenerUsuarioPorDni(String dniUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM tb_usuarios WHERE dni_usuario = ? AND estado = 'Activo'";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dniUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setApellidoUsuario(rs.getString("apellido_usuario"));
                usuario.setCorreoUsuario(rs.getString("correo_usuario"));
                usuario.setContraUsuario(rs.getString("contra_usuario"));
                usuario.setDniUsuario(rs.getString("dni_usuario"));
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
        String sql = "INSERT INTO tb_usuarios "
                + "(nombre_usuario, apellido_usuario, correo_usuario, contra_usuario, dni_usuario, rol, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String hash = BCrypt.hashpw(passwordPlano, BCrypt.gensalt());

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getApellidoUsuario());
            stmt.setString(3, usuario.getCorreoUsuario());
            stmt.setString(4, hash);
            stmt.setString(5, usuario.getDniUsuario());
            stmt.setString(6, usuario.getRol());
            stmt.setString(7, usuario.getEstado() != null ? usuario.getEstado() : "Activo");

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

}
