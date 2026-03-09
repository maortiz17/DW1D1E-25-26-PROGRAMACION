package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio02;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
	private String nif;
	private String nombre;
	private String apellidos;
	private Ciclo ciclo;
	private Curso curso;
	private LocalDate fechaNacimiento;
	
	public Alumno(String nif, String nombre, String apellidos, Ciclo ciclo, Curso curso, LocalDate fechaNacimiento) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Alumno(String nif) {
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "\nAlumno:\nNIF/NIE: " + nif + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nCiclo: " + ciclo
				+ "\nCurso: " + curso + "\nFecha de nacimiento: " + fechaNacimiento + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nif, other.nif);
	}
	
	
}
