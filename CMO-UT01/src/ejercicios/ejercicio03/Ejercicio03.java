package ejercicios.ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Deseas añadir contenido al final del archivo? (S/N): ");
		// Si pulsa S, append será true (añade). Si pulsa cualquier otra cosa, false (sobrescribe).
		boolean append = sc.nextLine().equalsIgnoreCase("S");
		// El true en FileWriter activa el modo 'append' (añadir)
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("notas.txt", append))) {
			String texto;
			do {
				System.out.print("Introduce texto (o 'salir'): ");
				texto = sc.nextLine();
				if (!texto.equalsIgnoreCase("salir")) {
					bw.write(texto);
					bw.newLine();
				}
			} while (!texto.equalsIgnoreCase("salir"));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
