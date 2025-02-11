/**
 * Provee clases e interfaces tendientes a implementar el TDA Cola
 */
package TDACola;

/**
 * Modela la excepcion en caso de que se realice una accion invalida sobre una Cola vacia.
 * @author Skorrom - Max Ferrer [Panda Foss]
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception{

	
	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional acerca de la excepcion.
	 */
	public EmptyQueueException(String m) {
		super(m);
	}
}
