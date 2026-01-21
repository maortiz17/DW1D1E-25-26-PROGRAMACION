package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio01;

public class Fecha {
	public static final int DIA_DEFECTO = 1;
	public static final int MES_DEFECTO = 1;
	public static final int ANIO_DEFECTO = 1970;
	
	private int dia, mes, anio;
	
	public Fecha() {
		this(DIA_DEFECTO, MES_DEFECTO, ANIO_DEFECTO);
	}
	
	public Fecha(int dia, int mes, int anio) {
		setAnio(anio);
		setMes(mes);
		setDia(dia);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia < 1) {
			throw new IllegalArgumentException("El día no puede ser menor que uno");
		}
		
		switch(mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			if (dia > 31) {
				throw new IllegalArgumentException("Día inválido para ese mes");
			}
			break;
		case 4, 6, 9, 11:
			if (dia > 30) {
				throw new IllegalArgumentException("Día inválido para ese mes");
			}
			break;
		default: // tiene que ser 2
			int ultimoDiaFebrero = esBisiesto(anio) ? 29 : 28;
			if (dia > ultimoDiaFebrero) {
				throw new IllegalArgumentException("Día inválido para ese mes");
			} 
			break;
		}
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes < 1 || mes > 12) {
			throw new IllegalArgumentException("Mes inválido");
		}
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		if (anio == 0) {
			throw new IllegalArgumentException("El año no puede ser cero");
		}
		this.anio = anio;
	}
	
	public void diaSiguiente() {
		if (enUltimoDiaAnio()) {
			this.dia = 1;
			this.mes = 1;
			if (this.anio == -1) {
				this.anio = 1;
			} else {
				this.anio++;
			}
		} else if (enUltimoDiaMes()) {
			this.dia = 1;
			this.mes++;
		} else {
			dia += 1;
		}
	}
	
	public boolean esMayorQue(Fecha f) {
		if (f == null) {
			return true;
		}
		if (this.anio > f.getAnio()) {
			return true;
		}
		if (this.anio == f.getAnio() && this.mes > f.getMes()) {
			return true;
		}
		if (this.anio == f.getAnio() && this.mes == f.getMes() && this.dia > f.getDia()) {
			return true;
		}
		return false;
	}
	
	private boolean esBisiesto(int anioAComprobar) {
		// Todos los años bisiestos son divisibles entre 4. 
		// Aquellos años que son divisibles entre 4, pero no entre 100, son bisiestos. 
		// Los años que son divisibles entre 100, pero no entre 400, no son bisiestos.
		return (((anioAComprobar % 4 == 0) && (anioAComprobar % 100 != 0)) || (anioAComprobar % 400 == 0));
	}
	
	private boolean enUltimoDiaMes() {
		switch (this.mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			return this.dia == 31;
		case 4, 6, 9, 11:
			return this.dia == 30;
		default: // Será el 2 obligatoriamente
			int ultimoDiaFebrero = esBisiesto(anio) ? 29 : 28;
			return this.dia == ultimoDiaFebrero;
		}
	}
	
	private boolean enUltimoDiaAnio() {
		return this.mes == 12 && this.dia == 31;
	}
	
	@Override
	public String toString() {
		return String.format("%02d-%02d-%04d", this.dia, this.mes, this.anio);
	}
}
