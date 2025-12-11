package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochilav2;

public enum TipoMaterial {
    ARMA(1),        // Solo 1 por fila
    POCION(5),      // Max 5 por fila
    RECURSO(20);    // Max 20 por fila (Límite físico de la matriz)

    private final int cantidadMaxima;

    private TipoMaterial(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }
}
