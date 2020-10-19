package TDALista;

/**
 * Clase EmptyListException.
 * Maneja la excepcion "EmptyListException".
 * @author Joaquin Garcia Diotto
 *
 */
public class EmptyListException extends Exception{
	static final long serialVersionUID = 1L;
	
	
	/**
	 * Crea la excepcion en caso de que la lista sea vacia.
	 * @param m Mensaje ingresado el cual sera mostrado en caso de producirse la excepcion.
	 */
	public EmptyListException(String m) {
		super(m);
	}
}
