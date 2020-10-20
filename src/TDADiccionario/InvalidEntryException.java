package TDADiccionario;

/**
 * Modela la excepcion en caso de que la Entrada utilizada no sea valida.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 */
public class InvalidEntryException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public InvalidEntryException(String m) {
		super(m);
	}
}
