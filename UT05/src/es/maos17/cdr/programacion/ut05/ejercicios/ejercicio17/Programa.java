package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio17;

import java.util.*;

public class Programa {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Especialidad, PriorityQueue<Paciente>> hospital = new HashMap<>();

    public static void main(String[] args) {
        inicializarHospital();
        int opcion;
        do {
            mostrarMenu();
            opcion = pedirOpcion();
            ejecutarAccion(opcion);
        } while (opcion != 5);
    }

    private static void inicializarHospital() {
        for (Especialidad esp : Especialidad.values()) {
            hospital.put(esp, new PriorityQueue<Paciente>());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE URGENCIAS ---");
        System.out.println("1. Añadir paciente");
        System.out.println("2. Listar pacientes por especialidad");
        System.out.println("3. Tratar paciente (extraer)");
        System.out.println("4. Buscar paciente por DNI");
        System.out.println("5. Salir");
    }

    private static int pedirOpcion() {
        while (true) {
            try {
                System.out.print("Seleccione una opción: ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número válido.");
            }
        }
    }

    private static void ejecutarAccion(int opcion) {
        switch (opcion) {
            case 1: 
            	anadirPaciente(); 
            	break;
            case 2: 
            	listarPacientes(); 
            	break;
            case 3: 
            	tratarPaciente(); 
            	break;
            case 4: 
            	mostrarPaciente(); 
            	break;
            case 5: 
            	System.out.println("Saliendo del sistema..."); 
            	break;
            default: 
            	System.out.println("Opción no válida.");
        }
    }

    private static void anadirPaciente() {
        System.out.print("DNI: "); 
        String dni = sc.nextLine();
        if (buscarPacienteDNI(dni) != null) {
        	System.out.println("Ese paciente ya está esperando ser atendido");
        	return;
        }
        System.out.print("Nombre completo: "); 
        String nombre = sc.nextLine();
        Especialidad esp = elegirEnum(Especialidad.values(), "especialidad");
        System.out.print("Síntomas: "); 
        String sintomas = sc.nextLine();
        Gravedad grav = elegirEnum(Gravedad.values(), "gravedad");

        Paciente p = new Paciente(dni, nombre, esp, sintomas, grav);
        hospital.get(esp).offer(p);
        System.out.println("Paciente registrado correctamente.");
    }

    private static void listarPacientes() {
        Especialidad esp = elegirEnum(Especialidad.values(), "especialidad");
        PriorityQueue<Paciente> cola = hospital.get(esp);

        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en la cola de " + esp);
        } else {
            // Pasamos a lista para ordenar y mostrar sin vaciar la cola original
            List<Paciente> listaTemporal = new ArrayList<>(cola);
            Collections.sort(listaTemporal);
            
            System.out.println("\nLista de espera en " + esp + ":");
            for (Paciente p : listaTemporal) {
                System.out.println(p);
            }
        }
    }

    private static void tratarPaciente() {
        Especialidad esp = elegirEnum(Especialidad.values(), "especialidad");
        Paciente p = hospital.get(esp).poll(); // Extrae el de mayor prioridad

        if (p != null) {
            System.out.println("ATENDIENDO A: " + p.getNombreCompleto());
            System.out.println("Gravedad: " + p.getGravedad());
        } else {
            System.out.println("Aviso: No hay pacientes pendientes en " + esp);
        }
    }

    private static void mostrarPaciente() {
        System.out.print("Introduzca DNI a buscar: ");
        String dniBusqueda = sc.nextLine();
        
        Paciente p = buscarPacienteDNI(dniBusqueda);
        
        if (p != null) {
        	List<Paciente> listaTemporal = new ArrayList<>(hospital.get(p.getEspecialidad()));
        	Collections.sort(listaTemporal);
        	int posicion = listaTemporal.indexOf(p);
            System.out.println("Paciente encontrado: " + p);
            System.out.println("Especialidad asignada: " + p.getEspecialidad());
            System.out.println("Posición en la cola de la especialidad: " + (posicion + 1));
        }else {
        	System.out.println("No se ha encontrado ningún paciente con DNI: " + dniBusqueda); 
        }
    }
    
    private static Paciente buscarPacienteDNI(String dni) {

        // Búsqueda recorriendo el mapa y sus colas
        for (Map.Entry<Especialidad, PriorityQueue<Paciente>> entrada : hospital.entrySet()) {
            for (Paciente p : entrada.getValue()) {
                if (p.getDni().equalsIgnoreCase(dni)) {
                    return p;
                }
            }
        }
        return null;    
    }

    // Método auxiliar para valores de Enums sin errores
    private static <T> T elegirEnum(T[] valores, String nombreEnum) {
        while (true) {
            try {
                System.out.println("Seleccione " + nombreEnum + ":");
                for (int i = 0; i < valores.length; i++) {
                    System.out.println((i + 1) + ". " + valores[i]);
                }
                int sel = Integer.parseInt(sc.nextLine());
                return valores[sel - 1];
            } catch (Exception e) {
                System.out.println("Selección no válida.");
            }
        }
    }
}