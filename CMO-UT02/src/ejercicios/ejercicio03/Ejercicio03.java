package ejercicios.ejercicio03;

@FunctionalInterface
interface Comparador {
	boolean esMayor(int a, int b);
}
public class Ejercicio03 {

	public static void main(String[] args) {
		Comparador comp = (a, b) -> a > b; 
		System.out.println(comp.esMayor(5,  2)); // true
	}

}
