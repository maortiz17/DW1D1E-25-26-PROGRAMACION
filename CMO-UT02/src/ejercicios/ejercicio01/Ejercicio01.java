package ejercicios.ejercicio01;

@FunctionalInterface
interface Operacion {
	int aplicar(int a, int b);
}

public class Ejercicio01 {

	public static void main(String[] args) {
		Operacion suma = (a, b) -> a + b;
		Operacion resta = (a, b) -> a - b;
		Operacion multiplicacion = (a, b) -> a * b;
		
		System.out.println(suma.aplicar(5, 3));          // 8
        System.out.println(resta.aplicar(5, 3));         // 2
        System.out.println(multiplicacion.aplicar(5, 3));// 15
	}

}
