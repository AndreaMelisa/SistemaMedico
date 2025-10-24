package seeder;

import DAO.UsuarioDAO;
import modelo.Usuario;

public class UsuarioSeeder {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u1 = new Usuario();
        u1.setNombreUsuario("admin");
        u1.setCorreoUsuario("admin@ves.com");
        u1.setRol("Administrador");

        Usuario u2 = new Usuario();
        u2.setNombreUsuario("dr_jimenez");
        u2.setCorreoUsuario("jimenez@ves.com");
        u2.setRol("Doctor");

        Usuario u3 = new Usuario();
        u3.setNombreUsuario("dr_gomez");
        u3.setCorreoUsuario("gomez@ves.com");
        u3.setRol("Doctor");

        usuarioDAO.registrarUsuario(u1, "123");
        usuarioDAO.registrarUsuario(u2, "123");
        usuarioDAO.registrarUsuario(u3, "123");

        System.out.println("Usuarios creados correctamente");
    }
}
