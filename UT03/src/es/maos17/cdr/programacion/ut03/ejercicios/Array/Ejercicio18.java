package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Scanner;

/*Crea un programa que permita mostrar el resultado de una jornada de competición deportiva.
Para ello, el programa:
● Preguntará cuantos partidos ha habido en la jornada.
● Para cada partido preguntará:
o Equipo local
o Equipo visitante
o Resultado (1, X, 2)
● Mostrará el resultado de la jornada, mostrando para cada partido los equipos que
compitieron y el resultado.
Ten en cuenta:
● Se debe usar tres arrays, uno para los nombres de los equipos locales, otro para el
nombre de los equipos visitantes, y otro para el resultado.
● Se debe mostrar el resultado con un partido en cada línea. Por ejemplo:
o Arapiles – Prosperidad – X
*/
public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Solicitamos el número de partidos
		System.out.print("¿Cuántos partidos hay esta jornada?: ");
		int numPartidos = sc.nextInt();
		// Creamos los arrays
		String[] locales = new String[numPartidos];
		String[] visitantes = new String[numPartidos];
		char[] resultados = new char[numPartidos];
		// Rellenamos los arrays
		sc.nextLine(); // Vaciamos el buffer de teclado
		for (int i = 0; i < locales.length; i++) {
			System.out.print("Introduzca el equipo local: ");
			locales[i] = sc.nextLine();
			System.out.print("Introduzca el equipo visitante: ");
			visitantes[i] = sc.nextLine();
			System.out.print("Introduzca resultado (1-X-2): ");
			resultados[i] = sc.nextLine().charAt(0);
		}
		
		mostrarResultados(locales, visitantes, resultados);
	}
	
	private static void mostrarResultados(String[] locales, String[] visitantes, char[] resultados) {
		for (int i = 0; i < locales.length; i++) {
			System.out.printf("%s - %s - %c\n",  locales[i], visitantes[i], resultados[i]);
		}
	}

}
