package TDAColaCP;
import java.util.Comparator;

import TDALista.*;

public class ColaCPconLista<K extends Comparable<K>,V> implements PriorityQueue<K,V> {
	
	protected PositionList<Entry<K,V>> elems;
	protected Comparator<K> comp;

	public ColaCPconLista(Comparator<K> compa) {
		elems = new ListaDE<Entry<K,V>>();
		comp = compa;
	}
	public ColaCPconLista() {
		elems = new ListaDE<Entry<K,V>>();
		comp = new DefaultComparator<K>();
	}
	
	@Override
	public int size() {
		return elems.size();
	}

	@Override
	public boolean isEmpty() {
		return elems.isEmpty();
	}

	@Override
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(elems.isEmpty()) throw new EmptyPriorityQueueException("min(); Cola vacia");
		Entry<K,V> entrada = null;
		try { entrada = elems.first().element(); }catch(EmptyListException e) {e.printStackTrace();}
		return entrada;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key==null) throw new InvalidKeyException("insert(); Clave no valida");
		boolean encontreLugar = false;
		Entry<K,V> entrada = new Entrada<K,V>(key,value);
		try {
			if(elems.isEmpty())
				elems.addFirst(entrada);
			else {
				Position<Entry<K,V>> PosEn = elems.first();
				while(PosEn != null && !encontreLugar) {
					if(comp.compare(PosEn.element().getKey(),key) >= 0) {
						encontreLugar = true;
						elems.addBefore(PosEn, entrada);
					}
					else
						PosEn = (PosEn==elems.last())? null : elems.next(PosEn);
				}
				if(!encontreLugar)
					elems.addLast(entrada);
			}
		} 
		catch (InvalidPositionException | EmptyListException | BoundaryViolationException e) {	e.printStackTrace();	}
		return entrada;
	}

	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(elems.isEmpty()) throw new EmptyPriorityQueueException("removeMin(); Cola vacia");
		Entry<K,V> entrada = null;
		try {	entrada = elems.remove(elems.first());} catch (InvalidPositionException | EmptyListException e) {	e.printStackTrace();	}
		return entrada;
	}
	
	public String toString() {
		String s = "";
		for(Entry<K,V> e : elems) {
			s+=e.toString()+" , ";
		}
		return s;
	}
}
