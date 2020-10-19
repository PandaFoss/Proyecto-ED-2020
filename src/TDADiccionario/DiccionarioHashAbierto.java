package TDADiccionario;
import java.util.Iterator;

import TDALista.*;

public class DiccionarioHashAbierto<K,V> implements Dictionary<K,V>{
	protected PositionList<Entrada<K,V>>[] DHA;
	protected int n;
	protected int N = 53;
	protected static final float fc = 0.5f;
	
	@SuppressWarnings("unchecked")
	public DiccionarioHashAbierto() {
		n=0;
		DHA = (PositionList<Entrada<K,V>>[]) new PositionList[N];
		for(int i=0; i<N; i++) {
			DHA[i] = new ListaDE<Entrada<K,V>>();
		}
	}
	protected int hash(K key) {
		return Math.abs(key.hashCode()%N);
	}
	
	
	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override
	public Entry<K, V> find(K key) throws InvalidKeyException {
		Entry<K, V> entrada = null;
		if(key==null) throw new InvalidKeyException("find(); Clave nula");
		for(Position<Entrada<K,V>> p : DHA[hash(key)].positions()) 			
			if(p.element().getKey().equals(key))
				entrada = p.element();
		return entrada;
	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		if(key==null) throw new InvalidKeyException("findAll(); Clave nula");
		PositionList<Entry<K,V>> lista = new ListaDE<Entry<K,V>>();
		for(Position<Entrada<K,V>> p : DHA[hash(key)].positions()) {
			if(p.element().getKey().equals(key))
				lista.addLast(p.element());
		}
		return lista;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key==null) throw new InvalidKeyException("insert(); Clave nula");
		if(n >= N*fc)
			redimensionar();
		Entrada<K,V> e = new Entrada<K,V>(key,value);
		DHA[hash(key)].addLast(e);
		n++;
		return e;
	}
	private void redimensionar() {
		PositionList<Entrada<K,V>>[] DHAviejo = DHA;
		DHA = inicializarArreglo(N=nextPrimo(N*2));
		PositionList<Entrada<K,V>> ListaVieja;
		int Bucket;
		Entrada<K,V> entrada = null;
		Iterator<Position<Entrada<K,V>>> pos;
		for(int i=0; i<DHAviejo.length; i++) {
			ListaVieja = DHAviejo[i];
			pos = ListaVieja.positions().iterator();
			while(!ListaVieja.isEmpty() && pos.hasNext()) {
				try {entrada = DHAviejo[i].remove(pos.next());} catch (InvalidPositionException e) {}
				Bucket = hash(entrada.getKey());
				DHA[Bucket].addLast(entrada);
			}
		}
	}
	private PositionList<Entrada<K,V>>[] inicializarArreglo(int cant){
		 @SuppressWarnings("unchecked")
		PositionList<Entrada<K,V>>[] nuevoArreglo = (PositionList<Entrada<K,V>>[]) new PositionList[cant];
		 for(int i = 0; i<cant; i++) {
			 nuevoArreglo[i] = new ListaDE<Entrada<K,V>>();
		 }
		 return nuevoArreglo;
	}
	private int nextPrimo(Integer n) {
		boolean encontre = false;
		while(!encontre) {
			n++;
			encontre = esPrimo(n);
		}
		return n;
	}
	private boolean esPrimo(int n) {
		boolean es = true; int i, k = i = 2; int f = (int) Math.sqrt(n);
		while(es && i<=f) {
			es = n%i != 0;
			k++;
			i = 2*k-1;
		}
		return es;
	}
	
	@Override
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		if(e == null) throw new InvalidEntryException("remove(); Entrada nula");
		boolean elimine = false;
		Position<Entrada<K,V>> entrada = null;
		int Bucket = hash(e.getKey());
		try {
			entrada = (DHA[Bucket].isEmpty())? null : DHA[Bucket].first();
			while(!elimine && entrada != null) {
				if(entrada.element().getKey().equals(e.getKey()) && entrada.element().getValue().equals(e.getValue())) {
					elimine = true;
					DHA[Bucket].remove(entrada);
					n--;
				} else
					entrada = DHA[Bucket].next(entrada);
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e1) {
			e1.printStackTrace();
		}
		if(elimine)
			return e;
		else
			throw new InvalidEntryException("remove(); Entrada no existente");
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> entradas = new ListaDE<Entry<K,V>>();
		for(int i=0; i<N; i++) {
			if(!DHA[i].isEmpty())
				for(Entry<K,V> entrada : DHA[i])
					entradas.addLast(entrada);
		}
		return entradas;
	}
	public void convertir_a_mapeo() {
		for(PositionList<Entrada<K,V>> l : DHA) {
			if(!l.isEmpty()) {
				try {
					Position<Entrada<K,V>> entrada = l.first();
					while(entrada != l.last()) {
						if(l.next(entrada).element().getKey()==entrada.element().getKey() && l.next(entrada).element().getValue()!=entrada.element().getValue())
							l.remove(l.next(entrada));
						else if (l.next(entrada).element().getKey()!=entrada.element().getKey())
							entrada = l.next(entrada);
					}
				} catch(EmptyListException | InvalidPositionException | BoundaryViolationException e) {e.printStackTrace();}
			}
		}
	}
	
}
