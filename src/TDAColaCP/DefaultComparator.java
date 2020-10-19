package TDAColaCP;

import java.util.Comparator;

public class DefaultComparator<K extends Comparable<K>> implements Comparator<K>{

	@Override
	public int compare(K o1, K o2) {
		return o1.compareTo(o2);
	}
	
}
