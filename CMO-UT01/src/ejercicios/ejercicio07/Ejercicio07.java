package ejercicios.ejercicio07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio07 {
	public static void main(String[] args) {
        File fichero = new File("jugador.dat");

        // 1. ESCRITURA
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
            dos.writeUTF("Aragorn"); // String
            dos.writeInt(25);        // int
            dos.writeDouble(95.5);   // double
            dos.writeBoolean(false); // boolean
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }

        // 2. LECTURA (IMPORTANTE: Mismo orden que la escritura)
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
            String nombre = dis.readUTF();
            int nivel = dis.readInt();
            double salud = dis.readDouble();
            boolean lleno = dis.readBoolean();

            System.out.println("Datos recuperados");
            System.out.printf("Nombre: %s\nNivel: %d\nSalud: %.1f\n¿Mochila llena?: %b\n", 
                              nombre, nivel, salud, lleno);
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
}
