package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochila1;

import java.util.Scanner;

public class ProgramaMochila {

	public static final int HUECOS_MOCHILA = 10;

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		Mochila mochila = new Mochila(HUECOS_MOCHILA);

		do {
			mostrarMenu();
			opcion = leerNumero("Indique una opción: ", sc);
			switch (opcion) {
			case 1:
				mochila.mostrarInventario();
				break;
			case 2:
				recogerObjeto(mochila, sc);
				break;
			case 3:
				tirarObjeto(mochila, sc);
				break;
			case 4:
				System.out.println("¡Hasta pronto!");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
		} while (opcion != 4);
	}

	public static void mostrarMenu() {
		System.out.println("1. Ver mochila");
		System.out.println("2. Recoger objeto");
		System.out.println("3. Tirar objeto");
		System.out.println("4. Salir");
	}

	public static int leerNumero(String mensaje, Scanner sc) {
		int numero;

		while (true) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				return numero;
			} catch (NumberFormatException e) {
				System.out.println("Número incorrecto");
			}
		}
	}

	public static void recogerObjeto(Mochila mochila, Scanner sc) {
		String nombre;
		TipoMaterial tipo = null;
		int cantidad;

		System.out.print("Nombre: ");
		nombre = sc.nextLine();

		while (true) {
			try {
				System.out.print("Introduzca el tipo (ARMA | POCION | RECURSO): ");
				tipo = TipoMaterial.valueOf(sc.nextLine().toUpperCase());
				cantidad = leerNumero("Introduzca la cantidad: ", sc);
				mochila.anadir(nombre, tipo, cantidad);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println("Error en valores");
			} catch (IllegalStateException e) {
				System.out.println("Error de estado: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Error inesperado: " + e.getMessage());
			}
		}
	}

	public static void tirarObjeto(Mochila mochila, Scanner sc) {
		int hueco = leerNumero("Indique el hueco: ", sc);
		int cantidad = leerNumero("Indique la cantidad: ", sc);
		try {
			mochila.tirar(hueco, cantidad);
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("Error en valores: " + e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("Error de estado: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}
}
