package ejercicios.ejercicio10.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio10.dao.IActorDao;
import ejercicios.ejercicio10.entities.Actor;

public class ActorDao implements IActorDao {
	private static final String SQL_GET_ALL = "SELECT actor_id, first_name, last_name FROM ACTOR";
	private static final String SQL_GET_BY_ID = "SELECT actor_id, first_name, last_name FROM ACTOR WHERE actor_id = ?";
	
    private final String url_conexion;
    private final String user;
    private final String password;

    public ActorDao(String url, String user, String password) {
        this.url_conexion = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Actor> getAll() throws SQLException{
        List<Actor> actores = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url_conexion, user, password);
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_ALL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                actores.add(new Actor(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
                ));
            }
        }
        return actores;
    }

    @Override
    public Actor getById(int id) throws SQLException{
        try (Connection con = DriverManager.getConnection(url_conexion, user, password);
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_BY_ID)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Actor(
                        rs.getInt("actor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    );
                }
            }
        }
        return null;
    }
}