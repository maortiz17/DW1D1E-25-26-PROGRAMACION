package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio13;

public interface Vehiculo {
	int VELOCIDAD_MAXIMA = 120;
	
	void frenar(int cuanto);
	void acelerar(int cuanto);
	int getNumPlazas();
	
}
