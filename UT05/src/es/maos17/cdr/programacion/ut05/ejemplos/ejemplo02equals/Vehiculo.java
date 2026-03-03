package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo02equals;

public class Vehiculo {
	private String matricula;
	private String marca;
	private Color color;

	public Vehiculo(String matricula, String marca, Color color) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public Color getColor() {
		return color;
	}
}
