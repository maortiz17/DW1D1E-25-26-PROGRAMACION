package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		ArrayList<Integer> enteros = new ArrayList<>();
		leerValoresUsuario(enteros);
		if (!enteros.isEmpty()) {
			System.out.printf("Se han cargado %d valores\n", enteros.size());
			System.out.printf("La media es %.2f\n", calcularMedia(enteros));
			System.out.printf("El máximo es %d\n", obtenerMaximo(enteros));
			System.out.printf("El mínimo es %d\n", obtenerMinimo(enteros));
		}else {
			System.out.println("No se ha introducido ningún valor");
		}
	}
	
	public static void leerValoresUsuario(ArrayList<Integer> enteros) {
		Scanner sc = new Scanner(System.in);
		int entero;
		do {
			System.out.print("Introduzca un número entero: ");
			entero = Integer.parseInt(sc.nextLine());
			if(entero != -9999) {
				enteros.add(entero);
			}
		}while (entero != -9999);
	}

	public static double calcularMedia(ArrayList<Integer> enteros) {
		if (enteros.isEmpty()) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		double total = 0;
		for (Integer entero : enteros) {
			total += entero;
		}
		return total / enteros.size();
	}
	
	public static int obtenerMaximo(ArrayList<Integer> enteros) {
		if (enteros.isEmpty()) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		int maximo = enteros.get(0);
		for (int i = 1; i < enteros.size(); i++) {
			if (enteros.get(i) > maximo) {
				maximo = enteros.get(i);
			}
		}
		return maximo;
	}
	
	public static int obtenerMinimo(ArrayList<Integer> enteros) {
		if (enteros.isEmpty()) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		int minimo= enteros.get(0);
		for (int i = 1; i < enteros.size(); i++) {
			if (enteros.get(i) < minimo) {
				minimo = enteros.get(i);
			}
		}
		return minimo;
	}
}
