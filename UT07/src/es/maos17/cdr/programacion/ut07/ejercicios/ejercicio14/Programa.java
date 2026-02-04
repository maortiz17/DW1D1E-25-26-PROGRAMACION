package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio14;

import java.util.Arrays;
import java.util.Random;

public class Programa {

	public static void main(String[] args) {
		Random rnd = new Random();
		int[] numeros = new int[10];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt(20);
		}
		
		System.out.println("Números antes de ordenar:");
		System.out.println(Arrays.toString(numeros));
		
		Arrays.sort(numeros);

		System.out.println("Números después de ordenar:");
		System.out.println(Arrays.toString(numeros));

	}

}
