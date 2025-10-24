package controlador;

import DAO.HistorialDAO;
import modelo.Historial;
import java.util.List;

public class Ctrl_historial {

    private final HistorialDAO historialDAO;

    public Ctrl_historial() {
        this.historialDAO = new HistorialDAO();
    }

    public List<Historial> listarHistorial() {
        return historialDAO.listarHistorial();
    }

    public boolean guardarHistorial(Historial historial) {
        if (historial == null) {
            System.out.println("Historial no puede ser nulo");
            return false;
        }
        return historialDAO.guardarHistorial(historial);
    }
}
