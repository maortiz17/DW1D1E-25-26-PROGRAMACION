package es.maos17.cdr.programacion.ut04.ejercicios.tiposenumerados.ejercicio02;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String colorFavorito;
		
		System.out.println("Los colores disponibles son:");
		for (Color color:Color.values()) {
			System.out.printf("%s\n", color.name());
		}
		
		System.out.print("Dime tu color favorito de los anteriores: ");
		colorFavorito = sc.nextLine();
		Color color = Color.valueOf(colorFavorito.toUpperCase());
		System.out.printf("Tu personalidad se basa en %s\n", color.getSensacion());
	}

}
