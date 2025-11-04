package es.maos17.cdr.programacion.ut03.ejemplos;

public class EjemploStringBuilder {

	public static void main(String[] args) {
		// Creacioón del nuevo objeto
		StringBuilder sb = new StringBuilder();
		
		String sabor = "fresa";
		int tamanioEnMl = 750;
		double precio = 10.75;

		sb.append("He comprado un helado de ");
		sb.append(sabor);
		sb.append(" de ");
		sb.append(tamanioEnMl);
		sb.append(" ml y me ha costado ");
		sb.append(precio);
		sb.append(" euros");
		
		//System.out.println(sb);
		
		Persona miguel = new Persona(50, "Miguel");
		System.out.println(miguel);
	}

}
