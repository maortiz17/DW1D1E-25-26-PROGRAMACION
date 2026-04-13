package ejercicios.ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {

	private static final String URL_CONEXION = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";

    private static final String QUERY = """
            SELECT title,
                   release_year,
                   language_id,
                   original_language_id,
                   rating,
                   description
            FROM film
            ORDER BY title
            """;


    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(URL_CONEXION, USER, PASS)){
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(QUERY)) {

                    while(resultSet.next()){
                        // Evitar usar índice de columna:
                        //String title =  resultSet.getString(1);
                        String title =  resultSet.getString("title");
                        int year = resultSet.getInt("release_year");
                        int languageId = resultSet.getInt("language_id");
                        int originalLanguageId = resultSet.getInt("original_language_id");
                        String rating = resultSet.getString("rating");
                        String description = resultSet.getString("description");

                        System.out.printf("%s - %d - %d - %d - %s\n%s\n", title, year, languageId, originalLanguageId, rating, description);
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
