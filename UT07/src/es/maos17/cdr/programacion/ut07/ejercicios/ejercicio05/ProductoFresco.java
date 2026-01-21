package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoFresco extends Producto {
	private LocalDate fechaEnvasado;
	private String paisOrigen;

	public ProductoFresco(LocalDate fechaCaducidad, int lote, LocalDate fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad, lote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}

	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s. Envasado el %s en %s", super.toString(), formatter.format(this.fechaEnvasado), this.paisOrigen);
	}
	
}
