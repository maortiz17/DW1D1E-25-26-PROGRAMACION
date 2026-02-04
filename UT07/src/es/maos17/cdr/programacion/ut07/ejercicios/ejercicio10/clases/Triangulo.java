package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio10.clases;

public class Triangulo extends Figura {

	private static final int NUM_LADOS = 3;

	// Atributos propios del triángulo
	private double ladoA;
	private double ladoB;
	private double ladoC;
	
	// Constructor
	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super(NUM_LADOS);
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}
	
	@Override
	public double perimetro() {
		return ladoA + ladoB + ladoC;
	}

	@Override
	public double area() {
		// Aplicamos fórmula de Herón
		double semiperimetro = perimetro() / 2;
		return Math.sqrt(semiperimetro * (semiperimetro - ladoA) * (semiperimetro - ladoB) * (semiperimetro - ladoC));
	}
}
