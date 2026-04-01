package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio16;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class Estacionamiento {
    private final int numPlazas;
    private final int numPlazasCola;
    private final int tiempoCortesiaSg;
    private final double costePorSgEnCentimos;

    // Mapa para los que ya están dentro (Matrícula -> Hora de entrada)
    private final Map<String, LocalDateTime> estacionados;
    // Cola para la rampa de espera
    private final Queue<String> esperando;

    public Estacionamiento(int numPlazas, int numPlazasCola, int tiempoCortesiaSg, double costePorSgEnCentimos) {
        this.numPlazas = numPlazas;
        this.numPlazasCola = numPlazasCola;
        this.tiempoCortesiaSg = tiempoCortesiaSg;
        this.costePorSgEnCentimos = costePorSgEnCentimos;
        this.estacionados = new HashMap<>();
        this.esperando = new LinkedList<>();
    }

    public ResultadoEstacionamiento estacionarVehiculo(String matricula) {
        // Verificamos si ya está en alguna parte del sistema
        if (estaEstacionado(matricula) || estaEsperando(matricula)) {
            throw new IllegalStateException("El vehículo con la matrícula " + matricula + " ya está en el sistema.");
        }

        // Intento aparcar directamente
        if (estacionados.size() < numPlazas) {
            estacionados.put(matricula, LocalDateTime.now());
            return ResultadoEstacionamiento.ESTACIONADO;
        } 
        // Si no hay sitio, intento rampa
        else if (esperando.size() < numPlazasCola) {
            esperando.offer(matricula);
            return ResultadoEstacionamiento.ESPERANDO;
        } 
        // No hay sitio en ninguna parte
        else {
            return ResultadoEstacionamiento.RECHAZADO;
        }
    }

    public double retirarVehiculo(String matricula) {
        if (!estaEstacionadoOEsperando(matricula)) {
            throw new IllegalArgumentException("El vehículo con matrícula " + matricula + " no está en el estacionamiento.");
        }

        if (estaEsperando(matricula)) {
            throw new IllegalStateException("No se puede retirar el vehículo con matrícula " + matricula + " porque está esperando en la rampa.");
        }

        // Cálculo del tiempo y el importe
        LocalDateTime entrada = estacionados.remove(matricula);
        long segundos = Duration.between(entrada, LocalDateTime.now()).getSeconds();
        
        double importe = 0;
        if (segundos > tiempoCortesiaSg) {
            // Se cobra el tiempo total (incluyendo la cortesía) si se ha pasado del límite
            importe = (segundos * costePorSgEnCentimos) / 100.0;
        }

        // Si al salir queda hueco y hay alguien en la rampa, entra el primero
        if (!esperando.isEmpty()) {
            estacionados.put(esperando.poll(), LocalDateTime.now());
        }

        return importe;
    }

    // Métodos de consulta de estado
    public boolean hayPlazasLibres() {
        return estacionados.size() < numPlazas;
    }

    public int numPlazasLibres() {
        return numPlazas - estacionados.size();
    }

    public boolean estaEstacionado(String matricula) {
        return estacionados.containsKey(matricula);
    }

    public boolean estaEsperando(String matricula) {
        return esperando.contains(matricula);
    }

    public boolean estaEstacionadoOEsperando(String matricula) {
        return estaEstacionado(matricula) || estaEsperando(matricula);
    }

    // --- Métodos que devuelven Colecciones ordenadas alfabéticamente ---
    // Devolvemos un TreeSet nuevo para cumplir con el orden y proteger el original

    public Collection<String> getMatriculasEstacionados() {
        return new TreeSet<>(estacionados.keySet());
    }

    public Collection<String> getMatriculasEsperando() {
        return new TreeSet<>(esperando);
    }

    public Collection<String> getMatriculasEstacionadosOEsperando() {
        TreeSet<String> todas = new TreeSet<>(estacionados.keySet());
        todas.addAll(esperando);
        return todas;
    }
}