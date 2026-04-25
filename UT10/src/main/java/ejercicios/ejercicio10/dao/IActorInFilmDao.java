package ejercicios.ejercicio10.dao;

import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio10.entities.ActorInFilm;

public interface IActorInFilmDao {
	List<ActorInFilm> getAll() throws SQLException;
	
}
