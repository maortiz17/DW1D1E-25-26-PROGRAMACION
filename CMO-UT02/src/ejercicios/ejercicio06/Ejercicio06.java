package ejercicios.ejercicio06;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Filtro {
	boolean aceptar(int a);
}

public class Ejercicio06 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 13, 14);
		Filtro esPar = a -> a % 2 == 0;
		for (int n : numeros) {
			if (esPar.aceptar(n)) {
				System.out.println(n);
			}
		}
		
		System.out.println("-".repeat(50));
		Filtro mayor10 = a -> a > 10;
		for (int n : numeros) {
			if (mayor10.aceptar(n)) {
				System.out.println(n);
			}
		}
	}

}
