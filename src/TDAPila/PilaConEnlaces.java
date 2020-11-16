package TDAPila;

/**
 * Implementa la interfaz Stack mediante la estructura de datos Pila Con Enlaces.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 * @param <E> Tipo del elemento a almacenar en la Pila
 */
public class PilaConEnlaces<E> implements Stack<E>{
	//Atributos
	protected Nodo<E> head;
	protected int size;
	
	//Constructor
	/**
	 * Crea una Pila Con Enlaces vacia.
	 */
	public PilaConEnlaces() {
		head = null;
		size = 0;
	}
	
	
	//Getters
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public E top() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException("La Pila es vacia");
		else
			return head.getElemento();
	}
	
	
	//Setters
	
	@Override
	public void push(E item) {
		head = new Nodo<E>(item, head);
		size++;
	}
	
	@Override
	public E pop() throws EmptyStackException {
		if (size == 0)
			throw new EmptyStackException("La Pila es vacia");
		else {
			E aux = head.getElemento();
			head = head.getSiguiente();
			size--;
			return aux;
		}
	}
	
}
