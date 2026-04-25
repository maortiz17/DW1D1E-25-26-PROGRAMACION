package ejercicios.ejercicio13.dao;

import java.sql.SQLException;
import java.util.Map;

import ejercicios.ejercicio13.entities.Actor;

public interface IActorDao {
	Map<Integer, Actor> getAll() throws SQLException;
	Actor getById(int id) throws SQLException;
}
