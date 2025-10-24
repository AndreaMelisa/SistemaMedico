package DAO;

import modelo.Cita;
import modelo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    public boolean registrarCita(Cita cita) {
        String sql = "INSERT INTO tb_citas (id_paciente, id_usuario, fecha_cita, hora_inicio, hora_fin, motivo, estado_cita) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cita.getId_paciente());
            stmt.setInt(2, cita.getId_usuario());
            stmt.setDate(3, cita.getFecha_cita());
            stmt.setTime(4, Time.valueOf(cita.getHora_inicio()));

            if (cita.getHora_fin() != null) {
                stmt.setTime(5, Time.valueOf(cita.getHora_fin()));
            } else {
                stmt.setNull(5, java.sql.Types.TIME);
            }

            stmt.setString(6, cita.getMotivo());
            stmt.setString(7, cita.getEstado_cita() != null ? cita.getEstado_cita() : "Pendiente");

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.err.println("Error al registrar cita: " + e.getMessage());
            return false;
        }
    }

    public Cita obtenerCitaPorId(int idCita) {
        Cita cita = null;
        String sql = "SELECT * FROM tb_citas WHERE id_cita = ?";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCita);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cita = mapearCita(rs);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener cita: " + e.getMessage());
        }

        return cita;
    }

    public List<Cita> obtenerCitasPorPaciente(int idPaciente) {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM tb_citas WHERE id_paciente = ? ORDER BY fecha_cita, hora_inicio";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                citas.add(mapearCita(rs));
            }

        } catch (Exception e) {
            System.err.println("Error al obtener citas: " + e.getMessage());
        }

        return citas;
    }

    private Cita mapearCita(ResultSet rs) throws SQLException {
        Cita cita = new Cita();
        cita.setId_cita(rs.getInt("id_cita"));
        cita.setId_paciente(rs.getInt("id_paciente"));
        cita.setId_usuario(rs.getInt("id_usuario"));
        cita.setFecha_cita(rs.getDate("fecha_cita"));
        cita.setHora_inicio(rs.getTime("hora_inicio").toLocalTime());
        cita.setHora_fin(rs.getTime("hora_fin").toLocalTime());
        cita.setMotivo(rs.getString("motivo"));
        cita.setEstado_cita(rs.getString("estado_cita"));
        return cita;
    }

}
