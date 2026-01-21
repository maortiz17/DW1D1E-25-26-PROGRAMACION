package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo14repaso;

public abstract class Procesador extends Componente{
	private int numeroNucleos;

	public Procesador(String numeroSerie, String nombre, String descripcion, int numeroNucleos) {
		super(numeroSerie, nombre, descripcion);
		this.numeroNucleos = numeroNucleos;
	}
	
	public int getNumeroNucleos() {
		return numeroNucleos;
	}
	
	@Override
	public double getConsumo() {
		return this.getNumeroNucleos()*15;
	}

}
