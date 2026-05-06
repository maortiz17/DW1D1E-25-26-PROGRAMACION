package ejercicios.ejercicio19;

import java.util.List;

public class Ejercicio19 {
	public static void main(String[] args) {
        List<String> nombres = List.of(
                "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
                "Carlos", "Cristina", "David", "Eduardo", "Daniela",
                "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
                "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
                "Javier", "Ana", "Jorge", "Luis", "Alberto",
                "Guillermo","Marta", "Nuria", "Francisco");

        List<String> nombres1 = nombres.stream()
            .filter(s -> s.startsWith("A") && s.length() > 8)
            .toList();
            
            nombres1.forEach(System.out::println);

        List<String> nombres2 = nombres.stream()
            .filter(s -> s.startsWith("A"))
            .filter(s -> s.length() > 8)
            .toList();

            nombres2.forEach(System.out::println);
    }
}
