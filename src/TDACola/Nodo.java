package TDACola;

public class Nodo<E> {
	private E elemento;
	private Nodo<E> siguiente;
	
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguiente = sig;
	}
	public Nodo(E item) {
		this(item,null);
	}
	
	public void setElemento(E elemento) {
		this.elemento =  elemento;
	}
	public void setSiguiente(Nodo<E> Siguiente) {
		siguiente  = Siguiente;
	}
	
	public E getElemento() {
		return elemento;
	}
	public Nodo<E> getSiguiente() {
		return siguiente;
	}
}
