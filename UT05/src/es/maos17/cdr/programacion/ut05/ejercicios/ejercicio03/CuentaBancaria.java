package es.maos17.cdr.programacion.ut05.ejercicios.ejercicio03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class CuentaBancaria implements Comparable<CuentaBancaria> {
	private static long siguienteNumCuenta = 100000000000L;
	private long numeroCuenta;
	private Cliente cliente;
	private ArrayList<Movimiento> movimientos;
	
	public CuentaBancaria(Cliente cliente, double saldoInicial) {
		this.cliente = new Cliente(cliente.getNif(), cliente.getNombre(), cliente.getApellidos(), 
				cliente.getFechaNacimiento(), cliente.getEmail());
		this.movimientos = new ArrayList<>();
		if (saldoInicial != 0) {
			movimientos.add(new Movimiento(TipoMovimiento.INGRESO, saldoInicial, 0, "Apertura de cuenta"));
		}
		this.numeroCuenta = siguienteNumCuenta++;
	}
	
	public CuentaBancaria(Cliente cliente) {
		this(cliente, 0);
	}
	
	public double getSaldo() {
		if (!movimientos.isEmpty()) {
			return movimientos.get(movimientos.size() - 1).getSaldoFinal();
		}
		else {
			return 0;
		}
	}
	
	public long getNumeroCuenta() {
		return numeroCuenta; 
	}
	public Cliente getCliente() {
		return cliente; 
	}
	
	public void ingresar(double importe, String concepto) {
		movimientos.add(new Movimiento(TipoMovimiento.INGRESO, importe, getSaldo(), concepto));
	}
	
	public void reembolsar(double importe) {
		movimientos.add(new Movimiento(TipoMovimiento.REINTEGRO, -importe, getSaldo(), ""));
	}
	
	public void transferir(double importe, String concepto) {
		movimientos.add(new Movimiento(TipoMovimiento.TRANSFERENCIA_OTRA_CUENTA, -importe, getSaldo(), concepto));
	}
	
	public void recibirTransferencia(double importe, String concepto) {
		movimientos.add(new Movimiento(TipoMovimiento.TRANSFERENCIA_FAVOR, importe, getSaldo(), concepto));
	}
	
	public ArrayList<Movimiento> getMovimientos(){
		ArrayList<Movimiento> copiaMovimientos = new ArrayList<>(this.movimientos);
		copiaMovimientos.sort(Comparator.reverseOrder());
		
		// Forma alternativa: Método estático reverse() de Collections
		//ArrayList<Movimiento> copiaMovimientos = new ArrayList<>(movimientos);
		//Collections.reverse(copiaMovimientos);
		
		// Forma alternativa: Utilizar ListIterator<T>
		//ArrayList<Movimiento> copiaMovimientos = new ArrayList<>(movimientos.size());
		//ListIterator<Movimiento> lit = movimientos.listIterator(movimientos.size());
		//while(lit.hasPrevious()) {
			//copiaMovimientos.add(lit.previous());
		//}
		return copiaMovimientos;
	}
	
	// Dos cuentas son iguales si tienen el mismo número
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CuentaBancaria)) return false;
		CuentaBancaria other = (CuentaBancaria) o;
		return numeroCuenta == other.numeroCuenta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta);
	}

	// Orden natural: por número de cuenta (orden de creación)

	@Override
	public int compareTo(CuentaBancaria other) {
		return Long.compare(numeroCuenta, other.numeroCuenta);
	}
	
	@Override 
	public String toString() {
		return String.format("Cuenta número %d. Saldo %.2f", numeroCuenta, getSaldo());
	}
}
