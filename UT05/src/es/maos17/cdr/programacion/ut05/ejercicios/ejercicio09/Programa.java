package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Programa {

	public static final int CANTIDAD_NUMEROS = 1000;
	public static final int MINIMO = 1;
	public static final int MAXIMO = 50;
	public static Random rnd = new Random();
	
	public static void main(String[] args) {
		
		List<Integer> numeros = crearNumerosAleatorios(CANTIDAD_NUMEROS, MINIMO, MAXIMO);
		Map<Integer, Integer> frecuencias = new HashMap<>();
		Iterator<Integer> it = numeros.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			frecuencias.put(i, frecuencias.getOrDefault(i, 0) + 1);
		}
		// Mostrar
		System.out.println("Frecuencias:");
		for (Map.Entry<Integer, Integer> frecuenciaNumero : frecuencias.entrySet()) {
			System.out.printf("El número %d ha aparecido %d veces\n", frecuenciaNumero.getKey(), frecuenciaNumero.getValue());
		}
	}
	
	public static List<Integer> crearNumerosAleatorios(int cantidadNumeros, int min, int max){
		List<Integer> numeros = new ArrayList<>(cantidadNumeros);
		while (cantidadNumeros > 0) {
			numeros.add(rnd.nextInt(min, max + 1));
			cantidadNumeros--;
		}
		return numeros;
	}

}
