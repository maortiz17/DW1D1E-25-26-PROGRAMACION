package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio12;

public class Moto implements Vehiculo {

	private int velocidad;
	private static final int NUM_PLAZAS = 2;
	
	public Moto() {
		velocidad = 0;
	}
	
	@Override
	public void frenar(int cuanto) {
		this.velocidad -= cuanto;
		if (this.velocidad < 0) {
			this.velocidad = 0;
		}
		System.out.printf("Soy una moto y freno hasta %d km/h\n", velocidad);
	}

	@Override
	public void acelerar(int cuanto) {
		this.velocidad += cuanto;
		if (this.velocidad > VELOCIDAD_MAXIMA) {
			this.velocidad = VELOCIDAD_MAXIMA;
		}
		System.out.printf("Soy una moto y acelero hasta %d km/h\n", velocidad);
	}

	@Override
	public int getNumPlazas() {
		return NUM_PLAZAS;
	}

}
