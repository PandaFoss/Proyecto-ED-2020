/**
 * Provee clases e interfaces tendientes a implementar el TDA Lista
 */
package TDALista;

/**
 * Interface Position.
 * @author Skorrom - Max Ferrer [Panda Foss]
 * 
 * @param <E> Elemento a ser almacenado por la posicion.
 */
public interface Position<E>{
	
	/**
	 * Devuelve el elemento almacenado por la posicion.
	 * @return Elemento almacenado por la posicion.
	 */
	public E element();
}
