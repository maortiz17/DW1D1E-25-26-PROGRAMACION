package ejercicios.ejercicio10.dao;

import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio10.entities.Actor;

public interface IActorDao {
	List<Actor> getAll() throws SQLException;
	Actor getById(int id) throws SQLException;
}
