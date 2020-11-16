package Programa;

/**
 * Modela una Transaccion
 * @author Joaquin Garcia Diotto - Maximiliano Ferrer Gregori
 *
 */
public class Transaccion {
	
	private Float monto;
	private String descripcion;
	
	/**
	 * Crea una nueva Transaccion
	 * @param m Monto de la Transaccion
	 * @param d Descripcion de la Transaccion
	 */
	public Transaccion(Float m, String d) {
		monto = m;
		descripcion = d;
	}
	
	/**
	 * Crea una nueva Transaccion sin descripcion
	 * @param m Monto de la Transaccion
	 */
	public Transaccion(Float m) {
		this(m,null);
	}
	
	/**
	 * Crea una Transaccion sin monto ni descripcion
	 */
	public Transaccion() {
		this(null, null);
	}
	
	/**
	 * Obtiene el monto de la Transaccion
	 * @return Monto de la Transaccion
	 */
	public Float getMonto() {
		return monto;
	}

	/**
	 * Obtiene la descripcion de la Transaccion
	 * @return Descripcion de la Transaccion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Cambia el Monto de la Transaccion
	 * @param m Monto a ser almacenado
	 */
	public void setMonto(Float m) {
		monto = m;
	}
	
	/**
	 * Cambia la Descripcion de la Transaccion
	 * @param d Descripcion a ser almacenada
	 */
	public void setDescripcion(String d) {
		descripcion = d;
	}

}
