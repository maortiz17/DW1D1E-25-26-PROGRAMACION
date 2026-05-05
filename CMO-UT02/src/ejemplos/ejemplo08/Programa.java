package ejemplos.ejemplo08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import ejemplos.ejemplo01.Persona;

public class Programa {

	// METHOD REFERENCES
	public static void main(String[] args) {
		// En forma de lambda
		Function<String, Integer> conversorLambda = s -> Integer.parseInt(s);
		// Method reference a método estático de la clase Integer
		Function<String, Integer> conversorRef = Integer::parseInt;
		
		int a = conversorRef.apply("33");
		
		// Method reference a método de un objeto particular
		Persona p1 = new Persona("pedro", "perez", 20);
		Persona p2 = new Persona("ana", "blanco", 15);
		Persona p3 = new Persona("miguel", "alvarez", 50);

		List<Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		// En forma de lambda
		lista.forEach(p -> System.out.println(p));
		// Method reference a método del objeto out de la clase PrintStream
		lista.forEach(System.out::println);
		
		System.out.println("-".repeat(100));
		// Method reference a método de instancia de objeto arbitrario
		// En forma de lambda
		lista.sort(Comparator.comparingInt(p -> p.getEdad()));
		// Method reference al método getEdad a través del nombre de la clase (aunque no es estático)
		lista.sort(Comparator.comparingInt(Persona::getEdad));
		lista.forEach(System.out::println);
	}

}
