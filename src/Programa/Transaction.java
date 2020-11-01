package Programa;

/**
 * Interface Transaction.
 * Define los metodos a ser utilizados sobre una Transaccion.
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 * @param <M> Tipo de dato usado por el monto de la transacción.
 * @param <D> Tipo de dato usado por la descripción de la transacción.
 */
public interface Transaction<M, D> {
	
	/**
	 * Obtiene el monto almacenado por la Transaccion.
	 * @return Retorna el monto de la transaccion.
	 */
	public M getMonto();
	
	/**
	 * Obtiene la descripción almacenada por la Transaccion.
	 * @return Retorna la descripción de la transaccion.
	 */
	public D getDescripcion();
	
}
