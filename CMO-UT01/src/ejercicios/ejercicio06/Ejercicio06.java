package ejercicios.ejercicio06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio06 {
	public static void main(String[] args) {
        File origen = new File("original.jpg");
        File destino = new File("copia.jpg");
        int contadorBytes = 0;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino))) {

            int dato;
            // read() devuelve el byte leído o -1 si llega al final
            while ((dato = bis.read()) != -1) {
                bos.write(dato);
                contadorBytes++;
            }
            
            System.out.printf("Copia finalizada. Se han copiado %.2f KB\n", (contadorBytes / 1024.0));

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo original.");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        }
    }
}
