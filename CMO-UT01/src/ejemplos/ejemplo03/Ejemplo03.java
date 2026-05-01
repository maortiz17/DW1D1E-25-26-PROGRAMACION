package ejemplos.ejemplo03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo03 {

	public static void main(String[] args) {
		// Escritura mediante el método write de FileWriter
		String carpetaPersonal = System.getProperty("user.home");
		File fichero = new File(carpetaPersonal + File.separator + "salida.txt");
		try (FileWriter fw = new FileWriter(fichero)){
			String frases = "Frase 1\nFrase 2";
			fw.write(frases);
		} catch (IOException e) {
			System.out.println("Error de escritura");
		}
	}

}
