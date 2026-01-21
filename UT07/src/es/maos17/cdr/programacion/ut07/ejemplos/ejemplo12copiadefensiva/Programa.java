package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo12copiadefensiva;

public class Programa {

	public static void main(String[] args) {
		Motor motor1 = new Motor(2000, 0);
		Coche c = new Coche(motor1);
		Motor motor2 = c.getMotor();
		
		c.acelerarMotor();	
		motor1.acelerar();
		motor2.acelerar();
		System.out.println(c.getRevoluciones());
		c.acelerarMotor();	
		System.out.println(c.getRevoluciones());
		c.acelerarMotor();	
		System.out.println(c.getRevoluciones());
		c.acelerarMotor();	
		System.out.println(c.getRevoluciones());
		
		
		Monitor m1 = new Monitor("Dell", "123AS", 100);
		Monitor m2 = new Monitor("Dell", "123AS", 100);
		Monitor m3 = m1;
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		
		System.out.println("¿Son iguales? " + m1.equals(m2));
		System.out.println("¿Es igual el monitor que el motor? " + m1.equals(null));
		System.out.println("¿Es igual el monitor que el motor? " + m1.equals(motor1));
	}

}
