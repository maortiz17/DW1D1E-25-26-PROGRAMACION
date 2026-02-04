package es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Afinable;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Arpa;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Clarinete;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Flauta;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Guitarra;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Instrumento;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Pandereta;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Piano;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Timbales;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Trompeta;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Tuba;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Violin;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Violoncelo;
import es.maos17.cdr.programacion.ut07.ejercicios.ejercicio19.instrumentos.Xilofono;
import net.datafaker.Faker;

public class Programa {

	private static final int NUM_TIPOS_INSTRUMENTOS = 12;
	
	
	private static Faker faker = new Faker(new Locale("es"));
	

	public static void main(String[] args) {

		Instrumento[] instrumentos = crearInstrumentos(20);
		
		tocarInstrumentos(instrumentos);
		Instrumento masDificil = buscarMasDificil(instrumentos);
		System.out.println("El instrumento más dificil es:");
		System.out.println(masDificil);
		
		Arrays.sort(instrumentos); // Ordenamos por orden natural
		mostrarInstrumentos(instrumentos);
		
		afinarInstrumentos(instrumentos);

	}

	private static Instrumento[] crearInstrumentos(int cuantos) {
		Instrumento[] instrumentos = new Instrumento[cuantos];
		for (int i = 0; i < instrumentos.length; i++) {
			instrumentos[i] = crearInstrumentoAleatorio();
		}
		return instrumentos;
	}

	private static void tocarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			instrumento.tocar();
		}
		for (Instrumento instrumento : instrumentos) {
			instrumento.parar();
		}
	}

	private static Instrumento buscarMasDificil(Instrumento[] instrumentos) {
		if (instrumentos.length == 0) {
			throw new IllegalArgumentException("El array de instrumentos no puede estar vacío");
		}
		// TODO: ¿comprobar nulos?
		Instrumento masDificil = instrumentos[0];
		for (Instrumento instrumento : instrumentos) {
			if (instrumento.esMasDificil(masDificil)) {
				masDificil = instrumento;
			}
		}
		return masDificil;
	}
	
	private static void mostrarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			System.out.println(instrumento);
		}
	}

	private static Instrumento crearInstrumentoAleatorio() {
		switch (faker.random().nextInt(NUM_TIPOS_INSTRUMENTOS)) {
		case 0:
			return new Arpa(faker.name().fullName());
		case 1:
			return new Clarinete(faker.name().fullName());
		case 2:
			return new Flauta(faker.name().fullName());
		case 3:
			return new Guitarra(faker.name().fullName());
		case 4:
			return new Pandereta(faker.name().fullName());
		case 5:
			return new Piano(faker.name().fullName());
		case 6:
			return new Timbales(faker.name().fullName());
		case 7:
			return new Trompeta(faker.name().fullName());
		case 8:
			return new Tuba(faker.name().fullName());
		case 9:
			return new Violin(faker.name().fullName());
		case 10:
			return new Violoncelo(faker.name().fullName());
		case 11:
			return new Xilofono(faker.name().fullName());
		default:
			throw new RuntimeException("Valor en switch no válido");
		}
	}
	
	private static void afinarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			if (instrumento instanceof Afinable) {
				((Afinable) instrumento).afinar();	
			}
		}
	}
}
