package ejercicios.ejercicio17;

import java.util.Random;

public class Ejercicio17 {
	public static void main(String[] args) {
        Random rnd = new Random();
        rnd.ints(10, -10, 11)
            .max()
            .ifPresent(System.out::println);

        rnd.ints(10, -10, 11)
            .min()
            .ifPresent(System.out::println);
    }
}
