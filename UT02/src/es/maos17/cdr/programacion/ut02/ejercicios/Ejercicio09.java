package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el año: ");
		int anyo = sc.nextInt();
		
		boolean esDivisiblePor4;
		boolean esDivisiblePor100;
		boolean esDivisiblePor400;
		
		
		esDivisiblePor4 = anyo % 4 == 0 ? true : false;
		esDivisiblePor100 = anyo % 100 == 0 ? true : false;
		esDivisiblePor400 = anyo % 400 == 0 ? true : false;
		
		if(esDivisiblePor4 && (!esDivisiblePor100 || esDivisiblePor400)) {
			System.out.println("Es bisiesto");
		}else {
			System.out.println("No es bisiesto");
		}
		
		/*
		if (anyo % 4 == 0) {
			if (anyo % 400 == 0) {
				System.out.println("Es bisiesto");
			}
			else if (anyo % 100 == 0) {
				System.out.println("No es bisiesto");
			}
			else {
				System.out.println("Es bisiesto");
			}
		} else {
			System.out.println("No es bisiesto");
		}*/
	}

}
