package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio03;

public class Punto {
	private int x;
	private int y;
	
	// Constructor
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Punto(Punto punto) { // Constructor de copia
		this(punto.getX(), punto.getY());
	}

	// Los objetos son mutables (hay setters)
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
