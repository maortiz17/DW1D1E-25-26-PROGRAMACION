package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class ejerciciosF3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numeroMenor, numeroMayor;
		int sumaPares = 0;
		int totalPares = 0;
		int sumaMult3 = 0;
		int totalMult3 = 0;
		
		// Solicitamos números hasta que se cumpla la condición
		do {
			System.out.print("Introduce el número menor: ");
			numeroMenor = sc.nextInt();
			System.out.print("Introduce el número mayor: ");
			numeroMayor = sc.nextInt();
			if (numeroMenor >= numeroMayor) {
				System.out.println("Error. El primer número debe ser menor que el segundo");
			}
		}while(numeroMenor >= numeroMayor);
		
		
		for (int i = (numeroMenor + 1); i <= numeroMayor; i++) {
			if (i % 2 == 0) { // Sumamos pares y los contamos
				sumaPares += i;
				totalPares++;
			}
			if (i % 3 == 0) { // Sumamos múltiplos de tres y los contamos
				sumaMult3 += i;
				totalMult3++;
			}
		}
		
		// Mostramos sumas y medias
		System.out.printf("La suma de pares entre %d (no incluido) y %d (incluido) es %d\n", numeroMenor, numeroMayor, sumaPares);
		if (totalPares > 0)
			System.out.printf("La media de estos número es %.2f\n", (double)sumaPares / totalPares);
		else
			System.out.println("Media no calculable porque no hay pares");
		System.out.printf("La suma de múltiplos de 3 entre %d (no incluido) y %d (incluido) es %d\n", numeroMenor, numeroMayor, sumaMult3);
		if (totalMult3 > 0)
			System.out.printf("La media de estos número es %.2f\n", (double)sumaMult3 / totalMult3);
		else
			System.out.println("Media no calculable porque no hay múltiplos de 3");
	}

}
