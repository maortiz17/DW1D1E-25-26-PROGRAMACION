package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Programa {
	private static final int LIMITE_NUMEROS = 10;
	private static final int CANTIDAD_NUMEROS = 20;

	public static void main(String[] args) {
		Random rnd = new Random();

		List<Integer> listaNumeros = new ArrayList<>(CANTIDAD_NUMEROS);

		System.out.println("Tamaño de la lista antes de insertar: " + listaNumeros.size());

		while (listaNumeros.size() < CANTIDAD_NUMEROS) {
			listaNumeros.add(rnd.nextInt(LIMITE_NUMEROS) + 1);
		}
		System.out.println("El tamaño de la lista después de insertar es " + listaNumeros.size());

		// Mostrar lista
		System.out.println(listaNumeros);

		// Copia de la lista
		List<Integer> listaEliminarFinal = new ArrayList<>(listaNumeros);
		// Eliminar duplicados al final
		eliminarDuplicadosAlFinal(listaEliminarFinal);
		// Mostrar la lista de nuevo
		System.out.println(listaEliminarFinal);

		// Copia de la lista
		List<Integer> listaEliminarPrincipio = new ArrayList<>(listaNumeros);
		// Eliminar duplicados al principio
		eliminarDuplicadosAlPrincipio(listaEliminarPrincipio);
		// Mostrar la lista de nuevo
		System.out.println(listaEliminarPrincipio);

		// Copia de la lista
		List<Integer> listaEliminarPrincipioV2 = new ArrayList<>(listaNumeros);
		// Eliminar duplicados al principio
		eliminarDuplicadosAlPrincipioV2(listaEliminarPrincipioV2);
		// Mostrar la lista de nuevo
		System.out.println(listaEliminarPrincipioV2);
	}

	public static <T> void eliminarDuplicadosAlFinal(List<T> numeros) {
		List<T> yaAparecidos = new ArrayList<>();
		Iterator<T> it = numeros.iterator();
		while (it.hasNext()) {
			T numero = it.next();
			if (!yaAparecidos.contains(numero)) {
				yaAparecidos.add(numero);
			} else {
				it.remove();
			}
		}
	}

	public static <T> void eliminarDuplicadosAlPrincipio(List<T> numeros) {
		List<T> yaAparecidos = new ArrayList<>();

		/*
		 * Método listIterator(int index) de List<E>: Devuelve un iterador de lista
		 * (ListIterator) sobre los elementos de esta lista (en la secuencia correcta),
		 * comenzando en la posición especificada en la lista.
		 * 
		 * ListIterator<E> es una interfaz que hereda de Iterator<E>
		 * 
		 * Un iterador para listas permite recorrer la lista en cualquier dirección,
		 * modificarla durante la iteración y obtener su posición actual. Un
		 * ListIterator no tiene ningún elemento actual; la posición de su cursor
		 * siempre se encuentra entre el elemento que devolvería una llamada a
		 * previous() y el que devolvería una llamada a next().
		 * 
		 * Ten en cuenta que los métodos remove() y set(Object) no se definen en función
		 * de la posición del cursor; operan sobre el último elemento devuelto por una
		 * llamada a next() o previous().
		 */
		ListIterator<T> it = numeros.listIterator(numeros.size()); // Nos posicionamos al final de la lista (más
																			// allá del último elemento)

		while (it.hasPrevious()) {
			T numero = it.previous();
			if (yaAparecidos.contains(numero)) {
				it.remove();
			} else {
				yaAparecidos.add(numero);
			}
		}
	}
	
	public static <T> void eliminarDuplicadosAlPrincipioV2(List<T> numeros) {
		// Aprovechamos el método anterior. Damos la vuelta a la lista dos veces
		Collections.reverse(numeros);
		eliminarDuplicadosAlFinal(numeros);
		Collections.reverse(numeros);
	}

}
