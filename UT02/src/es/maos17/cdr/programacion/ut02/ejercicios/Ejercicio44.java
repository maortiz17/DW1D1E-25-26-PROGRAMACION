package es.maos17.cdr.programacion.ut02.ejercicios;

public class Ejercicio44 {

	public static void main(String[] args) {
		
		mostrarNVeces("Hola a todos!!", -1);

	}
	
	private static void mostrarNVeces(String mensaje, int repeticiones) {
		if (repeticiones < 0) {
			System.out.println("Número de repeticiones erróneo.");
		}else {
			for (int i = 1; i <= repeticiones; i++) {
				System.out.println(i + " " + mensaje);
			}
		}
	}

}
