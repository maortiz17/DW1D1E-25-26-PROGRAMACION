package es.maos17.cdr.programacion.ut07.ejercicios.tablonmensajes;

public class Tablon {
	private static final int CAPACIDAD_MENSAJES = 10;
	private int siguienteMensaje = 0;
	private Mensaje[] tablon = new Mensaje[CAPACIDAD_MENSAJES];
	
	/**
	 * Devuelve una copia del tablón (copia defensiva)
	 * @return copia del tablón (copia defensiva)
	 */
	public Mensaje[] getTablon() {
		Mensaje[] copiaTablon = new Mensaje[CAPACIDAD_MENSAJES];
		for (int i = 0; i < this.tablon.length && this.tablon[i] != null; i++) {
			copiaTablon[i] = tablon[i];
		}
		return copiaTablon;
	}
	
	/**
	 * Crea un nuevo mensaje. Si el código de encriptación es -1 significa que el mensaje no está encriptado (es normal)
	 * @param mensaje Contenido del mensaje a almacenar
	 * @param codigoEncriptacion Será -1 para mensajes normales y un entero >= 0 para encriptados
	 */
	public void crearMensaje(String mensaje, int codigoEncriptacion) {
		if (codigoEncriptacion < -1) {
			throw new IllegalArgumentException("Código incorrecto");
		}
		if (siguienteMensaje == CAPACIDAD_MENSAJES) {
			eliminarMensajes(1);
		}
		int codigo = siguienteMensaje + 1; // Calculamos código
		if (codigoEncriptacion == -1) { // Mensaje normal
			tablon[siguienteMensaje++] = new MensajeNormal(codigo, mensaje);
		}else { // Mensaje encriptado
			tablon[siguienteMensaje++] = new MensajeEncriptado(codigo, mensaje, codigoEncriptacion);
		}
	}
	
	/**
	 * Destruye el mensaje cuyo código es recibido por parámetro y reorganiza mensajes y códigos
	 */
	public void eliminarMensajes(int codigoEliminar) {
		if (codigoEliminar < 1 || codigoEliminar > CAPACIDAD_MENSAJES) {
			throw new IllegalArgumentException("Código a eliminar fuera de rango");
		}
		if (codigoEliminar < CAPACIDAD_MENSAJES)
		for (int i = codigoEliminar; i < siguienteMensaje; i++) {
			tablon[i - 1] = tablon[i];
			if (tablon[i - 1] != null) {
				tablon[i - 1].setCodigo(i);
			}
		}
		siguienteMensaje--;
		tablon[siguienteMensaje] = null;
	}

	/**
	 * @return the siguienteMensaje
	 */
	public int getSiguienteMensaje() {
		return siguienteMensaje;
	}

	
}
