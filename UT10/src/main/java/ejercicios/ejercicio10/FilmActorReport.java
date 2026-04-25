package ejercicios.ejercicio10;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ejercicios.ejercicio10.dao.IActorDao;
import ejercicios.ejercicio10.dao.IActorInFilmDao;
import ejercicios.ejercicio10.dao.IFilmDao;
import ejercicios.ejercicio10.dao.impl.ActorDao;
import ejercicios.ejercicio10.dao.impl.ActorInFilmDao;
import ejercicios.ejercicio10.dao.impl.FilmDao;
import ejercicios.ejercicio10.entities.Actor;
import ejercicios.ejercicio10.entities.ActorInFilm;
import ejercicios.ejercicio10.entities.Film;

public class FilmActorReport {
	// Datos de conexión (ajustar a tu entorno)
    private static final String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String user = "sakila";
    private static final String pass = "oracle123";
    
	// Creamos comparator para ordenar lista de actores
	private static final Comparator<Actor> SORT_BY_NAME_COMPARATOR = new Comparator<>(){
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
        IActorDao actorDAO = new ActorDao(url, user, pass);
        IFilmDao filmDAO = new FilmDao(url, user, pass);
        IActorInFilmDao associationDAO = new ActorInFilmDao(url, user, pass);

        try {
            // 1. Obtener las tres colecciones de la BD
            List<Actor> actors = actorDAO.getAll();
            List<Film> films = filmDAO.getAll();
            List<ActorInFilm> associations = associationDAO.getAll();

            // 2. Generar el mapa del informe
            Map<Film, Set<Actor>> report = createFilmActorReport(films, actors, associations);

            // 3. Mostrar el informe por consola
            printReport(report);
        } catch (SQLException e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Crea el mapa asociando cada película con su conjunto de actores ordenados.
     */
    private static Map<Film, Set<Actor>> createFilmActorReport(List<Film> films, List<Actor> actors, List<ActorInFilm> associations){
    	
    	// Podríamos usar TreeMap para que las películas aparecieran ordenadas por su ID (orden natural)
    	// Como no piden nada utilizamos HashMap que es más rápido
        // El Set de Actores usará un Comparator para ordenar por nombre y apellidos
    	Map<Film, Set<Actor>> report = new HashMap<>();
    	
    	// Creamos un Map de actores para la búsqueda
    	Map<Integer, Actor> mapActors = new HashMap<>(actors.size());
    	for (Actor actor : actors) {
    		mapActors.put(actor.getActorId(), actor);
    	}
    	
    	// Creamos el mapa
    	for (Film film : films) {
    		report.put(film, createActorSet(film.getFilmId(), mapActors, associations));
    	}
    	
    	return report;
    }

    /**
     * Creamos un Set de Actor para un filmId
     */
    private static Set<Actor> createActorSet(int filmId, Map<Integer, Actor> actors, List<ActorInFilm> associations){
    	// Creamos un TreeSet ordenado por el Coparator anterior
    	Set<Actor> results = new TreeSet<>(SORT_BY_NAME_COMPARATOR);
    	
    	// Añadimos actores a la colección
    	for (ActorInFilm actorInFilm : associations) {
    		if (actorInFilm.getFilmId() == filmId) {
  				results.add(actors.get(actorInFilm.getActorId()));
    		}
    	}
    	return results;
    }
    
    /**
     * Muestra el informe en consola con el formato solicitado.
     */
    private static void printReport(Map<Film, Set<Actor>> report) {
        System.out.println("--- INFORME DE PELÍCULAS Y ACTORES ---");
        for (Map.Entry<Film, Set<Actor>> entry : report.entrySet()) {
            Film pelicula = entry.getKey();
            Set<Actor> actores = entry.getValue();

            System.out.print(pelicula.getTitle() + ": ");
            
            if (actores.isEmpty()) {
                System.out.println("No hay actores registrados.");
            } else {
                // Construimos la salida en un StringBuilder
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