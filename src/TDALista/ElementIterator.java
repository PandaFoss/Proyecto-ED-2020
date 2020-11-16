package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Clase ElementIterator.
 * Modela un iterador de elementos de una lista.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 * @param <E> Tipo de dato de la lista a iterar.
 */
public class ElementIterator<E> implements Iterator<E>{
	//Atributos
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Crea un iterador de elementos a partir de una lista.
	 * @param l Lista ingresada usada para crear el iterador.
	 */
	public ElementIterator(PositionList<E> l){
		try {
			list = l;
			cursor = (l != null && !l.isEmpty())? l.first(): null;
		} 
		catch (EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	
	//Getters
	
	/**
	 * Verifica si el iterador sigue teniendo elementos.
	 * @return Retorna un booleano indicando si sigue habiendo elementos.
	 */
	public boolean hasNext() {
		return cursor != null;
	}
	
	/**
	 * Pasa al siguiente elemento y retorna el actual.
	 * @return Retorna el elemento actual.
	 */
	public E next() throws NoSuchElementException {
		if (cursor==null) throw new NoSuchElementException("Error: No hay siguiente");
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last()) ? null: list.next(cursor);
		} 
		catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
}
