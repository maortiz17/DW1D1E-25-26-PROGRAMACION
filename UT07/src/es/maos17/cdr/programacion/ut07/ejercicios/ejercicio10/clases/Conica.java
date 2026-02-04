package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio10.clases;

public abstract class Conica extends Figura {
	private static final int NUM_LADOS = 0;
	
	private double semiejeMayor;
	private double semiejeMenor;
	

	public Conica(double semiejeMayor, double semiejeMenor) {
		super(NUM_LADOS);
		this.semiejeMayor = semiejeMayor;
		this.semiejeMenor = semiejeMenor;
	}
	
	double getSemiejeMenor() {
		return semiejeMenor;
	}
	
	double getSemiejeMayor() {
		return semiejeMayor;
	}
	
	@Override
	public double area() {
		return Math.PI * this.semiejeMayor * this.semiejeMenor;
	}
}
