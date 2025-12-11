package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochila1;

public class Objeto {

	private String nombre;
	private int cantidad;
	private TipoMaterial tipo;

	public Objeto(String nombre, int cantidad, TipoMaterial tipo) {
		this.nombre = nombre;
		if (cantidad > tipo.getCapacidadMaxima()) {
			this.cantidad = tipo.getCapacidadMaxima();
		} else {
			this.cantidad = cantidad;
		}
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public TipoMaterial getTipo() {
		return tipo;
	}

	public int incrementarCantidad(int cantidad) {

		int total = this.cantidad + cantidad;
		int max = this.tipo.getCapacidadMaxima();

		if (this.cantidad < max) {
			if (total <= max) {
				this.cantidad = total;
				return 0;
			} else {
				this.cantidad = max;
				return total - max;
			}
		} else {
			return cantidad;
		}
	}

	public void decrementarCantidad(int cantidad) {
		this.cantidad -= cantidad;
		if (this.cantidad < 0) {
			this.cantidad = 0;
		}
	}

	@Override
	public String toString() {
		return "[" + nombre + "] x" + cantidad + " (Max: " + tipo.getCapacidadMaxima() + ")";
	}

}
