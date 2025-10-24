package seeder;

import DAO.UsuarioDAO;
import modelo.Usuario;

public class UsuarioSeeder {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario u1 = new Usuario();
        u1.setNombreUsuario("Admin");
        u1.setApellidoUsuario("Admin");
        u1.setCorreoUsuario("admin@ves.com");
        u1.setRol("Administrador");
        u1.setDniUsuario("12345678"); 

        Usuario u2 = new Usuario();
        u2.setNombreUsuario("Ivan");
        u2.setApellidoUsuario("Jimenez");
        u2.setCorreoUsuario("jimenez@ves.com");
        u2.setRol("Doctor");
        u2.setDniUsuario("87654321"); 

        Usuario u3 = new Usuario();
        u3.setNombreUsuario("Rosa");
        u3.setApellidoUsuario("Gomez");
        u3.setCorreoUsuario("gomez@ves.com");
        u3.setRol("Doctor");
        u3.setDniUsuario("11223344");

        usuarioDAO.registrarUsuario(u1, "123");
        usuarioDAO.registrarUsuario(u2, "123");
        usuarioDAO.registrarUsuario(u3, "123");

        System.out.println("Usuarios creados correctamente");
    }
}
