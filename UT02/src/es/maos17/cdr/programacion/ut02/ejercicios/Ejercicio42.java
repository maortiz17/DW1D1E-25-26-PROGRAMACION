package es.maos17.cdr.programacion.ut02.ejercicios;

public class Ejercicio42 {

	public static void main(String[] args) {
		
		double numero1;
		double numero2;
		
		numero1 = 33.4;
		numero2 = 11.1;
		
		suma(numero1, numero2);

	}
	
	public static void suma(double n1, double n2) {
		System.out.printf("%.2f + %.2f = %.2f", n1, n2, n1 + n2);
	}

}
