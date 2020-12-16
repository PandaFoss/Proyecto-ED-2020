/**
 * Provee clases e interfaces tendientes a implementar el TDA Diccionario con Hash Abierto
 */
package TDADiccionario;

/**
 * Interface Entry.
 * Define los datos y metodos a ser utilizados sobre una Entrada.
 * @author Skorrom - Max Ferrer [Panda Foss]
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
