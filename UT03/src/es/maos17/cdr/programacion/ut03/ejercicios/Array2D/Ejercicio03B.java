package es.maos17.cdr.programacion.ut03.ejercicios.Array2D;
/* En este caso creamos matrices no necesariamente cuadradas
 * Para trasponer utilizamos una segunda matriz
 */
import java.util.Scanner;

public class Ejercicio03B {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el número de filas: ");
		int numFilas = scanner.nextInt();

		System.out.println("Introduce el número de columnas: ");
		int numColumnas = scanner.nextInt();

		scanner.close();

		int[][] numeros = crearArray2D(numFilas, numColumnas, 100);

		mostrarNumeros(numeros);
	
		System.out.println("-".repeat(numColumnas));
		
		mostrarNumeros(trasponer(numeros));
	}

	private static int[][] trasponer(int[][] original) {
		int[][] traspuesto = new int[original[0].length][original.length];

		/* En esta primera implementación recorremos la matriz original fila a fila
		 * Para cada fila de la matriz rellenamos una columna de la nueva matriz
		 */
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < traspuesto.length; j++) {
				traspuesto[j][i] = original[i][j];
			}
		}

		/* Este segundo bucle es equivalente al anterior (solo es necesario uno de ellos)
		 * Aquí recorremos la nueva matriz por filas, y en cada una de ellas copiamos
		 * una columna de la matriz original
		 */
		for (int i = 0; i < traspuesto.length; i++) {
			for (int j = 0; j < traspuesto[0].length; j++) {
				traspuesto[i][j] = original[j][i];
			}
		}

		// En una versión final del programa solo habría un bucle de los dos anteriores

		
		return traspuesto;
	}

	private static void mostrarNumeros(int[][] numeros) {
		for (int[] numerosFila : numeros) {
			for (int numero : numerosFila) {
				System.out.printf("%2s ", numero);
			}
			System.out.println();
		}

	}

	private static int[][] crearArray2D(int numFilas, int numColumnas, int limiteNumeros) {
		int[][] numeros = new int[numFilas][numColumnas];

		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[i].length; j++) {
				numeros[i][j] = (int) (Math.random() * limiteNumeros);
			}
		}
		return numeros;
	}

}