package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo12enum.ejemplo04ampliar;

public enum Potencia {
	ALTA("Más de 1000W"), 
	MEDIA("Entre 300 y 1000W"), 
	BAJA("Menos de 300W");

	private String descripcion;

	private Potencia(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}
}
