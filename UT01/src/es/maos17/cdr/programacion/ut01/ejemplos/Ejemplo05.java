package es.maos17.cdr.programacion.ut01.ejemplos;

public class Ejemplo05 {

	public static void main(String[] args) {
		// Caracteres de escape, comienzan con \
		
		String saludo = "Hola a todos\nBienvenidos!!"; // <- \n salto de línea
		
		// String comillasMal = "Texto entre "comillas""; <- Error!! Hay que escapar caracteres especiales
		String comillas = "Texto entre \"comillas\""; // <- \" comilla doble
		
		String comillasSimples = "Texto entre \'comillas simples\'"; // <- \' comilla simple
		
		System.out.println (saludo);
		System.out.println (comillas);
		System.out.println (comillasSimples);
	}

}
