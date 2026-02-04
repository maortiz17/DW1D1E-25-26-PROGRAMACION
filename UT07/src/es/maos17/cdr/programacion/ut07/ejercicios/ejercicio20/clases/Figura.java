package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio20.clases;

public abstract class Figura implements Escalable {
	private int numLados;
	
	//Constructor sin parámetros
	public Figura(int numLados) {
		this.numLados = numLados;
	}
	//Métodos abstractos
	public abstract double perimetro();
	
	public abstract double area();
	
	// Método implementado en su totalidad
	public int getNumLados() {
		return this.numLados;
	}
}
