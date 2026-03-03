package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo01genericos;

public class MetodoGenerico {
	public static <T> T obtenerElemento(T[] array, int indice) {
		return array[indice];
	}
}
