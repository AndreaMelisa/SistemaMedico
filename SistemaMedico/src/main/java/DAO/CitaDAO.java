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

        Time horaFinSQL = rs.getTime("hora_fin");
        if (horaFinSQL != null) {
            cita.setHora_fin(horaFinSQL.toLocalTime());
        } else {
            cita.setHora_fin(null);
        }

        cita.setMotivo(rs.getString("motivo"));
        cita.setEstado_cita(rs.getString("estado_cita"));
        return cita;
    }

    public List<Cita> obtenerTodasCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT c.*, p.nombre_paciente, u.nombre_usuario AS nombre_doctor "
                + "FROM tb_citas c "
                + "JOIN tb_pacientes p ON c.id_paciente = p.id_paciente "
                + "JOIN tb_usuarios u ON c.id_usuario = u.id_usuario "
                + "ORDER BY c.fecha_cita, c.hora_inicio";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setId_cita(rs.getInt("id_cita"));
                cita.setId_paciente(rs.getInt("id_paciente"));
                cita.setId_usuario(rs.getInt("id_usuario"));
                cita.setFecha_cita(rs.getDate("fecha_cita"));
                cita.setHora_inicio(rs.getTime("hora_inicio").toLocalTime());
                cita.setHora_fin(rs.getTime("hora_fin") != null ? rs.getTime("hora_fin").toLocalTime() : null);
                cita.setMotivo(rs.getString("motivo"));
                cita.setEstado_cita(rs.getString("estado_cita"));

                // Asignar nombres del paciente y doctor
                cita.setNombrePaciente(rs.getString("nombre_paciente"));
                cita.setNombreDoctor(rs.getString("nombre_doctor"));

                citas.add(cita);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener todas las citas: " + e.getMessage());
        }

        return citas;
    }

    public List<Cita> obtenerCitasPendientes() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT c.*, p.nombre_paciente, p.apellido_paciente "
                + "FROM tb_citas c "
                + "JOIN tb_pacientes p ON c.id_paciente = p.id_paciente "
                + "WHERE c.estado_cita = 'Pendiente' "
                + "ORDER BY c.fecha_cita, c.hora_inicio";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cita cita = mapearCita(rs);
                cita.setNombrePaciente(rs.getString("nombre_paciente"));
                cita.setApellidoPaciente(rs.getString("apellido_paciente"));
                citas.add(cita);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener citas pendientes: " + e.getMessage());
        }

        return citas;
    }

}
