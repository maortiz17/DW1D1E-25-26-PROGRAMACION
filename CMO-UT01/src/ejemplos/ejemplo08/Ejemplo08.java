package ejemplos.ejemplo08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo08 {

	public static void main(String[] args) {
		// Copia de fichero binario mediante FileInputStream y FileOutputStream
		String carpetaPersonal = System.getProperty("user.home");
		File archivoOld = new File(carpetaPersonal + File.separator + "salida.bin");
		File archivoNew = new File(carpetaPersonal + File.separator + "copia.bin");
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoOld));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoNew))){
			int byteLeido;
			while ((byteLeido = bis.read()) != -1) {
				bos.write(byteLeido);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero de entrada no encontrado");
		} catch (IOException e) {
			System.out.println("Error de lectura/escritura: " + e.getMessage());
		}

	}

}
