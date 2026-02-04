package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio20.clases;

public class Rombo extends Figura {
	private static final int NUM_LADOS = 4;
	
	private double diagonalMayor;
	private double diagonalMenor;

	public Rombo(double diagonalMayor, double diagonalMenor) {
		super(NUM_LADOS);
		this.diagonalMayor = diagonalMayor;
		this.diagonalMenor = diagonalMenor;
	}

	@Override
	public double perimetro() {
		return 2 * Math.sqrt(Math.pow(this.diagonalMayor, 2) + Math.pow(this.diagonalMenor, 2));
	}

	@Override
	public double area() {

		return this.diagonalMayor * this.diagonalMenor / 2;
	}
	
	@Override
	public void escalar(double factor) {
		this.diagonalMayor *= 2;
		this.diagonalMenor *= 2;
	}
}
