package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio09.clases;

public abstract class Paralelogramo extends Figura {

	// Atributos
	private double base;
	private double altura;
	
	// Constructor
	public Paralelogramo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	// Implementamos aquí los métodos abstractos de la superclase
	@Override
	public double perimetro() {
		return 2 * (base + altura);
	}
	@Override
	public double area() {
		return base * altura;
	}
	
	protected double getBase() {
		return base;
	}
}
