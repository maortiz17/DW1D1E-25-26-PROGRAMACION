package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio02;

import java.time.LocalDate;
import java.time.Period;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio01.Fecha;

public class Persona {
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String ciudad;
	private Fecha fechaNacimiento;

	public Persona(String nombre, String direccion, String codigoPostal, String ciudad, Fecha fechaNacimiento) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean esMayorDeEdad() {
		// Implementación utilizando el método between de la clase Period para obtener
		// la diferencia en años entre las fechas
		LocalDate fecNacLD = LocalDate.of(fechaNacimiento.getAnio(), fechaNacimiento.getMes(),
				fechaNacimiento.getDia());
		Period edad = Period.between(fecNacLD, LocalDate.now());
		return edad.getYears() >= 18;
	}

	public boolean esMayorDeEdadB() {
		// Implementación manual. Utilizamos el método estático now() de LocalDate para
		// obtener la fecha de hoy
		LocalDate hoy = LocalDate.now();

		if (hoy.getYear() - fechaNacimiento.getAnio() > 18) {
			return true;
		}
		if (hoy.getYear() - fechaNacimiento.getAnio() == 18 && hoy.getMonthValue() > fechaNacimiento.getMes()) {
			return true;
		}
		if (hoy.getYear() - fechaNacimiento.getAnio() == 18 && hoy.getMonthValue() > fechaNacimiento.getMes()
				&& hoy.getDayOfMonth() >= fechaNacimiento.getDia()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nombre: ");
		builder.append(nombre);
		builder.append("\nFecha de nacimiento: ");
		builder.append(fechaNacimiento);
		builder.append("\nDirección: ");
		builder.append(direccion);
		builder.append("\n");
		builder.append(codigoPostal);
		builder.append(" ");
		builder.append(ciudad);
		return builder.toString();
	}
}
