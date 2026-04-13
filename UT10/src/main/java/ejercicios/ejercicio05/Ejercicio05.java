package ejercicios.ejercicio05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio05 {
	private static final String CAD_CONEXION = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private static final String USER = "sakila";
	private static final String PASS = "oracle123";
	
	private static final String UPDATE = """
			update language
            set name = substr(name, 1, length(name)-1)
            where name like '%X'
			""";
	
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(CAD_CONEXION, USER, PASS)){
			try(PreparedStatement pstmt = con.prepareStatement(UPDATE)){
				int numRegistrosAfectados = pstmt.executeUpdate();
				System.out.printf("Se han modificado %d filas.\n", numRegistrosAfectados);
				
			}
		}catch(SQLException e) {
			System.out.println("Error de conexión o al ejecutar: " + e.getMessage());
		}
	}
}

