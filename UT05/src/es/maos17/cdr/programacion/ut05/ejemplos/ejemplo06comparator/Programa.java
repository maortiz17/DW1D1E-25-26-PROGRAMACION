package es.maos17.cdr.programacion.ut05.ejemplos.ejemplo06comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Programa {
	public static void main(String[] args) {
		Vehiculo v1 = new Vehiculo("11111A", "Opel", Color.BLANCO);
		Vehiculo v2 = new Vehiculo("11111A", "Opel", Color.BLANCO);
		
		System.out.printf("HashCode de v1: %s\n", v1.hashCode());
		System.out.printf("HashCode de v2: %s\n", v2.hashCode());
		System.out.printf("IdentityHashCode de v1: %s\n", System.identityHashCode(v1));
		System.out.printf("IdentityHashCode de v2: %s\n", System.identityHashCode(v2));
		System.out.printf("toString de v1: %s\n", v1.toString());
		System.out.printf("toString de v2: %s\n", v2.toString());
		System.out.printf("¿Son los vehículos v1 y v2 iguales? %s\n", v1.equals(v2));
		
		System.out.println("-".repeat(50));

		Vehiculo v3 = new Coche("11111A", "Opel", Color.BLANCO, true);
		System.out.printf("HashCode de v1: %s\n", v1.hashCode());
		System.out.printf("HashCode de v3: %s\n", v3.hashCode());
		System.out.printf("IdentityHashCode de v1: %s\n", System.identityHashCode(v1));
		System.out.printf("IdentityHashCode de v3: %s\n", System.identityHashCode(v3));
		System.out.printf("toString de v1: %s\n", v1.toString());
		System.out.printf("toString de v3: %s\n", v3.toString());
		System.out.printf("¿Son los vehículos v1 y v3 iguales? %s\n", v1.equals(v3));
		
		System.out.println("-".repeat(50));
		System.out.printf("¿Son los vehículos v1 y v3 iguales? %d\n", v1.compareTo(v3));
		Vehiculo v4 = new Vehiculo("44444F", "Seat", Color.ROJO);
		Vehiculo v5 = new Vehiculo("22222B", "Toyota", Color.BLANCO);
		Vehiculo v6 = new Vehiculo("33333C", "Kia", Color.VERDE);
		Vehiculo v7 = new Vehiculo("66666G", "Seat", Color.BLANCO);
		Vehiculo v8 = new Vehiculo("88888I", "Seat", Color.BLANCO);
		Vehiculo v9 = new Vehiculo("77777H", "Hyundai", Color.VERDE);
		Vehiculo[] vehiculos = {v1, v4, v5, v6, v7, v8, v9};
		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
		System.out.println("--Ordenamos por orden natural inverso--");
		Arrays.sort(vehiculos, Comparator.reverseOrder());
		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
		System.out.println("--Ordenamos por color, luego por orden natural--");
		Arrays.sort(vehiculos, new PorColorCocheComparator().thenComparing(Comparator.naturalOrder()));
		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
		System.out.println("--Ordenamos por marca--");
		Comparator<Vehiculo> porMarca = new Comparator<>() {
			@Override
			public int compare(Vehiculo v1, Vehiculo v2) {
				return v1.getMarca().compareTo(v2.getMarca());
			}
		};
		Arrays.sort(vehiculos, porMarca);
		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}
	}
}
