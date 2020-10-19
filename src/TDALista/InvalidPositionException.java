package TDALista;

/**
 * Modela la excepcion en caso de que la posicion utilizada no sea valida.
 * @author Joaquin Garcia Diotto
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception{

	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public InvalidPositionException(String m) {
		super(m);
	}
}
