/**
 * Provee clases e interfaces tendientes a implementar el TDA Lista
 */
package TDALista;

/**
 * Modela la excepcion cuando se intenta operar sobre una lista vacia.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 */
public class EmptyListException extends Exception{
	static final long serialVersionUID = 1L;
	
	
	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public EmptyListException(String m) {
		super(m);
	}
}
