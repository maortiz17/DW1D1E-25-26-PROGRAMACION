package ejemplos.ejemplo05;

import ejemplos.ejemplo03.Matematica;

public class Programa {

	public static void main(String[] args) {
		int c = 2;
		Matematica sumar = (a, b) -> {
			int d = a + b;
			return d;
		};
		// Lo siguiente no compilará. c es effectively final por estar declarada fuera de la lambda
		/*
		Matematica sumar2 = (a, b) -> {
			int c = a + b;
			return c;
		};
		*/
		System.out.println(sumar.operacion(3, 4));
	}

}
