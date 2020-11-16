package TDALista;

/**
 * Modela la interfaz Position mediante Nodos doblemente enlazados.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 * @param <E> Parametro generico utilizado por la clase.
 */
public class DNodo<E> implements Position<E>{
	
	//Atributos
	private E elemento;
	private DNodo<E> prev, next;
	
	
	/**
	 * Constructor N1 de la clase privada DNodo
	 * @param item Elemento el cual almacenara el Nodo.
	 * @param pre Nodo previo al actual.
	 * @param sig Nodo siguiente al actual.
	 */
	public DNodo(E item, DNodo<E> pre, DNodo<E> sig) {
		elemento = item;
		next = sig;
		prev = pre;
	}
	
	/**
	 * Constructor N2 de la clase privada DNodo, sus nodos previo y siguiente seran nulos.
	 * @param item Elemento que sera almacenado por el nodo.
	 */
	public DNodo(E item) {
		this(item,null,null);
	}
	
	//Metodos
	
	
	//Setters
	
	/**
	 * Cambia el elemento almacenado por el nodo.
	 * @param elemento Elemento nuevo a ser almacenado.
	 */
	public void setElemento(E elemento) {
		this.elemento =  elemento;
	}
	
	/**
	 * Cambia el nodo siguiente al actual.
	 * @param Siguiente Nodo el cual sera el siguiente al actual.
	 */
	public void setNext(DNodo<E> Siguiente) {
		next  = Siguiente;
	}
	
	/**
	 * Cambia el nodo previo al actual.
	 * @param prev Nodo el cual sera el previo al actual.
	 */
	public void setPrev(DNodo<E> prev) {
		this.prev = prev;
	}
		
	
	//Getters
	
	/**
	 * Obtiene el elemento almacenado por el nodo.
	 * @return Retorna el elemento almacenado por el nodo.
	 */
	public E getElemento() {
		return elemento;
	}
	
	/**
	 * Obtiene el nodo siguiente al actual.
	 * @return Retorna el nodo siguiente al acutal.
	 */
	public DNodo<E> getNext() {
		return next;
	}
	
	/**
	 * Obtiene el nodo previo al actual.
	 * @return Retorna el nodo previo al atual.
	 */
	public DNodo<E> getPrev(){
		return prev;
	}
	
	@Override
	public E element() {
		return elemento;
	}
}