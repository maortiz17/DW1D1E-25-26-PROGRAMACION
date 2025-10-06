package es.maos17.cdr.programacion.ut01.ejercicios;

import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el primer número: ");
		int primerNumero = scanner.nextInt();
		System.out.print("Introduce el segundo número: ");
		int segundoNumero = scanner.nextInt();

		int distancia = Math.abs(primerNumero - segundoNumero);

		System.out.printf("La distancia entre %d y %d es %d\n", primerNumero, segundoNumero, distancia);

	}	
}
