import ec.edu.uce.dominio.EspacioAparcamiento;

public class TestEspacioAparcamiento {
    public static void main(String[] args) {
        // Instancia utilizando el constructor por defecto
        EspacioAparcamiento espacioAparcamiento = new EspacioAparcamiento();

        System.out.println("\n===== Probando Constructor por Defecto =====");
        System.out.println(espacioAparcamiento); // Usando el método toString

        // Probando getters con el constructor por defecto
        System.out.println("\n===== Probando Getters (Constructor por Defecto) =====");
        System.out.println("Número de Espacio: " + espacioAparcamiento.getNumeroEspacio());
        System.out.println("Estado: " + (espacioAparcamiento.getEstado() ? "Ocupado" : "Libre"));

        // Instancia utilizando el constructor con parámetros
        EspacioAparcamiento espacioAparcamiento1 = new EspacioAparcamiento("A2", true);

        System.out.println("\n===== Probando Constructor con Parámetros =====");
        System.out.println(espacioAparcamiento1); // Usando el método toString

        // Probando getters con el constructor con parámetros
        System.out.println("\n===== Probando Getters (Constructor con Parámetros) =====");
        System.out.println("Número de Espacio: " + espacioAparcamiento1.getNumeroEspacio());
        System.out.println("Estado: " + (espacioAparcamiento1.getEstado() ? "Ocupado" : "Libre"));

        // Probando métodos setters
        System.out.println("\n===== Probando Métodos Setters =====");

        // Cambiar el número de espacio
        System.out.println("Intentando asignar un número de espacio inválido:");
        espacioAparcamiento1.setNumeroEspacio(""); // Inválido
        System.out.println("Intentando asignar un número de espacio válido:");
        espacioAparcamiento1.setNumeroEspacio("A3"); // Válido
        System.out.println("Número de Espacio Actual: " + espacioAparcamiento1.getNumeroEspacio());

        // Cambiar el estado del espacio
        espacioAparcamiento1.setEstado(false);
        System.out.println("Estado Actual: " + (espacioAparcamiento1.getEstado() ? "Ocupado" : "Libre"));

        // Probando los métodos adicionales
        System.out.println("\n===== Métodos Adicionales =====");

        System.out.println("Antes de asignar el espacio:");
        System.out.println(espacioAparcamiento1.getDetalle());

        // Asignar espacio
        System.out.println("Asignando espacio...");
        espacioAparcamiento1.setEstado(true);
        System.out.println("Después de asignar el espacio:");
        System.out.println(espacioAparcamiento1.getDetalle());

        // Liberar espacio
        System.out.println("Liberando espacio...");
        espacioAparcamiento1.setEstado(false);
        System.out.println("Después de liberar el espacio:");
        System.out.println(espacioAparcamiento1.getDetalle());

        // Probando el método copiarEspacios
        System.out.println("\n===== Probando Método copiarEspacios =====");

        EspacioAparcamiento[] espaciosOriginales = {
                new EspacioAparcamiento("A1", true),
                new EspacioAparcamiento("A2", false),
                new EspacioAparcamiento("A3", true)
        };

        EspacioAparcamiento[] espaciosCopiados = new EspacioAparcamiento[3];

        // Copiar espacios
        EspacioAparcamiento.copiarEspacios(espaciosOriginales, espaciosCopiados, 3);

        // Imprimir los espacios copiados
        System.out.println("Espacios copiados:");
        for (EspacioAparcamiento espacio : espaciosCopiados) {
            System.out.println(espacio);
        }
    }
}
