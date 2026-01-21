package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo21interfaces;

public class Persona implements Imprimible {
	private String dni;
	private String nombre;

	public Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void imprimir() {
		System.out.printf("Persona %s con dni %s\n", this.nombre, this.dni);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


}
