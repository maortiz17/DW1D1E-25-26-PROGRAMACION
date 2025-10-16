package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio24 {

	public static void main(String[] args) {
		/*Repite el programa del problema 24, pero usando un bucle while.*/
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca número inicial: ");
		int numInicial = sc.nextInt();
		System.out.print("Introduzca número final: ");
		int numFinal = sc.nextInt();
		
		if (numInicial <= numFinal) {
		/*while (numInicial <= numFinal) {

			if (numInicial < numFinal) {
				System.out.print(numInicial + " ");
			}else {
				System.out.print(numInicial);
			}
			numInicial++;
			// Ojo. En este caso estamos modificando el contenido de la variable numInicial
			// Si se necesita más adelante hay que declarar una variable auxiliar para
			// controlar el bucle
		}*/
			int num = numInicial;
			while (num <= numFinal) {

				if (num < numFinal) {
					System.out.print(num + " ");
				}else {
					System.out.print(num + "\n");
				}
				num++;
			}
		}else {
			System.out.println("El número inicial no puede ser mayor que el final");
		}
		System.out.printf("Los números eran %d y %d\n", numInicial, numFinal);
	}

}
