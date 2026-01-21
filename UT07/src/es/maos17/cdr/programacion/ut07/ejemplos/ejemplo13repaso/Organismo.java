package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo13repaso;

public abstract class Organismo {
	private TipoOrganismo tipoOrganismo;

	public Organismo(TipoOrganismo tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}
	
	public TipoOrganismo getTipoOrganismo() {
		return tipoOrganismo;
	}
}
