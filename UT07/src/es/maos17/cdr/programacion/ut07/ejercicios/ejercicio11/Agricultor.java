package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio11;

import java.util.Random;

public class Agricultor {
	private static int totalRecolectado;
	
	private String nombre;
	private String producto;
	
	public Agricultor(String nombre, String producto) {
		this.nombre = nombre;
		this.producto = producto;
	}
	
	public void recolectar() {
		Random rnd = new Random();
		int kgProducto = rnd.nextInt(100, 201);
		totalRecolectado += kgProducto;
		
		System.out.printf("%s: recolectados %d kilos de %s\n", nombre, kgProducto, producto);
	}
	
	public static int getTotalRecolectado() {
		return totalRecolectado;
	}
}
