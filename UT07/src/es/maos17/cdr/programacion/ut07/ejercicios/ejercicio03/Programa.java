package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio03;

public class Programa {

	public static void main(String[] args) {
		// Creamos el círculo 1
		Punto centro1 = new Punto(100, 100);
		CirculoSinDefensa circulo1 = new CirculoSinDefensa(centro1, 100, "circulo1");
		System.out.println(circulo1);

		// Creamos el círculo 2
		CirculoSinDefensa circulo2 = new CirculoSinDefensa(200, 200, 100, "circulo2");
		System.out.println(circulo2);
		
		// Modificamos centro1
		centro1.setX(150);
		centro1.setY(150);
		System.out.println(circulo1);
		
		// Obtenemos el centro de circulo2 y lo modificamos
		Punto centro2 = circulo2.getCentro();
		centro2.setX(250);
		centro2.setY(250);
		System.out.println(circulo2);
		
		/* Aunque los objetos son en teoría inmutables (no hay setters de sus atributos)
		   hemos conseguido modificar sus atributos tipo objeto de dos modos diferentes*/ 
		
		// Ahora hacemos lo mismo con una clase que defiende sus atributos
		Punto centro3 = new Punto(100, 100);
		CirculoConDefensa circulo3 = new CirculoConDefensa(centro3, 100, "circulo3");
		System.out.println(circulo3);

		// Creamos el círculo 3
		CirculoConDefensa circulo4 = new CirculoConDefensa(200, 200, 100, "circulo4");
		System.out.println(circulo4);
		
		// Modificamos centro3
		centro3.setX(150);
		centro3.setY(150);
		System.out.println(circulo3);
		
		// Obtenemos el centro de circulo4 y lo modificamos
		Punto centro4 = circulo4.getCentro();
		centro4.setX(250);
		centro4.setY(250);
		System.out.println(circulo4);
		
		// Los objetos solo son mutables a través de sus setters (si es que así lo deseamos)
		circulo3.setCentro(new Punto(300, 300));
		circulo3.setRadio(85);
		System.out.println(circulo3);
	}

}
