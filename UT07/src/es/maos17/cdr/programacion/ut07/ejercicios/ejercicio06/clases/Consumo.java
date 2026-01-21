package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases;

public enum Consumo {
	A(IncrementosPrecio.INCREMENTO_CONSUMO_A), 
	B(IncrementosPrecio.INCREMENTO_CONSUMO_B), 
	C(IncrementosPrecio.INCREMENTO_CONSUMO_C), 
	D(IncrementosPrecio.INCREMENTO_CONSUMO_D), 
	E(IncrementosPrecio.INCREMENTO_CONSUMO_E), 
	F(IncrementosPrecio.INCREMENTO_CONSUMO_F);
	
	private double incrementoPorConsumo;
	
	private Consumo(double incrementoPorConsumo) {
		this.incrementoPorConsumo = incrementoPorConsumo;
	}
	
	public double getIncrementoPorConsumo() {
		return this.incrementoPorConsumo;
	}
}
