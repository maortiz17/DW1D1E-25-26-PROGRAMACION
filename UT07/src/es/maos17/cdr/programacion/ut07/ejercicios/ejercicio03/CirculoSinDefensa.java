package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio03;

public class CirculoSinDefensa {
	// Atributos
	private final String nombre;
	private Punto centro;
	private int radio;
	
	// Constructores
	public CirculoSinDefensa(Punto centro, int radio, String nombre) {
		if (radio <= 0) {
			throw new IllegalArgumentException("El radio tiene que ser un entero positivo");
		}
		this.centro = centro;
		this.radio = radio;
		this.nombre = nombre;
	}
	
	public CirculoSinDefensa(int x, int y, int radio, String nombre) {
		this(new Punto(x, y), radio, nombre);
	}

	public String getNombre() {
		return nombre;
	}

	// Hacemos los círculos inmutables (no hay métodos setter)
	public Punto getCentro() {
		return centro;
	}

	public int getRadio() {
		return radio;
	}

	@Override
	public String toString() {
		return "Circulo " + nombre + " [centro=(" + centro.getX() + ", " + centro.getY() + "), radio=" + radio + "]";
	}
	
	
}
