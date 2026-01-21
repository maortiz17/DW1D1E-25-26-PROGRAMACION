package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo11interfaces;

public class Perro implements Imprimible {
	private String nombre;

	public Perro(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void imprimir() {
		System.out.println(this.nombre);
	}

}
