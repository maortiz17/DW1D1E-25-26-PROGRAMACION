package ejercicios.ejercicio13.dao;

import java.sql.SQLException;
import java.util.Map;

import ejercicios.ejercicio13.entities.Film;

public interface IFilmDao {
	Map<Integer, Film> getAll() throws SQLException;
	Film getById(int id) throws SQLException;
}
