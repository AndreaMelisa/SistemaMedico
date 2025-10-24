package DAO;

import modelo.Historial;
import modelo.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialDAO {

    public List<Historial> listarHistorial() {
        List<Historial> lista = new ArrayList<>();
        String sql = "SELECT h.id_historial, h.id_paciente, h.fecha_registro, h.diagnostico, h.tratamiento, h.observaciones, "
                + "p.nombre_paciente, p.apellido_paciente "
                + "FROM tb_historial h "
                + "JOIN tb_pacientes p ON h.id_paciente = p.id_paciente "
                + "ORDER BY h.fecha_registro DESC";

        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Historial h = new Historial();
                h.setIdHistorial(rs.getInt("id_historial"));
                h.setIdPaciente(rs.getInt("id_paciente"));
                h.setFechaRegistro(rs.getTimestamp("fecha_registro").toLocalDateTime());
                h.setDiagnostico(rs.getString("diagnostico"));
                h.setTratamiento(rs.getString("tratamiento"));
                h.setObservaciones(rs.getString("observaciones"));
                h.setNombrePaciente(rs.getString("nombre_paciente"));
                h.setApellidoPaciente(rs.getString("apellido_paciente"));

                lista.add(h);
            }

        } catch (Exception e) {
            System.err.println("Error al listar historial: " + e.getMessage());
        }

        return lista;
    }

    public boolean guardarHistorial(Historial historial) {
        String sql = "INSERT INTO tb_historial (id_paciente, diagnostico, tratamiento, observaciones) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historial.getIdPaciente());
            stmt.setString(2, historial.getDiagnostico());
            stmt.setString(3, historial.getTratamiento());
            stmt.setString(4, historial.getObservaciones());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error al guardar historial: " + e.getMessage());
            return false;
        }
    }
}
