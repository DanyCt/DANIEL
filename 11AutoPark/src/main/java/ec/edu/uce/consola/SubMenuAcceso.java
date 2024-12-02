package ec.edu.uce.consola;

import ec.edu.uce.util.Validacion;
import ec.edu.uce.consola.SubMenuGestionarUsuario.Cuenta;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

// Clase principal del menú de gestión de acceso
public class SubMenuAcceso {
    private static Validacion validacion = new Validacion();
    private static SubMenuGestionarUsuario gestionarUsuario = new SubMenuGestionarUsuario();

    public static void administrarAcceso() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Gestión de Acceso =====");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Salida");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    menuRegistrarEntrada(scanner);
                    break;
                case 2:
                    consultarEntrada(scanner);
                    break;
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void menuRegistrarEntrada(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n===== Registrar Entrada =====");
            System.out.println("1. Asignar Espacio");
            System.out.println("2. Generar Ticket");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            switch (opcion) {
                case 1:
                    asignarEspacio(scanner);
                    break;
                case 2:
                    generarEntrada(scanner);
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void asignarEspacio(Scanner scanner) {
        System.out.print("Ingrese el número del espacio a asignar (Ejemplo: A1): ");
        String espacio = scanner.nextLine();  // Cambiar a String

        // Usamos la validación para validar el formato de la cadena
        if (validacion.validarNumeroEspacio(espacio)) {
            System.out.println("Espacio " + espacio + " asignado exitosamente.");
        } else {
            System.out.println("El espacio " + espacio + " no está disponible.");
        }
    }


    private static void generarEntrada(Scanner scanner) {
        System.out.println("\n==============Generando Ticket...=================0");

        // Validar si el usuario ya tiene una cuenta
        System.out.print("Ingrese su número de cédula para verificar su cuenta: ");
        String cedula = scanner.nextLine();

        // Obtener la cuenta asociada desde SubMenuGestionarUsuario
        Cuenta cuenta = SubMenuGestionarUsuario.obtenerCuenta(cedula);
        if (cuenta != null) {
            // Generar un ID único como referencia para esta entrada
            String entradaId = UUID.randomUUID().toString();

            // Mostrar la información del usuario registrada en Cuenta
            System.out.println("\n===== Información del Ticket =====");
            System.out.println("ID de Entrada: " + entradaId);
            System.out.println("Nombre: " + cuenta.getNombreUsuario());
            System.out.println("Correo: " + cuenta.getCorreo());
        } else {
            System.out.println("No se encontró una cuenta asociada a la cédula ingresada. Cree una cuenta primero.");
        }
    }

    private static void consultarEntrada(Scanner scanner) {
        System.out.println("\nEsta funcionalidad está reservada para futuras implementaciones.");
    }
}
