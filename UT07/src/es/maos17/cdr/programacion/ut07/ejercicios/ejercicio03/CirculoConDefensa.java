package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio03;

public class CirculoConDefensa {
	// Atributos
	private final String nombre;
	private Punto centro;
	private int radio;
	
	// Constructores
	public CirculoConDefensa(Punto centro, int radio, String nombre) {
		if (radio <= 0) {
			throw new IllegalArgumentException("El radio tiene que ser un entero positivo");
		}
		setCentro(centro); // Llamamos al setter para que se realice copia del objeto no accesible 
		this.radio = radio;
		this.nombre = nombre;
	}
	
	public CirculoConDefensa(int x, int y, int radio, String nombre) {
		this(new Punto(x, y), radio, nombre);
	}

	public void setCentro(Punto centro) {
		this.centro = new Punto(centro); // Creamos una copia del objeto Punto no accesible
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	// getters y setters
	public Punto getCentro() {
		return new Punto(centro); // Devolvemos copia del objeto, no la referencia real
	}

	public int getRadio() {
		return radio;
	}

	@Override
	public String toString() {
		return "Circulo " + nombre + " [centro=(" + centro.getX() + ", " + centro.getY() + "), radio=" + radio + "]";
	}
	
	
}
