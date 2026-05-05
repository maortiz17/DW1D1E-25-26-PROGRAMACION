package ejercicios.ejercicio07_15;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ejercicio07_15 {
	public static void main(String[] args) {

		System.out.println("\n===== EJERCICIO 7 =====");
		ejercicio7();

		System.out.println("\n===== EJERCICIO 8 =====");
		ejercicio8();

		System.out.println("\n===== EJERCICIO 9 =====");
		ejercicio9();

		System.out.println("\n===== EJERCICIO 10 =====");
		ejercicio10();

		System.out.println("\n===== EJERCICIO 11 =====");
		ejercicio11();
		
		System.out.println("\n===== EJERCICIO 12 =====");
		ejercicio12();
		
		System.out.println("\n===== EJERCICIO 13 =====");
		ejercicio12();
		
		System.out.println("\n===== EJERCICIO 14 =====");
		ejercicio14ConConsumer();
		ejercicio14ConPredicate();
		
		System.out.println("\n===== EJERCICIO 15 =====");
		ejercicio15();

	}

	/**
	 * EJERCICIO 7: Usar interfaces funcionales predefinidas - Consumer
	 * 
	 * Enunciado: Crea un Consumer que reciba un string y lo imprima en mayúsculas.
	 */
	public static void ejercicio7() {

		Consumer<String> imprimirMayusculas = s -> System.out.println(s.toUpperCase());

		imprimirMayusculas.accept("hola, este texto se convertirá a mayúsculas");

		// Esto no haria nada, ya que accept no devuelve nada
		Consumer<String> mayusculas1 = s -> s.toUpperCase();
//		System.out.println(mayusculas1.accept("hola, este texto se convertirá a mayúsculas"));

		// Esto sí, ahora con la FI Function de Java devuelve una cadena:
		Function<String, String> mayusculas2 = s -> s.toUpperCase();
		System.out.println(mayusculas2.apply("hola, este texto se convertirá a mayúsculas"));
	}

	/**
	 * EJERCICIO 8: Usar interfaces funcionales predefinidas - Function
	 * 
	 * Enunciado: Crea una Function que convierta un string a su longitud, y
	 * aplícala a varios ejemplos.
	 */
	public static void ejercicio8() {

		Function<String, Integer> obtenerLongitud = s -> s.length();

		String texto1 = "Hola";
		String texto2 = "Programación Funcional";

		System.out.println("Longitud de '" + texto1 + "': " + obtenerLongitud.apply(texto1));
		System.out.println("Longitud de '" + texto2 + "': " + obtenerLongitud.apply(texto2));
	}

	/**
	 * EJERCICIO 9: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Escribe un Predicate que devuelva true si un número es par, y
	 * false si es impar.
	 * 
	 */
	public static void ejercicio9() {
		Predicate<Integer> esPar = n -> n % 2 == 0;

		int numero = 7;
		System.out.print("El numero '" + numero);
		System.out.println(esPar.test(numero) ? " es par." : " es impar.");
		
		numero = 10;
		System.out.print("El numero '" + numero);
		System.out.println(esPar.test(numero) ? " es par." : " es impar.");
	}

	/**
	 * EJERCICIO 10: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Crea una lambda que reciba un nombre y una edad, y muestre un
	 * mensaje como: "Luis tiene 25 años."
	 * 
	 */
	public static void ejercicio10() {
		// Definimos la lambda que recibe nombre y edad
		BiConsumer<String, Integer> mostrarMensaje = (nombre, edad) -> System.out
				.println(nombre + " tiene " + edad + " años.");

		// Probamos la lambda con diferentes valores
		mostrarMensaje.accept("Pedro", 22);
		mostrarMensaje.accept("María", 30);
		mostrarMensaje.accept("Carlos", 45);

	}

	/**
	 * EJERCICIO 11: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Ordenación con Comparator (sin streams): 
	 * Dada una lista de nombres (ArrayList<String>), 
	 * ordénala usando una lambda con Comparator.
	 * 
	 */
	
	public static void ejercicio11() {
		List<String> nombres = Arrays.asList("Miguel", "Carmen", "Marta", "Pedro", "Anselmo");
		nombres.sort((a, b) -> a.compareTo(b));
		System.out.println(nombres);
	}
	/**
	 * 
	 * EJERCICIO 12: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Crea un Predicate que determine si una edad es mayor o igual a 18.
	 * Si es mayor, imprime "Mayor de edad", si no, "Menor de edad".
	 * 
	 */
	public static void ejercicio12() {
		Predicate<Integer> mayorEdad = n -> n > 18;

		System.out.println(mayorEdad.test(17) ? " es mayor de edad." : " es menor de edad.");
		System.out.println(mayorEdad.test(20) ? " es mayor de edad." : " es menor de edad.");
	}

	/**
	 * EJERCICIO 13: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Escribe una función lambda que convierta grados Celsius a
	 * Fahrenheit. Fórmula: F = C × 9/5 + 32. Aplica la función a varios valores y
	 * muestra los resultados.
	 * 
	 */
	public static void ejercicio13() {
		Function<Double, Double> celsiusAFahrenheit = celsius -> celsius * 9 / 5 + 32;

		// Probamos la lambda con diferentes temperaturas
		System.out.println("0°C = " + celsiusAFahrenheit.apply(0.0) + "°F");
		System.out.println("25°C = " + celsiusAFahrenheit.apply(25.0) + "°F");
		System.out.println("100°C = " + celsiusAFahrenheit.apply(100.0) + "°F");
		System.out.println("-10°C = " + celsiusAFahrenheit.apply(-10.0) + "°F");
	}

	/**
	 * EJERCICIO 14: Usar interfaces funcionales predefinidas
	 * 
	 * Enunciado: Haz una función que verifique si una contraseña tiene al menos 8
	 * caracteres. Si es válida, imprime "Contraseña válida", si no, "Demasiado
	 * corta".
	 * 
	 */
	public static void ejercicio14ConConsumer() {
		 // Definimos la lambda que verifica la longitud de la contraseña
        Consumer<String> verificarContrasena = password -> {
            if (password.length() >= 8) {
                System.out.println("Contraseña válida");
            } else {
                System.out.println("Demasiado corta");
            }
        };
        
     // Probamos la lambda con diferentes contraseñas
        System.out.print("Contraseña 'abc123': ");
        verificarContrasena.accept("abc123");
        
        System.out.print("Contraseña 'seguridad123': ");
        verificarContrasena.accept("seguridad123");
        
        System.out.print("Contraseña '12345': ");
        verificarContrasena.accept("12345");
        
        System.out.print("Contraseña 'Java2023!': ");
        verificarContrasena.accept("Java2023!");
        
        System.out.print("Contraseña '': ");
        verificarContrasena.accept("");
	}
	
	public static void ejercicio14ConPredicate() {
		 // Definimos la lambda que verifica la longitud de la contraseña
       Predicate<String> verificarContrasena = (password) -> password.length() >= 8;
   
       
    // Probamos la lambda con diferentes contraseñas
       System.out.print("Contraseña 'abc123': ");
       if (verificarContrasena.test("abc123")) 
    	   System.out.println("Contraseña válida");
       else 
    	   System.out.println("Contraseña demasiado corta");
       
       
	}

	/**
	 * EJERCICIO 15: Usar interfaces funcionales predefinidas
	 * 
	 * Escribe un método aplicarOperacion(int valor, Function<Integer, Integer>
	 * operacion) y pruébalo con diferentes funciones: doblar, elevar al cuadrado,
	 * etc
	 * 
	 * El código muestra varias maneras de usar este método:

Con funciones lambda predefinidas (doblar, cuadrado, incrementar, negativo)
Pasando lambdas directamente como argumento
Encadenando operaciones usando el método andThen
	 */
	  // Método que aplica una operación a un valor entero
    public static int aplicarOperacion(int valor, Function<Integer, Integer> operacion) {
		return operacion.apply(valor);
    }
    
	public static void ejercicio15() {
		// Definimos diferentes operaciones como lambdas
        Function<Integer, Integer> doblar = x -> x * 2;
        Function<Integer, Integer> cuadrado = x -> x * x;
        Function<Integer, Integer> incrementar = x -> x + 1;
        Function<Integer, Integer> negativo = x -> -x;
        
        // Valor para probar
        int numero = 5;
        
        // Probamos el método con diferentes operaciones
        System.out.println("Número original: " + numero);
        System.out.println("Doble: " + aplicarOperacion(numero, doblar));
        System.out.println("Cuadrado: " + aplicarOperacion(numero, cuadrado));
        System.out.println("Incrementado: " + aplicarOperacion(numero, incrementar));
        System.out.println("Negativo: " + aplicarOperacion(numero, negativo));
        
        // También podemos pasar las lambdas directamente
        System.out.println("Cubo: " + aplicarOperacion(numero, x -> x * x * x));
        System.out.println("Mitad: " + aplicarOperacion(numero, x -> x / 2));
        
        // Encadenando 2 operaciones
        Function<Integer, Integer> cuadradoMasUno = cuadrado.andThen(incrementar);
        System.out.println("Cuadrado y luego incrementado: " + aplicarOperacion(numero, cuadradoMasUno));	
	}
}
