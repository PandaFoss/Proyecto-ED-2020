package TDACola;

/**
 * Modela la excepcion en caso de que se realice una accion invalida sobre una Cola vacia.
 * @author Joaquin Garcia Diotto
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception{

	
	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public EmptyQueueException(String m) {
		super(m);
	}
}
