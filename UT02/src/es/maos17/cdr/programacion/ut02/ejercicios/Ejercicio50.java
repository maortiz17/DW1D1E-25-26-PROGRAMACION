package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio50 {

	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		int opcion;

		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Menú de opciones");
			System.out.println("================");
			System.out.println("1 - Círculo");
			System.out.println("2 - Cuadrado");
			System.out.println("3 - Triángulo");
			System.out.println("0 - Salir");

			System.out.print("Introduzca una opción: ");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.print("Introduzca el radio ");
				int radio = sc.nextInt();
				System.out.println("El área del círculo es " + areaCirculo(radio));
				break;
			case 2:
				System.out.print("Introduzca el lado ");
				int lado = sc.nextInt();
				System.out.println("El área del cuadrado es " + areaCuadrado(lado));
				break;
			case 3:
				System.out.print("Introduzca la base ");
				int base = sc.nextInt();
				System.out.print("Introduzca la altura ");
				int altura = sc.nextInt();
				System.out.println("El área del triángulo es " + areaTriangulo(base, altura));
				break;
			case 0:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opción incorrecta");
			}

		} while (opcion != 0);
	}
	
	private static double areaCirculo(int radio) {
		return 2 * Math.PI * radio;
	}
	
	private static double areaCuadrado(int lado) {
		return lado * lado;
	}
	
	private static double areaTriangulo(int base, int altura) {
		return (base * altura) / 2;
	}

}
