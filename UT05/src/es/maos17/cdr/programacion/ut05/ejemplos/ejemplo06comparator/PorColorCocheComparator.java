package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo06comparator;

import java.util.Comparator;

public class PorColorCocheComparator implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo v1, Vehiculo v2) {
		return v1.getColor().name().compareTo(v2.getColor().name());
	}

}
