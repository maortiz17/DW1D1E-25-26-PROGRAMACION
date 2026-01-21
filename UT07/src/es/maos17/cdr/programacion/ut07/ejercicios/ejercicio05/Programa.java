package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio05;

import java.time.LocalDate;

public class Programa {

	public static void main(String[] args) {
//			ProductoFresco producto02 = new ProductoFresco(LocalDate.of(2024, 01, 30), 323322, LocalDate.of(2024, 1, 10),
//					"España");
//			System.out.println(producto02);
//
//			ProductoCongelado producto03 = new ProductoCongelado(LocalDate.of(2024, 01, 30), 3242, -30);
//			System.out.println(producto03);

		// Creamos los objetos como un array de objetos de la superclase. 
		// No podemos crear objetos de Producto por ser abstracta, pero si podemos 
		// sustituir un objeto de una de las subclases por uno de la superclase
		Producto[] productos = new Producto[3];
		productos[0] = new ProductoFresco(LocalDate.of(2024, 01, 30), 323322, LocalDate.of(2024, 1, 10), "España");
		productos[1] = new ProductoCongelado(LocalDate.of(2024, 01, 30), 3242, -30);
		productos[2] = new ProductoRefrigerado(LocalDate.of(2024, 01, 30), 323322, "OMS");

		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
}
