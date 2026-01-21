package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo12copiadefensiva;

public class Coche {
	private Motor motor;

	public Coche(Motor motor) {
		Motor nuevoMotor = new Motor(motor.getCilindrada(), motor.getRevoluciones());
		this.motor = nuevoMotor;
	}

	public void acelerarMotor() {
		this.motor.acelerar();
	}

	public int getRevoluciones() {
		return motor.getRevoluciones();
	}
	
	public Motor getMotor() {
		Motor otroMotor = new Motor(this.motor.getCilindrada(), this.motor.getRevoluciones());
		return otroMotor;
	}

}
