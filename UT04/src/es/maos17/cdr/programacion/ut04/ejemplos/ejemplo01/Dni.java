package es.maos17.cdr.programacion.ut04.ejemplos.ejemplo01;

public class Dni {
	// Atributos
	private int dni;
	// Constantes
	private static String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	// Constructores
	public Dni(int dni) {
		setDNI(dni);
	}
	public Dni(String nif) {
		setDNI(nif);
	}
	// Getters y setters
	public int getDNI() {
		return dni;
	}
	public String getNIF() {
		return String.valueOf(dni) + String.valueOf(calcularLetraNIF(dni));
	}
	public void setDNI(int dni) {
		if (dni > 999999 && dni <= 99999999)
			this.dni = dni;
		else
			System.err.println("Número inválido");
	}
	public void setDNI(String nif) {
		if ((extraerNumeroNIF(nif) > 999999 && extraerNumeroNIF(nif) <= 99999999) && validarNIF(nif))
			this.dni = extraerNumeroNIF(nif);
		else
			System.err.println("NIF inválido");
	}
	// Métodos privados
	private static char calcularLetraNIF(int dni) {
		//Devuelve la letra correspondiente al número recibido por parámetro
		return LETRAS_DNI.charAt(dni % 23);
	}
	private static char extraerLetraNIF(String nif) {
		// Devuelvo la letra
		return nif.charAt(nif.length() - 1);
	}
	private static int extraerNumeroNIF(String nif) {
		return Integer.parseInt(nif.substring(0, nif.length() - 1));
	}
	private boolean validarNIF(String nif) {
		if (nif == null)
			return false;
		else if(extraerNumeroNIF(nif) <= 999999 || extraerNumeroNIF(nif) > 99999999)
			return false;
		return (extraerLetraNIF(nif) == calcularLetraNIF(extraerNumeroNIF(nif)));
	}
}
















