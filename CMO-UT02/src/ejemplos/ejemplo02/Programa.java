package ejemplos.ejemplo02;

import java.util.ArrayList;
import java.util.Comparator;
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
		
		lista.sort(new Comparator<Persona>() {
			@Override
			public int compare(Persona p1, Persona p2) {
				return Integer.compare(p1.getEdad(), p2.getEdad());
			}
		});
		
		for (Persona p : lista) {
			System.out.println(p);
		}

	}

}
