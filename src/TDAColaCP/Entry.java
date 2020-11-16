package TDAColaCP;

/**
 * Interface Entry.
 * Define los datos y metodos a ser utilizados sobre una Entrada.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 * @param <K> Tipo de dato utilizado por las claves de la clase.
 * @param <V> Tipo de dato utilizado por los valores de la clase.
 */
public interface Entry<K,V>{
	/**
	 * Obtiene la clave alamcenada por la Entrada.
	 * @return Retorna la clave alamcenada por la Entrada.
	 */
	public K getKey();
	/**
	 * Obtiene el valor alamcenado por la Entrada.
	 * @return Retorna el valor alamcenado por la Entrada.
	 */
	public V getValue();
}
