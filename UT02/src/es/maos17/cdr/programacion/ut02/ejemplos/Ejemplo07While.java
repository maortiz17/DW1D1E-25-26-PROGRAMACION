package es.maos17.cdr.programacion.ut02.ejemplos;

import java.util.Scanner;

public class Ejemplo07While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 1;

		/*
		 * while (i < 9) { System.out.printf("Iteración número: %d\n", i); i++; }
		 */

		int numero = 0;

		// El siguiente bucle se ejecutará hasta que el usuario introduzca un número válido (1-10)
		while (numero < 1 || numero > 10) {
			System.out.print("Introduce un número del 1 al 10: ");
			numero = sc.nextInt();
		}

		// Primer bucle. Se ejecutará tantas veces como haya solicitado el usuario (desde 1 hasta numero)
		i = 1;
		while (i <= numero) { // El bucle finaliza cuando i > numero (i = numero + 1 en este caso)
			// Segundo bucle (anidado al primero) Imprime la tabla de multiplicar para cada
			// uno de los número del primer bucle
			int j = 1;
			while (j <= 10) { // El bucle finaliza cuando j = 11
				System.out.printf("%d * %d = %d\n", i, j, i * j);
				j++; // No olvides incrementar la variable de control
			}
			i++; // Incrementamos variable de control del primer bucle
		}
	}

}
