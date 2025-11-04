package es.maos17.cdr.programacion.ut03.ejercicios.String;

public class Ejercicio14 {
	public static void main(String[] args) {
		System.out.println(buscaYPasaMayusculas("Este es mi amigo Juan", "amigo"));

	}

	public static String buscaYPasaMayusculas(String cadena, String buscada) {
		if (cadena == null) {
			return null;
		}
		if (buscada == null) {
			return cadena;
		}

		StringBuilder sb = new StringBuilder(cadena);

		int posicionBuscada = sb.indexOf(buscada);
		while (posicionBuscada >= 0) {
			// Quitar los caracteres "originales" en cadena
			sb.delete(posicionBuscada, posicionBuscada + buscada.length());
			sb.insert(posicionBuscada, buscada.toUpperCase());
			posicionBuscada = sb.indexOf(buscada, posicionBuscada + buscada.length());
		}

		return sb.toString();
	}
}
