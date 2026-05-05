package ejercicios.ejercicio02;

@FunctionalInterface
interface Saludo {
	void saludar(String nombre);
}
public class Ejercicio02 {

	public static void main(String[] args) {
		Saludo saludo = s -> System.out.println("Hola " + s);
		saludo.saludar("Miguel");
	}

}
