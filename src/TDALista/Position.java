package TDALista;

/**
 * Interface Position.
 * @author Joaquin Garcia Diotto
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
