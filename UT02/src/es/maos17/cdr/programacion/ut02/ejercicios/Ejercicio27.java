package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		/*Realizar un programa que:
			Pregunte al usuario cuántos números vamos a procesar.
			Pida al usuario la cantidad de números que ha introducido en el paso anterior, 
			y para cada número indique si el número es menor que cero, cero o mayor que cero.
		*/
		Scanner sc = new Scanner(System.in);
		int cantidad;
		int numero;
		
		System.out.print("¿Cúantos números desea?: ");
		cantidad = sc.nextInt();
		
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Introduzca número " + i + ": ");
			numero = sc.nextInt();
			if (numero < 0) {
				System.out.println("El número es menor que cero");
			}else if (numero > 0) {
				System.out.println("El número es mayor que cero");
			}else {
				System.out.println("El número es cero");
			}
		}
		System.out.println("Fin del programa");
	}

}
