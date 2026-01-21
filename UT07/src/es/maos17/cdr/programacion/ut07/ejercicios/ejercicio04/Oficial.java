package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio04;

public class Oficial extends Operario {
	public Oficial() {
		super();
	}
	
	public Oficial (String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + "-> Operario -> Oficial";
	}
}
