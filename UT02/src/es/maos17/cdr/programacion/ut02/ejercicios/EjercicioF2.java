package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class EjercicioF2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Total de términos de la sucesión
		int iteracionesTotal;
		// Actual contiene el término a imprimir en la próxima iteración
		int actual = 0;
		// Este será el término a imprimir en la iteración +2
		int proximo = 1;
		// Variable auxiliar para calcular la proximo
		int masProximo;
		do {
			System.out.print("Introduce la cantidad de términos de la sucesión: ");
			iteracionesTotal = sc.nextInt();
			if (iteracionesTotal <= 0)
				System.out.println("La cantidad debe ser un número positivo.");
		}while (iteracionesTotal <= 0);
		
		int iteracionActual = 0;
		while (iteracionActual < iteracionesTotal) {
			iteracionActual++; // Posición actual de la iteración
			if (iteracionActual < iteracionesTotal)
				System.out.printf("%d, ", actual);
			else
				System.out.println(actual);
			// Calculamos el siguiente término de la sucesión. Será el actual más el siguiente
			masProximo = actual + proximo;
			// Actualizamos el actual
			actual = proximo;
			// Actualizamos el próximo término calculado anteriormente
			proximo = masProximo;
		}
	}

}
