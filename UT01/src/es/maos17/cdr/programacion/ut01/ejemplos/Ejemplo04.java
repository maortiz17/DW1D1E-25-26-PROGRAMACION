package es.maos17.cdr.programacion.ut01.ejemplos;

public class Ejemplo04 {

	final static int NUMERO_FIJO = 2; // Esta constante pertenece a la clase. Está disponible en cualquier método de la clase
	
	public static void main(String[] args) {

		final int NUMERO_VIDAS = 3; // Esta constante es local al método main
		
		// NUMERO_VIDAS = 5; <- Error!! Esto está prohibido. No pueden modificarse constantes
		
		System.out.println(NUMERO_FIJO);
		System.out.println(NUMERO_VIDAS);
	}
}
