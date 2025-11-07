package es.maos17.cdr.programacion.ut03.ejercicios.Array;
/*
 * Modifica el código del ejercicio 05 para que se usen estos métodos que debes implementar
como métodos estáticos del programa principal:
● Método buscaMaximo que recibe el array y que devuelve la posición en la que se
encuentra el valor máximo.
● Método buscaMinimo que recibe el array y que devuelve la posición en la que se
encuentra el valor mínimo.
 */
import java.util.Scanner;

public class Ejercicio06 {

	private static final int CANTIDAD_NUMEROS = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numeros = new int[CANTIDAD_NUMEROS];

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número ");
			numeros[i] = scanner.nextInt();
		}

		int posMaximo = buscaMaximo(numeros);
		int posMinimo = buscaMinimo(numeros);

		System.out.printf("El máximo es %d y está en la posición %d.\n", numeros[posMaximo], posMaximo);
		System.out.printf("El mínimo es %d y está en la posición %d.\n", numeros[posMinimo], posMinimo);
	}

	/**
	 * Busca el valor máximo dentro de un array de enteros
	 * 
	 * @param numeros array en el que tenemos que localizar el máximo
	 * @return la posición en la que se encuentra el máximo
	 */
	public static int buscaMaximo(int[] numeros) {
		int maximo = numeros[0];
		int posMaximo = 0;

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > maximo) {
				maximo = numeros[i];
				posMaximo = i;
			}
		}
		return posMaximo;
	}

	/**
	 * Busca el valor mínimo dentro de un array de enteros
	 * 
	 * @param numeros array en el que tenemos que localizar el mínimo
	 * @return la posición en la que se encuentra el mínimo
	 */
	public static int buscaMinimo(int[] numeros) {
		int minimo = numeros[0];
		int posMinimo = 0;

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < minimo) {
				minimo = numeros[i];
				posMinimo = i;
			}
		}
		return posMinimo;
	}

}
