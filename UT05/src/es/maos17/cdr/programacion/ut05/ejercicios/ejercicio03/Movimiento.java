package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio03;

import java.time.LocalDateTime;

public class Movimiento implements Comparable<Movimiento>{
	private TipoMovimiento tipoMovimiento;
	private LocalDateTime fechaHora;
	private double saldoInicial;
	private double importe;
	private double saldoFinal;
	private String concepto;
	public Movimiento(TipoMovimiento tipoMovimiento, double importe, double saldoInicial,
			String concepto) {
		if ((tipoMovimiento == TipoMovimiento.INGRESO || tipoMovimiento == TipoMovimiento.TRANSFERENCIA_FAVOR) 
			&& importe <= 0) {
			throw new IllegalArgumentException("El importe debe ser positivo en este tipo de operación");
		}
		if ((tipoMovimiento == TipoMovimiento.REINTEGRO || tipoMovimiento == TipoMovimiento.TRANSFERENCIA_OTRA_CUENTA) 
				&& importe >= 0) {
				throw new IllegalArgumentException("El importe debe ser negativo en este tipo de operación");
		}
		this.tipoMovimiento = tipoMovimiento;
		this.saldoInicial = saldoInicial;
		this.importe = importe;
		this.concepto = concepto;
		this.fechaHora = LocalDateTime.now();
		this.saldoFinal = saldoInicial + importe;
		
		
	}
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public double getSaldoInicial() {
		return saldoInicial;
	}
	public double getImporte() {
		return importe;
	}
	public double getSaldoFinal() {
		return saldoFinal;
	}
	public String getConcepto() {
		return concepto;
	}
	
	@Override
	public String toString() {
		return String.format("<%s> - %s - %.2f - %.2f - %.2f\n", fechaHora, tipoMovimiento.name(), saldoInicial, importe, saldoFinal);
	}
	
	@Override
	public int compareTo(Movimiento other) {
		return fechaHora.compareTo(other.getFechaHora());
	}
}
