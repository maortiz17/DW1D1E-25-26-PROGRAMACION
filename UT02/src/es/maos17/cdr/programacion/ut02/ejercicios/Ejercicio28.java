package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {
		/*
		 * Hacer un programa igual que el del ejercicio 27, 
		 * pero en lugar de mostrar un mensaje por cada número introducido, 
		 * mostrará cuántos números positivos, cuántos negativos y 
		 * cuántos ceros se han introducido.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int cantidad;
		int numero;
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		
		System.out.print("¿Cúantos números desea?: ");
		cantidad = sc.nextInt();
		
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Introduzca número " + i + ": ");
			numero = sc.nextInt();
			if (numero < 0) {
				negativos++;
			}else if (numero > 0) {
				positivos++;
			}else {
				ceros++;
			}
		}
		System.out.printf("Hay %d positivos, %d negativos y %d ceros.", positivos, negativos, ceros);
	}

}
