import ec.edu.uce.dominio.Usuario;

public class TestUsuario {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorParametros();
        testSettersYGetters();
        testToString();
        testCRUD();
    }

    // Test del constructor vacío
    public static void testConstructorPorDefecto() {
        Usuario usuario = new Usuario();
        System.out.println("=============== Test Constructor Vacío ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test del constructor con parámetros
    public static void testConstructorParametros() {
        Usuario usuario = new Usuario(1, "Juan Pérez", "juan@email.com", "contraseña123");
        System.out.println("=============== Test Constructor con Parámetros ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test de los Setters y Getters
    public static void testSettersYGetters() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNombre("Ana López");
        usuario.setCorreo("ana@email.com");
        usuario.setContrasenia("contraseña456");

        System.out.println("=============== Test Setters y Getters ===============");
        System.out.println("ID Usuario: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contraseña: " + usuario.getContrasenia());
        System.out.println("--------------------------------------------------------");
    }

    // Test de toString()
    public static void testToString() {
        Usuario usuario = new Usuario(3, "Carlos García", "carlos@email.com", "contraseña789");
        System.out.println("=============== Test toString() ===============");
        System.out.println(usuario.toString());
        System.out.println("--------------------------------------------------------");
    }

    // Test del CRUD
    public static void testCRUD() {
        Usuario gestor = new Usuario(5);

        // Crear usuarios
        System.out.println("Creando usuarios...");
        gestor.crearUsuario(1, "Juan Pérez", "juan@correo.com", "12345");
        gestor.crearUsuario(2, "Ana Gómez", "ana@correo.com", "password");
        gestor.crearUsuario(3, "Carlos López", "carlos@correo.com", "abc123");

        // Mostrar todos los usuarios
        System.out.println("\nUsuarios después de la creación:");
        gestor.mostrarUsuarios();

        // Consultar un usuario por ID
        System.out.println("\nConsultando usuario con ID 1:");
        Usuario usuario = gestor.consultarUsuario(1);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }

        // Modificar un usuario
        System.out.println("\nModificando usuario con ID 1...");
        boolean modificado = gestor.modificarUsuario(1, "Juan Pérez Actualizado", "juan.nuevo@correo.com", "newpass");
        System.out.println("Modificación de usuario con ID 1: " + (modificado ? "Éxito" : "Error"));

        // Mostrar usuarios después de la modificación
        System.out.println("\nUsuarios después de la modificación:");
        gestor.mostrarUsuarios();

        // Eliminar un usuario
        System.out.println("\nEliminando usuario con ID 2...");
        boolean eliminado = gestor.eliminarUsuario(2);
        System.out.println("Eliminación de usuario con ID 2: " + (eliminado ? "Éxito" : "Error"));

        // Mostrar usuarios después de la eliminación
        System.out.println("\nUsuarios después de la eliminación:");
        gestor.mostrarUsuarios();

        // Intentar eliminar un usuario que no existe
        System.out.println("\nIntentando eliminar usuario con ID 4...");
        boolean eliminadoNoExistente = gestor.eliminarUsuario(4);
        System.out.println("Eliminación de usuario con ID 4 (no existente): " + (eliminadoNoExistente ? "Éxito" : "Error"));
    }
}

