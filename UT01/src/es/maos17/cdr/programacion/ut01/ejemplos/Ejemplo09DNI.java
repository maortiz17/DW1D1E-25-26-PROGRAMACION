package es.maos17.cdr.programacion.ut01.ejemplos;

import java.util.Scanner;

public class Ejemplo09DNI {

	public static void main(String[] args) {
		// Constantes
		final int NUMERO_DIVISOR = 23;
		final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE"; // <- Letras ordenadas.
		/* En la constante anterior LETRAS_DNI(0) = 'T' ... LETRAS_DNI(22) = 'E' */

		System.out.println("Hola".charAt("Hola".length() - 1));
		
		// Objeto Scanner para lecturas desde teclado
		Scanner sc = new Scanner(System.in);
		
		// Solicitamos número y calculamos letra
		System.out.print("Introduzca su número de DNI: ");
		int numeroDNI = sc.nextInt();
		
		/*El resto de la división entera entre el número introducido y 23 me da
		 * el índice de la constante LETRAS_DNI con la letra correcta
		 */
		System.out.printf("Tu letra es: %c\n", LETRAS_DNI.charAt(numeroDNI % NUMERO_DIVISOR));

		// Solicitamos DNI completo
		sc.nextLine();
		System.out.print("Introduzca su DNI: ");
		String DNI = sc.nextLine();
		
		// La letra del DNI es el último carácter introducido
		char letra = DNI.charAt(DNI.length() - 1);
		/* El resto de la cadena desde la posición 0 será el número
		 * que conviento en entero para poder operar con él
		 * El método substring devuelve objeto de clase String que convierto
		 * en entero con el método estático valueOf de la clase wrapper Integer
		 */
		int numero = Integer.valueOf(DNI.substring(0, DNI.length() - 1));
		
		// Calculo la letra a partir del número con el mismo algoritmo
		char letraCalculada = LETRAS_DNI.charAt(numero % NUMERO_DIVISOR);
		
		// Compruebo si la letra introducida y la calculada coinciden
		System.out.println(letra == letraCalculada? "Correcto" : "Incorrecto");
		
	}

}
