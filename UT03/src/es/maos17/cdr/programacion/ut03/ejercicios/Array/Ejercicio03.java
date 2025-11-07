package es.maos17.cdr.programacion.ut03.ejercicios.Array;

/*
 * Escribe un programa que:
● Preguntará la cantidad de números que vamos a procesar. Esta cantidad tiene que
ser mayor que cero. Si el usuario introduce un número menor o igual a cero se
mostrará un mensaje de error y se volverá a pedir el número. Se repetirá el proceso
hasta que se introduzca un valor correcto.
● Creará un array del tamaño especificado.
● Pedirá al usuario que introduzca los números uno a uno, y los irá almacenando en el
array.
● Tomará los números que el usuario introdujo, y los mostrará en la consola. Primero
desde el primero al último (el mismo orden en que los introdujo el usuario) y luego
desde el último al primero.
Usa al menos los siguientes métodos:
● pedirCantidadNumeros. Pide al usuario la cantidad de números que se van a
procesar. Se encarga de controlar que es un valor mayor que cero, y de repetir la
pregunta hasta que el usuario introduzca el valor adecuado.
● pedirNumeros. Dos opciones:
○ Recibe un array y pide números al usuario para rellenarlo.
○ Recibe el tamaño del array que queremos crear, y devuelve un array, de ese
tamaño, lleno de números que se preguntan al usuario.
● mostrarNumerosOrdenNormal. Muestra los números del array en el orden en que se
introdujeron.
● mostrarNumerosOrdenInverso. Muestra los números del array en el orden inverso al
que se introdujeron.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cantNumeros = pedirCantidadNumeros(sc);

		int[] matrizNumeros1 = new int[cantNumeros];
		
		pedirNumeros(matrizNumeros1, sc);
		
		int[] matrizNumeros2 = pedirNumeros(cantNumeros, sc);
		
		mostrarNumerosOrdenNormal(matrizNumeros1);
		mostrarNumerosOrdenInverso(matrizNumeros2);
		
	}
	
	private static int pedirCantidadNumeros(Scanner sc) {
		int cantNumeros = 0;
		do {
			System.out.print("¿Cúantos números desea?: ");
			cantNumeros = sc.nextInt();
			if (cantNumeros <= 0) {
				System.err.println("Tiene que ser un número positivo");
			}
		}while (cantNumeros <= 0);
		
		return cantNumeros;
	}
	// Método sobrecargado con las dos versiones del enunciado
	
	// Esta versión recibe el array y lo modifica (parámetro por referencia)
	private static void pedirNumeros(int[] matriz, Scanner sc) {
		System.out.println("Sistema 1");
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("Introduce en número %d: ", i + 1);
			matriz[i] = sc.nextInt();
		}
	}

	// Esta versión devuelve un array creado en el propio método
	private static int[] pedirNumeros(int tam, Scanner sc) {
		System.out.println("Sistema 2");
		int[] matriz = new int[tam];
		for (int i = 0; i < matriz.length; i++) {
			System.out.printf("Introduce en número %d: ", i + 1);
			matriz[i] = sc.nextInt();
		}
		return matriz;
	}
	
	private static void mostrarNumerosOrdenNormal(int[] numeros) {
		System.out.println("Orden normal");
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%d ", numeros[i]);
		}
		System.out.println();
	}
	
	private static void mostrarNumerosOrdenInverso(int[] numeros) {
		System.out.println("Orden inverso");
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.printf("%d", numeros[i]);
		}
		System.out.println();
	}

}
