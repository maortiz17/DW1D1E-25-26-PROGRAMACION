package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio16;

import java.util.Collection;
import java.util.Scanner;

public class Programa {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Ejemplo: 20 plazas, 4 en cola, 30s cortesía, 1 céntimo/segundo
        Estacionamiento park = new Estacionamiento(20, 4, 30, 1.0);
        int opcion;

        do {
            mostrarMenu();
            opcion = pedirOpcion();
            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Matrícula a estacionar: ");
                        String m1 = scanner.nextLine();
                        ResultadoEstacionamiento res = park.estacionarVehiculo(m1);
                        System.out.println("Resultado: " + res);
                        break;
                    case 2:
                        System.out.print("Matrícula a retirar: ");
                        String m2 = scanner.nextLine();
                        double cobro = park.retirarVehiculo(m2);
                        System.out.printf("Vehículo retirado. Importe a cobrar: %.2f€\n", cobro);
                        break;
                    case 3:
                        System.out.print("Matrícula a comprobar: ");
                        String m3 = scanner.nextLine();
                        if (park.estaEstacionadoOEsperando(m3)) {
                            System.out.println("El vehículo está en las instalaciones.");
                        } else {
                            System.out.println("El vehículo no está en el estacionamiento.");
                        }
                        break;
            		case 4:
            		    System.out.println("Matrículas en el sistema (Estacionados + Esperando):");
            		    Collection<String> matriculas = park.getMatriculasEstacionadosOEsperando();
            		    for (String m : matriculas) {
            		        System.out.println(m);
            		    }
            		    break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ESTACIONAMIENTO ---");
        System.out.println("1. Estacionar vehículo");
        System.out.println("2. Retirar vehículo");
        System.out.println("3. Comprobar vehículo");
        System.out.println("4. Obtener todas las matrículas");
        System.out.println("0. Salir");
    }

    private static int pedirOpcion() {
        try {
            System.out.print("Elija opción: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}