package es.maos17.cdr.programacion.ut04.ejercicios.excepciones.ejercicio03bis;

import java.util.Scanner;

public class ProgramaCoche {
	
	public static void main(String[] args) {
		Coche coche = new Coche(120, -22);
		Scanner sc = new Scanner(System.in);
		int opcion;
		int kmh;
		
		do {
			mostrarMenu();
			opcion = leerNumero("Introduzca una opción: ", sc);
			try {
				switch(opcion) {
				case 1: 
					coche.arrancar();
					break;
				case 2:
					coche.detener();
					break;
				case 3:
					coche.ponerMarchaAtras();
					break;
				case 4:
					coche.quitarMarchaAtras();
					break;
				case 5:
					kmh = leerNumero("Cantidad de km/h a acelerar: ", sc);
					coche.acelerar(kmh);
					break;
				case 6:
					kmh = leerNumero("Cantidad de km/h a frenar: ", sc);
					coche.frenar(kmh);
					break;
				case 0:
					System.out.println("¡Hasta pronto!");
					break;
				default:
					System.out.println("Opción incorrecta");
					break;
				}
			}catch(IllegalStateException e) {
				System.out.println("ERROR DE ESTADO: " + e.getMessage());
			}catch(IllegalArgumentException e) {
				System.out.println("ERROR DE VALORES: " + e.getMessage());
			}catch (Exception e) {
				System.out.println("ERROR INESPERADO: " + e.getMessage());
			}
			System.out.println(coche);
		}while (opcion != 0);
	}
	
	public static void mostrarMenu() {
		System.out.println("1. Arrancar");
		System.out.println("2. Detener");
		System.out.println("3. Poner marcha atrás");
		System.out.println("4. Quitar marcha atrás");
		System.out.println("5. Acelerar");
		System.out.println("6. Frenar");
		System.out.println("0. Fin");
	}
	
	public static int leerNumero(String mensaje, Scanner sc) {
		int numero;
		while(true) {
			try {
				System.out.print(mensaje);
				numero = Integer.parseInt(sc.nextLine());
				return numero;
			}catch (NumberFormatException e) {
				System.out.println("Número no válido");
			}
		}
	}
}
