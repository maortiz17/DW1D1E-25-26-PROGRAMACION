package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciocine;

public class Cine {
	private static int contadorPeliculas;
	
	private Pelicula pelicula;
	private Butaca[][] sala;
	
	public Cine(Pelicula pelicula, int filas, int butacas) {
		if (pelicula == null || filas < 0 || filas > 15 || butacas < 0 || butacas > 20) {
			throw new IllegalArgumentException("Error al crear el cine");
		}
		this.pelicula = pelicula;
		this.sala = new Butaca[filas][butacas];
		cambiarPelicula(pelicula);
	}
	
	public void cambiarPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
		contadorPeliculas++;
		vaciarSala();
	}
	
	public void vaciarSala() {
		for (int fila = 0; fila < this.sala.length; fila++) {
			for (int butaca = 0; butaca < this.sala[0].length; butaca++) {
				sala[fila][butaca] = Butaca.LIBRE;
			}
		}
	}
	
	public int contarButacas(int filaInicial, int butacaInicial) {
		int butacasLibres = 0;
		for (int fila = filaInicial - 1; fila < this.sala.length; fila++) {
			for (int butaca = butacaInicial - 1; butaca < this.sala[0].length; butaca++) {
				if (sala[fila][butaca] == Butaca.LIBRE) {
					butacasLibres++;
				}
			}
			butacaInicial = 1;
		}
		return butacasLibres;
	}
	
	public double venderEntradas (int cantidad, int filaInicial, int butacaInicial) {
		if (cantidad > contarButacas(filaInicial, butacaInicial)) {
			throw new IllegalStateException("No hay suficientes butacas para la selección");
		}
		int entradasVendidas = 0;
		for (int fila = filaInicial - 1; entradasVendidas < cantidad && fila < sala.length; fila++) {
			for (int butaca = butacaInicial - 1; entradasVendidas < cantidad && butaca < sala[0].length; butaca++) {
				if (sala[fila][butaca] == Butaca.LIBRE) {
					sala[fila][butaca] = Butaca.OCUPADO;
					entradasVendidas++;
				}
			}
			butacaInicial = 1;
		}
		return this.pelicula.getPrecioEntrada() * cantidad;
	}
	
	public void verSala() {
		System.out.println("----PANTALLA---- Película: " + this.pelicula.getTitulo());
		for (int fila = 0; fila < this.sala.length; fila++) {
			System.out.printf("Fila %02d: ", fila + 1);
			for (int butaca = 0; butaca < this.sala[0].length; butaca++) {
				if (sala[fila][butaca] == Butaca.LIBRE) {
					System.out.printf("[L]");
				}
				else {
					System.out.printf("[O]");
				}
			}
			System.out.print("\n");
		}
	}

	public static int getContadorPeliculas() {
		return contadorPeliculas;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}
	
	public int getFilas() {
		return this.sala.length;
	}
	
	public int getButacas() {
		return this.sala[0].length;
	}
}
