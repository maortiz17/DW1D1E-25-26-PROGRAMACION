package ejercicios.ejercicio08;

import java.io.Serializable;

public class Alumno implements Serializable {
	private String nombre;
    private int edad;
    private String ciclo;

    public Alumno(String nombre, int edad, String ciclo) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciclo = ciclo;
    }
    
    
    public String getNombre() {
		return nombre;
	}


	public int getEdad() {
		return edad;
	}


	public String getCiclo() {
		return ciclo;
	}


	@Override
    public String toString() {
        return nombre + " (" + edad + " años) - " + ciclo;
    }
}
