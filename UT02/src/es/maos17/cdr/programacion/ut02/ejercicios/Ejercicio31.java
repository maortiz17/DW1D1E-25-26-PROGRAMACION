package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio31 {
	
	// Constantes con número máximo a generar y número máximo de intentos
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
		Random rnd = new Random(); // Objeto necesario para número aleatorio
		
		// El método genera un número entre cero (incluido) y NUMERO_MAXIMO (excluido)
		// Como en nuestro caso es entre 1 y NUMERO_MAXIMO sumamos 1 
		int numero = rnd.nextInt(NUMERO_MAXIMO) + 1;
		int numLeido;
		int intentos = 0;
		boolean hasAcertado = false; // Flag por si se acierta el número
		
		// Iteramos mientras tengamos intentos disponibles y no se haya acertado el número
		while (intentos < MAX_INTENTOS && !hasAcertado) {
			System.out.println("Te quedan " + (MAX_INTENTOS - intentos) + " intentos.");
			intentos++;
			System.out.print("Introduce un número: ");
			numLeido = sc.nextInt();
			
			hasAcertado = (numero == numLeido); // Ponemos el flag a true si se acierta el número
			if (!hasAcertado) {
				if (numero < numLeido) {
					System.out.println("El número buscado es menor");
				}else {
					System.out.println("El número buscado es mayor");
				}
			}
		}
		if (hasAcertado) { // Mensajes al final del juego
			System.out.println("Has acertado en " + intentos + " intentos.");
		}else {
			System.out.println("El número buscado era: " + numero);
		}

	}

}
