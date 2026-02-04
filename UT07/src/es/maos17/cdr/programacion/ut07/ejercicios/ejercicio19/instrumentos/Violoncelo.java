package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos;

public class Violoncelo extends Frotada {

	private static final int DIFICULTAD = 9;
	private static final int NUM_CUERDAS = 4;
	private static final String NOMBRE_INSTRUMENTO = "violoncelo";

	public Violoncelo(String propietario) {
		super(propietario, DIFICULTAD, NUM_CUERDAS);
	}

	@Override
	public void tocar() {
		System.out.printf("El %s de %s empieza a tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public void parar() {
		System.out.printf("El %s de %s deja de tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public String toString() {
		return String.format("Violoncelo - Propietario: %s - Dificultad: %d - %d cuerdas\n", this.getPropietario(),
				this.getDificultad(), this.getNumCuerdas());
	}

	@Override
	public void afinar() {
		System.out.println("Afinando el violoncelo");
	}
}
