package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio16;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellidos;
	
	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	
	@Override
	public int compareTo(Persona p) {
		return this.toString().compareTo(p.toString());
	}
}
