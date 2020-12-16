/**
 * Provee clases e interfaces tendientes a implementar el TDA Cola con Prioridad
 */
package TDAColaCP;

import java.util.Comparator;

/**
 * Modela la interfaz PriorityQueue mediante la estructura de datos Cola Con Prioridad con Heap.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 * @param <K> Tipo de dato de las claves de la Cola.
 * @param <V> Tipo de dato de los valores de la Cola.
 */
public class ColaCPconHeap<K extends Comparable<K>,V> implements PriorityQueue<K,V>{

	protected Comparator<K> comp;
	protected int size;
	protected Entrada<K,V>[] elems;
	
	
	@SuppressWarnings("unchecked")
	public ColaCPconHeap(Comparator<K> compa) {
		elems = (Entrada<K,V>[]) new Entrada[10000];
		size = 0;
		comp = compa;
	}
	@SuppressWarnings("unchecked")
	public ColaCPconHeap() {
		elems = (Entrada<K,V>[]) new Entrada[10000];
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
		if(key==null) throw new InvalidKeyException("insert(); Clave no valida");
		Entrada<K,V> entrada = new Entrada<K,V>(key,value);
		Entrada<K,V> elemActual, elemPadre;
		boolean seguir = true;
		size++;
		if(size==elems.length)	
			expandir();
		elems[size] = entrada;
		int i = size;
		while(i>1 && seguir) {
			elemActual = elems[i];
			elemPadre = elems[i/2];
			if(comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entrada<K,V> aux = elems[i];
				elems[i] = elems[i/2];
				elems[i/2] = aux;
				i /=2;
			}
			else
				seguir = false;
		}
		return entrada;
	}

	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(size==0) throw new EmptyPriorityQueueException("remove(); Cola vacia");
		Entry<K,V> entrada = min();
		boolean tieneHI, tieneHD, seguir;
		int i, hi, hd, m = 1;
		if(size==1) {
			elems[1] = null;
			size = 0;
		}
		else {
			elems[1] = elems[size];
			elems[size] = null;
			size--;
			i = 1; seguir = true;
			while(seguir) {
				hi = i*2; 
				hd = i*2+1;
				tieneHI = hi<=size;
				tieneHD = hd<=size;
				if(!tieneHI)
					seguir = false;
				else 
					if(tieneHD) 
						if(comp.compare(elems[hi].getKey(), elems[hd].getKey()) < 0 )
							m = hi;
						else
							m = hd;
					else
						m = hi;
				if(comp.compare(elems[i].getKey(), elems[m].getKey())>0) {
					Entrada<K,V> aux = elems[i];
					elems[i] = elems[m];
					elems[m] = aux;
					i = m;
				}
				else
					seguir = false;
			}
		}
		return entrada;
	}
	/**
	 * Metodo privado que expande el tamaño de la cola.
	 */
	private void expandir() {
		@SuppressWarnings("unchecked")
		Entrada<K,V>[] nuevo = (Entrada<K,V>[]) new Entrada[elems.length+10000];
		for(int i = 0; i<elems.length; i++) 
			nuevo[i] = elems[i];
		elems = nuevo;
	}
}
