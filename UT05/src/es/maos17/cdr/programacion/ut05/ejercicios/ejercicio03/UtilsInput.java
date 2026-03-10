package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UtilsInput {
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
			} catch (NumberFormatException e) {
				System.out.println("Número no válido");
			}
		}
	}

	public static String leerCadena(String mensaje, Scanner sc) {
		System.out.print(mensaje);
		return sc.nextLine();
	}
	
	public static LocalDate leerFecha(String mensaje, int anioMin, int anioMax, Scanner sc) {
		LocalDate fecha = null;
		while (fecha == null) {
			System.out.println(mensaje);
			try {
				int dia = UtilsInput.leerEnteroLimites("Día: ", 1, 31, sc);
				int mes = UtilsInput.leerEnteroLimites("Mes: ", 1, 12, sc);
				int anio = UtilsInput.leerEnteroLimites("Año: ", anioMin, anioMax, sc);
				fecha = LocalDate.of(anio, mes, dia);
			} catch (DateTimeException e) {
				System.out.println("Fecha no válida, inténtelo de nuevo.");
			}
		}
		return fecha;
	}
	
	public static double leerDoublePositivo(String mensaje, Scanner sc) {
		double numero = -1;
		while (numero < 0) {
			try {
				System.out.print(mensaje);
				numero = Double.parseDouble(sc.nextLine());
				if (numero < 0) {
					System.out.println("El importe no puede ser negativo.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Importe no válido.");
				numero = -1;
			}
		}
		return numero;
	}
}
