package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio21;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio20.clases.Escalable;

public class Imagen implements Escalable {
	private int ancho;
	private int alto;
	
	public Imagen(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}
	
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		salida.append("-".repeat(ancho) + "\n");
		for (int fila = 0; fila < (alto - 2); fila++) {
			salida.append("|" + " ".repeat(ancho - 2) + "|\n");
		}
		salida.append("-".repeat(ancho) + "\n");
		return salida.toString();
	}
	
	@Override
	public void escalar(double factor) {
		this.ancho *= factor;
		this.alto *= factor;
	}
}
