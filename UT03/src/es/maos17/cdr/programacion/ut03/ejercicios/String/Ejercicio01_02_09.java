package es.maos17.cdr.programacion.ut03.ejercicios.String;

public class Ejercicio01_02_09 {

	public static void main(String[] args) {
		
		System.out.println(insertarGuionesCadena3("Hola caracola"));

	}
	
	private static String insertarGuionesCadena1(String cadena) {
		if (cadena == null)
			return null;
		String cadenaConGuiones = "";
		for (int i = 0; i < cadena.length(); i++) {
			cadenaConGuiones += cadena.charAt(i);
			if (i != (cadena.length() - 1))
				cadenaConGuiones += "-";
		}
		return cadenaConGuiones;
	}
	
	private static String insertarGuionesCadena2(String cadena) {
		if (cadena == null)
			return null;
		char[] caracteresOriginal = cadena.toCharArray();
		char[] caracteresModificado = new char[caracteresOriginal.length * 2 - 1];
		for (int i = 0; i < cadena.length(); i++) {
			caracteresModificado[i * 2] = caracteresOriginal[i];
			if (i != (cadena.length() - 1))
				caracteresModificado[i * 2 + 1] = '-';
		}
		
		return new String(caracteresModificado);
	}
	
	private static String insertarGuionesCadena3(String cadena) {
		if (cadena == null)
			return null;
		StringBuilder sb = new StringBuilder(cadena);
		for (int i = sb.length() - 1; i > 0; i--)
			sb.insert(i, "-");
		
		return (sb.toString());
	}

}
