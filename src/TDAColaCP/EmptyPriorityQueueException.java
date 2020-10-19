package TDAColaCP;

/**
 * Modela la excepcion en caso de que se intente operar sobre una Cola Con Prioridad vacia.
 * @author Joaquin Garcia Diotto
 *
 */
public class EmptyPriorityQueueException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public EmptyPriorityQueueException(String m) {
		super(m);
	}
}
