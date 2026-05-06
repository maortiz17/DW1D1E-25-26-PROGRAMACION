package ejercicios.ejercicio18;

import java.util.List;

public class Ejercicio18 {
	public static void main(String[] args) {
        List<String> nombres = List.of(
                "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
                "Carlos", "Cristina", "David", "Eduardo", "Daniela",
                "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
                "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
                "Javier", "Ana", "Jorge", "Luis", "Alberto",
                "Guillermo","Marta", "Nuria", "Francisco");

        List<String> nombresFiltradosA = nombres.stream()
            .filter(s -> s.startsWith("A"))
            .toList();

        nombres.forEach(System.out::println);
        System.out.println("-".repeat(10));
        nombresFiltradosA.forEach(System.out::println);
        System.out.println("-".repeat(10));
        List<String> nombresLongitud = nombres.stream()
            .filter(p -> p.length() > 8)
            .toList();
        nombresLongitud.forEach(System.out::println);

    }
}
