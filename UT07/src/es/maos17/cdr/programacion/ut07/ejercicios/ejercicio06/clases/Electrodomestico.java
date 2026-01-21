package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases;

public abstract class Electrodomestico {
	private static final double PRECIO_BASE_DEFECTO = 100;
	private static final Color COLOR_DEFECTO = Color.BLANCO;
	private static final Consumo CONSUMO_DEFECTO = Consumo.F;
	private static final double PESO_DEFECTO = 5;

	private double precioBase;
	private Color color;
	private Consumo consumo;
	private double pesoKg;

	public Electrodomestico() {
		this(PRECIO_BASE_DEFECTO, COLOR_DEFECTO, CONSUMO_DEFECTO, PESO_DEFECTO);
	}

	public Electrodomestico(double precioBase, double pesoKg) {
		this(precioBase, COLOR_DEFECTO, CONSUMO_DEFECTO, pesoKg);
	}

	public Electrodomestico(double precioBase, Color color, Consumo consumo, double pesoKg) {
		// A este constructor es al que llaman el resto de constructores de la clase
		this.precioBase = precioBase;
		this.color = color;
		this.consumo = consumo;
		this.pesoKg = pesoKg;
	}

	double getPrecioBase() {
		return precioBase;
	}
	
	public double getPesoKg() {
		return pesoKg;
	}

	public double getPrecioFinal() {
		double precioFinal = this.precioBase;
		precioFinal += consumo.getIncrementoPorConsumo();
		precioFinal += calcularIncrementoPorPeso();
		return precioFinal;
	}

	private double calcularIncrementoPorPeso() {
		if (this.pesoKg >= 80) {
			return IncrementosPrecio.INCREMENTO_PESO_80_MAS;
		}
		if (this.pesoKg >= 50) {
			return IncrementosPrecio.INCREMENTO_PESO_50_80;
		}
		if (this.pesoKg >= 20) {
			return IncrementosPrecio.INCREMENTO_PESO_20_50;
		}
		return IncrementosPrecio.INCREMENTO_PESO_0_20;
	}
}
