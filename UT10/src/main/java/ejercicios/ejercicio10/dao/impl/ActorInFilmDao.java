package ejercicios.ejercicio10.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio10.dao.IActorInFilmDao;
import ejercicios.ejercicio10.entities.ActorInFilm;

public class ActorInFilmDao implements IActorInFilmDao {
    private static final String SQL_GET_ALL = "SELECT actor_id, film_id FROM film_actor"; //
	
	private final String url_conexion;
    private final String user;
    private final String password;

    public ActorInFilmDao(String url, String user, String password) {
		this.url_conexion = url;
		this.user = user;
		this.password = password;
	}

    @Override
    public List<ActorInFilm> getAll() throws SQLException{
        List<ActorInFilm> asociaciones = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url_conexion, user, password);
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_ALL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                asociaciones.add(new ActorInFilm(
                    rs.getInt("actor_id"),
                    rs.getInt("film_id")
                ));
            }
        }
        return asociaciones;
    }
}
