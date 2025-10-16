package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		/* Haz un programa que permita escribir la tabla de multiplicar 
		 * de un número que se pregunte al usuario.
		 */
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.print("Introduzca un número: ");
		numero = sc.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + "x" + i + "=" + numero * i);
		}

	}

}
