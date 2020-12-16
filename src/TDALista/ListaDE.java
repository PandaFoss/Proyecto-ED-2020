/**
 * Provee clases e interfaces tendientes a implementar el TDA Lista
 */
package TDALista;

import java.util.Iterator;

/**
 * Clase ListaDE.
 * Modela la interfaz PositionList mediante la estructura de datos Lista Doblemente Enlazada.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 * @param <E> Tipo de dato a almacenar en la lista.
 */
public class ListaDE<E> implements PositionList<E>{
	//Atributos
	protected DNodo<E> cabeza, rabo;
	protected int size;
	
	/**
	 * Constructor de la clase ListaDE. Crea una Lista Doblemente Enlazada.
	 */
	public ListaDE() {
		cabeza = new DNodo<E>(null);
		rabo = new DNodo<E>(null);
		cabeza.setPrev(null);
		cabeza.setNext(rabo);
		rabo.setPrev(cabeza);
		rabo.setNext(null);
		size = 0;
	}
	
	//Metodos
	
	
	//Getters
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Position<E> first() throws EmptyListException {
		if (cabeza.getNext()==rabo) throw new EmptyListException("first(); Lista vacia");
		return cabeza.getNext();
	}
	
	@Override
	public Position<E> last() throws EmptyListException {
		if (size==0) throw new EmptyListException("last(); Lista vacia");
		return rabo.getPrev();
	}
	
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> pos = checkPosition(p);
		if (p==rabo.getPrev()) throw new BoundaryViolationException("next(); Posicion rabo");
		return pos.getNext();
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> pos = checkPosition(p);
		if (pos.getPrev()==cabeza) throw new BoundaryViolationException("prev(); Posicion cabeza");
		if (size==0) throw new InvalidPositionException("Lista vacia");
		return pos.getPrev();
	}
	
	
	//Setters
	
	@Override
	public void addFirst(E element) {
		DNodo<E> e = new DNodo<E>(element,cabeza,cabeza.getNext());
		cabeza.getNext().setPrev(e);
		cabeza.setNext(e);
		size++;
	}

	@Override
	public void addLast(E element) {
		DNodo<E> nuevo = new DNodo<E>(element,rabo.getPrev(),rabo);
		rabo.getPrev().setNext(nuevo);
		rabo.setPrev(nuevo);
		size++;
	}

	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(element,pos,pos.getNext());
		pos.setNext(nuevo);
		nuevo.getNext().setPrev(nuevo);
		size++;
	}

	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> n = new DNodo<E>(element,pos.getPrev(),pos);
		pos.setPrev(n);
		n.getPrev().setNext(n);
		size++;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		E aux = pos.element();
		pos.setElemento(null);
		pos.getNext().setPrev(pos.getPrev());
		pos.getPrev().setNext(pos.getNext());
		pos.setPrev(null);
		pos.setNext(null);
		size--;
		return aux;
	}

	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		E aux = pos.element();
		pos.setElemento(element);
		return aux;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> p = new ListaDE<Position<E>>();
		DNodo<E> actual = cabeza.getNext();
		while (actual != rabo) {
			p.addLast(actual);
			actual = actual.getNext();
		}
		return p;
	}
	
	/**
	 * Chequea que la posicion ingresada y su elemento no sean nulos.
	 * @param p Posicion ingresada a chequear.
	 * @return Retorna un un objeto de tipo DNodo, el cual es la posicion ingresada casteada a DNodo.
	 * @throws InvalidPositionException si la posicion "p" no es un nodo de la lista.
	 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try {
			if(p==null) throw new InvalidPositionException("Posicion nula");
			if(p.element()==null) throw new InvalidPositionException("p eliminada previamente");
			return (DNodo<E>) p;
		}
		catch(ClassCastException e) {
			throw new InvalidPositionException("p no es un nodo de lista");
		}
	}
}
