package es.maos17.cdr.programacion.ut01.ejemplos;

public class Ejemplo06 {

	public static void main(String[] args) {
		// Tipos por defecto
		System.out.println(5 / 2); // <- El resultado se trata como int luego no hay decimales
		System.out.println(5F / 2F); // <- El resultado se trata como float
		System.out.println(5.0 / 2); // <- El resultado se trata como double
		System.out.println(5 / 2.0); // <- El resultado se trata como double
		
		float numeroReal = 5.0F; // <- 5.0F es un float
		// float numeroReal2 = 5.0; <- Error!! 5.0 por defecto es double luego no cabe en un float
	}

}
