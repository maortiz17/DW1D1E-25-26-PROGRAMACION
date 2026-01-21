package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo12enum.ejemplo01enumbasico;

public class Programa {
	public static void main(String[] args) {

		Transporte tp = Transporte.AVION;

		if (tp == Transporte.TREN) { /*...*/ }
		
		switch (tp) {
		case AVION:
			// Código
			break;
		case TREN:
			// Código
			break;
		default:
			// Código
			break;
		}
		
		
		
		
		
	}
}
