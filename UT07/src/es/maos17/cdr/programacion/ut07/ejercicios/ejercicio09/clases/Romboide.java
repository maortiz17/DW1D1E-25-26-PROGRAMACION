package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio09.clases;

public class Romboide extends Paralelogramo {
	private double ladoOblicuo;
	
	public Romboide(double base, double altura, double ladoOblicuo) {
		super(base, altura);
		this.ladoOblicuo = ladoOblicuo;
	}
	
	@Override
	public double perimetro() {
		return 2 * (getBase()+ ladoOblicuo);
	}
}
