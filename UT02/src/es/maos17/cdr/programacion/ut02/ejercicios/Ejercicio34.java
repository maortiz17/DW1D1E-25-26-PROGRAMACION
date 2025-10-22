package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio34 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cantidad = 0;
		long proximo = 2;
		
		System.out.print("¿Cuántos números primos desea calcular? ");
		cantidad = sc.nextInt();
		
		while (cantidad > 0) {
			if (esPrimo(proximo)) {
				System.out.printf("%d ", proximo);
				cantidad--;
			}
			proximo++;
		}

	}
	
	public static boolean esPrimo(long numero) {
		long raizNumero = (long)Math.sqrt(numero);
		
		boolean esPrimo = true;
		
		if (numero == 2) {
			return true;
		}
		
		if (numero % 2 == 0) {
			return false;
		}
		
		for (long divisor = 3; divisor <= raizNumero && esPrimo; divisor += 2) {
			long resto = numero % divisor;
			if (resto == 0) {
				esPrimo = false;
			}
		}
		
		return esPrimo;
		
	}

}
