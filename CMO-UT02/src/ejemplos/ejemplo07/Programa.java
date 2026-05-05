package ejemplos.ejemplo07;

import java.util.ArrayList;
import java.util.List;

import ejemplos.ejemplo01.Persona;

public class Programa {

	public static void main(String[] args) {
		Persona p1 = new Persona("pedro", "perez", 20);
		Persona p2 = new Persona("ana", "blanco", 15);
		Persona p3 = new Persona("miguel", "alvarez", 50);

		List<Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		lista.sort((o1, o2) -> Integer.compare(o1.getEdad(), o2.getEdad()));
		
		// Otra forma de hacerlo (Method Reference / Lambda):
        // lista.sort(Comparator.comparing(p -> p.getEdad()));
        
        /* ------------------------------------------------------------------
         * ¿CÓMO FUNCIONA Comparator.comparing INTERNAMENTE?
         * 1. Espera una Function<T, R>. 'T' es Persona (la entrada).
         * 2. 'R' exige un Objeto. Como getEdad() devuelve un primitivo 'int', 
         *    Java hace un "autoboxing" a 'Integer'.
         * 3. Como 'Integer' implementa 'Comparable', Java ya sabe ordenarlos.
         * 
         * TIP: RENDIMIENTO
         * Para evitar crear miles de objetos Integer temporales (autoboxing), 
         * existe una versión óptima para primitivos:
         * 
         *    lista.sort(Comparator.comparingInt(p -> p.getEdad()));
         * 
         * Al usar comparingInt, pasamos una ToIntFunction<T> que devuelve un 
         * 'int' puro, y la ordenación se hace directamente a nivel matemático 
         * usando Integer.compare(x, y).
         * ------------------------------------------------------------------ */
		
		for (Persona p : lista) {
			System.out.println(p);
		}

	}

}
