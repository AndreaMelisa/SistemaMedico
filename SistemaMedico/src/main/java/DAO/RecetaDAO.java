package DAO;

import modelo.ConexionBD;
import modelo.Receta;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecetaDAO {

    public List<Receta> obtenerTodasRecetas() {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT r.*, c.id_paciente, c.id_usuario, "
                + "p.nombre_paciente, u.nombre_usuario AS nombre_doctor "
                + "FROM tb_recetas r "
                + "JOIN tb_citas c ON r.id_cita = c.id_cita "
                + "JOIN tb_pacientes p ON c.id_paciente = p.id_paciente "
                + "JOIN tb_usuarios u ON c.id_usuario = u.id_usuario "
                + "ORDER BY r.fecha_emision DESC";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Receta r = new Receta();
                r.setIdReceta(rs.getInt("id_receta"));
                r.setIdCita(rs.getInt("id_cita"));
                r.setDescripcion(rs.getString("descripcion"));
                Timestamp ts = rs.getTimestamp("fecha_emision");
                if (ts != null) {
                    r.setFechaEmision(ts.toLocalDateTime());
                }

                r.setNombrePaciente(rs.getString("nombre_paciente"));
                r.setNombreDoctor(rs.getString("nombre_doctor"));

                recetas.add(r);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener recetas: " + e.getMessage());
        }

        return recetas;
    }

    public Receta crearReceta(int idCita, String descripcion) {
        Receta receta = null;
        String sql = "INSERT INTO tb_recetas (id_cita, descripcion) VALUES (?, ?)";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, idCita);
            stmt.setString(2, descripcion);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idReceta = rs.getInt(1);

                    // Recuperar la receta completa con nombres
                    receta = obtenerRecetaPorId(idReceta);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al crear receta: " + e.getMessage());
        }

        return receta;
    }

    public Receta obtenerRecetaPorId(int idReceta) {
        Receta r = null;
        String sql = "SELECT r.*, c.id_paciente, c.id_usuario, "
                + "p.nombre_paciente, u.nombre_usuario AS nombre_doctor "
                + "FROM tb_recetas r "
                + "JOIN tb_citas c ON r.id_cita = c.id_cita "
                + "JOIN tb_pacientes p ON c.id_paciente = p.id_paciente "
                + "JOIN tb_usuarios u ON c.id_usuario = u.id_usuario "
                + "WHERE r.id_receta = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idReceta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                r = new Receta();
                r.setIdReceta(rs.getInt("id_receta"));
                r.setIdCita(rs.getInt("id_cita"));
                r.setDescripcion(rs.getString("descripcion"));
                Timestamp ts = rs.getTimestamp("fecha_emision");
                if (ts != null) {
                    r.setFechaEmision(ts.toLocalDateTime());
                }

                r.setNombrePaciente(rs.getString("nombre_paciente"));
                r.setNombreDoctor(rs.getString("nombre_doctor"));
            }

        } catch (Exception e) {
            System.err.println("Error al obtener receta por ID: " + e.getMessage());
        }

        return r;
    }

    public boolean eliminarReceta(int idReceta) {
        String sql = "DELETE FROM tb_recetas WHERE id_receta = ?";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idReceta);
            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.err.println("Error al eliminar receta: " + e.getMessage());
            return false;
        }
    }

}
