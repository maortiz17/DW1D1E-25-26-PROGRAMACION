package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio18;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;

    public Producto(String codigo, String descripcion, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }
    
    public Producto (Producto p) {
    	this(p.getCodigo(), p.getDescripcion(), p.getPrecioUnitario());
    }

    public String getCodigo() { 
    	return codigo; 
    	}
    public String getDescripcion() { 
    	return descripcion; 
    	}
    public double getPrecioUnitario() { 
    	return precioUnitario; 
    	}

    @Override
    public String toString() {
        return String.format("[%s] %-20s | %6.2f€", codigo, descripcion, precioUnitario);
    }
}