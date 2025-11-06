package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Random;

public class Ejercicio9 {
	private static final int TOTAL_NUMEROS = 10;
	private static final int MAX = 50;
	
	public static void main(String[] args) {
		int[] numeros = new int[TOTAL_NUMEROS];
		rellenarConAleatorios(numeros);
		mostrarNumeros(numeros);
		System.out.println();
		procesarNumeros(numeros);
		mostrarNumeros(numeros);
	}
	
	private static boolean esPar(int n) {
		return ((n % 2) == 0);
	}
	
	private static void procesarNumeros(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (esPar(numeros[i]))
				numeros[i] /= 2;
			else
				numeros[i] *= 2;
				
		}
	}
	
	private static void rellenarConAleatorios(int[] numeros) {
		Random aleatorio = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = aleatorio.nextInt(MAX);
		}
	}
	
	private static void mostrarNumeros(int[] numeros) {
		for (int numero : numeros)
			System.out.printf("%d ", numero);
	}

}
