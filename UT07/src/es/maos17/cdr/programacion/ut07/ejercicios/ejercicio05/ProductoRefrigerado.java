package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoRefrigerado extends Producto {
	private String codigoSupervisor;
	
	public ProductoRefrigerado(LocalDate fechaCaducidad, int lote, String codigoSupervisor) {
		super(fechaCaducidad, lote);
		this.codigoSupervisor = codigoSupervisor;
	}
	
	public String getCodigoSupervisor() {
		return codigoSupervisor;
	}
	
	public void setCodigoSupervisor(String codigoSupervisor) {
		this.codigoSupervisor = codigoSupervisor;
	}
	
	@Override
	public String toString() {
		return String.format("%s. Regulado por %s.", super.toString(), this.codigoSupervisor);
	
	}
}
