package es.maos17.cdr.programacion.ut04.ejercicios.excepciones.ejercicio03bis;

public class Coche {

	// Atributos. Todos privados
	private boolean arrancado;
	private boolean marchaAtras;
	private int velocidadMaxima;
	private int velocidadMaximaAtras;
	private int velocidad;
	// En este atributo almacenaremos la "hora" actual para calcular distancias
	private long tiempo;
	// En este otro atributo vamos almacenando la distancia
	private double distancia;

	// Constructor con todos los atributos
	public Coche(boolean arrancado, boolean marchaAtras, int velocidadMaxima, int velocidadMaximaAtras, int velocidad) {
		this.arrancado = arrancado;
		this.marchaAtras = marchaAtras;
		this.velocidadMaxima = velocidadMaxima;
		this.velocidadMaximaAtras = velocidadMaximaAtras;
		this.velocidad = velocidad;
		this.tiempo = System.currentTimeMillis(); // Almacenamos el momento en el que se crea el coche
		this.distancia = 0;
	}

	// Constructor. Recibe solamente velocidades máximas
	public Coche(int velocidadMaxima, int velocidadMaximaAtras) {
		this(false, false, velocidadMaxima, velocidadMaximaAtras, 0);
	}

	// Solamente generamos getters.
	public boolean estaArrancado() {
		return arrancado;
	}

	public boolean estaMarchaAtras() {
		return marchaAtras;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public int getVelocidadMaximaAtras() {
		return velocidadMaximaAtras;
	}

	public int getVelocidad() {
		return velocidad;
	}

	// Métodos
	public void arrancar() {
		if (arrancado) {
			throw new IllegalStateException("El coche ya está arrancado");
		}
		arrancado = true;
	}

	public void detener() {
		if (!arrancado) {
			throw new IllegalStateException("El coche ya está parado");
		}
		if (velocidad != 0) {
			throw new IllegalStateException("La velocidad tiene que ser cero");
		}
		arrancado = false;
	}

	public void ponerMarchaAtras() {
		if (velocidad != 0) {
			throw new IllegalStateException("La velocidad tiene que ser cero");
		}
		if (marchaAtras) {
			throw new IllegalStateException("El coche ya está en marcha atrás");
		}
		marchaAtras = true;
	}

	public void quitarMarchaAtras() {
		if (velocidad != 0) {
			throw new IllegalStateException("La velocidad tiene que ser cero");
		}
		if (!marchaAtras) {
			throw new IllegalStateException("El coche no está en marcha atrás");
		}
		marchaAtras = false;
	}

	public void acelerar(int kmh) {
		// Si el coche está avanzando acumulamos distancia desde último cálculo
		actualizarDistancia();
		
		if (arrancado) {
			if (kmh <= 0) {
				throw new IllegalArgumentException("La aceleración tiene que ser positiva");
			}
			if (!marchaAtras) {
				velocidad += kmh;
				if (velocidad > velocidadMaxima) {
					velocidad = velocidadMaxima;
				}
			} else {
				velocidad -= kmh;
				if (velocidad < velocidadMaximaAtras) {
					velocidad = velocidadMaximaAtras;
				}
			}
		}
	}

	public void frenar(int kmh) {
		// Cada vez que el coche modifica su velocidad hay que calcular el espacio
		actualizarDistancia();
		
		if (arrancado) {
			if (kmh <= 0) {
				throw new IllegalArgumentException("La aceleración tiene que ser positiva");
			}
			if (!marchaAtras) {
				velocidad -= kmh;
				if (velocidad < 0) {
					velocidad = 0;
				}
			} else {
				velocidad += kmh;
				if (velocidad > 0) {
					velocidad = 0;
				}
			}
		}
	}
	
	// Nuevo método que acumula y actualiza distancia recorrida
	// Clase de física: v = e / t por lo que e = v * t
	private void actualizarDistancia() {
	    long tiempoActual = System.currentTimeMillis();
	    // 1. Usamos 3600000.0 (con el punto decimal) para forzar división double
	    // 2. Calculamos la diferencia de tiempo
	    double horasTranscurridas = (tiempoActual - this.tiempo) / 3600000.0;
	    
	    // Solo sumamos si no estamos marcha atrás
	    if (!marchaAtras) {
	        this.distancia += this.velocidad * horasTranscurridas;
	    }
	    
	    // Actualizamos el tiempo para el siguiente cálculo
	    this.tiempo = tiempoActual;
	}

	// Sobreescribimos método toString
	@Override
	public String toString() {
		// Antes de imprimir datos actualizamos la distancia recorrida
		actualizarDistancia();
		return String.format("Estado del coche:\n%s\nVelocidad: %d km/h\n%s\nDistancia recorrida: %.2f km\n",
				(arrancado ? "Está arrancado" : "Está detenido"), velocidad,
				(marchaAtras ? "Tiene la marcha atrás" : "Tiene la directa"),
				distancia);
	}

}
