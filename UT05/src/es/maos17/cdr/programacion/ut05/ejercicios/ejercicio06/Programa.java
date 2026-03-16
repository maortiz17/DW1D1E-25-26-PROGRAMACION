package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Programa {
	
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String cadena;
		do {
			System.out.print("Introduzca una opción (suma/media) o número: ");
			cadena = sc.nextLine();
			switch(cadena) {
			case "suma":
				sumarNumeros(numeros);
				break;
			case "media":
				calcularMedia(numeros);
				break;
			case "fin":
				System.out.println("Fin del programa");
				break;
			default:
				if (convertirNumero(cadena, numeros)) {
					System.out.printf("La lista ahora tiene %d números\n", numeros.size());
				}else {
					System.out.println("Opción no válida");
				}
				break;
			}
		}while(!cadena.equals("fin"));
	}

	public static boolean convertirNumero(String posibleNumero, List<Integer> numeros) {
		try {
			Integer numero = Integer.parseInt(posibleNumero);
			numeros.add(numero);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void sumarNumeros(List<Integer> numeros) {
		if (numeros.isEmpty()) {
			System.out.println("La lista está vacía");
			return;
		}
		System.out.printf("La suma vale: %d\n", sumar(numeros));
	}
	
	public static void calcularMedia(List<Integer> numeros) {
		if (numeros.isEmpty()) {
			System.out.println("La lista está vacía");
			return;
		}
		System.out.printf("La media vale: %.2f\n", (double)sumar(numeros) / numeros.size());
	}
	
	public static long sumar(List<Integer> numeros) {
		long suma = 0;
		int numero;
		Iterator<Integer> it = numeros.iterator();
		while(it.hasNext()) {
			numero = it.next();
			suma += numero;
		}
		return suma;
	}
}
