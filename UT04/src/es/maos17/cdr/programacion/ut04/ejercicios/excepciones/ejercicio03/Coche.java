package es.maos17.cdr.programacion.ut04.ejercicios.excepciones.ejercicio03;

public class Coche {

	// Atributos. Todos privados
	private boolean arrancado;
	private boolean marchaAtras;
	private int velocidadMaxima;
	private int velocidadMaximaAtras;
	private int velocidad;

	// Constructor con todos los atributos
	public Coche(boolean arrancado, boolean marchaAtras, int velocidadMaxima, int velocidadMaximaAtras, int velocidad) {
		this.arrancado = arrancado;
		this.marchaAtras = marchaAtras;
		this.velocidadMaxima = velocidadMaxima;
		this.velocidadMaximaAtras = velocidadMaximaAtras;
		this.velocidad = velocidad;
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

	// Sobreescribimos método toString
	@Override
	public String toString() {
		return String.format("Estado del coche:\n%s\nVelocidad: %d km/h\n%s\n",
				(arrancado ? "Está arrancado" : "Está detenido"), velocidad,
				(marchaAtras ? "Tiene la marcha atrás" : "Tiene la directa"));
	}

}
