package es.maos17.cdr.programacion.ut07.ejemplos.ejemplo05herencia.ejemplo01;

	public SubClase(int numero) {
		super(numero);
		System.out.println("En el constructor con 1 parámetro de la subclase.");
	}
	
	// Puedo declarar nuevos constructores siempre que sean compatibles con algún constructor de la superclase
	public SubClase(String numero) {
		super(Integer.parseInt(numero));
	}

    // Esto no funcionará, ya que al principio se hace una llamada implícita a super(), y el constructor por defecto de la superclase no existe
//	public SubClase(String numero) {
//		int num = Integer.parseInt(numero);
//		this.setNumero(num);
//	}
//	





