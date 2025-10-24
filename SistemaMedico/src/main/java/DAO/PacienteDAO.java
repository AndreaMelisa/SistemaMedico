package DAO;

import modelo.ConexionBD;
import modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacienteDAO {

    public Paciente obtenerPacientePorDni(String dniPaciente) {
        Paciente paciente = null;
        String sql = "SELECT * FROM tb_pacientes WHERE dni_paciente = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dniPaciente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setNombrePaciente(rs.getString("nombre_paciente"));
                paciente.setApellidoPaciente(rs.getString("apellido_paciente"));
                paciente.setDniPaciente(rs.getString("dni_paciente"));
                paciente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setDireccion(rs.getString("direccion"));
            }

        } catch (Exception e) {
            System.err.println("Error al obtener paciente: " + e.getMessage());
        }

        return paciente;
    }

    public boolean registrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO tb_pacientes "
                   + "(nombre_paciente, apellido_paciente, dni_paciente, fecha_nacimiento, sexo, telefono, direccion) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNombrePaciente());
            stmt.setString(2, paciente.getApellidoPaciente());
            stmt.setString(3, paciente.getDniPaciente());
            stmt.setDate(4, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            stmt.setString(5, paciente.getSexo());
            stmt.setString(6, paciente.getTelefono());
            stmt.setString(7, paciente.getDireccion());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.err.println("Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }
}
