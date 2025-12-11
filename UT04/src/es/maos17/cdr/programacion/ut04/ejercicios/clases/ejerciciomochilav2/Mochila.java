package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochilav2;


public class Mochila {

    private Objeto[][] items;

    public Mochila(int numHuecos) {
        if (numHuecos < 1) throw new IllegalArgumentException("Debe haber al menos 1 hueco");
        this.items = new Objeto[numHuecos][]; // Filas (huecos) vacías a null
    }

    public void anadir(String nombre, TipoMaterial tipo, int cantidad) {
        int restante = cantidad;

        // 1. FASE I: Rellenar huecos existentes (apilar)
        for (int i = 0; i < items.length && restante > 0; i++) {
            if (items[i] != null && items[i][0].getNombre().equals(nombre) && items[i][0].getTipo() == tipo) {
                restante = insertarEnFila(i, nombre, tipo, restante);
            }
        }

        // 2. FASE II: Si sobran objetos tras fase I, usar huecos vacíos
        for (int i = 0; i < items.length && restante > 0; i++) {
            if (items[i] == null) {
                items[i] = new Objeto[tipo.getCantidadMaxima()]; // Dimensionado dinámico en función del tipo de objeto
                restante = insertarEnFila(i, nombre, tipo, restante);
            }
        }

        if (restante > 0) {
            System.out.println("Mochila llena. Sobraron " + restante + " objetos.");
        } else {
            System.out.println("Objetos guardados correctamente.");
        }
    }

    // Método auxiliar para no repetir código de bucles
    private int insertarEnFila(int fila, String nombre, TipoMaterial tipo, int cantidad) {
        for (int j = 0; j < items[fila].length && cantidad > 0; j++) {
            if (items[fila][j] == null) {
                items[fila][j] = new Objeto(nombre, tipo); // En cada iteración añadimos un objeto al hueco hasta que se llene
                cantidad--;
            }
        }
        return cantidad;
    }

    public void tirar(int fila, int cantidad) {
        if (fila < 0 || fila >= items.length || items[fila] == null) {
            System.out.println("No se puede tirar (Fila inválida o vacía).");
            return;
        }

        int tirados = 0;
        // Recorrido inverso: desde el final hacia el principio (LIFO: El último en entrar en la fila es el primero en salir)
        for (int j = items[fila].length - 1; j >= 0 && tirados < cantidad; j--) {
            if (items[fila][j] != null) {
                items[fila][j] = null;
                tirados++;
            }
        }
        System.out.println("Se han tirado " + tirados + " objetos.");

        // AUTO-LIMPIEZA: Si la base (índice 0) es null, la fila entera es inútil.
        if (items[fila][0] == null) {
            items[fila] = null; // Liberamos la fila (hueco) para llenar con otro objeto más adelante
        }
    }

    public void mostrarInventario() {
        System.out.println("\n--- INVENTARIO ---");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("[%d] ", i);
            if (items[i] == null) {
                System.out.println("Vacío");
            } else {
                // Contamos no-nulos para mostrar cantidad real
                int cantidadObjetos = 0;
                for (Objeto o : items[i]) {
                	if (o != null) {
                		cantidadObjetos++;
                	}
                }
                
                System.out.printf("%s (x%d) [Max: %d]\n", 
                    items[i][0].getNombre(), cantidadObjetos, items[i].length);
            }
        }
    }
}