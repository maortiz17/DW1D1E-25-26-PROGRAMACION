package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Programa {

    public static final int CANTIDAD = 100;
    public static final int MAXIMO = 1000;

    public static void main(String[] args) {
        // 1. Generar la lista de 100 números aleatorios
        List<Integer> listaOriginal = generarAleatorios(CANTIDAD, MAXIMO);

        // 2. Calcular divisibilidad por primos < 10 (2, 3, 5, 7)
        int[] primos = {2, 3, 5, 7};
        Map<Integer, List<Integer>> mapaDivisibles = clasificarDivisibles(listaOriginal, primos);

        // 3. Mostrar resultados
        mostrarResultados(mapaDivisibles);
    }

    /**
     * Genera una lista de números aleatorios.
     */
    public static List<Integer> generarAleatorios(int cantidad, int max) {
        List<Integer> numeros = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < cantidad; i++) {
            numeros.add(rnd.nextInt(max) + 1);
        }
        return numeros;
    }

    /**
     * Clasifica los números de la lista según su divisibilidad.
     */
    public static Map<Integer, List<Integer>> clasificarDivisibles(List<Integer> lista, int[] divisores) {
        Map<Integer, List<Integer>> mapa = new HashMap<>();

        // Inicializamos el mapa con una lista vacía para cada primo
        for (int primo : divisores) {
            mapa.put(primo, new ArrayList<Integer>());
        }

        // Clasificamos cada número (un número puede entrar en varias listas)
        for (Integer num : lista) {
            for (int primo : divisores) {
                if (num % primo == 0) {
                    mapa.get(primo).add(num);
                }
            }
        }
        return mapa;
    }

    /**
     * Muestra el contenido del mapa usando EntrySet.
     */
    public static void mostrarResultados(Map<Integer, List<Integer>> mapa) {
        System.out.println("CLASIFICACIÓN DE NÚMEROS DIVISIBLES");
        System.out.println("====================================");
        
        for (Map.Entry<Integer, List<Integer>> entrada : mapa.entrySet()) {
            Integer primo = entrada.getKey();
            List<Integer> listaDivisibles = entrada.getValue();
            
            System.out.printf("Divisibles por %d (%d números):\n", primo, listaDivisibles.size());
            System.out.println(listaDivisibles);
            System.out.println("------------------------------------");
        }
    }
}