package es.maos17.cdr.programacion.ut03.ejercicios.Array;
/*
 * Escribe un programa que genere 100 números aleatorios menores que 100 (de 0 a 99), y
los almacene en un array. Luego debe calcular la suma y la media de los números
introducidos.
Usa al menos los siguientes métodos:
● generarNumeros. Hay dos opciones:
○ Recibe un array de cierto tamaño y lo llena de números aleatorios.
○ Recibe el tamaño del array que queremos crear, y devuelve un array, de ese
tamaño, lleno de números aleatorios.
● calcularSuma. Recibe el array de números y devuelve la suma de los números.
● calcularMedia. Recibe el array de números y devuelve la media de los números.
Recomendación: para simplificar este método, puedes llamar al método
calcularSuma.
 */
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
