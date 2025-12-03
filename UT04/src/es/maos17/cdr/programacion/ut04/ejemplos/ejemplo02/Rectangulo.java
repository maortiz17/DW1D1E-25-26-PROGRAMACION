package es.maos17.cdr.programacion.ut04.ejemplos.ejemplo02;

public class Rectangulo {
	// Atributos
	// Constantes estáticas
	public static final String NOMBRE_FIGURA = "Rectángulo";
	// Vértice 1
	private int x1;
	private int y1;
	// Vértice 2
	private int x2;
	private int y2;
	// Nombre del rectángulo
	private String nombre;
	// Número de rectángulos
	private static int numeroRectangulos;
	// Getters y setters de los atributos
	
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return this.y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static int getNumeroRectangulos() {
		return numeroRectangulos;
	}
	
	// Métodos
	public int calcularSuperficie() {
		
		int base = x2 - x1;
		int altura = y2 - y1;
		int superficie =  multiplicar(base, altura);
		return superficie;
	}
public int calcularPerimetro() {
		
		int base = x2 - x1;
		int altura = y2 - y1;
		int perimetro =  2 * (base + altura);
		return perimetro;
	}

public void desplazar(int x, int y) {
	this.x1 += x;
	this.x2 += x;
	this.y1 += y;
	this.y2 += y;
}
	
private int multiplicar(int n1, int n2) {
	return n1 * n2;
}
	
}
