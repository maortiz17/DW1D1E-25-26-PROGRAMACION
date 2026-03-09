package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio02;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static final Scanner sc = new Scanner(System.in);
	public static final String[] OPCIONES_MENU = {
			"Listar alumnos",
			"Añadir alumno",
			"Eliminar alumno",
			"Mostrar alumno",
			"Salir"
	};
	
	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<>();
		menu(alumnos);
	}
	
	public static void menu(List<Alumno> alumnos) {
		int opcion;
		do {
			imprimirArray(OPCIONES_MENU);
			opcion = UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, 5, sc);
			switch(opcion) {
			case 1:
				listarAlumnos(alumnos);
				break;
			case 2:
				anadirAlumno(alumnos);
				break;
			case 3:
				eliminarAlumno(alumnos);
				break;
			case 4:
				mostrarAlumno(alumnos);
				break;
			case 5:
				System.out.println("Cerrando aplicación. Hasta pronto");
				break;
			}
		}while (opcion != 5);
	}
	
	public static <T> void imprimirArray(T[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("imprimirArray: array vacío");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d. %s\n", i + 1, array[i]);
		}
	}
	
	public static void listarAlumnos(List<Alumno> alumnos) {
		if (alumnos.isEmpty()) {
			System.out.println("La lista está vacía");
		}else {
			for (Alumno alumno : alumnos) {
				System.out.printf("%s - %s %s\n", alumno.getNif(), alumno.getNombre(), alumno.getApellidos());
			}
		}
	}
	
	public static void anadirAlumno(List<Alumno> alumnos) {
		System.out.println("Introduzca los datos del alumno:");
		String nif = UtilsInput.leerCadena("Introduzca el nif/nie: ", sc);
		if (alumnos.contains(new Alumno(nif))) {
			System.out.println("Ya hay un alumno con ese nif/nie en la lista");
			return;
		}
		String nombre = UtilsInput.leerCadena("Introduzca el nombre: ", sc);
		String apellidos = UtilsInput.leerCadena("Introduzca los apellidos: ", sc);
		System.out.println("Introduzca el ciclo: ");
		Ciclo[] ciclos = Ciclo.values();
		imprimirArray(ciclos);
		Ciclo ciclo = ciclos[UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, ciclos.length, sc) - 1];
		Curso[] cursos = Curso.values();
		imprimirArray(cursos);
		Curso curso = cursos[UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, cursos.length, sc) - 1];
		LocalDate fechaNacimiento = null;
		while(fechaNacimiento == null) {
			System.out.println("Introduzca fecha de nacimiento:");
			try {
				int dia = UtilsInput.leerEnteroLimites("Introduzca día: ", 1, 31, sc);
				int mes= UtilsInput.leerEnteroLimites("Introduzca mes: ", 1, 12, sc);
				int anio = UtilsInput.leerEnteroLimites("Introduzca año: ", 1900, LocalDate.now().getYear(), sc);
				fechaNacimiento = LocalDate.of(anio, mes, dia);
			}catch(DateTimeException e) {
				System.out.println("Fecha no válida");
			}
		}
		alumnos.add(new Alumno(nif, nombre, apellidos, ciclo, curso, fechaNacimiento));
		System.out.println("Alumno añadido correctamente");
	}
	
	public static void eliminarAlumno(List<Alumno> alumnos) {
		String nif = UtilsInput.leerCadena("Introduzca el nif/nie del alumno a eliminar: ", sc);
		if (alumnos.remove(new Alumno(nif))) {
			System.out.println("Alumno eliminado correctamente");
		}else {
			System.out.println("Nif/nie no encontrado");
		}
	}
	
	public static void mostrarAlumno(List<Alumno> alumnos) {
		String nif = UtilsInput.leerCadena("Introduzca el nif/nie del alumno a mostrar: ", sc);
		int indice = alumnos.indexOf(new Alumno(nif));
		if (indice >= 0) {
			System.out.println(alumnos.get(indice));
		}else {
			System.out.println("Nif/nie no encontrado");
		}
	}
}
