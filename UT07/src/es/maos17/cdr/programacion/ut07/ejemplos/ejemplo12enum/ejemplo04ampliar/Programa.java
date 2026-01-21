package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo12enum.ejemplo04ampliar;

public class Programa {

	public static void main(String[] args) {

		for (Potencia potencia : Potencia.values()) {
			System.out.printf("La descripción de %s es '%s'\n", 
					potencia, potencia.getDescripcion());
		}

	}
}

