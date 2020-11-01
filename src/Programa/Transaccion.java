package Programa;

public class Transaccion<M, D> implements Transaction<M, D> {
	
	private M monto;
	private D descripcion;
	
	public Transaccion(M m, D d) {
		monto = m;
		descripcion = d;
	}
	
	public Transaccion(M m) {
		monto = m;
	}

	@Override
	public M getMonto() {
		return monto;
	}

	@Override
	public D getDescripcion() {
		return descripcion;
	}
	
	public void setMonto(M m) {
		monto = m;
	}
	
	public void setDescripcion(D d) {
		descripcion = d;
	}

}
