package es.maos17.cdr.programacion.ut03.ejercicios.Array;

import java.util.Scanner;

/*
 * Copia el programa del ejercicio 16 y modifícalo para que:
● El array de números no se genere aleatoriamente. Se preguntará al usuario, para esto:
o Antes de generar el array, se preguntará al usuario cuántos números quiere
cargar.
o Se pregunta al usuario tantas veces como sea necesario, una para cada
número.
● Pregunta al usuario qué parte del array quiere invertir. Para esto preguntará dos datos:
o Posición inicial
o Posición final
● Invertirá sólo la parte del array contenida entre las posiciones inicial y final. El resto del
array debe quedar igual.
Ten en cuenta:
● Se sustituirá el método que genera el array por un método que recibe la cantidad de
números que debe preguntar al usuario (que ha indicado previamente), y devuelve el
array con los números indicados por el usuario.
● Las posiciones inicial y final deben estar dentro del rango del array, es decir:
o Tienen que ser mayores o iguales a 0.
o Tienen que ser menores que la cantidad de números cargados
● La posición inicial tiene que ser menor o igual que la posición final.
● Si el usuario carga posición inicial y/o final no válida, se deberá volver a preguntar
hasta que cargue posiciones válidas.
● Se modificará el método para invertir el array, creado en el ejercicio 16, para que
reciba, además, dos valores adicionales, las posiciones de inicio y fin para la inversión.
Ejemplo: el usuario carga un array igual que el del ejemplo del ejercicio 16:
[1, 2, 5, 7, 8, 6, 5, 6, 8, 3]
Y quiere invertir los valores entre las posiciones 2 y 6, ambas incluidas,
Se invierte y debe quedar
[1, 2, 5, 6, 8, 7, 5, 6, 8, 3]
Como los extremos de ese intervalo tienen el mismo valor (5) y es un intervalo de tamaño
impar (5 elementos) parece que sólo se han permutado el 7 (posición 3) con el 6 (posición 5),
pero en realidad se han permutado todos los elementos.
 */

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Generamos el array en un método
		int[] numeros = generarArray(sc, solicitarNumero(sc, "¿Cuántos elementos tendrá el array?: "));
		
		// Solicitamos posición inicial y final con los controles necesarios
		int posInicial, posFinal;
		
		do {
			posInicial = solicitarNumero(sc, "Posición inicial a invertir: ");
			posFinal = solicitarNumero(sc, "Posición final a invertir: ");
			if (posInicial < 0 || posFinal < 0) {
				System.out.println("Ambos tienen que ser positivos.");
			}else if (posInicial > posFinal) {
				System.out.println("La posición inicial tiene que ser menor o igual que la posición final.");
			}else if (posFinal >= numeros.length) {
				System.out.println("Tienen que ser menores que la cantidad de números cargados");
			}
		}while (posInicial < 0 || posFinal < 0 || posInicial > posFinal || posFinal >= numeros.length);
		
		mostrarArray(numeros);
		invertirArray(numeros, posInicial, posFinal);
		mostrarArray(numeros);
	}

	public static void invertirArray(int[] numeros, int posInicial, int posFinal) {
		// Comprueba si es null. Los arrays son objetos, y pueden tener valor "null".
		// Si es null, al llamar, por ejemplo, al atributo "length", se produciría una
		// excepción NullPointerException
		if (numeros != null) {
			// Empieza por la izquierda desde la posición inicial solicitada del array
			int izquierda = posInicial;
			// Por la derecha desde el final de la posición solicitada del array
			int derecha = posFinal;
			// Mientras que no se crucen...
			while (izquierda < derecha) {
				// Permutamos los valores de las dos posiciones.
				int aux = numeros[izquierda];
				numeros[izquierda] = numeros[derecha];
				numeros[derecha] = aux;
				// La izquierda avanza hacia delante y la derecha hacia atrás
				izquierda++;
				derecha--;
			}

			// Se puede hacer con un for, más compacto:
//			for (int izq = 0, dch = numeros.length - 1; izq < dch; izq++, dch--) {
//				// Permutamos los valores de las dos posiciones.
//				int aux = numeros[izq];
//				numeros[izq] = numeros[dch];
//				numeros[dch] = aux;
//			}
		}
	}

	public static void mostrarArray(int[] numeros) {
		// Muestra todos los números del array separándolos con espacio.
		for (int numero : numeros) {
			System.out.printf("%d ", numero);
		}
		System.out.println();
	}

	public static int[] generarArray(Scanner scanner, int numero) {
		// Crear el array del tamaño adecuado. Solicitamos tamaño
		int[] numeros = new int[numero];
		// Recorrer el array (con un índice, porque si no no se puede cambiar)
		for (int i = 0; i < numeros.length; i++) {
			// En cada posición leemos un valor por teclado
			numeros[i] = solicitarNumero(scanner, "Introduzca un número: ");
		}
		// Devuelve el array generado
		return numeros;
	}
	
	public static int solicitarNumero(Scanner scanner, String mensaje) {
		System.out.print(mensaje);
		return scanner.nextInt();
	}

}
