package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio22.clases;

public class Planeador extends VehiculoAereo implements Matriculable{

	private String matricula;

	public Planeador(String nombrePropietario, int altitudMaxima, String matricula) {
		super(nombrePropietario, altitudMaxima);
		this.matricula = matricula;
	}

	@Override
	public String getMatricula() {
		
		return this.matricula;
	}

}
