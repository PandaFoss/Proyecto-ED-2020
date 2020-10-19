package TDADiccionario;

/**
 * Modela la excepcion en caso de que la Clave utilizada no sea valida.
 * @author Joaquin Garcia Diotto
 *
 */
public class InvalidKeyException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public InvalidKeyException(String m) {
		super(m);
	}
}
