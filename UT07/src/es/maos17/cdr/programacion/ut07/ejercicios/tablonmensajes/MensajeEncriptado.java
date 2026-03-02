package es.maos17.cdr.programacion.ut07.ejercicios.tablonmensajes;

public class MensajeEncriptado extends Mensaje implements IEncriptable {
	public MensajeEncriptado(int codigo, String mensaje, int codigoEncriptacion) {
		super(codigo, encriptarMensaje(mensaje, codigoEncriptacion));
	}
	
	private static String encriptarMensaje(String mensaje, int codigoEncriptacion) { // Estático para ser invocable desde el constructor
		if (codigoEncriptacion < 0) {
			throw new IllegalArgumentException("El código de encriptación tiene que ser entero mayor o igual a cero");
		}
		StringBuilder mensajeEncriptado = new StringBuilder(""); // Inicializamos mensaje encriptado
		char[] caracteres = mensaje.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			mensajeEncriptado.append((char)(caracteres[i] + i + codigoEncriptacion));
		}
		return mensajeEncriptado.toString();
	}
	
	@Override
    public String encriptar(String mensaje, int codigoEncriptacion) {
        return encriptarMensaje(mensaje, codigoEncriptacion);
    }
	
	@Override
	public String desencriptar(int codigo) {
	    // El objeto sabe CÓMO restar, pero necesita el QUÉ restar (el código)
	    StringBuilder sb = new StringBuilder();
	    String textoCifrado = this.getMensaje(); // Asumiendo que getMensaje devuelve el cifrado
	    
	    for (int i = 0; i < textoCifrado.length(); i++) {
	        char c = textoCifrado.charAt(i);
	        // Aplicamos la fórmula inversa encapsulada aquí
	        // CarácterCifrado - CodigoSecreto - IndicePosicion
	        char descifrado = (char) (c - codigo - i); 
	        sb.append(descifrado);
	    }
	    return sb.toString();
	} 
}
