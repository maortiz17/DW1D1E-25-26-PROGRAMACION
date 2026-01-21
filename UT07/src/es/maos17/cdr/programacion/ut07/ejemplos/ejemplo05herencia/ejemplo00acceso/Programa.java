package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo05herencia.ejemplo00acceso;

import java.time.LocalDate;

import es.maos17.cdr.programacion.ut07.ejemplos.ejemplo05herencia.ejemplo00acceso.personas.Empleado;
import es.maos17.cdr.programacion.ut07.ejemplos.ejemplo05herencia.ejemplo00acceso.personas.Persona;


public class Programa {

	public static void main(String[] args) {
		Persona p1 = new Persona(1, "José Luis", LocalDate.now());
		
		Empleado e1 = new Empleado(2, "Juan", LocalDate.now(), "Profesor", "IFC");
		
		System.out.println(p1.toString());
		System.out.println(e1.toString());
		


	}

}
