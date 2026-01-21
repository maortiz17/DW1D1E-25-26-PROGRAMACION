package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.programa;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases.Consumo;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases.Electrodomestico;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases.Lavadora;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases.Television;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio06.clases.Color;

public class Programa {
	public static void main(String[] args) {Electrodomestico[] electrodomesticos = new Electrodomestico[10];

		electrodomesticos[0] = new Lavadora(230, Color.INOX, Consumo.C, 40, 7);
		electrodomesticos[1] = new Television(280, Color.NEGRO, Consumo.A, 17, 55, true);
		electrodomesticos[2] = new Television(280, Color.BLANCO, Consumo.F, 17, 75, true);
		electrodomesticos[3] = new Lavadora(280, 70);
		electrodomesticos[4] = new Television(199, Color.NEGRO, Consumo.C, 12, 36, false);
		electrodomesticos[5] = new Lavadora(350, 75);
		electrodomesticos[6] = new Lavadora();
		electrodomesticos[7] = new Television(880, Color.NEGRO, Consumo.A, 40, 70, true);
		electrodomesticos[8] = new Lavadora(500, Color.BLANCO, Consumo.A, 55, 9);
		electrodomesticos[9] = new Lavadora();

		System.out.println("-".repeat(50));

		muestraTodosLosPrecios(electrodomesticos);

		System.out.println("-".repeat(50));

		muestraPreciosLavadoras(electrodomesticos);

		System.out.println("-".repeat(50));

		muestraPreciosTelevisiones(electrodomesticos);

	}

	private static void muestraTodosLosPrecios(Electrodomestico[] electrodomesticos) {
		double total = 0;
		int numero = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			System.out.println(electrodomestico.getPrecioFinal());
			total += electrodomestico.getPrecioFinal();
			numero++;
		}
		System.out.printf("Precio medio: %.2f\n", total / numero);
	}

	private static void muestraPreciosLavadoras(Electrodomestico[] electrodomesticos) {
		double suma = 0;
		int cuenta = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico instanceof Lavadora) {
				Lavadora lavadora = (Lavadora) electrodomestico;
				System.out.printf("Precio de la lavadora con carga %.2f kg: %.2f \n", lavadora.getCarga(),
						electrodomestico.getPrecioFinal());
				suma += electrodomestico.getPrecioFinal();
				cuenta++;
			}
		}
		double precioMedio = suma / cuenta;
		System.out.printf("El precio medio de las lavadoras es de %.2f euros\n", precioMedio);
	}

	private static void muestraPreciosTelevisiones(Electrodomestico[] electrodomesticos) {
		double suma = 0;
		int cuenta = 0;
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico instanceof Television) {
				Television television = (Television) electrodomestico;
				System.out.printf("Precio de la televisión con %d pulgadas es: %.2f \n",
						television.getResolucionPulgadas(), electrodomestico.getPrecioFinal());
				suma += electrodomestico.getPrecioFinal();
				cuenta++;
			}
		}
		double precioMedio = suma / cuenta;
		System.out.printf("El precio medio de las televisiones es de %.2f euros\n", precioMedio);
	}

	private static void muestraPreciosLavadorasYTv(Electrodomestico[] electrodomesticos) {
		for (Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico instanceof Lavadora) {
				Lavadora lavadora = (Lavadora) electrodomestico;
				System.out.printf("Precio de la lavadora con carga %f kg: %.2f \n", lavadora.getCarga(),
						electrodomestico.getPrecioFinal());
			}
			if (electrodomestico instanceof Television) {
				Television tv = (Television) electrodomestico;
				System.out.printf("Precio de la tv con %d pulgadas: %.2f \n", tv.getResolucionPulgadas(),
						electrodomestico.getPrecioFinal());
			}

			if (electrodomestico.getClass().equals(Electrodomestico.class)) {
				System.out.println("No es lavadora ni television");
			}
		}
	}

	private static void muestraPesoElectrodomestico(Electrodomestico e) {

		System.out.printf("El peso del electrodomestico es %.2f\n", e.getPesoKg());
	}
}
