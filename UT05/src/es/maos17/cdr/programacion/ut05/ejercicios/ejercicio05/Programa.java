package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Programa {
	private static final int LIMITE_NUMEROS = 10;
	private static final int CANTIDAD_NUMEROS = 10;
	public static void main(String[] args) {
		
		//Listas
		List<Integer> listaMinuendo= generarLista();
		List<Integer> listaSustraendo = generarLista();
		List<Integer> listaDiferencia = restar(listaMinuendo, listaSustraendo);
		List<Integer> listaDiferenciaSinDuplicados = restarSinDuplicados(listaMinuendo, listaSustraendo);
		
		System.out.println("Lista minuendo:" + listaMinuendo);
		System.out.println("Lista sustraendo:" + listaSustraendo);
		System.out.println("Lista diferencia:" + listaDiferencia);
		System.out.println("Lista diferencia sin duplicados:" + listaDiferenciaSinDuplicados);
	}
	
	public static List<Integer> restar(List<Integer> listaMinuendo, List<Integer> listaSustraendo){
		if (listaMinuendo == null || listaSustraendo == null) {
			throw new IllegalArgumentException("Las listas no pueden ser null");
		}
		List<Integer> listaDiferencia = new ArrayList<>();
		Iterator<Integer> it = listaMinuendo.iterator();
		int numero;
		while (it.hasNext()) {
			numero = it.next();
			if (!listaSustraendo.contains(numero)) {
				listaDiferencia.add(numero);
			}
		}
		return listaDiferencia;
	}
	
	private static List<Integer> restarSinDuplicados(List<Integer> listaMinuendo, List<Integer> listaSustraendo) {
		if (listaMinuendo == null || listaSustraendo == null) {
			throw new IllegalArgumentException("Las listas no pueden ser null");
		}

		List<Integer> resultado = new ArrayList<Integer>();

		for (Integer numero : listaMinuendo) {
			if (!listaSustraendo.contains(numero)) {
				if (!resultado.contains(numero)) {
					resultado.add(numero);
				}
			}
		}

		return resultado;
	}
	
	public static List<Integer> generarLista() {
		Random rnd = new Random();
		
		List<Integer> lista = new ArrayList<>(CANTIDAD_NUMEROS);
		
		while (lista.size() < CANTIDAD_NUMEROS) {
			lista.add(rnd.nextInt(LIMITE_NUMEROS) + 1);
		}
		return lista;
	}
}
