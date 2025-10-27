package es.maos17.cdr.programacion.ut02.ejemplos;

public class Ejemplo10Array {

	public static void main(String[] args) {
		
		int[] arrayEnteros = {2, 3, 6, 9, 12};
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		
		//arrayEnteros[0] = 1;
		//arrayEnteros[4] = 10;
		for (String dia: dias) {
			System.out.println(dia);
		}
		
		for (int i = 0; i < arrayEnteros.length; i++) {
			arrayEnteros[i] *= 2;
		}
		
		for (int numero: arrayEnteros) {
			System.out.printf("%d, ", numero);
		}
		
		int numero = 10;
		
		String cadena = "Hola";
		cadena = "Hola2";
		
		System.out.println("Antes " + numero + " " + arrayEnteros[2] + " " + cadena);
		
		cambiar(numero);
		cambiar(arrayEnteros);
		cambiar(cadena);
		
		System.out.println("Después " + numero + " " + arrayEnteros[4] + " " + cadena);
		
		//System.out.println(arrayEnteros.length);
	}
	
	private static void cambiar(int[] array) {
		array[4] = 6;
	}
	
	private static void cambiar(int n) {
		n = 6;
	}
	
	private static void cambiar(String s) {
		s = "Adios";
	}

}
