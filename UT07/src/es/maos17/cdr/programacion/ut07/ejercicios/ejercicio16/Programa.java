package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio16;

import java.util.Arrays;
import java.util.Locale;

import net.datafaker.Faker;

public class Programa {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("es"));
		Persona[] personas = new Persona[10];
		
		for (int i = 0; i < personas.length; i++) {
			personas[i] = new Persona(faker.name().firstName(), faker.name().lastName());
		}

		System.out.println("Antes de ordenar");
		System.out.println(Arrays.toString(personas));
		
		Arrays.sort(personas);
		System.out.println("Después de ordenar");
		System.out.println(Arrays.toString(personas));

	}

}
