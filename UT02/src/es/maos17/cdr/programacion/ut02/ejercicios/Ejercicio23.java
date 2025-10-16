package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		/* Realiza un programa que:
Pida al usuario un número inicial (entero)
Pida al usuario un número final (entero)
Si el número inicial no es menor o igual al número final, mostrará un mensaje de error.
En caso contrario, usando un bucle bucle for, muestre todos los números desde el inicial al final, 
separados por espacios, ambos incluidos.
*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca número inicial: ");
		int inicial = sc.nextInt();
		System.out.print("Introduzca número final: ");
		int ultimo = sc.nextInt();
		
		/*if (inicial <= ultimo) {
			for (int i = inicial; i <= ultimo; i++) {
				if (i < ultimo) {
					System.out.print(i + " ");
				}else {
					System.out.print(i);
				}
			}
		}else {
			System.out.println("El número inicial no puede ser mayor que el final");
		}*/
		
		while (inicial > ultimo) {
			System.out.println("El número inicial no puede ser mayor que el final");
			System.out.print("Introduzca número inicial: ");
			inicial = sc.nextInt();
			System.out.print("Introduzca número final: ");
			ultimo = sc.nextInt();
			
		}
		for (int i = inicial; i <= ultimo; i++) {
			if (i < ultimo) {
				System.out.print(i + " ");
			}else {
				System.out.print(i);
			}
		}

	}

}
