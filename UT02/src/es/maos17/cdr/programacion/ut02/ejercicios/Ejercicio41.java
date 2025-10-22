package es.maos17.cdr.programacion.ut02.ejercicios;

public class Ejercicio41 {

	private static final String NOMBRE_COMPLETO = "Miguel Ángel Ortiz";
	public static void main(String[] args) {
		
		escribirNombre();
		escribirNombre("Hola ");
	}
	
	private static void escribirNombre() {
		System.out.println(NOMBRE_COMPLETO);
	}
	
	private static void escribirNombre(String saludo) {
		System.out.println(saludo + NOMBRE_COMPLETO + "!!");
	}

}
