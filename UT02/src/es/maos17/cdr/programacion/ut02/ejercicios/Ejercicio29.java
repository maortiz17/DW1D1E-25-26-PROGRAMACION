package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {
		/* Crea un programa que pida números enteros positivos hasta que se introduzca un cero. 
		 * Debe calcular la suma y la media de todos los números introducidos. 
		 * Si el usuario introduce un número menor que cero, 
		 * debe mostrar un mensaje indicando que no es válido y no tenerlo en cuenta para el cálculo.
		 */
		Scanner sc = new Scanner(System.in);
		int numero;
		int cantidad = 0;
		int suma = 0;
		boolean esCero = false;
		
		while (!esCero) {
			System.out.print("Introduzca un número (0 para terminar): ");
			numero = sc.nextInt();
			
			if (numero < 0) {
				System.out.println("Número incorrecto. Solo positivos!!");
			}else {
				esCero = (numero == 0);
				
				if (!esCero) {
					cantidad++;
					suma += numero;
				}
			}
		}
		System.out.printf("La suma es %d y la media es %.2f", suma, (double)suma/cantidad);
	}

}
