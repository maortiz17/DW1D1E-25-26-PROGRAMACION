package ejemplos.ejemplo10;

import java.util.ArrayList;
import java.util.List;

import ejemplos.ejemplo01.Persona;

public class Ejemplo10 {

	public static void main(String[] args) {
		Persona p1 = new Persona("pedro", "perez", 20);
		Persona p2 = new Persona("ana", "blanco", 15);
		Persona p3 = new Persona("miguel", "alvarez", 50);

		List<Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);

		// Eliminamos los menores de edad mediante un filtro (predicate)
		// Si la lambda devuelve 'true', el elemento se "destruye".
		lista.removeIf(p -> p.getEdad() < 18);
		// Utilizamos un consumer para imprimir la lista de salida
		lista.forEach(System.out::println);
	}

}
