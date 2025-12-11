package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochila1;

public class Mochila {

	private Objeto[] huecos;

	public Mochila(int cantidadHuecos) {
		if (cantidadHuecos < 1) {
			throw new IllegalArgumentException("El número de huecos tiene que ser mayor que 0");
		}
		this.huecos = new Objeto[cantidadHuecos];
	}

	public void anadir(String nombre, TipoMaterial tipo, int cantidad) {
		/*
		 * Busca si ya existe ese objeto en la mochila y si cabe más cantidad. Si cabe,
		 * rellena ese hueco hasta su tope. Solamente pueden apilarse objetos con el
		 * mismo nombre y siempre que el tipo lo permita.
		 */
		int cantidadRestante = cantidad;
		for (int i = 0; i < huecos.length && cantidadRestante > 0; i++) {
			if (huecos[i] != null && 
					huecos[i].getNombre().equals(nombre) && 
					huecos[i].getTipo() == tipo) {
				cantidadRestante = huecos[i].incrementarCantidad(cantidadRestante);  
			}
		}
		
		for (int i = 0; i < huecos.length && cantidadRestante > 0; i++) {
			if (huecos[i] == null) {
				huecos[i] = new Objeto(nombre, cantidadRestante, tipo);
				if (cantidadRestante > tipo.getCapacidadMaxima()) {
					cantidadRestante -= tipo.getCapacidadMaxima();
				}else {
					cantidadRestante = 0;
				}
			}
		}
		
		if (cantidadRestante > 0) {
			System.out.println("Se han caído al suelo " + cantidadRestante + " objetos");
		}else {
			System.out.println("Guardado correctamente");
		}
	}
	
	public void tirar(int hueco, int cantidad) {
		if (hueco < 0 || hueco >= huecos.length) {
			throw new IllegalArgumentException("Número de hueco inválido");
		}
		if (huecos[hueco] == null) {
			throw new IllegalStateException("El hueco está vacío");
		}
		
		huecos[hueco].decrementarCantidad(cantidad);
		if (huecos[hueco].getCantidad() == 0) {
			System.out.println("Has tirado todos los objetos del hueco");
			huecos[hueco] = null;
		}
	}
	
	public void mostrarInventario() {
		System.out.println("--- MOCHILA (" + huecos.length + " huecos) ---");
		for (int i = 0; i < huecos.length; i++) {
			
			System.out.printf("Hueco %d: %s\n", i, (huecos[i] != null ? huecos[i]:  "[ VACÍO ]"));
		}
	}
}
