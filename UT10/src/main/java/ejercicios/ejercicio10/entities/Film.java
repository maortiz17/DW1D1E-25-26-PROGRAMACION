package ejercicios.ejercicio10.entities;

import java.util.Objects;

public class Film implements Comparable<Film> {
	private final int filmId;
	private final String title;
	private final String description;
	private final Integer releaseYear; // Puede ser null, por lo que utilizo un objeto
	private final Integer length; // Puede ser null, por lo que utilizo un objeto
	private final String rating;

	public Film(int filmId, String title, String description, int releaseYear, int length, String rating) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.length = length;
		this.rating = rating;
	}

	// Getters
	public int getFilmId() {
		return filmId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public Integer getLength() {
		return length;
	}

	public String getRating() {
		return rating;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Film film = (Film) o;
		return filmId == film.filmId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmId);
	}

	@Override
	public int compareTo(Film other) {
		return Integer.compare(this.filmId, other.filmId);
	}
}