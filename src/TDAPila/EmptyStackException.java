package TDAPila;

/**
 * Modela la excepcion cuando se realice una accion invalida sobre una pila vacia.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 * 
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception{

	/**
	 * Inicializa la excepcion indicando el origen del error.
	 * @param m Especifica informacion adicional a cerca de la excepcion.
	 */
	public EmptyStackException(String m) {
		super(m);
	}
}
