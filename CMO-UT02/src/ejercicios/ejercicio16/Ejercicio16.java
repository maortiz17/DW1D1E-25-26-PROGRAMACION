package ejercicios.ejercicio16;

import java.util.List;

public class Ejercicio16 {
	public static void main(String[] args) {
		List<Integer> enteros = List.of(10, 8, 22, 51, 71, 4, 16, -14, 21);

		// Cálculo del máximo

		// 1. Lambda explícita: Total control, pero más código.
		enteros.stream()
			.max((a, b) -> Integer.compare(a, b))
			.ifPresent(System.out::println);

		// 2. Referencia a método estático
		enteros.stream()
			.max(Integer::compare)
			.ifPresent(System.out::println);

		// 3. Referencia a método de instancia de tipo arbitrario:
		// (Clase::metodoInstancia)
		enteros.stream()
			.max(Integer::compareTo)
			.ifPresent(System.out::println);

		// Cálculo del mínimo

		// 1. Con lambda explícita
		enteros.stream()
			.min((a, b) -> Integer.compare(a, b))
			.ifPresent(System.out::println);

		// 2. Con Referencia a método estático
		enteros.stream()
			.min(Integer::compare)
			.ifPresent(System.out::println);

		// 3. Con referencia a método de instancia
		enteros.stream()
			.min(Integer::compareTo)
			.ifPresent(System.out::println);
	}
}
