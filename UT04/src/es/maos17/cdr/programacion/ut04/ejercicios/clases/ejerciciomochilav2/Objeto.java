package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochilav2;

public class Objeto {
	// Solo guardamos datos básicos del objetos. La cantidad será la segunda dimensión del array mochila
    private String nombre;
    private TipoMaterial tipo;

    public Objeto(String nombre, TipoMaterial tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() { 
    	return nombre; 
    }
    
    public TipoMaterial getTipo() { 
    	return tipo; 
    }

    @Override
    public String toString() {
        return nombre;
    }
}