package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio45B {

	public static void main(String[] args) {
		int numero = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		numero = sc.nextInt();
		
		System.out.printf("El factorial de %d es %d", numero, factorial(numero));

	}
	
	private static long factorial (int numero) {
		if (numero == 0) {
			return 1;
		}	
		return numero * factorial(numero - 1);
	}

}
