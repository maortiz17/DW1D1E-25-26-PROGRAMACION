package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio04;

public class Directivo extends Empleado {
	public Directivo(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Directivo";
	}
}
