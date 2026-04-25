package ejercicios.ejercicio08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio08 {
	private static final String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";
    private static final String QUERY_COMPROBAR_CLIENTE = "select customer_id from customer where customer_id = ?";

    private static final String QUERY_UPDATE_EMAIL = "update customer set email = ? where customer_id = ?";
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Introduce el id del cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        // Abrimos la conexión 
        try (Connection con = DriverManager.getConnection(CONNECTION_STRING, USER, PASS)) {
            
            if (!existeCliente(con, idCliente)) {
                System.out.println("No se ha encontrado al cliente");
                return;
            }

            System.out.print("Introduce el nuevo correo electrónico: ");
            String nuevoCorreo = scanner.nextLine();

            if (!modificarCorreo(con, idCliente, nuevoCorreo)) {
                System.out.println("No se ha podido modificar el correo");
            } else {
                System.out.println("Correo modificado correctamente");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    private static boolean existeCliente(Connection con, int idCliente) {
        try (PreparedStatement pstmt = con.prepareStatement(QUERY_COMPROBAR_CLIENTE)) {
            pstmt.setInt(1, idCliente);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Error SQL en comprobación: " + e.getMessage());
            return false;
        }
    }

    private static boolean modificarCorreo(Connection con, int idCliente, String nuevoCorreo) {
        try (PreparedStatement pstmt = con.prepareStatement(QUERY_UPDATE_EMAIL)) {
            pstmt.setString(1, nuevoCorreo);
            pstmt.setInt(2, idCliente);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error SQL en modificación: " + e.getMessage());
            return false;
        }
    }
}