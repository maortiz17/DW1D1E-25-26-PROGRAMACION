package ejemplos.ejemplo01;

import java.io.File;
import java.io.IOException;

public class Ejemplo01 {
	public static void main(String[] args) {
		// Obtenemos la carpeta personal del usuario
		String home = System.getProperty("user.home");
		String documentos = home + File.separator + "Documentos";
		// Creamos una carpeta en Documentos
		File nueva_carpeta = new File(documentos + File.separator + "carpeta");
		if (nueva_carpeta.mkdir()) {
			System.out.println("Carpeta creada correctamente");
		} else {
			System.out.println("No se pudo crear la carpeta");
		}
		// Creamos un archivo vacío en la carpeta nueva
		File nuevo_archivo = new File(nueva_carpeta, "nuevo_archivo.txt");
		try {
			if (nuevo_archivo.createNewFile()) {
				System.out.println("Fichero creado correctamente");
			} else {
				System.out.println("No se pudo crear el archivo");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo: " + e.getMessage());
		}
		// Renombrar el archivo recien creado
		File nuevo_nombre = new File(nueva_carpeta, "archivo_renombrado.txt");
		if (nuevo_archivo.renameTo(nuevo_nombre)) {
			System.out.println("Archivo renombrado correctamente");
		} else {
			System.out.println("Error al renombrar archivo");
		}
		//Eliminar el archivo. Ahora el objeto que apunta al archivo es nuevo_nombre
		if (nuevo_nombre.delete()) {
			System.out.println("Archivo eliminado correctamente");
		} else {
			System.out.println("Error al eliminar el archivo");
		}
		// Listamos el contenido de Documentos como un array de Strings. Es más eficiente en consumo de memoria
		File contenidoDocumentos = new File(documentos);
		String[] contenidos = contenidoDocumentos.list();
		for (String contenido : contenidos) {
			System.out.println(contenido);
		}
		System.out.println("-".repeat(100));
		// Obtenemos el contenido de Documentos como array de objetos File. Menos eficiente pero con métodos prácticos
		File[] contenidosFile = contenidoDocumentos.listFiles();
		for (File contenidoFile : contenidosFile) {
			// Solamente mostramos carpetas
			if (contenidoFile.isDirectory()) {
				System.out.println(contenidoFile);
			}
		}
	}
}
