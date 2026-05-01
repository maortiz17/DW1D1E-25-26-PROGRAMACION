package ejercicios.ejercicio08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio08 {
	private static final String FICHERO_ENTRADA = System.getProperty("user.home") + File.separator +  "alumnos.txt";
	private static final String FICHERO_SALIDA = System.getProperty("user.home") + File.separator + "backup_alumnos.dat";
	public static void main(String[] args) {
        List<Alumno> listaParaGuardar = new ArrayList<>();
        File archivoBinario = new File(FICHERO_SALIDA);

        // 1. LEER DEL TXT Y RELLENAR LISTA
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO_ENTRADA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Usando una lógica similar a la anterior
                String[] datos = linea.split(","); 
                if (datos.length == 3) {
                    listaParaGuardar.add(new Alumno(datos[0], Integer.parseInt(datos[1]), datos[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de texto: " + e.getMessage());
        }

        // 2. SERIALIZAR (GUARDAR) LA LISTA
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
            oos.writeObject(listaParaGuardar);
            System.out.println("Archivo binario guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }

        System.out.println("----------------------------------------------");

        // 3. RECUPERAR (DESERIALIZAR) Y MOSTRAR POR PANTALLA
        if (archivoBinario.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoBinario))) {
                
                // Leemos el objeto y hacemos el casting
                ArrayList<Alumno> listaRecuperada = (ArrayList<Alumno>) ois.readObject();

                System.out.println("Contenido recuperado del archivo binario:");
                for (Alumno alu : listaRecuperada) {
                    // Aquí ya puedes usar tus nuevos Getters
                    System.out.println(alu);
                }

            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al recuperar los datos: " + e.getMessage());
            }
        }
    }
}
