package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;


public class Ejercicio11 {

	static final int DIAS_LARGO = 31;
	static final int DIAS_NORMAL= 30;
	static final int FEBRERO_LARGO = 29;
	static final int FEBRERO_NORMAL = 28;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el día: ");
		int dia = sc.nextInt();
		System.out.print("Introduzca el mes: ");
		int mes = sc.nextInt();
		System.out.print("Introduzca el año: ");
		int anyo = sc.nextInt();
		
		boolean esBisiesto = (anyo % 4 == 0) && (anyo % 100 != 0 || anyo % 400 == 0);
		int diasFebrero = esBisiesto ? FEBRERO_LARGO : FEBRERO_NORMAL;
		
		if (anyo > 0) {
			switch (mes) {
			case 1, 3, 5, 7, 8, 10, 12:
				if (dia < 1 || dia > DIAS_LARGO)
					System.out.println("Día incorrecto");
				else
					System.out.println("Día correcto");
				break;
			case 4, 6, 9, 11:
				if (dia < 1 || dia > DIAS_NORMAL)
					System.out.println("Día incorrecto");
				else
					System.out.println("Día correcto");
				break;
			case 2:
				if (dia < 1 || dia > diasFebrero)
					System.out.println("Día incorrecto");
				else
					System.out.println("Día correcto");
				break;
			default:
				System.out.println("Mes incorrecto");
			}
		}else {
			System.out.println("Año incorrecto");
		}

	}

}
