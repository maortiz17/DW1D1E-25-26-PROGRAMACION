package es.maos17.cdr.programacion.ut02.ejercicios;

public class Ejercicio43 {

	public static void main(String[] args) {
		double numero1;
		double numero2;
		
		numero1 = 33.4;
		numero2 = 11.1;
		
		System.out.printf("%.2f + %.2f = %.2f", numero1, numero2, suma(numero1, numero2));

		double otroNumero = 2 * suma(numero1, numero2);
	}

	public static double suma(double n1, double n2) {
		return n1 + n2;
	}
}
