package ejercicios.ejercicio04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04 {
	public static void main(String[] args) {
        int lineas = 0;
        int palabras = 0;
        boolean esEspacio = false;

        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                // contamos los espacios para contar palabras
                linea = linea.trim(); // Quitamos espacios al principio y final
                char[] caracteres = linea.toCharArray();
                for (char caracter : caracteres) {
                	if (caracter == ' ') {
                		if (!esEspacio) { // Si el anterior carácter no era un espacio
                			palabras++;
                		}
                		esEspacio = true;
                	} else {
                		esEspacio = false;
                	}
                }
                if (!linea.isEmpty()) { // Si la línea no está vacía añado la última palabra
                	palabras++;
                }
            }
            System.out.println("Líneas: " + lineas);
            System.out.println("Palabras: " + palabras);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
