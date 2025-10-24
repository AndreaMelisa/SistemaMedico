package controlador;

import DAO.PacienteDAO;
import modelo.Paciente;

public class Ctrl_paciente {

    private final PacienteDAO pacienteDAO;

    public Ctrl_paciente() {
        this.pacienteDAO = new PacienteDAO();
    }

    public Paciente buscarPacientePorDni(String dni) {
        if (dni == null || dni.isEmpty()) return null;
        return pacienteDAO.obtenerPacientePorDni(dni);
    }

    public boolean registrarPaciente(Paciente paciente) {
        return pacienteDAO.registrarPaciente(paciente);
    }
}
