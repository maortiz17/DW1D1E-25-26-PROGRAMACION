package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio04;

public class Tecnico extends Operario {

	public Tecnico (String nombre) {
		super(nombre);
	}
	
	public Tecnico() {
		super();
	}
	
	@Override
	public String toString() {
		return super.toString() + "-> Operario -> Tecnico";
	}
}
