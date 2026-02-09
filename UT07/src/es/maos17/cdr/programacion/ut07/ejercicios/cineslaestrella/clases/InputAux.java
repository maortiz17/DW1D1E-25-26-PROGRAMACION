package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

import java.util.Scanner;

public final class InputAux {
	public static int leerEntero(String mensaje, Scanner sc) {
		int numero;
		while (true) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				return numero;
			}catch(NumberFormatException e) {
				System.out.println("Número entero no válido");
			}
		}
	}
	
	public static int leerEnteroLimites(String mensaje, int min, int max, Scanner sc) {
		int numero;
		while (true) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				if (numero >= min && numero <= max) {
					return numero;
				}else {
					System.out.printf("El número debe estar entre %d y %d.\n", min, max);
				}
			}catch(NumberFormatException e) {
				System.out.println("Número entero no válido");
			}
		}
	}
}