package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	private Double montoIva = null;

	public ArticuloDeLibreria(String nombre, Double precio) throws Exception {
		super(nombre, precio);
		this.setMontoIva();
	}

	public Double getPrecio() {
		Double valor =  this.getMontoIva() + super.getPrecio();
		return valor;
	}

	private void setMontoIva() {
		this.montoIva =  0.21 * super.getPrecio();
	}

	public Double getMontoIva() {
		return this.montoIva;
	}

}
