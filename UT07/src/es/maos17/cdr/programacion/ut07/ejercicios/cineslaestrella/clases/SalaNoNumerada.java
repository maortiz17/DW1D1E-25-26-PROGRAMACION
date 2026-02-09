package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

public class SalaNoNumerada extends Sala {

	private final int totalButacas;
    private int disponibles;
    
    /**
     * 
     * @param pelicula: Título de la película a proyectar inicialmente
     * @param totalButacas: Capacidad total de la sala
     * @throws IllegalArgumentException 
     */
    public SalaNoNumerada(Pelicula pelicula, int totalButacas) {
    	super(pelicula);
    	if (totalButacas<= 0) {
    		throw new IllegalArgumentException("La capacidad de la sala debe ser positiva");
    	}
    	this.totalButacas = totalButacas;
    	this.disponibles = totalButacas;
    }
    
    
    @Override
	public int obtenerButacasDisponibles() {
		return disponibles;
	}

    /**
     * Cambia la película que se proyecta en la sala y pone todas las butacas disponibles.
     * @param pelicula El título de la nueva película.
     * @throws IllegalArgumentException si el título de la película es null o está vacío 
     * (propagada desde la clase base Sala).
     */
	@Override
	public void cambiarPelicula(Pelicula pelicula) {
		super.setPelicula(pelicula);
		this.disponibles = this.totalButacas;
	}
	
	public String venderEntradas(int numeroEntradas) {
		if (numeroEntradas <= 0) {
			throw new IllegalArgumentException("El número de entradas a comprar debe ser positivo");
		}
		if (numeroEntradas > this.disponibles) {
			throw new IllegalStateException("Número de entradas disponible insuficiente");
		}
		disponibles -= numeroEntradas;
		return String.format("ENTRADAS\n========\nSala: %d\nPelícula: %s\nNúmero de entradas: %d\n\n", this.getNumeroSala(), this.getPelicula().getTitulo(), numeroEntradas);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tEntradas disponibles: " + obtenerButacasDisponibles() + " (no numeradas)";
	}

}
