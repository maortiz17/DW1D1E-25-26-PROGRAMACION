package ejercicios.ejercicio04;

@FunctionalInterface
interface Convertidor {
	String convertir(int a);
}

public class Ejercicio04 {

	public static void main(String[] args) {
		Convertidor conv = a -> String.format("Número: %d", a);
		System.out.println(conv.convertir(6)); // Número: 6
	}
}
