package Programa;

import TDAColaCP.ColaCPconLista;
import TDAColaCP.EmptyPriorityQueueException;
import TDAColaCP.InvalidKeyException;
import TDAColaCP.PriorityQueue;
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
		Transaccion<Float, String> masCostosa = new Transaccion<Float, String>();
		PriorityQueue<Integer, Transaccion<Float, String>> masCostosaCCP = new ColaCPconLista<Integer, Transaccion<Float, String>>();
		float montoMayor = 0;
		int prioridadActualMin = transacciones.size();
		int prioridadActualMax = transacciones.size() + 1;
		
		try {
			
			// Paso cada transaccion a la CCP procurando que la de menor
			// prioridad sea la del monto más alto.
			for (Transaccion<Float,String> t: transacciones) {
				if (t.getMonto() > montoMayor) {
					masCostosaCCP.insert(prioridadActualMin, t);
					prioridadActualMin--;
					montoMayor = t.getMonto();
				} else {
					masCostosaCCP.insert(prioridadActualMax, t);
					prioridadActualMax++;
				}
			}
		
			masCostosa = masCostosaCCP.min().getValue();
			
		} catch (EmptyPriorityQueueException | InvalidKeyException e) {
			e.printStackTrace();
		}
		
		return (Transaccion<Float, String>) masCostosa;
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
