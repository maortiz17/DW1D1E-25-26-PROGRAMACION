package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

public abstract class Sala {
    
    private static int proxNum = 1;
    private final int numeroSala;
    private Pelicula pelicula;
    
    /**
     * 
     * @param pelicula: Título de película a proyectar inicialmente
     */
    public Sala(Pelicula pelicula){
    	setPelicula(pelicula);
        numeroSala = proxNum++;
    }

    /**
     * Devuelve el título de la película proyectada
     * @return String con el título de la película proyectada
     */
    public Pelicula getPelicula() {
    	return new Pelicula(pelicula);
    }
    
    /**
     * Devuelve el número de la sala
     * @return entero con el número de la sala
     */
    public int getNumeroSala() {
        return numeroSala ;
    }
    
    @Override
    public String toString(){
        return "Sala número: " + numeroSala + "\t" + pelicula.toString();
    }
    
    /**
     * Cambia el título de la película proyectada
     * @param pelicula: Título de la nueva película a proyectar
     * @throws IllegalArgumentException si el título es null o está vacío
     */
    public void setPelicula(Pelicula pelicula) {
    	if (pelicula == null) {
    		throw new IllegalArgumentException("Película inválida");
    	}
    	this.pelicula = new Pelicula(pelicula);
    }
    
    /**
     * Modifica la película asignada a la sala.
     * Las clases concretas deberán encargarse de resetear el estado de la sala (butacas).
     * @param pelicula El nuevo título de la película.
     * @throws IllegalArgumentException Si el título es null o está vacío 
     * (según validación de setPelicula).
     */
    public abstract void cambiarPelicula(Pelicula pelicula);
    
    public abstract int obtenerButacasDisponibles();
}
