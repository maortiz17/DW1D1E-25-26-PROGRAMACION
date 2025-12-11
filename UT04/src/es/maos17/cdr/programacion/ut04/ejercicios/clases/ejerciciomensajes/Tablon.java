package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomensajes;

public class Tablon {
    private Mensaje[] mensajes;
    private final int CAPACIDAD = 10;

    public Tablon() {
        this.mensajes = new Mensaje[CAPACIDAD];
    }

    public void anadirMensaje(Mensaje nuevoMensaje) {
        // ESTRATEGIA: Buscar el primer hueco null
        for (int i = 0; i < mensajes.length; i++) {
            if (mensajes[i] == null) {
                mensajes[i] = nuevoMensaje;
                return; // Trabajo hecho, salimos
            }
        }

        // Si llegamos aquí, NO había huecos (array lleno).
        // Toca desplazar todo a la izquierda para borrar el más antiguo (FIFO)
        desplazarYAnadir(nuevoMensaje);
    }

    private void desplazarYAnadir(Mensaje nuevo) {
        // Desplazamos: El 1 pasa al 0, el 2 al 1...
        for (int i = 0; i < mensajes.length - 1; i++) {
            mensajes[i] = mensajes[i + 1];
        }
        // El último hueco queda libre para el nuevo
        mensajes[mensajes.length - 1] = nuevo;
    }

    public Mensaje getMensaje(int indice) {
        // Ajustamos índice usuario (1..10) a array (0..9)
        int i = indice - 1;
        if (i >= 0 && i < mensajes.length && mensajes[i] != null) {
            return mensajes[i];
        }
        return null;
    }

    public void mostrarTablon() {
        System.out.println("\n=== MENSAJES CIFRADOS ===");
        boolean vacio = true;
        for (int i = 0; i < mensajes.length; i++) {
            if (mensajes[i] != null) {
                System.out.printf("%d. %s\n", (i + 1), mensajes[i].toString());
                vacio = false;
            }
        }
        if (vacio) System.out.println("(Tablón vacío)");
        System.out.println("=========================");
    }
}