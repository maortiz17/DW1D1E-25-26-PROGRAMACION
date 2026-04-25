package ejercicios.ejercicio03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Ejercicio03 {
	private static final String CAD_CONEXION = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static final String USER = "sakila";
	private static final String PASS = "oracle123";

	private static final String QUERY = """
			select trunc(payment_date) as fecha_pago, sum(amount) total
			from payment
			group by trunc(payment_date)
			order by trunc(payment_date) desc
			""";

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection(CAD_CONEXION, USER, PASS)) {
			try (PreparedStatement pstmt = con.prepareStatement(QUERY)) {
				try (ResultSet rs = pstmt.executeQuery()) {

					System.out.println("Fecha\t\t\tImporte");
					System.out.println("_".repeat(100));
					while (rs.next()) {
						LocalDate fecha = rs.getObject("fecha_pago", LocalDate.class);
						double importe = rs.getDouble("total");
						System.out.printf("%s\t\t%7.2f\n", fecha, importe);
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
