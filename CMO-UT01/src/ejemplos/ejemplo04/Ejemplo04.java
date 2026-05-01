package ejemplos.ejemplo04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo04 {

	public static void main(String[] args) {
		//Lectura de fichero de texto mediante BufferedReader. La lectura se hace por líneas con el método readLine
			String carpetaPersonal = System.getProperty("user.home");
			File fichero = new File(carpetaPersonal + File.separator + "frases.txt");
			String linea;
			try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} catch (FileNotFoundException e) {
				System.out.println("Fichero no encontrado");
			} catch (IOException e) {
				System.out.println("Error de lectura: " + e.getMessage());
			}
	}

}
