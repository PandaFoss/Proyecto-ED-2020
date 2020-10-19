package TDAPila;

public class PilaConEnlaces<E> implements Stack<E> {
	
	protected Nodo<E> head;
	protected int tamanio;
	
	public PilaConEnlaces() {
		head = null;
		tamanio = 0;
	}

	@Override
	public int size() {
		return tamanio;
	}

	@Override
	public boolean isEmpty() {
		return tamanio == 0;
	}

	@Override
	public E top() throws EmptyStackException {
		if ( tamanio == 0 ) throw new EmptyStackException("No es posible examinar el primer elemento: pila vacía.");
		return head.elemento;
	}

	@Override
	public void push(E element) {
		Nodo<E> newHead = new Nodo<E>(element, head);
		head = newHead;
		tamanio++;
	}

	@Override
	public E pop() throws EmptyStackException {
		if ( tamanio == 0 ) throw new EmptyStackException("No es posible quitar el primer elemento: pila vacía.");
		E elemento = head.elemento;
		head = head.siguiente;
		tamanio--;
		return elemento;
	}

}
