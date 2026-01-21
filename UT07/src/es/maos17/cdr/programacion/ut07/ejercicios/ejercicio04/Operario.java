package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio04;

public class Operario extends Empleado {

	public Operario(String nombre) {
		super(nombre);
	}
	
	public Operario() {
		super();
	}
	
	@Override
	public String toString() {
		return super.toString() + "-> Operario";
	}
}
