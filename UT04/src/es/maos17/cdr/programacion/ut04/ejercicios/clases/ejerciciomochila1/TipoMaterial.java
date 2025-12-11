package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochila1;

public enum TipoMaterial {
	ARMA(1), 
	POCION(5), 
	RECURSO(20);
	
	private final int capacidadMaxima;
	
	private TipoMaterial(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
}
