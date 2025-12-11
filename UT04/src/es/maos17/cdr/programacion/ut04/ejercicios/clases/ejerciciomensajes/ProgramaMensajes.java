package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomensajes;

import java.util.Scanner;

public class ProgramaMensajes {
private static Tablon tablon;
    
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tablon = new Tablon();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    tablon.mostrarTablon();
                    break;
                case 2:
                    crearMensaje(sc);
                    break;
                case 3:
                    descifrarMensaje(sc);
                    break;
                case 4:
                    System.out.println("Destruyendo mensajes...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 4);
        sc.close();
    }
    
    // Método auxiliar para leer números enteros
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un número entero válido.");
            }
        }
    }
    
    public static void mostrarMenu() {
    	System.out.println("\n1. Ver Tablón\n2. Dejar Mensaje\n3. Leer Mensaje\n4. Salir");
    }
    
    public static void crearMensaje(Scanner sc) {
    	System.out.print("Mensaje secreto: ");
        String texto = sc.nextLine();
        System.out.print("Remitente: ");
        String rem = sc.nextLine();
        int codigo = leerEntero(sc, "Código numérico de cifrado: ");
        
        tablon.anadirMensaje(new Mensaje(texto, rem, codigo));
        System.out.println(">> Mensaje encriptado y publicado.");
    }
    
    public static void descifrarMensaje(Scanner sc) {
    	int idx = leerEntero(sc, "¿Qué número de mensaje quieres leer?: ");
        Mensaje m = tablon.getMensaje(idx);
        
        if (m != null) {
            int pass = leerEntero(sc, "Introduce el código para descifrar: ");
            System.out.println("\n-----------------------------------");
            System.out.println(m.descifrar(pass));
            System.out.println("-----------------------------------");
        } else {
            System.out.println("Mensaje no encontrado.");
        }
    }
}