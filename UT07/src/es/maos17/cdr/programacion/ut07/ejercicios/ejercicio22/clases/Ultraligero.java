package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio22.clases;

public class Ultraligero extends VehiculoAereo implements Matriculable, Motorizado {

	private String matricula;
	private int potencia;

	public Ultraligero(String nombrePropietario, int altitudMaxima, String matricula, int potencia) {
		super(nombrePropietario, altitudMaxima);
		this.matricula = matricula;
		this.potencia = potencia;
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
