/**
 * Provee clases e interfaces tendientes a implementar el TDA Deque
 */
package TDADeque;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.BoundaryViolationException;
import TDALista.ListaDE;
import TDALista.Position;
import TDALista.PositionList;


/**
 * Modela la interfaz Deque mediante una lista
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 * @param <E> Tipo de dato a almacenar en la Deque
 */
public class Deque<E> implements java.util.Deque<E> {
	private PositionList<E> lista;
	
	/**
	 * Crea una Deque vacia.
	 */
	public Deque() {
		lista = new ListaDE<E>();
	}
	
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[lista.size()];
		int i = 0;
		for(E elemento : lista) {
			array[i] = elemento;
			i++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) { //Hay que cambiar T a E????? Porque sino no tiene sentido. Que pasaria si la lista fuera <Integer> y el arreglo Boolean entonces?
		return null;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		boolean tiene = true;
		Iterator<?> it = c.iterator();
		while(tiene && it.hasNext())
			tiene = contains(it.next());
		return tiene;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean eliminados = true;
		for(Object o : c)
			if(!remove(o))
				eliminados = false;
		return eliminados;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		int size = lista.size();
		for(Position<E> posicion : lista.positions())
			if(!c.contains(posicion.element()))
				try {
					lista.remove(posicion);
				} catch (InvalidPositionException e) {}
		return lista.size()<size;
	}

	@Override
	public void clear() {
		lista = new ListaDE<E>();
	}

	@Override
	public void addFirst(E e) {
		lista.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		lista.addLast(e);
	}

	@Override
	public boolean offerFirst(E e) {
		lista.addFirst(e);
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		lista.addLast(e);
		return true;
	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		if(lista.isEmpty()) throw new NoSuchElementException("removeFirst(); Deque vacia");
		E elemento = null;
		try {
			elemento = lista.remove(lista.first());
		} catch (InvalidPositionException | EmptyListException e) {}
		return elemento;
	}

	@Override
	public E removeLast() throws NoSuchElementException {
		if(lista.isEmpty()) throw new NoSuchElementException("removeLast(); Deque vacia");
		E elemento = null;
		try {
			elemento = lista.remove(lista.last());
		} catch (InvalidPositionException | EmptyListException e) {}
		return elemento;
	}

	@Override
	public E pollFirst() {
		E elemento = null;
		if(!lista.isEmpty())
			try {
				elemento = lista.remove(lista.first());
		}	 catch (InvalidPositionException | EmptyListException e) {}
		return elemento;
	}

	@Override
	public E pollLast() {
		E elemento = null;
		if(!lista.isEmpty())
			try {
				elemento = lista.remove(lista.last());
			} catch (InvalidPositionException | EmptyListException e) {}
		return elemento;
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		if(lista.isEmpty()) throw new NoSuchElementException("getFirst(); Deque vacia");
		E elemento = null;
		try {
			elemento = lista.first().element();
		} catch (EmptyListException e) {}
		return elemento;
	}

	@Override
	public E getLast() throws NoSuchElementException {
		if(lista.isEmpty()) throw new NoSuchElementException("getLast(); Deque vacia");
		E elemento = null;
		try {
			elemento = lista.last().element();
		} catch (EmptyListException e) {}
		return elemento;
	}

	@Override
	public E peekFirst() {
		E elemento = null;
		if(!lista.isEmpty())
			try {
				elemento = lista.first().element();
			} catch (EmptyListException e) {}
		return elemento;
	}

	@Override
	public E peekLast() {
		E elemento = null;
		if(!lista.isEmpty())
			try {
				elemento = lista.last().element();
			} catch (EmptyListException e) {}
		return elemento;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		boolean eliminado = false;
		Position<E> posicion = null;
		try {
			posicion = (lista.isEmpty())? null : lista.first();
			while(posicion!=null && !eliminado) {
				if(posicion.element().equals(o)) {
					lista.remove(posicion);
					eliminado = true;
				}
				posicion = (posicion==lista.last())? null : lista.next(posicion);
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {}
		return eliminado;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		boolean eliminado = false;
		Position<E> posicion = null;
		try {
			posicion = (lista.isEmpty())? null : lista.last();
			while(posicion!=null && !eliminado) {
				if(posicion.element().equals(o)) {
					lista.remove(posicion);
					eliminado = true;
				}
				posicion = (posicion==lista.first())? null : lista.prev(posicion);
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {}
		return eliminado;
	}

	@Override
	public boolean add(E e) {
		return offerLast(e);
	}

	@Override
	public boolean offer(E e) {
		return offerLast(e);
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E element() {
		return getFirst();
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E elemento : c) 
			lista.addLast(elemento);
		return true;
	}

	@Override
	public void push(E e) {
		lista.addFirst(e);
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public boolean remove(Object o) {
		return removeFirstOccurrence(o);
	}

	@Override
	public boolean contains(Object o) {
		boolean tiene = false;
		Iterator<E> it = lista.iterator();
		while(!tiene && it.hasNext())
			tiene = it.next().equals(o);
		return tiene;
	}

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public Iterator<E> iterator() {
		return lista.iterator();
	}

	@Override
	public Iterator<E> descendingIterator() {
		PositionList<E> listaDescendiente = new ListaDE<E>();
		for(E elemento : lista)
			listaDescendiente.addFirst(elemento);
		return listaDescendiente.iterator();
	}

}
