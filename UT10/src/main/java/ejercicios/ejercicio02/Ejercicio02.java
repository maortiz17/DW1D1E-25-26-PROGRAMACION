package ejercicios.ejercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio02 {
	private static final String CAD_CONEXION = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";

    private static final String QUERY = """
            SELECT title,
                   release_year,
                   l.name as language,
                   ol.name as original_language,
                   original_language_id,
                   rating,
                   description
            FROM film
            INNER JOIN sakila.language l on film.language_id = l.language_id
            LEFT JOIN sakila.language ol on film.original_language_id = ol.language_id
            ORDER BY title
            """;


    public static void main(String[] args) {

        try(Connection con = DriverManager.getConnection(CAD_CONEXION, USER, PASS)){
            try (PreparedStatement pstmt = con.prepareStatement(QUERY)) {
                try (ResultSet rs = pstmt.executeQuery()) {

                    while(rs.next()){
                        // Evitar usar índice de columna:
                        //String title =  resultSet.getString(1);
                        String title =  rs.getString("title");
                        int year = rs.getInt("release_year");
                        String language = rs.getString("language");
                        String originalLanguage= rs.getString("original_language");
                        String rating = rs.getString("rating");
                        String description = rs.getString("description");

                        if (originalLanguage == null){
                            originalLanguage = "Desconocido";
                        }

                        System.out.printf("%s - %d - %s - %s - %s\n%s\n", title, year, language, originalLanguage, rating, description);
                        System.out.println("_".repeat(100));
                    }




                }catch (SQLException e) {
                    System.out.printf("Error al ejecutar sentencia: %s\n", e.getMessage());
                }


            }catch (SQLException e) {
                System.out.printf("Error al crear sentencia: %s\n", e.getMessage());
            }

        } catch (SQLException e) {
            System.out.printf("Error al conectar: %s\n", e.getMessage());
        }


    }
}
