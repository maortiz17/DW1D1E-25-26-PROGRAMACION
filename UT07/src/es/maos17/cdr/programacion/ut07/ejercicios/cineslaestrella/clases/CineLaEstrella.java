package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

import java.util.Scanner;

public class CineLaEstrella {
	public static final Scanner sc = new Scanner(System.in);
	public static Sala[] salas;

	public static void main(String[] args) {
		crearCine();
		menu();
	}

	/**
	 * Inicializa el cine con el número de salas que contiene y la configuración
	 * inicial de cada sala
	 */
	public static void crearCine() {
		int numeroSalas = InputAux.leerEnteroLimites("Introduzca número de salas (1-5): ", 1, 5, sc);
		salas = new Sala[numeroSalas];
		for (int i = 0; i < numeroSalas; i++) {
			while (salas[i] == null) {
				System.out.printf("Sala número %d:\n", i + 1);
				Pelicula pelicula = null;
				while (pelicula == null) {
					pelicula = leerPelicula();
				}
				System.out.println("Tipo:\n1. No numerada\n2. Numerada");
				int tipo = InputAux.leerEnteroLimites("Indique el tipo: ", 1, 2, sc);
				try {
					switch (tipo) {
					case 1:
						int capacidad = InputAux.leerEnteroLimites("Indique capacidad de la sala: ", 1,
								Integer.MAX_VALUE, sc);
						salas[i] = new SalaNoNumerada(pelicula, capacidad);
						break;
					case 2:
						int filas = InputAux.leerEnteroLimites("Indique el número de filas de la sala: ", 1,
								Integer.MAX_VALUE, sc);
						int butacas = InputAux.leerEnteroLimites("Indique el número de butacas por fila: ", 1,
								Integer.MAX_VALUE, sc);
						salas[i] = new SalaNumerada(pelicula, filas, butacas);
						break;
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	/**
	 * Muestra menú de opciones y ejecuta acción en función de la opción
	 * seleccionada
	 */
	public static void menu() {
		int opcion;
		do {
			System.out.println("\nMENÚ DE OPCIONES");
			System.out.println("================");
			System.out.println("1. Listar salas");
			System.out.println("2. Vender entradas");
			System.out.println("3. Cambiar película");
			System.out.println("4. Salir");
			opcion = InputAux.leerEnteroLimites("Seleccione una opción: ", 1, 4, sc);
			switch (opcion) {
			case 1:
				listarSalas();
				break;
			case 2:
				venderEntradas();
				break;
			case 3:
				cambiarPelicula();
				break;
			case 4:
				System.out.println("Cerrando aplicación");
				break;
			}
		} while (opcion != 4);
	}

	/**
	 * Muestra un listado de salas por pantalla
	 */
	public static void listarSalas() {
		for (Sala sala : salas) {
			System.out.println(sala);
		}
	}

	/**
	 * Gestiona la venta de entradas. Si la sala es numerada solicita número de
	 * entradas deseada, así como la fila y butaca a partir de la que se desea hacer
	 * la asignación de butacas. Asignará las primeras butacas libres a partir de
	 * ahí. Si es no numerada únicamente solicita el número de entradas deseadas.
	 * Muestra por pantalla las entradas generadas si no se produce ningún error.
	 */
	public static void venderEntradas() {
		listarSalas();
		int numSala = InputAux.leerEnteroLimites("Indique número de la sala (0 para salir): ", 0, salas.length, sc);
		if (numSala != 0) {
			try {
				Sala sala = salas[numSala - 1];
				System.out.println(sala);
				int entradas = InputAux.leerEnteroLimites("¿Cuántas entradas desea?: ", 1,
						sala.obtenerButacasDisponibles(), sc);
				if (sala instanceof SalaNumerada) {
					System.out.println(((SalaNumerada) sala).obtenerMapaSala());
					int fila = InputAux.leerEnteroLimites("Indique fila deseada: ", 1, ((SalaNumerada) sala).getFilas(),
							sc);
					int butaca = InputAux.leerEnteroLimites("Indique butaca deseada: ", 1,
							((SalaNumerada) sala).getButacas(), sc);
					System.out.println(((SalaNumerada) sala).venderEntradas(entradas, fila, butaca));
				} else {
					System.out.println(((SalaNoNumerada) sala).venderEntradas(entradas));
				}

			} catch (IllegalArgumentException e) {
				System.out.println("Venta cancelada: " + e.getMessage());
			} catch (IllegalStateException e) {
				System.out.println("Venta cancelada: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Venta cancelada: " + e.getMessage());
			}
		}else {
			System.out.println("Venta cancelada a petición del usuario");
		}
	}

	/**
	 * Modifica la película e inicializa la sala
	 */
	public static void cambiarPelicula() {
		listarSalas();
		int numSala = InputAux.leerEnteroLimites("Indique número de la sala: ", 1, salas.length, sc);
		
		Pelicula pelicula = null;
		while (pelicula == null) {
			pelicula = leerPelicula();
		}
		
		salas[numSala - 1].cambiarPelicula(pelicula);
	}
	
	public static Pelicula leerPelicula() {
		Pelicula pelicula = null;
		System.out.print("Indique la película: ");
		String titulo = sc.nextLine();
		int duracionMinutos = InputAux.leerEnteroLimites("Indique la duración de la película en minutos: ", 1, Integer.MAX_VALUE, sc);
		Categoria[] categorias = Categoria.values();
		System.out.println("\nIndique la categoría a la que pertenece la película:");
		for (int i = 0; i < categorias.length; i++) {
			System.out.println((i + 1) + ". " + categorias[i]);
		}
		int categoria = InputAux.leerEnteroLimites("Seleccione una opción: ", 1, categorias.length, sc);
		try {
			pelicula = new Pelicula(titulo, duracionMinutos, Categoria.values()[categoria - 1]);
		}catch (IllegalArgumentException e) {
			System.out.println("Error al crear la película: " + e.getMessage());
		}
		return pelicula;
	}

}
