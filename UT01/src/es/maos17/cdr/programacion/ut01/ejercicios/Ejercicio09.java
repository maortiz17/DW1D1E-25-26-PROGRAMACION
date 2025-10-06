package es.maos17.cdr.programacion.ut01.ejercicios;

import java.util.Scanner;

public class Ejercicio09 {
	private final static double COMISION = 0.1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double sueldoBase;
		double primeraVenta, segundaVenta, terceraVenta;

		System.out.print("Introduce el sueldo base: ");
		sueldoBase = scanner.nextDouble();
		System.out.print("Introduce primera venta: ");
		primeraVenta = scanner.nextDouble();
		System.out.print("Introduce segunda venta: ");
		segundaVenta = scanner.nextDouble();
		System.out.print("Introduce tercera venta: ");
		terceraVenta = scanner.nextDouble();

		double sueldoFinal = sueldoBase + ((primeraVenta + segundaVenta + terceraVenta) * COMISION);
		System.out.printf("El sueldo final es: %.2f\n", sueldoFinal);

	}
}
