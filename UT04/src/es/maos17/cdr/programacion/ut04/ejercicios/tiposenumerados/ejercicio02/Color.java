package es.maos17.cdr.programacion.ut04.ejercicios.tiposenumerados.ejercicio02;

public enum Color {
	ROJO("la pasión"),
	AZUL("la calma"),
	VERDE("la frescura"),
	NEGRO("el misterio"),
	AMARILLO("el peligro");
	
	private final String sensacion;
	
	private Color(String sensacion) {
		this.sensacion = sensacion;
	}

	public String getSensacion() {
		return sensacion;
	}
	
}
