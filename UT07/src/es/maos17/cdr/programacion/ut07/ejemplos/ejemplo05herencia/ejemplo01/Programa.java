// Ejemplo de constructores en herencia y sobreescritura de métodos

package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo05herencia.ejemplo01;

public class Programa {

	public static void main(String[] args) {
		SuperClase c1 = new SuperClase(100);
		System.out.println(c1.getNumero());
		
		SubClase c2 = new SubClase(200);
		System.out.println(c2.getNumero());
		
		SubClaseB c3 = new SubClaseB(100);
		

		
	}

}
