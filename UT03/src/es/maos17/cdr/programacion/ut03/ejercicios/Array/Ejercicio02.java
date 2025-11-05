package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Scanner;

/* Escribe un programa que pida 10 nombres por teclado. Almacena los nombres en un array,
y luego muéstralos junto a la posición que ocupan en el array.
Ten en cuenta el tipo de dato más adecuado para guardar un nombre, para usarlo en la
declaración del array. */
public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] nombres = new String[10];
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Introduzca nombre %d: ", i + 1);
			nombres[i] = sc.nextLine();
		}
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("El nombre %d es %s.\n", i + 1, nombres[i]);
		}

	}

}
