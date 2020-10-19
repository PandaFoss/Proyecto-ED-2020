package TDAColaCP;

import java.util.Comparator;

public class ColaCPconArreglo<K extends Comparable<K>,V> implements PriorityQueue<K,V>{

	protected Comparator<K> comp;
	protected int size;
	protected Entry<K,V>[] elems;
	
	
	@SuppressWarnings("unchecked")
	public ColaCPconArreglo(Comparator<K> compa) {
		elems = (Entrada<K,V>[]) new Entrada[100000];
		size = 0;
		comp = compa;
	}
	@SuppressWarnings("unchecked")
	public ColaCPconArreglo() {
		elems = (Entrada<K,V>[]) new Entrada[100000];
		size = 0;
		comp = new DefaultComparator<K>();
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(size==0) throw new EmptyPriorityQueueException("min(); Cola vacia");
		return elems[1];
	}
	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key==null)throw new InvalidKeyException("insert(); Clave no valida");
		Entry<K,V> entrada = new Entrada<K,V>(key,value);
		int j = size, i = 1; boolean encontreLugar = false;
		while(!encontreLugar && i<=j) {
			if(comp.compare(elems[i].getKey(), key) >= 0)
				encontreLugar = true;
			else 
				i++;
		}
		while(j>=i) {
			elems[j+1] = elems[j];
			j--;
		}
		elems[i] = entrada; 
		size++;
		return entrada;
	}
	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(size==0) throw new EmptyPriorityQueueException("removeMin(); Cola vaci");
		Entry<K, V> entrada = min();
		elems[1] = null;
		for(int i = 1; i+1<=size; i++) {
			elems[i] = elems[i+1];
		}
		size--;
		return entrada;
	}
}
