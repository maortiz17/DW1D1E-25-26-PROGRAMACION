package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio33D {

	public static void main(String[] args) {
		// Declaración de variables
		Scanner sc = new Scanner(System.in);
		long numero;
		
		System.out.print("Introduzca un número: ");
		numero = sc.nextLong();
		
		long raizNumero = (long)Math.sqrt(numero);
		
		boolean esPrimo = true;
		
		if (numero % 2 == 0) {
			esPrimo = false;
		}
		
		long inicio = System.currentTimeMillis();
		
		for (long divisor = 3; divisor <= raizNumero && esPrimo; divisor+=2) {
			long resto = numero % divisor;
			if (resto == 0) {
				System.out.println("Divisor: " + divisor);
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
