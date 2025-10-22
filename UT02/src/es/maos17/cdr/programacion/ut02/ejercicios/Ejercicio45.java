package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio45 {

	public static void main(String[] args) {
		
		int numero = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		numero = sc.nextInt();
		
		System.out.printf("El factorial de %d es %d", numero, factorial(numero));

	}
	
	private static long factorial (int numero) {
		long factorial = 1;
		
		for (int i = numero; i > 1; i--) {
			factorial = factorial * i;
		}
		
		return factorial;
	}

}
