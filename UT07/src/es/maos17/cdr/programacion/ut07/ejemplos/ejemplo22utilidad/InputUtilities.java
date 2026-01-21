package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo22utilidad;

import java.util.Scanner;

public class InputUtilities {

	private InputUtilities() {

	}

	public static int pedirEntero(Scanner scanner, String mensaje) {
		System.out.println(mensaje);
		return scanner.nextInt();
	}
}
