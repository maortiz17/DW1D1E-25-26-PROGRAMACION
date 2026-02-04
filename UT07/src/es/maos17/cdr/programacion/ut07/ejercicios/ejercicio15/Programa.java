package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio15;
import java.util.Arrays;
import java.util.Locale;

import net.datafaker.Faker;
public class Programa {


	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("es"));
		String[] nombres = new String[10];
		
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = faker.name().firstName();
		}
		System.out.println("Antes de ordenar");
		System.out.println(Arrays.toString(nombres));
		
		Arrays.sort(nombres);
		
		System.out.println("Después de ordenar");
		System.out.println(Arrays.toString(nombres));
	}

}
