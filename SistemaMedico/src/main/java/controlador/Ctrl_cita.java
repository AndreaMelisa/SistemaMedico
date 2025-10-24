package controlador;

import DAO.CitaDAO;
import java.util.List;
import modelo.Cita;

public class Ctrl_cita {

    private final CitaDAO citaDAO;

    public Ctrl_cita() {
        this.citaDAO = new CitaDAO();
    }

    public List<Cita> obtenerCitasPendientes() {
        return citaDAO.obtenerCitasPendientes();
    }

    public boolean registrarCita(Cita cita) {
        if (cita == null) {
            System.out.println("La cita no puede ser nula");
            return false;
        }
        if (cita.getFecha_cita() == null || cita.getHora_inicio() == null) {
            System.out.println("Fecha u hora de inicio no pueden ser nulas");
            return false;
        }

        cita.setHora_fin(null);

        return citaDAO.registrarCita(cita);
    }

}
