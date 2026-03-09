package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio02;

import java.util.Scanner;

public final class UtilsInput {
	public static int leerEnteroLimites(String mensaje, int min, int max, Scanner sc) {
		int numero;
		while (true) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				if (numero >= min && numero <= max) {
					return numero;
				}
				System.out.printf("El número debe estar entre %d y %d\n", min, max);
			}catch(NumberFormatException e) {
				System.out.println("Número no válido");
			}
		}
	}
	
	public static String leerCadena(String mensaje, Scanner sc) {
		System.out.print(mensaje);
		return sc.nextLine();
	}
}
