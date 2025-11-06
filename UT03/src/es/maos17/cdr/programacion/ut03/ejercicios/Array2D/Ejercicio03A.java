	package es.maos17.cdr.programacion.ut03.ejercicios.Array2D;
	/*
	 * Escribe un programa que:
	● Pida al usuario un número n
	● Cree un array de dos dimensiones de n filas y n columnas
	● Rellene el array con números aleatorios menores que 10
	● Presente el array en pantalla
	● Trasponga el array (las filas pasan a columnas y las columnas a filas)
	● Vuelva a presentar el array en pantalla
	*/
	
	import java.util.Random;
	import java.util.Scanner;
	
	public class Ejercicio03A {
		private static int VALOR_MAXIMO = 9;
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Tamaño de la matriz: ");
			int n = sc.nextInt();
			// Creamos array
			int[][] matriz = new int[n][n];
			rellenarConAleatorios(matriz);
			// Mostramos valor inicial
			System.out.println("Matriz inicial");
			mostrarMatriz(matriz);
			// Trasponemos la matriz
			trasponerMatriz(matriz);
			// Mostramos valor final
			System.out.println("Matriz traspuesta");
			mostrarMatriz(matriz);
	
		}
	
		private static void rellenarConAleatorios(int[][] array) {
			Random aleatorio = new Random();
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = aleatorio.nextInt(VALOR_MAXIMO + 1);
				}
			}
		}
	
		private static void mostrarMatriz(int[][] array) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.printf("%d ", array[i][j]);
				}
				System.out.println();
			}
		}
		
		private static void trasponerMatriz(int[][] matriz) {
			//Variable auxiliar para intercambios
			int auxiliar = 0;
			/* En este caso no vamos a utilizar una segunda matriz para trasponer
			Al empezar j en i + 1, solo recorremos la diagonal superior de la matriz.
			Intercambiamos el elemento [i][j] (arriba de la diagonal) con su simétrico [j][i] (debajo de la diagonal).
			Los elementos de la diagonal principal (donde i == j) no se tocan */
			for (int i = 0; i < matriz.length; i++)
				for (int j = i + 1; j < matriz[i].length; j++) {
					auxiliar = matriz[i][j];
					matriz[i][j] = matriz[j][i];
					matriz[j][i] = auxiliar;
				}
		}
	}
