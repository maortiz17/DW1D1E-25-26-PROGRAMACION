package ejercicios.ejercicio02;

import java.io.File;
import java.util.Scanner;

public class Ejercicio02 {

	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce la ruta en disco del directorio:");
        String rutaDirectorio = scanner.nextLine();

        File directorio = new File(rutaDirectorio);

        if (!directorio.exists()){
            System.out.println("No existe el directorio");
            return;
        }

        if (!directorio.isDirectory()){
            System.out.println("La ruta especificada corresponde a un archivo, no un directorio.");
            return;
        }

        mostrarDirectorio(directorio);
        //mostrarDirectorioRecursividad(directorio, 0);

    }

    private static void mostrarDirectorio(File directorio) {
    	File[] contenidoDirectorio = directorio.listFiles();
        // Se puede convertir a lista:
        // List<File> listaContenido = Arrays.asList(contenidoDirectorio);

        for (File ficheroODirectorio: contenidoDirectorio) {
        	String salida = String.format("%s - %-30s",
                    ficheroODirectorio.isDirectory()? "D": "F",
                    ficheroODirectorio.getName());
        	if (ficheroODirectorio.isFile()) {
        		salida = salida + "\t\t\t - " + ficheroODirectorio.length();
        	}
            System.out.println(salida);
        }
    	
    }
    private static void mostrarDirectorioRecursividad(File directorio, int nivel) {
        // Este método devuelve solo el nombre de los ficheros / subdirectorios
        // String[] nombresContenido = directorio.list();
        // Este método devuelve objetos File con los datos de cada elemento
        File[] contenidoDirectorio = directorio.listFiles();
        // Se puede convertir a lista:
        // List<File> listaContenido = Arrays.asList(contenidoDirectorio);

        for (File ficheroODirectorio: contenidoDirectorio) {
            System.out.print("\t".repeat(nivel));
            System.out.printf("%s - %-30s - %d\n",
                    ficheroODirectorio.isDirectory()? "D": "F",
                    ficheroODirectorio.getName(),
                    ficheroODirectorio.length()
            );
            if (ficheroODirectorio.isDirectory()){
                mostrarDirectorioRecursividad(ficheroODirectorio, nivel+1);
            }

        }
    }

}
