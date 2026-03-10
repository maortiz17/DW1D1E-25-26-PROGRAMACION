package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static final Scanner sc = new Scanner(System.in);
	public static final String[] OPCIONES_MENU_PRINCIPAL = {
			"Gestionar clientes",
			"Gestionar cuentas",
			"Salir"
	};
	public static final String[] OPCIONES_MENU_CLIENTES = {
			"Listar clientes",
			"Dar de alta un cliente",
			"Mostrar un cliente",
			"Eliminar un cliente",
			"Volver al menú principal"
	};
	public static final String[] OPCIONES_MENU_CUENTAS = {
			"Crear cuenta",
			"Listar cuentas de un cliente",
			"Ingresar",
			"Reintegrar",
			"Transferir entre cuentas",
			"Ver movimientos",
			"Volver al menú principal"
	};

	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<>();
		List<CuentaBancaria> cuentas = new ArrayList<>();
		menuPrincipal(clientes, cuentas);
	}

	// MENÚS
	public static void menuPrincipal(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		int opcion;
		do {
			System.out.println("\n=== MENÚ PRINCIPAL ===");
			imprimirArray(OPCIONES_MENU_PRINCIPAL);
			opcion = UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, 3, sc);
			switch (opcion) {
				case 1: 
					menuClientes(clientes); 
					break;
				case 2: 
					menuCuentas(clientes, cuentas); 
					break;
				case 3: 
					System.out.println("Cerrando aplicación. Hasta pronto."); 
					break;
			}
		} while (opcion != 3);
	}

	public static void menuClientes(List<Cliente> clientes) {
		int opcion;
		do {
			System.out.println("\n=== GESTIÓN DE CLIENTES ===");
			imprimirArray(OPCIONES_MENU_CLIENTES);
			opcion = UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, 5, sc);
			switch (opcion) {
				case 1: 
					listarClientes(clientes); 
					break;
				case 2: 
					altaCliente(clientes); 
					break;
				case 3: 
					mostrarCliente(clientes); 
					break;
				case 4: 
					eliminarCliente(clientes); 
					break;
				case 5: 
					System.out.println("Volviendo al menú principal...");
					break;
			}
		} while (opcion != 5);
	}

	public static void menuCuentas(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		int opcion;
		do {
			System.out.println("\n=== GESTIÓN DE CUENTAS ===");
			imprimirArray(OPCIONES_MENU_CUENTAS);
			opcion = UtilsInput.leerEnteroLimites("Introduzca una opción: ", 1, 7, sc);
			switch (opcion) {
				case 1: 
					crearCuenta(clientes, cuentas); 
					break;
				case 2: 
					listarCuentasCliente(clientes, cuentas); 
					break;
				case 3: 
					ingresar(clientes, cuentas); 
					break;
				case 4: 
					reintegrar(clientes, cuentas); 
					break;
				case 5: 
					transferir(clientes, cuentas); 
					break;
				case 6: 
					verMovimientos(clientes, cuentas); 
					break;
				case 7: 
					System.out.println("Volviendo al menú principal..."); 
					break;
			}
		} while (opcion != 7);
	}


	// OPERACIONES CON CLIENTES
	public static void listarClientes(List<Cliente> clientes) {
		if (clientes.isEmpty()) {
			System.out.println("No hay clientes registrados.");
			return;
		}
		// Orden natural de Cliente: apellidos y nombre (Comparable)
		List<Cliente> ordenados = new ArrayList<>(clientes);
		Collections.sort(ordenados);
		System.out.println("\n--- Lista de clientes (orden alfabético) ---");
		for (Cliente c : ordenados) {
			System.out.printf("%s - %s %s\n", c.getNif(), c.getNombre(), c.getApellidos());
		}
	}

	public static void altaCliente(List<Cliente> clientes) {
		System.out.println("Introduzca los datos del nuevo cliente:");
		String nif = UtilsInput.leerCadena("NIF/NIE: ", sc);

		// contains() funciona directamente por utilizar equals
		if (clientes.contains(new Cliente(nif))) {
			System.out.println("Ya existe un cliente con ese NIF/NIE.");
			return;
		}
		String nombre = UtilsInput.leerCadena("Nombre: ", sc);
		String apellidos = UtilsInput.leerCadena("Apellidos: ", sc);
		String email = UtilsInput.leerCadena("Correo electrónico: ", sc);
		LocalDate fechaNacimiento = UtilsInput.leerFecha("Introduzca fecha de nacimiento: ", 1900, LocalDate.now().getYear(), sc);
		clientes.add(new Cliente(nif, nombre, apellidos, fechaNacimiento, email));
		System.out.println("Cliente dado de alta correctamente.");
	}

	public static void mostrarCliente(List<Cliente> clientes) {
		String nif = UtilsInput.leerCadena("Introduzca el NIF/NIE del cliente: ", sc);

		// indexOf() usa equals() 
		int indice = clientes.indexOf(new Cliente(nif));
		if (indice >= 0) {
			System.out.println(clientes.get(indice));
		} else {
			System.out.println("NIF/NIE no encontrado.");
		}
	}

	public static void eliminarCliente(List<Cliente> clientes) {
		String nif = UtilsInput.leerCadena("Introduzca el NIF/NIE del cliente a eliminar: ", sc);

		// remove utiliza método equals de la Clase
		if (clientes.remove(new Cliente(nif))) {
			System.out.println("Cliente eliminado correctamente.");
		} else {
			System.out.println("NIF/NIE no encontrado.");
		}
	}

	// OPERACIONES CON CUENTAS
	public static void crearCuenta(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		if (clientes.isEmpty()) {
			System.out.println("No hay clientes registrados. Dé de alta un cliente primero.");
			return;
		}
		String nif = UtilsInput.leerCadena("NIF/NIE del cliente titular: ", sc);
		int indice = clientes.indexOf(new Cliente(nif));
		if (indice < 0) {
			System.out.println("No existe ningún cliente con ese NIF/NIE.");
			return;
		}
		Cliente cliente = clientes.get(indice);
		double saldoInicial = UtilsInput.leerDoublePositivo("Saldo inicial (0 para ninguno): ", sc);
		if (saldoInicial > 0) {
			cuentas.add(new CuentaBancaria(cliente, saldoInicial));
		} else {
			cuentas.add(new CuentaBancaria(cliente));
		}
		System.out.println("Cuenta creada correctamente.");
	}

	public static void listarCuentasCliente(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		List<CuentaBancaria> resultado = pedirNifYObtenerCuentas(clientes, cuentas);
		if (resultado == null) return;
		if (resultado.isEmpty()) {
			System.out.println("Este cliente no tiene cuentas.");
			return;
		}
		System.out.println("\n--- Cuentas ---");
		for (CuentaBancaria cb : resultado) {
			System.out.println(cb);
		}
	}

	public static void ingresar(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		CuentaBancaria cuenta = pedirNifYSeleccionarCuenta(clientes, cuentas);
		if (cuenta == null) return;
		double importe = UtilsInput.leerDoublePositivo("Importe a ingresar: ", sc);
		String concepto = UtilsInput.leerCadena("Concepto: ", sc);
		cuenta.ingresar(importe, concepto);
		System.out.printf("Ingreso realizado. Nuevo saldo: %.2f €\n", cuenta.getSaldo());
	}

	public static void reintegrar(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		CuentaBancaria cuenta = pedirNifYSeleccionarCuenta(clientes, cuentas);
		if (cuenta == null) return;
		double importe = UtilsInput.leerDoublePositivo("Importe a reintegrar: ", sc);
		if (importe > cuenta.getSaldo()) {
			System.out.println("Saldo insuficiente.");
			return;
		}
		cuenta.reembolsar(importe);
		System.out.printf("Reintegro realizado. Nuevo saldo: %.2f €\n", cuenta.getSaldo());
	}

	public static void transferir(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		System.out.println("-- Cuenta de origen --");
		CuentaBancaria origen = pedirNifYSeleccionarCuenta(clientes, cuentas);
		if (origen == null) return;

		System.out.println("-- Cuenta de destino --");
		CuentaBancaria destino = pedirNifYSeleccionarCuenta(clientes, cuentas);
		if (destino == null) return;

		// equals() de CuentaBancaria compara por numeroCuenta
		if (origen.equals(destino)) {
			System.out.println("La cuenta de origen y destino no pueden ser la misma.");
			return;
		}
		double importe = UtilsInput.leerDoublePositivo("Importe a transferir: ", sc);
		if (importe > origen.getSaldo()) {
			System.out.println("Saldo insuficiente en la cuenta de origen.");
			return;
		}
		String concepto = UtilsInput.leerCadena("Concepto: ", sc);
		origen.transferir(importe, concepto);
		destino.recibirTransferencia(importe, concepto);
		System.out.printf("Transferencia realizada. Saldo origen: %.2f €  |  Saldo destino: %.2f €\n",
				origen.getSaldo(), destino.getSaldo());
	}

	public static void verMovimientos(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		CuentaBancaria cuenta = pedirNifYSeleccionarCuenta(clientes, cuentas);
		if (cuenta == null) return;
		System.out.println("\n--- Movimientos (más reciente primero) ---");
		System.out.printf("%-22s %-30s %10s %10s %10s\n",
				"Fecha/Hora", "Tipo", "Saldo ini.", "Importe", "Saldo fin.");
		System.out.println("-".repeat(87));
		for (Movimiento m : cuenta.getMovimientos()) {
			System.out.printf("%-22s %-30s %10.2f %10.2f %10.2f\n",
					m.getFechaHora(), m.getTipoMovimiento().name(),
					m.getSaldoInicial(), m.getImporte(), m.getSaldoFinal());
		}
	}

	// UTILIDADES
	public static <T> void imprimirArray(T[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("imprimirArray: array vacío");
		}
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d. %s\n", i + 1, array[i]);
		}
	}

	public static CuentaBancaria seleccionarCuenta(List<CuentaBancaria> cuentasCliente) {
		if (cuentasCliente.isEmpty()) {
			System.out.println("Este cliente no tiene cuentas.");
			return null;
		}
		List<CuentaBancaria> ordenadas = new ArrayList<>(cuentasCliente);
		Collections.sort(ordenadas);
		for (int i = 0; i < ordenadas.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, ordenadas.get(i));
		}
		int opcion = UtilsInput.leerEnteroLimites("Seleccione una cuenta: ", 1, ordenadas.size(), sc);
		return ordenadas.get(opcion - 1);
	}

	// Pide NIF, valida que existe y devuelve sus cuentas. Devuelve null si el cliente no existe.
	public static List<CuentaBancaria> pedirNifYObtenerCuentas(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		String nif = UtilsInput.leerCadena("NIF/NIE del cliente: ", sc);
		if (!clientes.contains(new Cliente(nif))) {
			System.out.println("No existe ningún cliente con ese NIF/NIE.");
			return null;
		}
		List<CuentaBancaria> resultado = new ArrayList<>();
		for (CuentaBancaria cb : cuentas) {
			if (cb.getCliente().getNif().equalsIgnoreCase(nif)) {
				resultado.add(cb);
			}
		}
		return resultado;
	}

	// Pide NIF, lista las cuentas del cliente y devuelve la seleccionada. Devuelve null si algo falla.
	public static CuentaBancaria pedirNifYSeleccionarCuenta(List<Cliente> clientes, List<CuentaBancaria> cuentas) {
		List<CuentaBancaria> cuentasCliente = pedirNifYObtenerCuentas(clientes, cuentas);
		if (cuentasCliente == null) return null;
		return seleccionarCuenta(cuentasCliente);
	}
}