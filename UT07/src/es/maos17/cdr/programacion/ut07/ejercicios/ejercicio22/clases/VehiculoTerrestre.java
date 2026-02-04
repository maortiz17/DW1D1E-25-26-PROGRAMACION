package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio22.clases;

public abstract class VehiculoTerrestre extends Vehiculo {
	private int numRuedas;

	public VehiculoTerrestre(String nombrePropietario, int numRuedas) {
		super(nombrePropietario);
		this.numRuedas = numRuedas;
	}
	
	public int getNumRuedas() {
		return numRuedas;
	}

}
