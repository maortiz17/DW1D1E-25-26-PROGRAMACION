package ejercicios.ejercicio06;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio06 {

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";
    private static final String QUERY_CLIENTE = """
            select first_name, last_name, email, active,
                   a.address, a.address2, a.district, a.postal_code, a.phone,
                   c2.city, c3.country
            from customer c
                     inner join address a on c.address_id = a.address_id
                     inner join scity c2 on a.city_id = c2.city_id
                     inner join scountry c3 on c2.country_id = c3.country_id
            where customer_id = ?
            """;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el id del cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        // 1.- Obtener conexión. Hay que poner el catch porque lanza checked exception
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASS)) {
            // 2.- Preparar sentencia SQL. Recibe la query con las interrogaciones
            try (PreparedStatement pstmt = connection.prepareStatement(QUERY_CLIENTE)) {
                // 3.- Parametrizar sentencia (cambiar las ? por valores)
                pstmt.setInt(1, idCliente);

                // 4.- Obtener resultados
                try (ResultSet rs = pstmt.executeQuery()) {
                    // 5.- Recorrer resultados
                    // 5.1.- Mirar si hay resultados. next() devuelve true si hay datos.
                    if (!rs.next()) {
                        System.out.printf("No se ha encontrado el cliente con id %d \n", idCliente);
                    }
                    else{
                        // 5.2. - Mostrar datos
                        System.out.printf("Nombre: %s %s\n", rs.getString("first_name"), rs.getString( "last_name"));
                    }
                    // 5.1.B Otra forma de ver si hay datos
//                    if (datos.isBeforeFirst()){
//                        // True si hay datos.isBeforeFirst
//                    }
                }
                
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
        	sc.close();
        }
        System.out.println("Fin del programa");
    }
}
