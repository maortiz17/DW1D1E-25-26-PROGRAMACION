package es.maos17.cdr.programacion.ut02.ejemplos;

import java.util.Scanner;

public class Ejemplo08DoWhile {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Hacemos una lectura adelantada
		System.out.print("Introduce un número del 1 al 10: ");
		int numero = sc.nextInt();
		
		// El siguiente bucle se ejecutará hasta que el usuario introduzca un número
		// válido (1-10)
		while (numero < 1 || numero > 10) {
			System.out.println("Número incorrecto.");
			System.out.print("Introduce un número del 1 al 10: ");
			numero = sc.nextInt();
		}
		
		System.out.printf("El número seleccionado es: %d\n", numero);
		
		do {
			// En este caso, como se ejecuta siempre, leo en la primera iteración
			System.out.print("Introduce un número del 1 al 10: ");
			numero = sc.nextInt();
			
			if (numero < 1 || numero > 10) {
				System.out.println("Número incorrecto.");
			}
		} while (numero < 1 || numero > 10);
		
		System.out.printf("El número seleccionado es: %d\n", numero);
	}

}
