package ejemplos.ejemplo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo02 {
	//Lectura de fichero de texto mediante FileReader. La lectura se hace carácter a carácter con el método read en este caso
	public static void main(String[] args) {
		String carpetaPersonal = System.getProperty("user.home");
		File fichero = new File(carpetaPersonal + File.separator + "frases.txt");
		try (FileReader fr = new FileReader(fichero)) {
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			System.out.println("Error de lectura: " + e.getMessage());
		}
	}

}
