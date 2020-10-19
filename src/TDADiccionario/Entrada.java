package TDADiccionario;

/**
 * Modela la interfaz Entry a mediante Entradas.
 * @author Joaquin Garcia Diotto
 *
 * @param <K> Tipo de dato utilizado por las claves de la clase.
 * @param <V> Tipo de dato utilizado por los valores de la clase.
 */
public class Entrada<K,V> implements Entry<K,V>{
	private K key;
	private V value;
	
	/**
	 * Crea una nueva entrada no vacia.
	 * @param key Clave de la entrada
	 * @param value Valor de la entrada
	 */
	public Entrada(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}
	@Override
	public V getValue() {
		return value;
	}
	
	/**
	 * Cambia la clave alamcenada por la Entrada.
	 * @param key Clave nueva a ser almacenada.
	 */
	public void setKey(K key) {
		this.key = key;
	}
	/**
	 * Cambia el valor alamcenado por la Entrada.
	 * @param value Valor nuevo a ser almacenado.
	 */
	public void setValue(V value) {
		this.value = value;
	}
}
