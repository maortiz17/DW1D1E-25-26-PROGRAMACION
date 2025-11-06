package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cantNumeros = pedirCantidadNumeros(sc);

		int[] matrizNumeros1 = new int[cantNumeros];
		
		pedirNumeros(matrizNumeros1, sc);
		
		int[] matrizNumeros2 = pedirNumeros(cantNumeros, sc);
		
		mostrarNumerosOrdenNormal(matrizNumeros1);
		mostrarNumerosOrdenInverso(matrizNumeros2);
		
	}
	
	private static int pedirCantidadNumeros(Scanner sc) {
		int cantNumeros = 0;
		do {
			System.out.print("¿Cúantos números desea?: ");
			cantNumeros = sc.nextInt();
			if (cantNumeros <= 0) {
				System.err.println("Tiene que ser un número positivo");
			}
		}while (cantNumeros <= 0);
		
		return cantNumeros;
	}
	// Método sobrecargado con las dos versiones del enunciado
	
	// Esta versión recibe el array y lo modifica (parámetro por referencia)
	private static void pedirNumeros(int[] matriz, Scanner sc) {
		System.out.println("Sistema 1");
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("Introduce en número %d: ", i + 1);
			matriz[i] = sc.nextInt();
		}
	}

	// Esta versión devuelve un array creado en el propio método
	private static int[] pedirNumeros(int tam, Scanner sc) {
		System.out.println("Sistema 2");
		int[] matriz = new int[tam];
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("Introduce en número %d: ", i + 1);
			matriz[i] = sc.nextInt();
		}
		return matriz;
	}
	
	private static void mostrarNumerosOrdenNormal(int[] numeros) {
		System.out.println("Orden normal");
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%d", numeros[i]);
		}
		System.out.println();
	}
	
	private static void mostrarNumerosOrdenInverso(int[] numeros) {
		System.out.println("Orden inverso");
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.printf("%d", numeros[i]);
		}
		System.out.println();
	}

}
