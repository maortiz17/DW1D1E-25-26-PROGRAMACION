package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio08.programa;

import java.util.Random;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio08.clases.*;

public class Programa {
	private static final int NUM_FIGURAS = 10;
	private static Random rnd = new Random();
	public static void main(String[] args) {
		Figura[] figuras = new Figura[NUM_FIGURAS];
		
		for (int i = 0; i < figuras.length; i++) {
			figuras[i] = figuraAleatoria();
		}
		mostrarFiguras(figuras);
	}
	
	public static Figura figuraAleatoria() {
		switch (rnd.nextInt(5)) {
		case 0:
			return new Circulo(rnd.nextInt(10) + 1);
		case 1:
			return new Cuadrado(rnd.nextInt(10) + 1);
		case 2:
			return new Rectangulo(rnd.nextInt(10) + 1, rnd.nextInt(10) + 1);
		case 3:
			return new Romboide(rnd.nextInt(10) + 1, rnd.nextInt(10) + 1, rnd.nextInt(10) + 1);
		default:
			return crearTrianguloAleatorio();
		}
	}
	
	public static Triangulo crearTrianguloAleatorio() {
		int ladoA = rnd.nextInt(10) + 1;
		int ladoB = rnd.nextInt(10) + 1;
		int ladoC;
		do {
			ladoC = rnd.nextInt(10) + 1;
		}while (ladoA >= (ladoB + ladoC) || ladoB >= (ladoA + ladoC) || ladoC >= (ladoA + ladoB));
		return new Triangulo(ladoA, ladoB, ladoC);
	}
	
	public static String tipoFigura(Figura figura) {
		if (figura instanceof Circulo) {
			return "círculo";
		}
		if (figura instanceof Cuadrado) {
			return "cuadrado";
		}
		if (figura instanceof Rectangulo) {
			return "rectángulo";
		}
		if (figura instanceof Romboide) {
			return "romboide";
		}
		return "triángulo";
	}
	
	public static void mostrarFiguras(Figura[] figuras) {
		int i = 0;
		for(Figura figura : figuras){
			System.out.printf("La figura %d es %s, su área es %.2f y su perímetro es %.2f\n" ,
					++i, tipoFigura(figura), figura.area(), figura.perimetro());
		}
	}
}
