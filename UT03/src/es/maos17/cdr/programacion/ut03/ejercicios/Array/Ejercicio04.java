package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Random;

public class Ejercicio04 {
	private static final int CANTIDAD_NUMEROS = 100;

	public static void main(String[] args) {
		// Llamada al método versión 1
		int[] numeros = generarNumeros(CANTIDAD_NUMEROS, 0, 100);

		int suma = calcularSuma(numeros);

		double media = calcularMedia(numeros);

		System.out.printf("La suma es %d y la media es %.2f\n", suma, media);
		// Llamada al método versión 2
		generarNumeros(numeros, 0, 100);
		suma = calcularSuma(numeros);

		media = calcularMedia(numeros);

		System.out.printf("La suma es %d y la media es %.2f\n", suma, media);
	}

	private static double calcularMedia(int[] numeros) {
		return (double) calcularSuma(numeros) / numeros.length;
	}

	private static int calcularSuma(int[] numeros) {
		int suma = 0;
		for (int num : numeros) {
			suma += num;
		}
		return suma;
	}

	// Generamos las dos versiones del método como en el ejercicio 3
	private static int[] generarNumeros(int cantidadNumeros, int min, int max) {
		Random rnd = new Random();

		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt(min, max);
		}

		return numeros;
	}
	private static void generarNumeros(int[] numeros, int min, int max) {
		Random rnd = new Random();

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt(min, max);
		}
	}
}
