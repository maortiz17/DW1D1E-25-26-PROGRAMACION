package ejercicios.ejercicio10.dao;

import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio10.entities.Film;

public interface IFilmDao {
	List<Film> getAll() throws SQLException;
	Film getById(int id) throws SQLException;
}
