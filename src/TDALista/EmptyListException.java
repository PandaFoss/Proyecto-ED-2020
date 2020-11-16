package TDALista;

/**
 * Modela la excepcion cuando se intenta operar sobre una lista vacia.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
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
