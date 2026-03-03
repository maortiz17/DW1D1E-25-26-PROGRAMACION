package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo03equalssobreescrito;

import java.util.Objects;

public class Vehiculo {
	private String matricula;
	private String marca;
	private Color color;
	
	public Vehiculo(String matricula, String marca, Color color) {
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, marca, matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return color == other.color && Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula);
	}
	
	// En principio dos vehículos serían iguales si tienen la misma matrícula
	//@Override
	//public int hashCode() {
	//	return Objects.hash(matricula);
	//}

	//@Override
	//public boolean equals(Object obj) {
	//	if (this == obj)
	//		return true;
	//	if (obj == null)
	//		return false;
	//	if (getClass() != obj.getClass())
	//		return false;
	//	Vehiculo other = (Vehiculo) obj;
	//	return Objects.equals(matricula, other.matricula);
	//}

}
