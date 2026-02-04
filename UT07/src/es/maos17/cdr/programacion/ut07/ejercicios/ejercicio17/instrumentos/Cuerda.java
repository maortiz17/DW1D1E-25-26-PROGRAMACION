package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio17.instrumentos;

public abstract class Cuerda extends Instrumento {

	private final int numCuerdas;
	
	public Cuerda(String propietario, int dificultad, int numCuerdas) {
		super(propietario, dificultad);
		this.numCuerdas = numCuerdas;
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}
	
	

}
