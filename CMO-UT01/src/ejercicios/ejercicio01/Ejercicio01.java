package ejercicios.ejercicio01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio01 {
	private static final String PATH_HOME = System.getProperty("user.home");
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(PATH_HOME);

		// Crear directorio
		File directorio01 = new File(PATH_HOME + File.separator + "ficheros-de-prueba-borrar");
		if (!directorio01.mkdir()) {
			System.out.printf("No se pudo crear el directorio %s\n", directorio01);
		} else {
			System.out.printf("Carpeta %s creada correctamente\n", directorio01);
		}
		System.out.print("Pulsa intro");
		SC.nextLine();
		// Eliminar directorio
		if (!directorio01.delete()) {
			System.out.printf("No se pudo eliminar el directorio %s\n", directorio01);
		} else {
			System.out.printf("Carpeta %s eliminada correctamente\n", directorio01);
		}
		// Crear directorio con carpeta padre (mkdirs)
		File directorio02 = new File(
				PATH_HOME + File.separator + "ficheros-de-prueba" + File.separator + "ejercicio01");
		if (!directorio02.mkdirs()) {
			System.out.printf("No se pudo crear el directorio %s\n", directorio02);
		} else {
			System.out.printf("Carpeta %s creada correctamente\n", directorio02);
		}
		// Crear ficheros
		File fichero01 = new File(directorio02 + File.separator + "fichero1.txt");
		if (fichero01.exists()) {
			System.out.printf("El fichero %s ya existe\n", fichero01);
		} else {
			try {
				fichero01.createNewFile();
			} catch (IOException e) {
				System.out.printf("Error al crear el fichero: %s", e.getMessage());
			}
		}

		File fichero02 = new File(directorio02 + File.separator + "fichero-para-borrar.txt");
		if (fichero02.exists()) {
			System.out.printf("El fichero %s ya existe\n", fichero02);
		} else {
			try {
				fichero02.createNewFile();
			} catch (IOException e) {
				System.out.printf("Error al crear el fichero: %s", e.getMessage());
			}
		}
		System.out.print("Pulsa intro");
		SC.nextLine();
		// Eliminar fichero
		if (!fichero02.delete()) {
			System.out.printf("No se ha podido borrar el fichero %s\n", fichero02);
		}
		
		// esto no borra porque el directorio no está vacío
		File directorio03 = new File(PATH_HOME + File.separator + "ficheros-de-prueba");
        if (!directorio03.delete()) {
            System.out.printf("No se ha podido borrar el directorio %s\n", directorio03);
        } else {
        	System.out.printf("Directorio %s eliminado correctamente", directorio03);
        }

        // Método para borrado recursivo del contenido de la carpeta (¡CUIDADO! Si te equivocas en la ruta puedes borrar tu home, o incluso tu sistema de archivos)
        borrarDirectorioRecursivo(directorio03);
	}
	
	public static void borrarDirectorioRecursivo(File directorio) {
		// Seguridad extra: no borrar si es una raíz o el home
	    if (directorio.getAbsolutePath().equals(PATH_HOME)) return;
	    File[] contenido = directorio.listFiles();
	    if (contenido != null) {
	        for (File archivo : contenido) {
	            borrarDirectorioRecursivo(archivo);
	        }
	    }
	    directorio.delete();
	}

}
