package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo06comparator;

public class Coche extends Vehiculo {
	private boolean electrico;

	public Coche(String matricula, String marca, Color color, boolean electrico) {
		super(matricula, marca, color);
		this.electrico = electrico;
	}
	
	public boolean esElectrico() {
		return electrico;
	}
}
