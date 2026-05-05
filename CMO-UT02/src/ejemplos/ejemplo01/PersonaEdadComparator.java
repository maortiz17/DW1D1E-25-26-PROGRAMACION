package ejemplos.ejemplo01;

import java.util.Comparator;

public class PersonaEdadComparator implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return Integer.compare(p1.getEdad(), p2.getEdad());
	}

}
