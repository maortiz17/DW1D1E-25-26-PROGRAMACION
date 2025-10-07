package es.maos17.cdr.programacion.ut02.ejercicios;

import java.util.Scanner;

public class Ejercicio05 {

	static final String USUARIO = "pepe";
	static final String PASSWORD = "asdasd";
	
	public static void main(String[] args) {
		
		// Declaramos objeto de la clase Scanner
		Scanner sc = new Scanner(System.in);
		
		// Solicitamos usuario y contraseña por teclado
		System.out.print("Introduzca su usuario: ");
		String usuario = sc.nextLine();
		System.out.print("Introduzca su contraseña: ");
		String password = sc.nextLine();
		
		if (usuario.equalsIgnoreCase(USUARIO) && password.equals(PASSWORD)) {
			System.out.println("Has entrado al sistema");
		} else {
			System.out.println("Credenciales incorrectas");
		}
		

	}

}
