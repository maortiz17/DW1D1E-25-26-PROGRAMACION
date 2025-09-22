package es.maos17.cdr.programacion.ut01.ejemplos;

public class Ejemplo05 {

	public static void main(String[] args) {
		// Secuencias de escape
		
		String saludo = "Hola a todos\nBienvenidos!!";
		
		// String comillasMal = "Texto entre "comillas""; <- Error!!
		String comillas = "Texto entre \"comillas\"";
		
		String comillasSimples = "Texto entre \'comillas simples\'";
		
		System.out.println (saludo);
		System.out.println (comillas);
		System.out.println (comillasSimples);
	}

}
