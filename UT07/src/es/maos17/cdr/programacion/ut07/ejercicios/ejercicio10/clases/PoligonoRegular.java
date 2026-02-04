package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio10.clases;

public class PoligonoRegular extends Figura {
	
	private int numLados;
	private double apotema;
	private double lado;

	public PoligonoRegular(int numLados, double apotema, double lado) {
		super(numLados);
		this.apotema = apotema;
		this.lado = lado;
	}

	@Override
	public double perimetro() {
		return this.lado * numLados;
	}

	@Override
	public double area() {
		return this.perimetro() * this.apotema / 2;
	}

}
