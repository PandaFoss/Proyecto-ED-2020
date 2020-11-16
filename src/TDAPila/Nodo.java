package TDAPila;

/**
 * Modela Nodos simplemente enlazados.
 * @author Joaquin Garcia Diotto
 * 
 * @param <E> Tipo de elemento a almacenar en el Nodo.
 */
public class Nodo<E>{
	//Atributos
	private E elemento;
	private Nodo<E> siguiente;
	
	//Constructores
	
	/**
	 * Constructor N1 de la clase Nodo
	 * @param item Elemento a ser almacenado por el nodo.
	 * @param sig Nodo siguiente al actual.
	 */
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguiente = sig;
	}
	/**
	 * Constructor N2 de la clase Nodo, crea un nuevo nodo siendo su siguiente nodo nulo.
	 * @param item Elemento a almacenar en el nodo.
	 */
	public Nodo(E item) {
		this(item,null);
	}
	
	//Metodos
	
	
	//Setters
	
	/**
	 * Cambia el elemento almacenado por el nodo
	 * @param elemento Elemento nuevo a ser almacenado.
	 */
	public void setElemento(E elemento) {
		this.elemento =  elemento;
	}
	
	/**
	 * Cambia el nodo siguiente al actual.
	 * @param Siguiente Nodo que sera el siguiente al actual.
	 */
	public void setSiguiente(Nodo<E> Siguiente) {
		siguiente  = Siguiente;
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
	 * @return Retorna el nodo siguiente al actual.
	 */
	public Nodo<E> getSiguiente() {
		return siguiente;
	}
}
