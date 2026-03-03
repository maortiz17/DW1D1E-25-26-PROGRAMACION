package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo01genericos;

import java.util.Arrays;

public class Programa {
	public static void main(String[] args) {
		String[] nombres = {"Miguel", "Ana", "María", "Javier"};
		Integer[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Tienen que ser clases, no primitivos. Para primitivos utilizamos clases wrapper
		
		System.out.println(MetodoGenerico.obtenerElemento(nombres, 2));
		System.out.println(MetodoGenerico.obtenerElemento(numeros, 4));
		
		ClaseGenerica<String> cadenas = new ClaseGenerica<>();
		ClaseGenerica<Integer> enteros= new ClaseGenerica<>();
		
		cadenas.invertirArray(nombres);
		enteros.invertirArray(numeros);
		
		System.out.println(Arrays.toString(nombres));
		System.out.println(Arrays.toString(numeros));
		
		// cadenas.invertirArray(numeros); Esto no compila, porque el objeto cadenas solo trabaja con arrays de tipo String
	}
	
}
