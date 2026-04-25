package ejercicios.ejercicio07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio07 {
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
    
    private static final String QUERY_ALQUILERES = """
            select rental_date, return_date, f.title
            from rental r
                     inner join sakila.inventory i on r.inventory_id = i.inventory_id
                     inner join sakila.film f on i.film_id = f.film_id
            where r.customer_id = ?
            order by rental_date desc
            """;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el id del cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());

     // 1.- Obtener conexión. Hay que poner el catch porque lanza checked exception
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASS)) {


            // 2.- Preparar sentencia SQL. Recibe la query con las interrogaciones
            try (PreparedStatement ps = connection.prepareStatement(QUERY_CLIENTE)) {
                // 3.- Parametrizar sentencia (cambiar las ? por valores)
                ps.setInt(1, idCliente);

                // 4.- Obtener resultados
                try (ResultSet datos = ps.executeQuery()) {
                    // 5.- Recorrer resultados
                    // 5.1.- Mirar si hay resultados. next() devuelve true si hay datos.
                    if (!datos.next()) {
                        System.out.printf("No se ha encontrado el cliente con id %d \n", idCliente);
                    } else {
                        // 5.2. - Mostrar datos
                        System.out.printf("Nombre: %s %s\n", datos.getString("first_name"), datos.getString("last_name"));
                    }
                    // 5.1.B Otra forma de ver si hay datos
//                    if (datos.isBeforeFirst()){
//                        // True si hay datos.isBeforeFirst
//                    }
                }

            }

            try (PreparedStatement ps = connection.prepareStatement(QUERY_ALQUILERES)) {
                ps.setInt(1, idCliente);
                try(ResultSet resultSet = ps.executeQuery()){

	                // Comprobar si hay filas
	                if (!resultSet.isBeforeFirst()) {
	                    // No hay filas
	                    System.out.println("El cliente no tiene alquileres");
	                } else {
	                    while(resultSet.next()){
	                    	/* Desde JDBC 4.2, se recomienda usar el método getObject
	                    	 * pasando la clase destino para que el driver 
	                    	 * realice la conversión correctamente */
	                        LocalDate fechaAlquiler = resultSet.getObject("rental_date", LocalDate.class);
	                        LocalDate fechaDevolucion = resultSet.getObject("return_date",LocalDate.class);
	                        // String fechaDevolucion = resultSet.getString("return_date");
	                        String tituloPelicula = resultSet.getString("title");
	
	                        String fechaDevolucionStr = fechaDevolucion == null ? "Pendiente" : fechaDevolucion.toString();
	
	                        System.out.printf("%10.10s %-10.10s %s \n", fechaAlquiler, fechaDevolucionStr, tituloPelicula);
	
	                    }
	
	                }
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
