package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo08abstractas;

public abstract class Animal {
	private int pesoKg;

	public Animal(int pesoKg) {
		this.pesoKg = pesoKg;
	}

	public int getPesoKg() {
		return pesoKg;
	}

	@Override
	public String toString() {
		return "Animal";
	}


	
	public void engordar(int cuanto) {
		this.pesoKg += cuanto;
	}

	public abstract void desplazarse(double metros);

	
	
}
