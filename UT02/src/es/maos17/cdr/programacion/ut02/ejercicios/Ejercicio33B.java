package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio33B {

	public static void main(String[] args) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.print("Introduzca un número: ");
		numero = sc.nextInt();
		
		int raizNumero = (int)Math.sqrt(numero);
		
		boolean esPrimo = true;
		
		long inicio = System.currentTimeMillis();
		
		for (int divisor = 2; divisor <= raizNumero; divisor++) {
			int resto = numero % divisor;
			if (resto == 0) {
				esPrimo = false;
			}
		}
		
		long fin = System.currentTimeMillis();
		
		if (!esPrimo) {
			System.out.println("El número no es primo");
		}else {
			System.out.println("El número es primo");
		}

		System.out.printf("He tardado: %s", fin - inicio);
	}

}
