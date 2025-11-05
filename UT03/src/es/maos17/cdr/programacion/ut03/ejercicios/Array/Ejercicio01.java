package es.maos17.cdr.programacion.ut03.ejercicios.Array;

/*Declara un array de números enteros. Créalo usando la palabra reservada new, de forma
que tenga un tamaño de 5 posiciones.
Llena el array (las 5 posiciones) con números. Elige los números que quieras. Muestra el
valor de la tercera y cuarta posición del array. Recuerda que para acceder a la primera
posición del array se accede a la posición 0.*/
public class Ejercicio01 {

	public static void main(String[] args) {
		int[] numeros = new int[5];
		
		numeros[0] = 3;
		numeros[1] = 6;
		numeros[2] = 9;
		numeros[3] = 7;
		numeros[4] = 5;
		// numeros[5] = 10; // Lanza una excepción de índice fuera de límites
		System.out.printf("La tercera posición (índice 2) es %d, y la cuarta (índice 3) es %d.\n", numeros[2], numeros[3]);

	}

}
