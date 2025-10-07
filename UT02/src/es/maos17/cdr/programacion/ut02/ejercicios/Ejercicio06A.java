package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio06A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca una letra: ");
		String unaLetra = sc.nextLine();
		
		if (unaLetra.length() == 1) {
			if (unaLetra.equals(unaLetra.toUpperCase())) {
				System.out.println("Su letra es mayúscula!!");
			} else {
				System.out.println("Debe ser mayúscula. Letra incorrecta");
			}
		}else {
			System.out.println("La cadena no tiene una letra");
		}

	}

}
