package TDADiccionario;

public class EntradaComparable <K extends Comparable<K>,V> implements Entry<K,V>, Comparable<EntradaComparable<K,V>> {

	private K key;
	private V value;
	
	public EntradaComparable(K k, V v) {
		key = k;
		value = v;
	}

	
	@Override
	public int compareTo(EntradaComparable<K, V> o) {
		return key.compareTo(o.getKey());
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	public void setKey(K k) {
		key = k;
	}
	public void setValue(V v) {
		value = v;
	}
}
