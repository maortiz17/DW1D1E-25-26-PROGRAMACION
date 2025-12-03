package es.maos17.cdr.programacion.ut04.ejercicios.tiposenumerados.ejercicio01;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- BIENVENIDO AL PERSONALIZADOR DE CAMISETAS ---");

        // Llamamos a nuestros métodos de validación
        Talla tallaElegida = leerTalla(sc);
        Color colorElegido = leerColor(sc);

        System.out.println("\nPEDIDO CONFIRMADO:");
        System.out.println("Camiseta talla " + tallaElegida + " de color " + colorElegido);
        
        sc.close();
    }

    // Método para validar la Talla
    public static Talla leerTalla(Scanner sc) {
        while (true) {
            try {
                // 1. Mostramos las opciones disponibles dinámicamente
                System.out.print("Elige una talla (");
                for (Talla t : Talla.values()) {
                    System.out.print(t + " ");
                }
                System.out.print("): ");

                // 2. Leemos el texto y lo pasamos a mayúsculas (para evitar errores por minúsculas)
                String entrada = sc.nextLine().toUpperCase();

                // 3. Intentamos convertir ("Magia" del valueOf)
                // Si 'entrada' no existe en el Enum, aquí salta la excepción
                return Talla.valueOf(entrada);

            } catch (IllegalArgumentException e) {
                // 4. Gestionamos el error si escribió algo inventado
                System.out.println("Error: Esa talla no existe en nuestro catálogo.");
            }
        }
    }

    // Método para validar el Color (Casi idéntico, ideal para practicar)
    public static Color leerColor(Scanner sc) {
        while (true) {
            try {
                System.out.print("Elige un color (");
                for (Color c : Color.values()) {
                    System.out.print(c + " ");
                }
                System.out.print("): ");

                String entrada = sc.nextLine().toUpperCase();
                return Color.valueOf(entrada);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: Color no disponible.");
            }
        }
    }
}
