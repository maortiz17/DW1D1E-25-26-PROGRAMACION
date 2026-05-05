package ejercicios.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio05 {

	public static void main(String[] args) {
		List<String> nombres = new ArrayList<>();
		nombres.add("Carlos");
		nombres.add("Ana");
		nombres.add("Luis");
		
		nombres.sort((s1, s2) -> s1.compareTo(s2));
		
		System.out.println(nombres);

	}

}
