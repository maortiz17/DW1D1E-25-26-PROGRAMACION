package es.maos17.cdr.programacion.ut02.ejemplos;

import java.util.Scanner;

public class Ejemplo09For {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce una cadena: ");
		
		String cadena = sc.nextLine();
		
		/* boolean encontrado = false; // Controla la búsqueda
		
		for (int i = 0; i < cadena.length() && !encontrado; i++) { // Busco hasta que encuentre o se acabe la cadena
			if (cadena.charAt(i) == 'Z')
				encontrado = true;
		}
		
		System.out.println(encontrado ? "Había una Z" : "No había una Z");
		*/
		int contador = 0;
		for (int i = 0; i < cadena.length(); i++) { // Busco hasta que encuentre o se acabe la cadena
			if (cadena.charAt(i) == 'Z')
				contador++;
		}
		
		System.out.println("Había " + contador + " zetas");
		
	}

}
