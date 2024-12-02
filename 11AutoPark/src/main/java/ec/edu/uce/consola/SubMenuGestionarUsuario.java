package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class SubMenuGestionarUsuario {

    // Estructura para almacenar las cuentas con todos sus datos usando el nombre de usuario como clave
    private static Map<String, Cuenta> cuentas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarCuenta() {
        int opcion;

        do {
            System.out.println("\n============= Gestionar Usuario ===============");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Editar Cuenta");
            System.out.println("3. Consultar Cuenta");
            System.out.println("4. Eliminar Cuenta");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("==================================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    editarCuenta();
                    break;
                case 3:
                    consultarCuenta();
                    break;
                case 4:
                    eliminarCuenta();
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCuenta() {
        System.out.println("\n================== CREAR CUENTA ====================");

        // Validar nombre de usuario
        String nombreUsuario = solicitarInput("Ingrese su nombre de usuario: ", Validacion::validarNombreUsuario);

        // Validar correo
        String correo = solicitarInput("Ingrese su correo electrónico: ", Validacion::validarCorreo);

        // Validar contraseña
        String contrasenia = solicitarInput("Ingrese su contraseña: ", Validacion::validarContrasenia);

        if (cuentas.containsKey(nombreUsuario)) {
            System.out.println("La cuenta con este nombre de usuario ya existe. Intente nuevamente.");
        } else {
            cuentas.put(nombreUsuario, new Cuenta(nombreUsuario, correo, contrasenia));
            System.out.println("Cuenta creada exitosamente.\n");
        }
    }

    private static void editarCuenta() {
        System.out.println("\n================== EDITAR CUENTA ====================");

        String nombreUsuario = solicitarInput("Ingrese el nombre de usuario de la cuenta a editar: ", Validacion::validarNombreUsuario);

        if (cuentas.containsKey(nombreUsuario)) {
            Cuenta cuenta = cuentas.get(nombreUsuario);

            System.out.println("\nEstá editando la cuenta");

            // Nuevos datos
            String nuevoNombreUsuario = solicitarInput("Nuevo nombre de usuario (actual: " + cuenta.getNombreUsuario() + "): ", Validacion::validarNombreUsuario);
            String nuevoCorreo = solicitarInput("Nuevo correo (actual: " + cuenta.getCorreo() + "): ", Validacion::validarCorreo);
            String nuevaContrasenia = solicitarInput("Nueva contraseña: ", Validacion::validarContrasenia);

            cuenta.setNombreUsuario(nuevoNombreUsuario);
            cuenta.setCorreo(nuevoCorreo);
            cuenta.setContrasenia(nuevaContrasenia);

            System.out.println("Cuenta actualizada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con el nombre de usuario proporcionado.");
        }
    }

    private static void consultarCuenta() {
        System.out.println("\n================== CONSULTAR CUENTA ====================");

        String nombreUsuario = solicitarInput("Ingrese el nombre de usuario para consultar: ", Validacion::validarNombreUsuario);

        if (cuentas.containsKey(nombreUsuario)) {
            Cuenta cuenta = cuentas.get(nombreUsuario);
            System.out.println("\nInformación de la cuenta:");
            System.out.println(cuenta);
        } else {
            System.out.println("No se encontró una cuenta con el nombre de usuario proporcionado.");
        }
    }

    private static void eliminarCuenta() {
        System.out.println("\n================== ELIMINAR CUENTA ====================");

        String nombreUsuario = solicitarInput("Ingrese el nombre de usuario de la cuenta a eliminar: ", Validacion::validarNombreUsuario);

        if (cuentas.containsKey(nombreUsuario)) {
            cuentas.remove(nombreUsuario);
            System.out.println("Cuenta eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una cuenta con el nombre de usuario proporcionado.");
        }
    }

    private static String solicitarInput(String mensaje, Predicate<String> validador) {
        String input;

        while (true) {
            System.out.print(mensaje);
            input = scanner.nextLine();

            if (validador.test(input)) {
                break;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
        return input;
    }

    // Clase interna para almacenar los datos de una cuenta
    public static class Cuenta {
        private String nombreUsuario;
        private String correo;
        private String contrasenia;

        public Cuenta(String nombreUsuario, String correo, String contrasenia) {
            this.nombreUsuario = nombreUsuario;
            this.correo = correo;
            this.contrasenia = contrasenia;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nuevoNombreUsuario) {
            this.nombreUsuario = nuevoNombreUsuario;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String nuevoCorreo) {
            this.correo = nuevoCorreo;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String nuevaContrasenia) {
            this.contrasenia = nuevaContrasenia;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombreUsuario + ", Correo: " + correo;
        }
    }

    public static Cuenta obtenerCuenta(String nombreUsuario) {
        return cuentas.get(nombreUsuario); // Retorna la cuenta asociada al nombre de usuario o null si no existe
    }
}
