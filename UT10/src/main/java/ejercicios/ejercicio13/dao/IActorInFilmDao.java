package ejercicios.ejercicio13.dao;

import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio13.entities.ActorInFilm;

public interface IActorInFilmDao {
	List<ActorInFilm> getAll() throws SQLException;
	
}
