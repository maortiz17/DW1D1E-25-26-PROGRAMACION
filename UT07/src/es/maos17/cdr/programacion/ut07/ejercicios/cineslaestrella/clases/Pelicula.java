package es.maos17.cdr.programacion.ut07.ejercicios.cineslaestrella.clases;

public class Pelicula {
	private String titulo;
	private int duracionMinutos;
	private Categoria categoria;

	/**
	 * Crea un nuevo objeto de tipo Pelicula a partir de tres parámetros
	 * 
	 * @param titulo          Título de la película
	 * @param duracionMinutos Duración en minutos de la película
	 * @param categoria       Categoría a la que pertenece la película. Tiene que
	 *                        ser uno de los valores del tipo enumerado Categoria
	 * @throws IllegalArgumentException a través de setters setTitulo y setDuracionMinutos
	 */
	public Pelicula(String titulo, int duracionMinutos, Categoria categoria) {
		setTitulo(titulo);
		setDuracionMinutos(duracionMinutos);
		this.categoria = categoria;
	}
	
	/**
	 * Constructor de copia
	 * @param Objeto de tipo Pelicula utilizado para crear el nuevo objeto
	 */
	public Pelicula(Pelicula pelicula) {
		this(pelicula.titulo, pelicula.duracionMinutos, pelicula.categoria);
	}

	/**
	 * @return Devuelve título de la película
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo Título de la película
	 * @throws IllegalArgumentException si el título es una cadena de caracteres vacía
	 */
	public void setTitulo(String titulo) {
		if (titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("Título no válido");
		}
		this.titulo = titulo;
	}

	/**
	 * @return Devuelve duración en minutos de la película
	 */
	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	/**
	 * @param Fija la duración en minutos de la película
	 * @throws IllegalArgumentException si la duración no es un entero positivo
	 */
	public void setDuracionMinutos(int duracionMinutos) {
		if (duracionMinutos <= 0) {
			throw new IllegalArgumentException("La duración en minutos tiene que ser un entero positivo");
		}
		this.duracionMinutos = duracionMinutos;
	}

	/**
	 * @return Devuelve la categoría a la que pertenece la película
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param Recibe la categoría a la que pertenece la película
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
	    return titulo + " (" + duracionMinutos + " minutos) [" + categoria + "]";
	}
	
}
