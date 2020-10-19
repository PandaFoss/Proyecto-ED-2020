package TDAColaCP;

/**
 * Interface PriorityQueue - Estructura de Datos (DCIC-UNS).
 * Define los datos y operaciones aplicables sobre una cola con prioridad.
 * @author Estructuras de Datos, DCIC-UNS.
 * @version 1.0 - María Lujan Ganuza (2013-2018)
 * @version 2.0 - Federico Joaquín (2019-2020) 
 * @param <K> Tipo de dato de las claves a almacenar en la cola con prioridad.
 * @param <V> Tipo de dato de los valores a almacenar en la cola con prioridad.
 */
public interface PriorityQueue<K, V> {

	/**
	 * Consulta la cantidad de elementos de la cola.
	 * @return Cantidad de elementos de la cola.
	 */	
	public int size();
	
	/**
	 * Consulta si la cola está vacía.
	 * @return Verdadero si la cola está vacía, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola está vacía.
	 */
	public Entry<K,V> min()throws EmptyPriorityQueueException;
	
	/**
	 * Inserta un par clave-valor y devuelve la entrada creada.
	 * @param key Clave de la entrada a insertar.
	 * @param value Valor de la entrada a insertar.
	 * @return Entrada creada.
	 * @throws InvalidKeyException si la clave es inválida.
	 */
	public Entry<K,V> insert(K key,V value)throws InvalidKeyException;
	
	/**
	 * Remueve y devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola está vacía.
	 */
	public Entry<K,V> removeMin()throws EmptyPriorityQueueException; 
}
