package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio08;

import java.util.Collections;
import java.util.Comparator;
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
				//nombres.offer(scanner.nextLine());
				nombres.offerFirst(scanner.nextLine());
				break;
			case 3:
				//String nombre = nombres.poll();
				String nombre = nombres.pollLast();
				if (nombre != null) {
					System.out.println("Nombre eliminado: " + nombre);
				}else {
					System.out.println("La cola está vacía");
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
				List<String> listaOrdenada = (LinkedList<String>)nombres; // Esta LinkedList es tipo lista. En este caso no hacemos una copia 
				listaOrdenada.sort(null); //Collections.sort(listaOrdenada);
				System.out.println(nombres);
				break;
			case 7:
				// El método sort no existe en Deque. 
				listaOrdenada = (LinkedList<String>)nombres;
				listaOrdenada.sort(Comparator.reverseOrder()); //Collections.reverse(listaOrdenada)
				System.out.println(nombres);
				break;
			}
		}while (opcion != 8);
	}
	
	public static void mostrarOpciones() {
		System.out.println("MENÚ DE OPCIONES");
		System.out.println("================");
		System.out.println("1.- Listar nombres");
		System.out.println("2.- Añadir nombre");
		System.out.println("3.- Extraer nombre");
		System.out.println("4.- Eliminar nombre");
		System.out.println("5.- Eliminar todos");
		System.out.println("6.- Ordenar la cola ascendente");
		System.out.println("7.- Ordenar la cola descendente");
		System.out.println("8.- Salir");
	}
	
	private static int pedirOpcion() {
		while (true) {
			try {
				System.out.print("¿Qué operación quieres realizar (1-7, 8 para salir)? ");
				int opcion = Integer.parseInt(scanner.nextLine());
				return opcion;
			} catch (NumberFormatException e) {
				System.out.println("La opción elegida no es válida.");
			}
		}
	}
}

