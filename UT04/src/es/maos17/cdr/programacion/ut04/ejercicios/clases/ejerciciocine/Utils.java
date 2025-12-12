package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciocine;

import java.util.Scanner;

public class Utils {
	public static int leerEntero(String mensaje, Scanner sc) {
		int numero = 0;
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
	public static int leerEnteroLimites(String mensaje, int inferior, int superior, Scanner sc) {
		int numero;
		do {
			numero = leerEntero(mensaje, sc);
			if (numero < inferior || numero > superior) {
				System.out.printf("El número debe estar entre %d y %d\n", inferior, superior);
			}
		}while (numero < inferior || numero > superior);
		return numero;
	}
	public static double leerDouble (String mensaje, Scanner sc) {
		double numero = 0;
		while (true) {
			try {
				System.out.print(mensaje);
				numero = Double.parseDouble(sc.nextLine());
				return numero;
			} catch (NumberFormatException e) {
				System.out.println("Número incorrecto");
			}
		}
	}
}
