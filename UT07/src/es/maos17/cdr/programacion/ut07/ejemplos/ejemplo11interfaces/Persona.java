package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo11interfaces;

public class Persona implements Imprimible {
	private String dni;
	private String nombre;

	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	@Override
	public void imprimir() {
		System.out.printf("%s - %s\n", this.dni, this.nombre);

	}

}
