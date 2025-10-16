package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio26A {

	public static void main(String[] args) {
		
/*Algoritmo que pida números hasta que se introduzca un cero. 
 * Debe mostrar cada uno de los números introducidos, hasta que el usuario introduzca el cero, 
 * a medida que los vaya introduciendo. 
 * El cero, que es el número con el que el usuario “corta” el programa, no debe mostrarse.
 */
		Scanner sc = new Scanner(System.in);
		boolean esCero = false;
		int numero;
		
		while(!esCero) {
			System.out.print("Introduzca un número: ");
			numero = sc.nextInt();
			
			esCero = (numero == 0);
			
			if (!esCero) {
				System.out.println(numero);
			}
		}
		System.out.println("Fin del programa");
	}

}
