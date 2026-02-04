package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio07;

import java.util.Random;
import java.util.Scanner;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio04.*;

public class Programa {

	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numEmpleados = 0;
		boolean ok = false;
		do {
			try {
				System.out.print("Introduzca número de empleados: ");
				numEmpleados = Integer.parseInt(sc.nextLine());
				if (numEmpleados > 0) {
					ok = true;
				} else {
					System.out.println("El número de empleados debe ser un entero positivo");
				}
			} catch (NumberFormatException e) {
				System.out.println("Número inválido");
			}
		} while (!ok);
		Empleado[] empleados = new Empleado[numEmpleados];
		for (int i = 0; i < numEmpleados; i++) {
			System.out.print("Nombre del empleado " + (i + 1) + ": ");
			empleados[i] = crearEmpleadoAleatorio(sc.nextLine());
		}
		// Listado de todos los empleados
		System.out.println("Todos los empleados:");
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
		// Listado de todos los directivos
		System.out.println("Directivos:");
		for (Empleado empleado : empleados) {
			if (empleado instanceof Directivo)
				System.out.println(empleado);
		}
		// Listado de todos los operarios
		System.out.println("Operarios:");
		for (Empleado empleado : empleados) {
			if (empleado instanceof Operario)
				System.out.println(empleado);
		}
		// Listado de todos los oficiales
		System.out.println("Oficiales:");
		for (Empleado empleado : empleados) {
			if (empleado instanceof Oficial)
				System.out.println(empleado);
		}
		// Listado de todos los técnicos
		System.out.println("Técnicos:");
		for (Empleado empleado : empleados) {
			if (empleado instanceof Tecnico)
				System.out.println(empleado);
		}
	}

	public static Empleado crearEmpleadoAleatorio(String nombre) {
		Random aleatorio = new Random();
		switch (aleatorio.nextInt(5)) {
		case 0:
			return new Empleado(nombre);
		case 1:
			return new Directivo(nombre);
		case 2:
			return new Operario(nombre);
		case 3:
			return new Oficial(nombre);
		default:
			return new Tecnico(nombre);
		}
	}

}
