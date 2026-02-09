package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

public class SalaNumerada extends Sala {

	private final boolean[][] butacas;

	public SalaNumerada(Pelicula pelicula, int filas, int butacas) {
		super(pelicula);
		if (filas <= 0 || butacas <= 0) {
			throw new IllegalArgumentException("Número de filas y butacas debe ser positivo");
		}
		this.butacas = new boolean[filas][butacas];
		inicializarSala(); // Al crear el array todos valen false por defecto, pero no es mala práctica inicializar manualmente
	}

	/**
	 * Calcula el número de butacas libres desde una posición inicial hasta el final
	 * de la sala
	 * 
	 * @param filaInicial   Fila desde la que se inicia el conteo
	 * @param butacaInicial Butaca de la fila inicial desde la que se inicia el
	 *                      conteo
	 * @return número de butacas libres
	 * @throws IllegalArgumentException si la fila o butaca iniciales no son válidas
	 */
	private int contarButacasLibres(int filaInicial, int butacaInicial) {
		if (filaInicial >= butacas.length || filaInicial < 0) {
			throw new IllegalArgumentException("Valor de fila inicial no válido");
		}
		if (butacaInicial >= butacas[0].length || butacaInicial < 0) {
			throw new IllegalArgumentException("Valor de butaca inicial no válido");
		}
		int butacasLibres = 0;
		for (int fila = filaInicial; fila < butacas.length; fila++) {
			for (int butaca = butacaInicial; butaca < butacas[fila].length; butaca++) {
				if (!butacas[fila][butaca]) {
					butacasLibres++;
				}
			}
			butacaInicial = 0;
		}
		return butacasLibres;
	}

	/**
	 * Devuelve el número total de butacas disponibles
	 * 
	 * @return Número total de butacas disponibles
	 */
	@Override
	public int obtenerButacasDisponibles() {
		return contarButacasLibres(0, 0);
	}

	/**
	 * Genera un mapa de la sala. Una butaca libre se representa con 'O' y una
	 * ocupada con 'X'
	 * 
	 * @return Mapa de la sala
	 */
	public String obtenerMapaSala() {
		StringBuilder mapaSala = new StringBuilder("");
		for (int fila = 0; fila < butacas.length; fila++) {
			for (int butaca = 0; butaca < butacas[fila].length; butaca++) {
				if (butacas[fila][butaca]) { // Butaca ocupada
					mapaSala.append('X');
				} else { // Butaca libre
					mapaSala.append('O');
				}
			}
			mapaSala.append('\n'); // Nueva fila
		}
		return mapaSala.toString();
	}

	/**
	 * Pone todas las butacas de la sala como disponibles
	 */
	private void inicializarSala() {
		for (int fila = 0; fila < butacas.length; fila++) {
			for (int butaca = 0; butaca < butacas[fila].length; butaca++) {
				butacas[fila][butaca] = false;
			}
		}
	}

	/**
	 * Cambia la película que se proyecta en la sala y pone todas las butacas
	 * disponibles.
	 * 
	 * @param pelicula El título de la nueva película.
	 * @throws IllegalArgumentException si el título de la película es null o está
	 *                                  vacío (propagada desde la clase base Sala).
	 */
	@Override
	public void cambiarPelicula(Pelicula pelicula) {
		super.setPelicula(pelicula);
		inicializarSala();
	}

	/**
	 * 
	 * @param numeroEntradas Número de entradas deseadas
	 * @param filaInicial    Fila desde la que se inicia la venta
	 * @param butacaInicial  Butaca de la fila inicial desde la que se inicia la
	 *                       venta
	 * @return Entradas generadas
	 * @throws IllegalArgumentException si el número de entradas no es positivo o si
	 *                                  la fila o butaca iniciales no son válidas
	 * @throws IllegalStateException    si no hay suficientes entradas disponibles.
	 *                                  La venta no se realiza.
	 */
	public String venderEntradas(int numeroEntradas, int filaInicial, int butacaInicial) {
		if (numeroEntradas <= 0) {
			throw new IllegalArgumentException("El número de entradas a comprar debe ser positivo");
		}
		if (filaInicial > butacas.length || filaInicial <= 0) {
			throw new IllegalArgumentException("Valor de fila inicial no válido");
		}
		if (butacaInicial > butacas[0].length || butacaInicial <= 0) {
			throw new IllegalArgumentException("Valor de butaca inicial no válido");
		}
		// Adaptamos parámetros a índices del array
		filaInicial--;
		butacaInicial--;
		if (numeroEntradas > this.contarButacasLibres(filaInicial, butacaInicial)) {
			throw new IllegalStateException("Número de entradas disponible insuficiente");
		}

		StringBuilder entradas = new StringBuilder("");
		// Recorremos sala buscando butacas libres
		for (int fila = filaInicial; fila < butacas.length && numeroEntradas > 0; fila++) {
			for (int butaca = butacaInicial; butaca < butacas[fila].length && numeroEntradas > 0; butaca++) {
				if (!butacas[fila][butaca]) { // Butaca libre
					butacas[fila][butaca] = true;
					numeroEntradas--;
					entradas.append(
							String.format("ENTRADA\n=======\nSala: %d\nPelícula: %s\nFila: %d\n\nButaca: %d\n\n",
									this.getNumeroSala(), this.getPelicula().getTitulo(), fila + 1, butaca + 1));
				}
			}
			butacaInicial = 0;
		}
		return entradas.toString();
	}

	/**
	 * Devuelve el número de filas de la sala
	 * 
	 * @return Número de filas de la sala
	 */
	public int getFilas() {
		return butacas.length;
	}

	/**
	 * Devuelve el número de butacas por fila de la sala
	 * 
	 * @return Número de butacas por fila de la sala
	 */
	public int getButacas() {
		return butacas[0].length;
	}

	@Override
	public String toString() {
		return super.toString() + "\tEntradas disponibles: " + obtenerButacasDisponibles() + " (numeradas)";
	}
}
