package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo13repaso;

public abstract class Vegetal extends Organismo {
	private static final TipoOrganismo TIPO_ORGANISMO = TipoOrganismo.PLURICELULAR;

	public Vegetal() {
		super(TIPO_ORGANISMO);
	}
	
	public abstract void fotosintesis(int cantidadLuz);

}
