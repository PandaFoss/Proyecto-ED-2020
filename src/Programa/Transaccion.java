package Programa;

public class Transaccion {
	
	private Float monto;
	private String descripcion;
	
	public Transaccion(Float m, String d) {
		monto = m;
		descripcion = d;
	}
	
	public Transaccion(Float m) {
		this(m,null);
	}
	
	public Transaccion() {
		this(null, null);
	}

	public Float getMonto() {
		return monto;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setMonto(Float m) {
		monto = m;
	}
	
	public void setDescripcion(String d) {
		descripcion = d;
	}

}
