package ejemplos.ejemplo06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo06 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo de escritura de archivo binario con números
		String carpetaPersonal = System.getProperty("user.home");
		File salida = new File(carpetaPersonal + File.separator + "salida.bin");
		try (FileOutputStream fos = new FileOutputStream(salida)){
			int numero;
			do {
				System.out.print("Introduzca un número [1-255]: ");
				numero = Integer.parseInt(sc.nextLine());
				if (numero != 0) {
					if (numero > 0 && numero <= 255) {
						fos.write(numero);
					} else {
						System.out.println("Número fuera de rango");
					}
				}
			}while (numero != 0);
		} catch (IOException e) {
			System.out.println("Fichero no encontrado");
		}
	}

}
