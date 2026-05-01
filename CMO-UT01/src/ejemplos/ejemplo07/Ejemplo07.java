package ejemplos.ejemplo07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo07 {

	public static void main(String[] args) {
		// Copia de fichero binario mediante FileInputStream y FileOutputStream
		String carpetaPersonal = System.getProperty("user.home");
		File archivoOld = new File(carpetaPersonal + File.separator + "salida.bin");
		File archivoNew = new File(carpetaPersonal + File.separator + "copia.bin");
		try (FileInputStream fis = new FileInputStream(archivoOld);
				FileOutputStream fos = new FileOutputStream(archivoNew)){
			int byteLeido;
			while ((byteLeido = fis.read()) != -1) {
				fos.write(byteLeido);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero de entrada no encontrado");
		} catch (IOException e) {
			System.out.println("Error de lectura/escritura: " + e.getMessage());
		}
	}

}
