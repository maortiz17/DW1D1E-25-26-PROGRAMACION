package es.maos17.cdr.programacion.ut03.ejercicios.String;

public class Ejercicio15 {
	public static void main(String[] args) {

		System.out.println(eliminaCarcteresRepetidos("PermaNentemente"));
	}

	public static String eliminaCarcteresRepetidos(String original) {

		if (original == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (char caracter : original.toCharArray()) {
			String strCaracter = String.valueOf(caracter);
			if (sb.indexOf(strCaracter) == -1) {
				sb.append(caracter);
			}
		}
		return sb.toString();
	}
}
