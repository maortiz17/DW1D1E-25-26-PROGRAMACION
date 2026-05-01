package ejercicios.ejercicio05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio05 {

	public static void main(String[] args) {
		File entrada = new File("datos.csv");
		File salida = new File("aprobados.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(entrada));
				BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

			String linea;
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(",");
				if (campos.length == 2) {
					String nombre = campos[0];
					double nota = Double.parseDouble(campos[1]);

					if (nota >= 5) {
						bw.write(nombre);
						bw.newLine();
					}
				}
			}
			System.out.println("Proceso de filtrado terminado.");
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error procesando el fichero: " + e.getMessage());
		}
	}
}
