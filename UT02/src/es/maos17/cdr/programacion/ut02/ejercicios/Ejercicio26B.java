package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio26B {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numero;
		
		do {
			System.out.print("Introduzca un número: ");
			numero = sc.nextInt();
			if (numero != 0) {
				System.out.println(numero);
			}
		}while (numero != 0);
		
		System.out.println("Fin del programa");
	}

}
