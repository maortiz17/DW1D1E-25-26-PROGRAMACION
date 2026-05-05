package ejemplos.ejemplo06;

import java.util.ArrayList;
import java.util.List;

import ejemplos.ejemplo03.Matematica;

public class Programa {

	public static void main(String[] args) {
		List<Matematica> operaciones = new ArrayList<>();
		operaciones.add((a, b) -> a + b);
		operaciones.add((a, b) -> a - b);
		operaciones.add((a, b) -> a * b);
		operaciones.add((a, b) -> a / b);
		
		for (Matematica operacion : operaciones) {
			System.out.println(operacion.operacion(6, 2));
		}
	}

}
