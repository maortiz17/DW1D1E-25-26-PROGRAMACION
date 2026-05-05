package ejemplos.ejemplo03;

public class Programa {
	public static void main(String[] args) {
		Matematica sumar = new Sumar();
		int i1 = 3;
		int i2 = 4;
		System.out.printf("%d + %d = %d", i1, i2, sumar.operacion(i1, i2));
	}
}
