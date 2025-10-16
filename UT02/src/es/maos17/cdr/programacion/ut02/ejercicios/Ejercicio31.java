package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio31 {
	
	static final int NUMERO_MAXIMO = 99;
	static final int MAX_INTENTOS = 10;
	
	public static void main(String[] args) {
		/*Crea una aplicación que permita adivinar un número. 
		 * La aplicación genera un número aleatorio del 1 al 99. 
		 * A continuación, 
		 * va pidiendo números y va respondiendo 
		 * si el número a adivinar es mayor o menor que el introducido, 
		 * además de informarle de los intentos que le quedan 
		 * (tiene 10 intentos para acertarlo). 
		 * El programa termina cuando se acierta el número 
		 * (además te dice en cuantos intentos lo has acertado), 
		 * si se llega al límite de intentos te muestra el número que había generado.
		 */
		
		
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
		int numero = rnd.nextInt(NUMERO_MAXIMO) + 1;
		int numLeido;
		int intentos = 0;
		boolean hasAcertado = false;
		
		while (intentos < MAX_INTENTOS && !hasAcertado) {
			System.out.println("Te quedan " + (MAX_INTENTOS - intentos) + " intentos.");
			intentos++;
			System.out.print("Introduce un número: ");
			numLeido = sc.nextInt();
			
			hasAcertado = (numero == numLeido);
			if (!hasAcertado) {
				if (numero < numLeido) {
					System.out.println("El número buscado es menor");
				}else {
					System.out.println("El número buscado es mayor");
				}
			}
		}
		if (hasAcertado) {
			System.out.println("Has acertado en " + intentos + " intentos.");
		}else {
			System.out.println("El número buscado era: " + numero);
		}

	}

}
