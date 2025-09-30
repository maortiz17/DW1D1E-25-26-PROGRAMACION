package es.maos17.cdr.programacion.ut01.ejemplos;

import java.util.Scanner;

public class Ejemplo09DNI {

	public static void main(String[] args) {
		// Constantes
		final int NUMERO_DIVISOR = 23;
		final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

		System.out.println("Hola".charAt("Hola".length() - 1));
		
		// Objeto Scanner para lecturas desde teclado
		Scanner sc = new Scanner(System.in);
		
		// Solicitamos número y calculamos letra
		System.out.print("Introduzca su número de DNI: ");
		int numeroDNI = sc.nextInt();
		
		System.out.printf("Tu letra es: %c\n", LETRAS_DNI.charAt(numeroDNI % NUMERO_DIVISOR));

		// Solicitamos DNI completo
		sc.nextLine();
		System.out.print("Introduzca su DNI: ");
		String DNI = sc.nextLine();
		
		char letra = DNI.charAt(DNI.length() - 1);
		int numero = Integer.valueOf(DNI.substring(0, DNI.length() - 1));
		
		char letraCalculada = LETRAS_DNI.charAt(numero % NUMERO_DIVISOR);
		
		System.out.println(letra == letraCalculada? "Correcto" : "Incorrecto");
		
	}

}
