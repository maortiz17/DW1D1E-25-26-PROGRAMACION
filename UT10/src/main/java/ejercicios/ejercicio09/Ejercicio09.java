package ejercicios.ejercicio09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio09 {

	private static final Scanner sc = new Scanner(System.in);
	
	private static final String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";
    
	private static final String QUERY_COMPROBAR_CIUDAD = "select city_id from scity where city = ?";
	private static final String QUERY_COMPROBAR_PAIS = "select country_id from scountry where country = ?";
	private static final String QUERY_CREAR_PAIS = "insert into scountry (country) values (?)";
	private static final String QUERY_CREAR_CIUDAD = "insert into scity(city, country_id) values (?,?)";
	
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(CONNECTION_STRING, USER, PASS)){
			System.out.print("Introduce nombre de nueva ciudad: ");
			String nombreCiudad = sc.nextLine();
			
			if (existeCiudad(con, nombreCiudad)) {
				System.out.println("Ya existe esa ciudad");
				return;
			}
			
			System.out.print("Introduce nombre del país: ");
			String nombrePais = sc.nextLine();
			int idPais = getIdPais(con, nombrePais);
			if (idPais == 0) {
				idPais = crearPais(con, nombrePais);
				if (idPais > 0) {
					System.out.println("Se ha creado el nuevo país correctamente");
				}
			}
			
			// Creamos ciudad con el id de país (nuevo o ya existente)
			if (idPais > 0) {
				crearCiudad(con, nombreCiudad, idPais);
			}
			
		}catch(SQLException e) {
			System.out.println("Error de conexión: " + e.getMessage());
		}

	}
	
	private static boolean existeCiudad(Connection con, String nombreCiudad) {
		try(PreparedStatement pstmt = con.prepareStatement(QUERY_COMPROBAR_CIUDAD)){
			pstmt.setString(1, nombreCiudad);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		}catch(SQLException e) {
			System.out.println("Error al comprobar ciudad: " + e.getMessage());
			return false;
		}
	}
	
	private static int getIdPais(Connection con, String nombrePais) {
		try(PreparedStatement pstmt = con.prepareStatement(QUERY_COMPROBAR_PAIS)){
			pstmt.setString(1, nombrePais);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("country_id");
			}else {
				return 0;
			}
		}catch(SQLException e) {
			System.out.println("Error al comprobar pais: " + e.getMessage());
			return 0;
		}
	}
	
	private static int crearPais(Connection con, String nombrePais) {
		String[] pk = {"country_id"};
		try(PreparedStatement pstmt = con.prepareStatement(QUERY_CREAR_PAIS, pk)){
			pstmt.setString(1, nombrePais);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}
		}catch(SQLException e) {
			System.out.println("Error al crear pais: " + e.getMessage());
			return 0;
		}
	}
	
	private static void crearCiudad(Connection con, String nombreCiudad, int idPais) {
		try(PreparedStatement pstmt = con.prepareStatement(QUERY_CREAR_CIUDAD)){
			pstmt.setString(1, nombreCiudad);
			pstmt.setInt(2, idPais);
			pstmt.executeUpdate();
			System.out.println("Se ha creado la ciudad correctamente");
		}catch(SQLException e) {
			System.out.println("Error al crear pais: " + e.getMessage());
		}
	}

}
