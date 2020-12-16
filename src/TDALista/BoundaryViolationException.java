/**
 * Provee clases e interfaces tendientes a implementar el TDA Lista
 */
package TDALista;

/**
 * Modela la excepcion cuando se intentan sobrepasar los limites de la lista.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	
	
	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public BoundaryViolationException(String m) {
		super(m);
	}
}
