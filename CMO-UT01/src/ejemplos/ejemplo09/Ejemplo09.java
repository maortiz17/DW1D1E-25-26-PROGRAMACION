package ejemplos.ejemplo09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejemplo09 {

	private static final int NUM_PAREJAS = 10;
	private static final String NOMBRE_FICHERO = "numeros.bin";
	private static final Random RND = new Random();

	public static void main(String[] args) {
		String personalFolder = System.getProperty("user.home");
		File ficheroNumeros = new File(personalFolder + File.separator + NOMBRE_FICHERO);
		
		// Generamos fichero de salida
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroNumeros))){
			for (int i = 0; i < NUM_PAREJAS; i++) {
				int entero = RND.nextInt(100);
				double doble = RND.nextDouble(1E6);
				System.out.printf("Pareja generada: %d %f\n", entero, doble);
				dos.writeUTF("Pareja nº " + (i + 1));
				dos.writeInt(entero);
				dos.writeDouble(doble);
			}
		} catch (IOException e) {
			System.out.println("Error al generar el fichero de salida: " + e.getMessage());
		}
		
		// Leemos e imprimimos el archivo del paso anterior
		boolean isEOF = false;
		try (DataInputStream dis = new DataInputStream(new FileInputStream(ficheroNumeros))){
			while (!isEOF) {
				String pareja = dis.readUTF();
				int entero = dis.readInt();
				double doble = dis.readDouble(); 
				System.out.printf("%s leída: %d % f\n", pareja, entero, doble);
			}
		} catch (EOFException e) {
			isEOF = true;
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado.");
		} catch (IOException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}

}
