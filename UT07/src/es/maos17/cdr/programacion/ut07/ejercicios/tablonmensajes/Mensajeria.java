package es.maos17.cdr.programacion.ut07.ejercicios.tablonmensajes;

import java.util.Scanner;

public class Mensajeria {
	public static final int MENSAJE_NORMAL = -1;
	public static Tablon tablon = new Tablon();
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		int opcion;

		do {
			System.out.println("\nMENÚ DE OPCIONES");
			System.out.println("================");
			System.out.println("1. Listar mensajes");
			System.out.println("2. Mostrar mensajes normales");
			System.out.println("3. Mostrar mensajes encriptados");
			System.out.println("4. Añadir mensaje");
			System.out.println("5. Desencriptar mensaje");
			System.out.println("6. Eliminar mensaje");
			System.out.println("7. Salir");
			opcion = InputAux.leerEnteroLimites("Seleccione una opción: ", 1, 8, sc);

			try {
			switch (opcion) {
			case 1:
				listarMensajes(1);
				break;
			case 2:
				listarMensajes(2);
				break;
			case 3:
				listarMensajes(3);
				break;
			case 4:
				crearMensaje();
				break;
			case 5:
				System.out.println(desencriptarMensaje());
				break;
			case 6:
				eliminarMensaje();
				break;
			case 7:
				System.out.println("Hasta pronto");
				break;
			}
			}catch(IllegalArgumentException e) {
				System.out.println("Error en parámetros: " + e.getMessage());
			}catch(IllegalStateException e) {
				System.out.println("Error de estado: " + e.getMessage());
			}
		} while (opcion != 7);
	}

	/**
	 * Muestra mensajes por pantalla
	 * 
	 * @param opcion : 1 Muestra todos los mensajes 2 Muestra mensajes normales 3
	 *               Muestra mensajes encriptados
	 */
	public static void listarMensajes(int opcion) {
		if (tablon.getSiguienteMensaje() == 0) {
			throw new IllegalStateException("No hay mensajes");
		}
		if (opcion < 1 || opcion > 3) {
			throw new IllegalArgumentException("Opción inválida en método listarMensajes");
		}
		Mensaje[] mensajes = tablon.getTablon();
		for (int i = 0; i < mensajes.length; i++) {
			if (tablon.getTablon()[i] != null
					&& (opcion == 1 || (opcion == 2 && !estaEncriptado(mensajes[i])) || (opcion == 3 && estaEncriptado(mensajes[i])))) {
				System.out.println(mensajes[i]);
			}
		}
	}

	/**
	 * Devuelve true si un mensaje está encriptado y false en caso contrario
	 * 
	 * @param codigo Código del mensaje a inspeccionar
	 * @return true si un mensaje está encriptado y false en caso contrario
	 */
	public static boolean estaEncriptado(Mensaje mensaje) {
		if (mensaje == null) {
			throw new IllegalArgumentException("Mensaje no válido (null)");
		}
		return mensaje instanceof MensajeEncriptado;
	}

	public static void crearMensaje() {
		System.out.println("Seleccione tipo:\n1. Normal\n2. Encriptado\n0. Salir");
		int opcion = InputAux.leerEnteroLimites("Seleccione opción: ", 0, 2, sc);
		switch (opcion) {
		case 1:
			crearMensajeNormal();
			break;
		case 2:
			crearMensajeEncriptado();
			break;
		case 0:
			System.out.println("Creación cancelada");
			break;
		}
	}

	public static void crearMensajeNormal() {
		System.out.print("Introduzca texto del mensaje: ");
		String mensaje = sc.nextLine();
		tablon.crearMensaje(mensaje, MENSAJE_NORMAL);
	}

	public static void crearMensajeEncriptado() {
		System.out.print("Introduzca texto del mensaje: ");
		String mensaje = sc.nextLine();
		int codigoEncriptacion = InputAux.leerEnteroLimites("Introduzca código (entero mayor o igual a cero): ", 0,
				Integer.MAX_VALUE, sc);
		tablon.crearMensaje(mensaje, codigoEncriptacion);
	}

	public static String desencriptarMensaje() { // Desencriptamos aquí porque se supone que el algoritmo es secreto.
													// Solo podemos desencriptar mensajes si conocemos el algoritmo y el
													// código
		int codigoMensaje = InputAux.leerEnteroLimites("Selecciona el mensaje: ", 1, tablon.getSiguienteMensaje(), sc) - 1;
		Mensaje mensaje = tablon.getTablon()[codigoMensaje];
		if (mensaje == null) {
			throw new IllegalArgumentException("Mensaje no encontrado");
		}
		if (!estaEncriptado(mensaje)) {
			throw new IllegalStateException("Mensaje no encriptado");
		}
		int codigoEncriptacion = InputAux.leerEnteroLimites("Introduzca código (entero mayor o igual a cero): ", 0,
				Integer.MAX_VALUE, sc);
		return ((MensajeEncriptado)mensaje).desencriptar(codigoEncriptacion);
	}

	public static void eliminarMensaje() {
		if (tablon.getSiguienteMensaje() == 0) {
			throw new IllegalStateException("No hay mensajes");
		}
		int codigoMensaje = InputAux.leerEnteroLimites("Selecciona el mensaje: ", 1, tablon.getSiguienteMensaje(), sc);
		tablon.eliminarMensajes(codigoMensaje);
	}
}
