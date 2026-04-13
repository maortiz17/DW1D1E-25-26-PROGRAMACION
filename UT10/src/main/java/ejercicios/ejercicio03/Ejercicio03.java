package ejercicios.ejercicio03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Ejercicio03 {
	private static final String CAD_CONEXION = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static final String USER = "sakila";
	private static final String PASS = "oracle123";

	private static final String QUERY = """
			select payment_date, sum(amount) total
			from payment
			group by payment_date
			order by payment_date desc
			""";

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(CAD_CONEXION, USER, PASS)) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(QUERY)) {

					System.out.println("Fecha\t\t\tImporte");
					System.out.println("_".repeat(100));
					while (resultSet.next()) {
						Timestamp fecha = resultSet.getTimestamp("payment_date");
						double importe = resultSet.getDouble("total");
						System.out.printf("%s\t\t%7.2f\n", fecha.toLocalDateTime().toLocalDate(), importe);
					}
				} catch (SQLException e) {
					System.out.printf("Error al ejecutar sentencia: %s\n", e.getMessage());
				}
			} catch (SQLException e) {
				System.out.printf("Error al crear sentencia: %s\n", e.getMessage());
			}
		} catch (SQLException e) {
			System.out.printf("Error al conectar: %s\n", e.getMessage());
		}

	}
}
