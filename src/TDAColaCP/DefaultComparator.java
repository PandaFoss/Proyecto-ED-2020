/**
 * Provee clases e interfaces tendientes a implementar el TDA Cola con Prioridad
 */
package TDAColaCP;

import java.util.Comparator;

/**
 * Modela la interfaz Comparator mediante un Comparador por Defecto.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 * @param <K> Tipo de dato a ser comparado.
 */
public class DefaultComparator<K extends Comparable<K>> implements Comparator<K>{

	@Override
	public int compare(K o1, K o2) {
		return o1.compareTo(o2);
	}
	
}
