package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo13repaso;

public abstract class Animal extends Organismo {
	private static final TipoOrganismo TIPO_ORGANISMO = TipoOrganismo.PLURICELULAR;

	public Animal() {
		super(TIPO_ORGANISMO);
	}
	
	public abstract void comer(String alimento);

}
