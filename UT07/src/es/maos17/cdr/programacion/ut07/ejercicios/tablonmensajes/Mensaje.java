package es.maos17.cdr.programacion.ut07.ejercicios.tablonmensajes;

public abstract class Mensaje {
	private int codigo;
	private String mensaje;
	
	public Mensaje(int codigo, String mensaje) {
		this.codigo = codigo;
		setMensaje(mensaje);
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		if (mensaje == null || mensaje.isEmpty()) {
			throw new IllegalArgumentException("Mensaje vacío");
		}
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "Mensaje " + codigo + ": " + mensaje;
	}
}
