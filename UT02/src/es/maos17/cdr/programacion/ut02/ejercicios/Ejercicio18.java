package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un año: ");
		int anyo = sc.nextInt();
		System.out.print("Introduce un mes: ");
		int mes = sc.nextInt();
		
		int numeroDias = 0;
		
		if (anyo <= 0) {
			System.out.println("Año introducido incorrecto.");
		}else {
			switch(mes) {
			case 1, 3, 5 ,7, 8, 10, 12:
				System.out.println("31 días");
				break;
			case 4, 6, 9, 11:
				System.out.println("30 días");
			break;
			case 2:
				boolean esBisiesto = (anyo % 4 == 0) && (!(anyo % 100 == 0) || anyo % 400 == 0);
				if (esBisiesto) {
					System.out.println("el mes tiene 29 días");
				}else {
					System.out.println("el mes tiene 28 días");
				}
				System.out.println(esBisiesto ? "29 días" : "28 días");
				break;
			default:
				System.out.println("Mes incorrecto");
			}
		}

	}

}
