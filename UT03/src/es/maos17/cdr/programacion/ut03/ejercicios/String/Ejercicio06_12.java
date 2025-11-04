package es.maos17.cdr.programacion.ut03.ejercicios.String;

public class Ejercicio06_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub(

		System.out.println("Versión con Strings");
		System.out.println(espejo("bicicleta"));
		System.out.println(espejo("Hoy hay examen de LLMM"));
		System.out.println(espejo(""));
		System.out.println(espejo("ABC"));
		System.out.println(espejo(null));

		System.out.println("Versión con StringBuilder");
		System.out.println(espejo2("bicicleta"));
		System.out.println(espejo2("Hoy hay examen de LLMM"));
		System.out.println(espejo2(""));
		System.out.println(espejo2("ABC"));
		System.out.println(espejo2(null));

	}

	public static String espejo(String original) {
		if (original == null) {
			return null;
		}
		String cadenaResultado = original;
		for (int i = original.length() - 2; i >= 0; i--) {
			cadenaResultado += original.charAt(i);
		}
		return cadenaResultado;

	}

	public static String espejo2(String original) {
		if (original == null) {
			return null;
		}

		StringBuilder copia = new StringBuilder(original);
		// Opción 1: invertir y eliminar el primero
//		copia.reverse();
//		if (copia.length() > 0) {
//			copia.deleteCharAt(0);
//		}

		// Opción 2: eliminar el último y luego invertir
		if (copia.length() > 0) {
			copia.deleteCharAt(copia.length() - 1);
		}
		copia.reverse();

		return original + copia.toString();

	}

}
