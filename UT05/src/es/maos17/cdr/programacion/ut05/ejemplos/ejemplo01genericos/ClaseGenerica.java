package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo01genericos;

public class ClaseGenerica <T>{
	public void invertirArray(T[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			T elementoTemporal = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = elementoTemporal;
		}
	}
}
