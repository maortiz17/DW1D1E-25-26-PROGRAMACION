package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciocine;

import java.util.Scanner;

public class ProgramaCine {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Creamos cine e inicializamos
		System.out.println("VENTA DE ENTRADAS");
		System.out.println("=================");
		int filas = Utils.leerEnteroLimites("Número de filas: ", 1, 15, sc);
		int butacas = Utils.leerEnteroLimites("Número de butacas por fila: ", 1, 20, sc);
		Pelicula pelicula = leerPelicula(sc);
		Cine cine = null;
		
		try {
			cine = new Cine(pelicula, filas, butacas);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		int opcion = 0;
		while (opcion != 5) {
			opcionesMenu();
			opcion = Utils.leerEnteroLimites("Seleccione una opción: ", 1, 5, sc);
			switch (opcion) {
			case 1:
				cine.verSala();
				break;
			case 2:
				gestionarEntradas(cine, sc);
				break;
			case 3:
				cine.cambiarPelicula(leerPelicula(sc));
				break;
			case 4:
				System.out.printf("Se han proyectado %d películas.\n", cine.getContadorPeliculas());
				break;
			case 5:
				System.out.println("Hasta pronto");
				break;
			}
		}
	}
	
	public static void opcionesMenu() {
		System.out.println("\nMENÚ DE OPCIONES");
		System.out.println("================");
        System.out.println("1. Ver sala");
        System.out.println("2. Vender entradas");
        System.out.println("3. Cambiar película");
        System.out.println("4. Ver estadísticas");
        System.out.println("5. Salir");
	}
	
	public static Pelicula leerPelicula(Scanner sc) {
		String tituloPelicula = "";
		while (tituloPelicula.length() == 0) {
			System.out.print("Título de la película: ");
			tituloPelicula = sc.nextLine();
		}
		int duracion = Utils.leerEnteroLimites("Duración en minutos: ", 60, 240, sc);
		double precio = Utils.leerDouble("Precio de la entrada: ", sc);
		return new Pelicula(tituloPelicula, duracion, precio);
	}
	
	public static void gestionarEntradas(Cine cine, Scanner sc) {
		System.out.println("Película: " + cine.getPelicula().getTitulo());
		System.out.println("Entradas disponibles: " + cine.contarButacas(1, 1));
		int cantidad = Utils.leerEnteroLimites("¿Cuántas entradas desea?: ", 1, cine.contarButacas(1, 1), sc);
		int fila = Utils.leerEnteroLimites("Fila deseada: ", 1, cine.getFilas(), sc);
		int butaca = Utils.leerEnteroLimites("Butaca deseada: ", 1, cine.getButacas(), sc);
		try {
			double importe = cine.venderEntradas(cantidad, fila, butaca);
			System.out.println("Total a pagar " + importe + "€");
		}catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
