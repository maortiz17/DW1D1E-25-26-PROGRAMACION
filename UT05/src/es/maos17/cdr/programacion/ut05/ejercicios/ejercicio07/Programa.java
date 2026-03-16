package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	private static Scanner scanner = new Scanner(System.in);
	private static Deque<String> nombres = new LinkedList<>();
	
	public static void main(String[] args) {
		gestionarMenu();
	}
	
	public static void gestionarMenu() {
		int opcion;
		do {
			mostrarOpciones();
			opcion = pedirOpcion();
			switch (opcion) {
			case 1:
				System.out.println(nombres);
				break;
			case 2:
				System.out.print("Introduzca un nombre: ");
				//nombres.push(scanner.nextLine());
				nombres.offerFirst(scanner.nextLine());
				break;
			case 3:
				//String nombre = nombres.pop();
				String nombre = nombres.pollFirst();
				if (nombre != null) {
					System.out.println("Nombre eliminado: " + nombre);
				}else {
					System.out.println("La pila está vacía");
				}
				break;
			case 4:
				System.out.print("Introduzca un nombre a eliminar: ");
				nombre = scanner.nextLine();
				if (nombres.remove(nombre)) { // En una pila Deque es lo mismo que removeFirstOccurrence(Object o)
					System.out.println("Nombre eliminado correctamente");
				}else {
					System.out.println("Nombre no encontrado");
				}
				break;
			case 5:
				nombres.clear();
				System.out.println("Pila vaciada");
				break;
			case 6:
				// El método sort no existe en Deque. 
				List<String> listaOrdenada = new LinkedList<>(nombres); // Esta LinkedList es tipo lista 
				listaOrdenada.sort(null); //Collections.sort(listaOrdenada);
				System.out.println(listaOrdenada);
				break;
			}
		}while (opcion != 7);
	}
	
	public static void mostrarOpciones() {
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("================");
		System.out.println("1.- Listar nombres");
		System.out.println("2.- Añadir nombre");
		System.out.println("3.- Extraer nombre");
		System.out.println("4.- Eliminar nombre");
		System.out.println("5.- Eliminar todos");
		System.out.println("6.- Mostrar en orden alfabético");
		System.out.println("7.- Salir");
	}
	
	private static int pedirOpcion() {
		while (true) {
			try {
				System.out.print("¿Qué operación quieres realizar (1-6, 7 para salir)? ");
				int opcion = Integer.parseInt(scanner.nextLine());
				return opcion;
			} catch (NumberFormatException e) {
				System.out.println("La opción elegida no es válida.");
			}
		}
	}
}
