package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio22.clases;

public class Camion extends VehiculoTerrestre implements Matriculable, Motorizado {

	private int cargaMaxima;
	private String matricula;
	private int potencia;

	public Camion(String nombrePropietario, int numRuedas, int cargaMaxima, String matricula, int potencia) {
		super(nombrePropietario, numRuedas);
		if (numRuedas < 4 || numRuedas > 16) {
			throw new IllegalArgumentException("El número de ruedas es incorrecto");
		}
		if (cargaMaxima <= 0 || cargaMaxima > 40000) {
			throw new IllegalArgumentException("La carga es incorrecta");
		}

		this.cargaMaxima = cargaMaxima;
		this.matricula = matricula;
		this.potencia = potencia;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}

	@Override
	public String getMatricula() {
		return this.matricula;
	}
	
	@Override
	public int getPotencia() {
		return this.potencia;
	}

}
