package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo13repaso;

public class Geranio extends Vegetal {

	private static final String NOMBRE_ESPECIE = "GERANIO";
	
	@Override
	public void fotosintesis(int cantidadLuz) {
		System.out.printf("Soy un %s y estoy procesando %s lux\n", NOMBRE_ESPECIE, cantidadLuz);
	}

}
