package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Programa {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Producto> inventario = new HashMap<>();
    private static Queue<Cliente> colaCaja = new LinkedList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = pedirEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1: gestionarMantenimiento(); break;
                case 2: llegadaClienteACaja(); break;
                case 3: cobrarCliente(); break;
                case 4: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- GESTIÓN SUPERMERCADO ---");
        System.out.println("1. Mantenimiento de productos");
        System.out.println("2. Llegada de cliente a caja");
        System.out.println("3. Cobrar cliente");
        System.out.println("4. Salir");
    }

    // --- BLOQUE MANTENIMIENTO ---
    private static void gestionarMantenimiento() {
        System.out.println("\n--- SUBMENÚ MANTENIMIENTO ---");
        System.out.println("1. Alta de producto");
        System.out.println("2. Buscar producto");
        int subOpcion = pedirEntero("Seleccione una opción: ");

        if (subOpcion == 1) {
            System.out.print("Código: "); String cod = sc.nextLine();
            System.out.print("Descripción: "); String desc = sc.nextLine();
            double precio = pedirDouble("Precio unitario: ");
            inventario.put(cod, new Producto(cod, desc, precio));
            System.out.println("Producto guardado.");
        } else if (subOpcion == 2) {
            System.out.print("Introduzca código: ");
            String cod = sc.nextLine();
            Producto p = inventario.get(cod);
            System.out.println(p != null ? p : "Producto no encontrado.");
        }
    }

    // --- BLOQUE LLEGADA CLIENTE ---
    private static void llegadaClienteACaja() {
        if (inventario.isEmpty()) {
            System.out.println("No se pueden crear clientes sin productos en el inventario.");
            return;
        }

        Cliente nuevoCliente = new Cliente();
        String cod;
        System.out.println("\n--- ESCANEO DE PRODUCTOS (FIN para terminar) ---");
        do {
            System.out.print("Código de producto (fin para salir): ");
            cod = sc.nextLine();
            if (!cod.equalsIgnoreCase("FIN")) {
                Producto p = inventario.get(cod);
                if (p != null) {
                    int cant = pedirEntero("Cantidad: ");
                    if (cant > 0) {
                        nuevoCliente.agregarLinea(p, cant);
                        System.out.println("Añadido: " + p.getDescripcion());
                    }
                } else {
                    System.out.println("Error: El código no existe.");
                }
            }
        } while (!cod.equalsIgnoreCase("FIN"));

        if (!nuevoCliente.getCarrito().isEmpty()) {
            colaCaja.offer(nuevoCliente);
            System.out.println("Cliente enviado a la cola de caja.");
        } else {
            System.out.println("Compra cancelada: El carrito está vacío.");
        }
    }

    // --- BLOQUE COBRO (TICKET) ---
    private static void cobrarCliente() {
        Cliente c = colaCaja.poll(); // FIFO: Primero en entrar, primero en salir

        if (c == null) {
            System.out.println("No hay clientes esperando en la cola.");
            return;
        }

        double totalFactura = 0;
        System.out.println("\n========================================");
        System.out.println("           TICKET DE COMPRA             ");
        System.out.println("========================================");
        System.out.printf("%-15s %-5s %-10s %-10s\n", "Desc.", "Cant.", "Precio U.", "Subtotal");
        System.out.println("----------------------------------------");

        for (LineaCompra linea : c.getCarrito()) {
            double subtotal = linea.calcularSubtotal();
            totalFactura += subtotal;
            System.out.printf("%-15.15s %-5d %-10.2f %-10.2f\n", 
                linea.getProducto().getDescripcion(),
                linea.getCantidad(),
                linea.getProducto().getPrecioUnitario(),
                subtotal);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-32s %-10.2f€\n", "TOTAL A PAGAR:", totalFactura);
        System.out.println("========================================\n");
    }

    // --- MÉTODOS AUXILIARES DE VALIDACIÓN ---
    private static int pedirEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número entero.");
            }
        }
    }

    private static double pedirDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Formato de precio incorrecto.");
            }
        }
    }
}