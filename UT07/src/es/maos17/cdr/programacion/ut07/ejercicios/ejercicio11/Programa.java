package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio11;

import java.util.Random;

public class Programa {

	private static final int NUM_AGRICULTORES = 5;
	private static final Random rnd = new Random();
	
	public static void main(String[] args) {
		Agricultor[] agricultores = new Agricultor[NUM_AGRICULTORES];
		agricultores[0] = new Agricultor("María", "ajos");
		agricultores[1] = new Agricultor("Juan", "patatas");
		agricultores[2] = new Agricultor("Ana", "naranjas");
		agricultores[3] = new Agricultor("Antonio", "melocotones");
		agricultores[4] = new Agricultor("Pilar", "cebollas");
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < agricultores.length; j++) {
				agricultores[j].recolectar();
				System.out.printf("Total recolectado: %d\n", Agricultor.getTotalRecolectado());
			}
		}
	}

}
