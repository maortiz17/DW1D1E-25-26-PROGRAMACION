package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio09.clases;

public abstract class Conica extends Figura {
	private double semiejeMayor;
	private double semiejeMenor;
	

	public Conica(double semiejeMayor, double semiejeMenor) {
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
