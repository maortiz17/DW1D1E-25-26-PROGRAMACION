package es.maos17.cdr.programacion.ut02.ejemplos;

import java.util.Scanner;

public class Ejemplo06OperadorTernario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Pedimos un número y dos mensajes
		// Uno para positivos y cero y otro para negativos
		System.out.print("Introduce un número: ");
		int numero = sc.nextInt();
		sc.nextLine(); // Consumimos el intro
		System.out.print("Introduce mensaje para positivos: ");
		String mensajePositivos = sc.nextLine();
		System.out.print("Introduce mensaje para negativos: ");
		String mensajeNegativos = sc.nextLine();
		
		// Mostramos un mensaje y otro en función del contenido de numero
		String mensaje = (numero >= 0) ? mensajePositivos : mensajeNegativos;
		
		System.out.println(mensaje);
		
		// Lo anterior en una sola línea
		// System.out.println((numero >= 0) ? mensajePositivos : mensajeNegativos);
	}

}
