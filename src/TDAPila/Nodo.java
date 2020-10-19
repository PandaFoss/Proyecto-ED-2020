package TDAPila;

public class Nodo<E> {

	protected E elemento;
	protected Nodo<E> siguiente;
	
	public Nodo(E item) {
		this(item,null);
	}
	
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguiente = sig;
	}
}
