package es.maos17.cdr.programacion.ut04.Ejemplos;

public class EjemploUtilizacionPunto {

	public static void main(String[] args) {
		Punto p1 = new Punto();
		Punto p2 = new Punto();

		p1.modificarX(10);
		Rectangulo r1 = new Rectangulo();
		r1.setNombre("Rectángulo cuadrado");
		r1.setX1(1);
		r1.setY1(1);
		r1.setX2(10);
		r1.setY2(10);
		System.out.printf("El valor x de p1 es %d.\n", p1.obtenerX());
		
		System.out.println(Rectangulo.NOMBRE_FIGURA);
		System.out.println(Rectangulo.getNumeroRectangulos());
		System.out.printf("El rectángulo llamado %s tiene un área de %d y un perímetro de %d\n", r1.getNombre(), r1.calcularSuperficie(), r1.calcularPerimetro());
		r1.desplazar(0, 10);
		System.out.println(r1.getY1());
		System.out.println(r1.getY2());
	}

}
