package ejemplos.ejemplo09;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import ejemplos.ejemplo01.Persona;

public class Ejemplo09 {
	public static void main(String[] args) {
		Persona persona = new Persona("Pedro", "Pérez", 20);
		// Ejemplo Predicate: ¿Es la persona mayor de edad?
		Predicate<Persona> esMayorEdad = p -> p.getEdad() >= 18;
		if(esMayorEdad.test(persona)) { // El método test devuelve true
			System.out.println("Es mayor de edad");
		} else {
			System.out.println("Es menor de edad");
		}
		
		// Ejemplo Function: Dada una Persona (T), devuelve su nombre en formato String (R)
		//Function<Persona, String> extraerNombre = (p) -> p.getNombre();
		Function<Persona, String> extraerNombre = Persona::getNombre;
		System.out.println(extraerNombre.apply(persona)); // Devuelve "Pedro"
		
		// Ejemplo Consumer: Recibe una Persona y la imprime por consola
		Consumer<Persona> imprimirPersona = System.out::println;
		imprimirPersona.accept(persona); // Imprime el objeto por pantalla
	}
}

