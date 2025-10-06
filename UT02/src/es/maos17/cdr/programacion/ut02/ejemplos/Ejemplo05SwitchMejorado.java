package es.maos17.cdr.programacion.ut02.ejemplos;

import java.util.Scanner;

public class Ejemplo05SwitchMejorado {

	public static void main(String[] args) {
		int diaSemana;
		String diaCadena;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el día de la semana: ");
		diaSemana = sc.nextInt();
		
		/* switch (diaSemana) {
			case 1, 2, 3, 4 -> {
				System.out.println("Otro día en la oficina");}
			case 5 -> {
				System.out.println("Ya es viernes!");}
			case 6 -> {
				System.out.println("Saturday night!!");}
			case 7 -> {
				System.out.println("Relájate que es domingo");}
			default -> {
				System.out.println("Día incorrecto");
			}		
		}*/
		
		diaCadena = switch (diaSemana) {
		case 1, 2, 3, 4, 5 -> "día laborable";
		case 6 -> "sábado";
		case 7 -> "domingo";
		default -> "día incorrecto";
		};
		
		System.out.println("Hoy es " + diaCadena);
	}

}
