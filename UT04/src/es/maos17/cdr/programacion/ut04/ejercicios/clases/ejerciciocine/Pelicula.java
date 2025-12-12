package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciocine;

public class Pelicula {
	private String titulo;
	private int duracionMinutos;
	private double precioEntrada;
	
	public Pelicula(String titulo, int duracionMinutos, double precioEntrada) {
		this.titulo = titulo;
		this.duracionMinutos = duracionMinutos;
		this.precioEntrada = precioEntrada;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}
	
}
