package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio05;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	private int temperaturaCongelacion;
	
	public ProductoCongelado(LocalDate fechaCaducidad, int lote, int temperaturaCongelacion) {
		super(fechaCaducidad, lote);
		this.temperaturaCongelacion = temperaturaCongelacion;
	}

	public int getTemperaturaCongelacion() {
		return temperaturaCongelacion;
	}

	public void setTemperaturaCongelacion(int temperaturaCongelacion) {
		this.temperaturaCongelacion = temperaturaCongelacion;
	}
	
	@Override
	public String toString() {
		return String.format("%s. Congelado a %s.", super.toString(), this.temperaturaCongelacion);
	}
	
}
