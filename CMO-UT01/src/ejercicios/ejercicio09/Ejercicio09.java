package ejercicios.ejercicio09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ejercicios.ejercicio08.Alumno;

public class Ejercicio09 {
	private static final String FICHERO_SALIDA = System.getProperty("user.home") + File.separator +  "informe_daw.txt";
	private static final String FICHERO_ENTRADA = System.getProperty("user.home") + File.separator + "backup_alumnos.dat";
	
	public static void main(String[] args) {
        File ficheroBinario = new File(FICHERO_ENTRADA);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroBinario))) {
            
            ArrayList<Alumno> lista = (ArrayList<Alumno>) ois.readObject();

            // --- 1. Estadísticas de edad ---
            int sumaEdades = 0;
            Alumno masVeterano = lista.get(0);

            for (Alumno a : lista) {
                sumaEdades += a.getEdad();
                if (a.getEdad() > masVeterano.getEdad()) {
                    masVeterano = a;
                }
            }
            double media = (double) sumaEdades / lista.size();

            System.out.printf("Media de edad: %.2f años\n", media);
            System.out.println("Alumno más veterano: " + masVeterano.getNombre() + " (" + masVeterano.getEdad() + ")");

            // --- 2. Filtrado y exportación a Texto (Cerrando el círculo) ---
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO_SALIDA))) {
                bw.write("LISTADO DE ALUMNOS DE DAW");
                bw.newLine();
                bw.write("==========================");
                bw.newLine();

                int contadorDaw = 0;
                for (Alumno a : lista) {
                    if (a.getCiclo().equalsIgnoreCase("DAW")) {
                        bw.write(String.format("%s\t\t%d años", a.getNombre(), a.getEdad()));
                        bw.newLine();
                        contadorDaw++;
                    }
                }
                bw.newLine();
                bw.write("Total alumnos DAW: " + contadorDaw);
                System.out.println("Informe generado con éxito en 'informe_daw.txt'");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
