package ejercicios.ejercicio10.entities;

import java.util.Objects;

public class ActorInFilm implements Comparable<ActorInFilm> {
	private final int actorId;
	private final int filmId;


	public ActorInFilm(int actorId, int filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}

	// Getters y Setters
	public int getActorId() {
		return actorId;
	}

	public int getFilmId() {
		return filmId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ActorInFilm that = (ActorInFilm) o;
		return actorId == that.actorId && filmId == that.filmId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}

	@Override
	public int compareTo(ActorInFilm o) {
		// Ordenamos primero por actorId y luego por filmId para dos películas del mismo actor
		int res = Integer.compare(this.actorId, o.actorId);
		if (res == 0) {
			res = Integer.compare(this.filmId, o.filmId);
		}
		return res;
	}
}
