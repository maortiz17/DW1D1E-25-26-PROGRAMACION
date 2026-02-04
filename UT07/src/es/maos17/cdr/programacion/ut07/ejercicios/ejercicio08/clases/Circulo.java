package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio08.clases;

public class Circulo extends Figura {
	// Atributos propios
	private double radio;
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	// Implementamos métodos abstractos de la clase base
	@Override
	public double perimetro() {
		return 2 * Math.PI * radio;
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow(radio, 2);
	}
}
