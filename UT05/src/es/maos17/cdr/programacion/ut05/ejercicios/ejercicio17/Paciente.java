package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio17;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Paciente implements Comparable<Paciente> {
    private String dni;
    private String nombreCompleto;
    private Especialidad especialidad;
    private String sintomas;
    private Gravedad gravedad;
    private LocalDateTime fechaHoraLlegada;

    public Paciente(String dni, String nombre, Especialidad esp, String sintomas, Gravedad grav) {
        this.dni = dni;
        this.nombreCompleto = nombre;
        this.especialidad = esp;
        this.sintomas = sintomas;
        this.gravedad = grav;
        this.fechaHoraLlegada = LocalDateTime.now();
    }

    @Override
    public int compareTo(Paciente otro) {
        // PriorityQueue extrae primero el valor "menor" según compareTo.
        // Como ALTA es 0 y BAJA es 2, saldrá antes el de gravedad ALTA.
        int res = this.gravedad.compareTo(otro.gravedad);
        if (res == 0) {
            // Si la gravedad es igual, comparamos fecha: el que llegó antes es "menor" cronológicamente
            res = this.fechaHoraLlegada.compareTo(otro.fechaHoraLlegada);
        }
        return res;
    }

    // Getters 
    public String getDni() { 
    	return dni; 
    }
    public String getNombreCompleto() { 
    	return nombreCompleto; 
    }
    public Especialidad getEspecialidad() {
    	return especialidad; 
    }
    public Gravedad getGravedad() { 
    	return gravedad; 
    }
    
    public String getSintomas() {
    	return sintomas;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %s - Gravedad: %s | Llegada: %s", 
                dni, nombreCompleto, gravedad, fechaHoraLlegada.format(dtf));
    }

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni);
	}
    
    
}