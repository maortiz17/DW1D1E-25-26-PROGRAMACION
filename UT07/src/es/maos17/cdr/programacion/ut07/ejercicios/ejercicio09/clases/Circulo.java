package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio09.clases;

public class Circulo extends Conica {
	
	public Circulo(double radio) {
		super(radio, radio);
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * this.getSemiejeMayor();
	}
}
