package controlador;

import DAO.RecetaDAO;
import modelo.Receta;
import java.util.List;

public class Ctrl_receta {

    private final RecetaDAO recetaDAO;

    public Ctrl_receta() {
        recetaDAO = new RecetaDAO();
    }

    public List<Receta> listarRecetas() {
        return recetaDAO.obtenerTodasRecetas();
    }

    public Receta crearReceta(int idCita, String descripcion) {
        return recetaDAO.crearReceta(idCita, descripcion);
    }

    public boolean eliminarReceta(int idReceta) {
        return recetaDAO.eliminarReceta(idReceta);
    }

    public Receta obtenerReceta(int idReceta) {
        return recetaDAO.obtenerRecetaPorId(idReceta);
    }
}
