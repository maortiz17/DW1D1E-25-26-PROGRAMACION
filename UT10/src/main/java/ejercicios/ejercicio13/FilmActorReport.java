package ejercicios.ejercicio13;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ejercicios.ejercicio13.dao.impl.ActorDao;
import ejercicios.ejercicio13.dao.impl.ActorInFilmDao;
import ejercicios.ejercicio13.dao.impl.FilmDao;
import ejercicios.ejercicio13.entities.Actor;
import ejercicios.ejercicio13.entities.ActorInFilm;
import ejercicios.ejercicio13.entities.Film;

public class FilmActorReport {
    // Datos de conexión
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "sakila";
    private static final String PASS = "oracle123";
    
    // Comparator para ordenar actores por nombre y apellido
    private static final Comparator<Actor> SORT_BY_NAME_COMPARATOR = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            int res = a1.getFirstName().compareTo(a2.getFirstName());
            if (res == 0) {
                res = a1.getLastName().compareTo(a2.getLastName());
            }
            return res;
        }
    };

    public static void main(String[] args) {
        // Instanciar DAOs
        ActorDao actorDAO = new ActorDao(URL, USER, PASS);
        FilmDao filmDAO = new FilmDao(URL, USER, PASS);
        ActorInFilmDao associationDAO = new ActorInFilmDao(URL, USER, PASS);

        try {
            // 1. Obtener los datos directamente en el formato eficiente (Mapas e ID)
            Map<Integer, Actor> actors = actorDAO.getAll();
            Map<Integer, Film> films = filmDAO.getAll();
            List<ActorInFilm> associations = associationDAO.getAll();

            // 2. Generar el mapa del informe
            Map<Film, Set<Actor>> report = createFilmActorReport(films, actors, associations);

            // 3. Mostrar el informe por consola
            imprimirInforme(report);

        } catch (SQLException e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Crea el informe asociando actores a películas.
     * Ahora es más sencillo porque no hay que crear mapas de búsqueda intermedios.
     */
    private static Map<Film, Set<Actor>> createFilmActorReport(Map<Integer, Film> filmsMap, Map<Integer, Actor> actorsMap, List<ActorInFilm> associations) {
        Map<Film, Set<Actor>> report = new HashMap<>();

        // Paso A: Inicializamos el informe con todas las películas y sets vacíos
        // Usamos .values() para obtener la colección de objetos Film del mapa
        for (Film film : filmsMap.values()) {
            report.put(film, new TreeSet<>(SORT_BY_NAME_COMPARATOR));
        }

        // Paso B: "Repartimos" las asociaciones. 
        // Es una sola pasada.
        for (ActorInFilm actorInFilm : associations) {
            Film film = filmsMap.get(actorInFilm.getFilmId());
            Actor actor = actorsMap.get(actorInFilm.getActorId());

            if (film != null && actor != null) {
                report.get(film).add(actor);
            }
        }

        return report;
    }

    /**
     * Muestra el informe en consola con el formato solicitado.
     */
    private static void imprimirInforme(Map<Film, Set<Actor>> informe) {
        System.out.println("--- INFORME DE PELÍCULAS Y ACTORES ---");
        for (Map.Entry<Film, Set<Actor>> entrada : informe.entrySet()) {
            Film pelicula = entrada.getKey();
            Set<Actor> actores = entrada.getValue();

            System.out.print(pelicula.getTitle() + ": ");
            
            if (actores.isEmpty()) {
                System.out.println("No hay actores registrados.");
            } else {
                StringBuilder sb = new StringBuilder();
                boolean primero = true;
                for (Actor a : actores) {
                    if (!primero) {
                        sb.append(", ");
                    }
                    sb.append(a.getFirstName()).append(" ").append(a.getLastName());
                    primero = false;
                }
                System.out.println(sb.toString());
            }
        }
    }
}