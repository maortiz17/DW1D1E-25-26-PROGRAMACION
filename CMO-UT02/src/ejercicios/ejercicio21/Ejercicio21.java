package ejercicios.ejercicio21;

import java.util.List;

import ejemplos.ejemplo01.Persona;

public class Ejercicio21 {
	static class ResumenPersona {
		private String nombreApellidos;
		private int edad;
		
		public ResumenPersona(Persona p) {
			this.nombreApellidos = p.getNombre() + " " + p.getApellidos();
			this.edad = p.getEdad();
		}

		public String getNombreApellidos() {
			return nombreApellidos;
		}

		public int getEdad() {
			return edad;
		}
	}
	
	public static void main(String[] args) {
		List<Persona> personas = List.of(
				new Persona("Miguel", "Ortiz", 50),
				new Persona("Ana", "Martínez", 35));
		
		personas.stream()
			.map(ResumenPersona::new)
			.forEach(p -> {
				System.out.printf("%s: %d años\n", p.getNombreApellidos(), p.getEdad());
			});
		
		// Para obtener solo las edades como primitivos y sacar el máximo:
		int maxEdad = personas.stream()
		    .mapToInt(Persona::getEdad) // Convertimos a IntStream
		    .max()
		    .orElse(0);
		System.out.println("Mayor edad: " + maxEdad);
	}
	
}
