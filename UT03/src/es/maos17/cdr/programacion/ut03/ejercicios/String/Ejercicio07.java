package es.maos17.cdr.programacion.ut03.ejercicios.String;

public class Ejercicio07 {

	public static void main(String[] args) {
		System.out.println(contarOcurrencias("a", "albacete"));
		System.out.println(contarOcurrencias("aa", "abcaabcaacbaaca"));
		System.out.println(contarOcurrencias("aa", "abcaaaaabcaacbaaca"));
		System.out.println(contarOcurrenciasNoSolapadas("aa", "abcaaaaabcaacbaaca"));
		System.out.println(contarOcurrencias("aa", "abcaaaaabcaacbaacaa"));
		System.out.println(contarOcurrenciasNoSolapadas("aa", "abcaaaaabcaacbaacaa"));

	}

	public static int contarOcurrencias(String buscada, String buscarEn) {
		if (buscada == null || buscarEn == null) {
			return 0;
		}

		buscada = buscada.toUpperCase();
		buscarEn = buscarEn.toUpperCase();

		int contador = 0;
		int posicionBusqueda = 0;
		int posicionEncontrada = buscarEn.indexOf(buscada);

		while (posicionEncontrada != -1) {
			contador++;
			posicionBusqueda = posicionEncontrada + 1;
			posicionEncontrada = buscarEn.indexOf(buscada, posicionBusqueda);
		}

		return contador;

	}

	public static int contarOcurrenciasNoSolapadas(String buscada, String buscarEn) {
		if (buscada == null || buscarEn == null) {
			return 0;
		}

		buscada = buscada.toUpperCase();
		buscarEn = buscarEn.toUpperCase();

		int contador = 0;
		int posicionBusqueda = 0;
		int posicionEncontrada = buscarEn.indexOf(buscada);

		while (posicionEncontrada != -1) {
			contador++;
			posicionBusqueda = posicionEncontrada + buscada.length(); // Saltamos la longitud de la cadena buscada
			posicionEncontrada = buscarEn.indexOf(buscada, posicionBusqueda);
		}

		return contador;

	}

}
