package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio18.instrumentos;

public abstract class Instrumento {
	private final String propietario;
	private final int dificultad;
	
	public Instrumento(String propietario, int dificultad) {
		this.propietario = propietario;
		this.dificultad = dificultad;
	}

	public String getPropietario() {
		return propietario;
	}

	public int getDificultad() {
		return dificultad;
	}
	
	public abstract void tocar();
	
	public abstract void parar();
	
	public boolean esMasDificil(Instrumento instrumento) {
		return this.dificultad > instrumento.dificultad;
	}
}
