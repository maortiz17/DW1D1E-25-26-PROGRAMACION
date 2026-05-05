package ejemplos.ejemplo04;

import ejemplos.ejemplo03.Matematica;

public class Programa {

	public static void main(String[] args) {
		int i1 = 3;
		int i2 = 4;
		// Implementación mediante clase anónima
		/*Matematica sumar = new Matematica() {
			@Override
			public int operacion(int a, int b) {
				return a + b;
			}
		};*/
		// Simplificación mediante expresión Lambda
		Matematica sumar = (a, b) -> a + b;
		System.out.printf("%d + %d = %d", i1, i2, sumar.operacion(i1, i2));
	}

}
