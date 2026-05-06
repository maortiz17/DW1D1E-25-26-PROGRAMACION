package ejercicios.ejercicio20;

import java.util.List;

public class Ejercicio20 {
	public static void main(String[] args) {
        List<String> nombres = List.of(
                "Mario", "Laura", "Alejandro", "Carmen", "Bernardo",
                "Carlos", "Cristina", "David", "Eduardo", "Daniela",
                "Elena", "Oscar", "Enrique", "Fernanda", "Irene",
                "Gabriel", "Beatriz", "Gema", "Hugo", "Julia", "Miguel",
                "Javier", "Ana", "Jorge", "Luis", "Alberto",
                "Guillermo","Marta", "Nuria", "Francisco");

        StringBuilder sb = new StringBuilder();
        
        nombres.stream()
            .map(s -> s.charAt(0))
            .forEach(sb::append);

        System.out.println(sb.toString());
    }
}
