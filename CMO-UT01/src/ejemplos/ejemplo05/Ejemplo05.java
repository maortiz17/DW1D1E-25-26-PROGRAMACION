package ejemplos.ejemplo05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo05 {

	public static void main(String[] args) {
		// Escritura mediante el método write de BufferedWriter
				String carpetaPersonal = System.getProperty("user.home");
				File fichero = new File(carpetaPersonal + File.separator + "salida.txt");
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))){
					String[] frases = {"Frase uno", "Frase dos"};
					for (String frase : frases) {
						bw.write(frase);
						bw.newLine();
					}
				} catch (IOException e) {
					System.out.println("Error de escritura: " + e.getMessage());
				}
	}

}
