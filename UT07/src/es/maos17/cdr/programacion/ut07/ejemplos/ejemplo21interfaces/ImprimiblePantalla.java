package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo21interfaces;

public interface ImprimiblePantalla extends Imprimible {

	public default void imprimir() {
		System.out.println("Estoy en imprimir de imprimible pantalla");
	}
	
}
