package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio03;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
	private String nif;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String email;

	// Constructor completo
	public Cliente(String nif, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	// Constructor de búsqueda: permite usar contains(), indexOf(), remove()
	//  en listas pasando únicamente el NIF 
	public Cliente(String nif) {
		this.nif = nif;
	}

	// Getters

	public String getNif() { 
		return nif; 
	}
	public String getNombre() {
		return nombre; 
	}
	public String getApellidos() {
		return apellidos; 
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento; 
	}
	public String getEmail() { return email; }

	// Igualdad: dos clientes son iguales si tienen el mismo NIF

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cliente)) return false;
		Cliente other = (Cliente) o;
		return nif.equalsIgnoreCase(other.nif);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif.toUpperCase());
	}

	// Orden natural: apellidos y nombre (mira el uso del operador ternario aquí)

	@Override
	public int compareTo(Cliente other) {
		int cmp = apellidos.compareToIgnoreCase(other.apellidos);
		return cmp != 0 ? cmp : nombre.compareToIgnoreCase(other.nombre);
	}

	@Override
	public String toString() {
		return "\nCliente:\nNIF/NIE: " + nif + "\nNombre: " + nombre + "\nApellidos: " + apellidos +
				"\nFecha de nacimiento: " + fechaNacimiento + "\nCorreo electrónico: " + email + "\n";
	}
}