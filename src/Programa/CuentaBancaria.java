package Programa;

import TDAColaCP.ColaCPconLista;
import TDAColaCP.EmptyPriorityQueueException;
import TDAColaCP.InvalidKeyException;
import TDAColaCP.PriorityQueue;
import TDADeque.Deque;
import TDADiccionario.DiccionarioHashAbierto;
import TDADiccionario.Dictionary;
import TDADiccionario.Entry;
import TDALista.ListaDE;
import TDALista.PositionList;

public class CuentaBancaria {
	protected float saldo;
	protected Deque<Transaccion> transacciones;
	
	/**
	 * Instancia una nueva cuenta bancaria con saldo en cero.
	 */
	public CuentaBancaria() {
		saldo = 0.00F;
		transacciones = new Deque<Transaccion>();
	}
	
	/**
	 * Método que permite obtener la transacción más reciente efectuada.
	 * @return La Transaccion más reciente.
	 */
	public Transaccion transaccionMasReciente() {
		return transacciones.getLast();
	}
	
	/**
	 * Método que permite obtener la transacción más histórica efectuada.
	 * @return La Transaccion más histórica.
	 */
	public Transaccion transaccionMasHistorica() {
		return transacciones.getFirst();
	}
	
	/**
	 * Método que permite obtener la transacción más costosa efectuada.
	 * @return La Transaccion más costosa.
	 */
	public Transaccion transaccionMasCostosa() {
		Transaccion masCostosa = new Transaccion();
		PriorityQueue<Float, Transaccion> masCostosaCCP = new ColaCPconLista<Float, Transaccion>();
		try {
			//Inserto todas las transacciones en la cola. Su prioridad (o monto) pasa a ser negativa asi las de mayor monto quedan primeras.
			for (Transaccion t: transacciones) {
				masCostosaCCP.insert(-t.getMonto(),t);
			}
			masCostosa = masCostosaCCP.min().getValue();
		} catch (EmptyPriorityQueueException | InvalidKeyException e) {
			e.printStackTrace();
		}
		return masCostosa;
	}
	
	/**
	 * Método que permite obtener las transacciones con igual monto.
	 * @return Transacciones con igual monto.
	 */
	public Iterable<Transaccion> transaccionesIgualMonto(Float monto) {
		Dictionary<Float,Transaccion> transaccionesDiccionario = new DiccionarioHashAbierto<Float,Transaccion>();
		PositionList<Transaccion> transaccionesLista = new ListaDE<Transaccion>();
		try {
			for(Transaccion t : transacciones) {
				transaccionesDiccionario.insert(t.getMonto(), t);
			}
			for(Entry<Float, Transaccion> e : transaccionesDiccionario.findAll(monto)) {
				transaccionesLista.addLast(e.getValue());
			}
		} catch (TDADiccionario.InvalidKeyException e) {
			e.printStackTrace();
		}
		return transaccionesLista;
	}
	
	/**
	 * Método que efectúa una transacción t.
	 * @param t transacción a computar.
	 */
	public void realizarTransaccion (Transaccion t) {
		saldo += t.getMonto();
		transacciones.add(t);
	}
}
