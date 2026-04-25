package ejercicios.ejercicio10.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio10.dao.IFilmDao;
import ejercicios.ejercicio10.entities.Film;

public class FilmDao implements IFilmDao {
	private static final String SQL_GET_ALL = "SELECT film_id, title, description, release_year, length, rating FROM film";
	private static final String SQL_GET_BY_ID = "SELECT film_id, title, description, release_year, length, rating FROM film WHERE film_id = ?"; //
	
    private final String url_conexion;
    private final String user;
    private final String password;

    public FilmDao(String url, String user, String password) {
        this.url_conexion = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Film> getAll() throws SQLException{
        List<Film> peliculas = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url_conexion, user, password);
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_ALL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                peliculas.add(new Film(
                    rs.getInt("film_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getObject("release_year") != null ? rs.getInt("release_year") : null, // El atributo de la entidad es un objeto, por lo que puedo almacenar null
                    rs.getObject("length") != null ? rs.getInt("length") : null,
                    rs.getString("rating")
                ));
            }
        }
        return peliculas;
    }

    @Override
    public Film getById(int id) throws SQLException{

        try (Connection con = DriverManager.getConnection(url_conexion, user, password);
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_BY_ID)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                        rs.getInt("film_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getObject("release_year") != null ? rs.getInt("release_year") : null,
                        rs.getObject("length") != null ? rs.getInt("length") : null,
                        rs.getString("rating")
                    );
                }
            }
        }
        return null;
    }
}