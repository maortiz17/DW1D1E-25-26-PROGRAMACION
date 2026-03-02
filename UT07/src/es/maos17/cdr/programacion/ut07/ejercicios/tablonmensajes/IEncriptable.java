package es.maos17.cdr.programacion.ut07.ejercicios.tablonmensajes;

public interface IEncriptable {
	// Definimos el contrato: quien implemente esto sabe cifrar y descifrar
	public String encriptar(String mensaje, int codigoEncriptacion);
	public String desencriptar(int codigoEncriptacion);
}
