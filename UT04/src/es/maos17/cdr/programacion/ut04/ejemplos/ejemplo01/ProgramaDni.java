package es.maos17.cdr.programacion.ut04.ejemplos.ejemplo01;

public class ProgramaDni {

	public static void main(String[] args) {
		Dni dni1 = new Dni("83652990N");
		Dni dni2 = new Dni(83757827); // Letra S
		
		System.out.println(dni1.getDNI());
		System.out.println(dni1.getNIF());
		System.out.println(dni2.getDNI());
		System.out.println(dni2.getNIF());
	}

}
