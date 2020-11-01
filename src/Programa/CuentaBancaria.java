package Programa;

import TDADeque.Deque;

public class CuentaBancaria {
	protected float saldo;
	protected Deque<Transaccion<Float,String>> transacciones;
	
	/**
	 * Instancia una nueva cuenta bancaria con saldo en cero.
	 */
	public CuentaBancaria() {
		saldo = 0.00F;
		transacciones = new Deque<Transaccion<Float,String>>();
	}
	
	/**
	 * Método que permite obtener la transacción más reciente efectuada.
	 * @return La Transaccion más reciente.
	 */
	public Transaccion<Float, String> transaccionMasReciente() {
		return transacciones.getLast();
	}
	
	/**
	 * Método que permite obtener la transacción más histórica efectuada.
	 * @return La Transaccion más histórica.
	 */
	public Transaccion<Float, String> transaccionMasHistorica() {
		return transacciones.getFirst();
	}
	
	/**
	 * Método que permite obtener la transacción más costosa efectuada.
	 * @return La Transaccion más costosa.
	 */
	public Transaccion<Float, String> transaccionMasCostosa() {
		return null;
	}
	
	/**
	 * Método que permite obtener las transacciones con igual monto.
	 * @return Transacciones con igual monto.
	 */
	public Transaccion<Float, String> transaccionIgualMonto() {
		return null;
	}
	
	/**
	 * Método que efectúa una transacción t.
	 * @param t transacción a computar.
	 */
	public void realizarTransaccion (Transaccion<Float, String> t) {
		saldo += t.getMonto();
		transacciones.add(t);
	}
}
