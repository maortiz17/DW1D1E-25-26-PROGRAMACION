package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class EjercicioF1 {

	// Constantes de clase para evitar "números mágicos"
	private static final int OPCION_SUMAR = 1;
	private static final int OPCION_RESTAR = 2;
	private static final int OPCION_MULTIPLICAR = 3;
	private static final int OPCION_DIVIDIR = 4;
	private static final int OPCION_POTENCIA = 5;
	private static final int OPCION_SALIR = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			// Mantenemos bucle sobre pedir opción mientras no se seleccione salir
			opcion = pedirOpcionUsuario(sc);
			if (opcion >= OPCION_SUMAR && opcion <= OPCION_POTENCIA) {
				// Si opción correcta realizamos operación correspondiente
				realizarOperacion(sc, opcion);
			}
		} while (opcion != OPCION_SALIR);
		// Si salir mostramos mensaje de despedida
		System.out.println("Gracias por usar la calculadora. Hasta la próxima.");
	}

	private static void mostrarMenu() {
		System.out.println("CALCULADORA");
		System.out.println("===========");
		System.out.println("1.- Sumar (A+B)");
		System.out.println("2.- Restar (A-B)");
		System.out.println("3.- Multiplicar (A*B)");
		System.out.println("4.- Dividir (A/B)");
		System.out.println("5.- Potencia (A elevado a B)");
		System.out.println("0.- Salir");
	}
	
	// Método pedirOpcionUsuario. Recibe escanner y devuelve una opción válida.
	// Finaliza si se selecciona OPCION_SALIR (0) 
	private static int pedirOpcionUsuario(Scanner sc) {
		int opcion;
		boolean esCorrecto = false;		
		do {
			mostrarMenu(); // El menú se muestra en un método
			System.out.print("Introduzca una opción: ");
			opcion = sc.nextInt();
			
			if (opcion >= OPCION_SALIR && opcion <= OPCION_POTENCIA)
				esCorrecto = true;
			else
				System.err.println("Opción incorrecta");
		}while (!esCorrecto); // Mostramos menú mientras no se seleccione salir
		
		return opcion;
	}
	
	private static void realizarOperacion(Scanner sc, int opcion) {
		int operandoA, operandoB;
		
		System.out.print("Primer número: ");
		operandoA = sc.nextInt();
		System.out.print("Segundo número: ");
		operandoB = sc.nextInt();
		// Estructura switch con las opciones de la calculadora
		switch (opcion) {
		case OPCION_SUMAR:
			System.out.printf("\n%d + %d = %d\n\n", operandoA, operandoB, operandoA + operandoB);
			break;
		case OPCION_RESTAR:
			System.out.printf("\n%d - %d = %d\n\n", operandoA, operandoB, operandoA - operandoB);
			break;
		case OPCION_MULTIPLICAR:
			System.out.printf("\n%d * %d = %d\n\n", operandoA, operandoB, operandoA * operandoB);
			break;
		case OPCION_DIVIDIR:
			if (operandoB != 0)
				System.out.printf("\n%d / %d = %.2f\n\n", operandoA, operandoB, (double)operandoA / operandoB);
			else
				System.err.println("\nEl divisor no puede ser 0\n");
			break;
		case OPCION_POTENCIA:
			System.out.printf("\n%d elevado a %d = %d\n\n", operandoA, operandoB, calcularPotencia(operandoA, operandoB));
			break;
		}
	}
	
	private static int calcularPotencia(int n1, int n2) {
		int resultado  = 1;
		// Para calcular la potencia multiplicamos el número por sí mismo n2 veces
		for (int i = 1; i <= n2; i++) {
			resultado *= n1;
		}
		return resultado;
	}

}
