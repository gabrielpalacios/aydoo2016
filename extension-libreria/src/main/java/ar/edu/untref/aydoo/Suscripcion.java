package ar.edu.untref.aydoo;

public class Suscripcion extends Compra {

	private Boolean esAnual;

	public Suscripcion(Mes mes) {

		super(mes);
		this.esAnual = false;
	}

	public void agregarProducto(Producto producto) throws Exception {

		if (producto.getSoportaSuscripcion()) {
			super.agregarProducto(producto);
		} else {
			throw new RuntimeException("No puede suscribirse a un libro o articulo de libreria");
		}

	}

	public Double getPrecioDeLaCompra() {

		Double precio = 0.0;

		precio = calcularPrecio(precio);

		if (this.esAnual()) {

			precio *= 0.8;
		}

		return precio;
	}

	private Double calcularPrecio(Double precio) {

		Double precioRetorno = 0.0;
		for (Producto producto : this.getListaDeProductos()) {

			if (producto.getSoportaSuscripcion()) {

				precioRetorno += producto.getPrecio() * ((AptoSuscripcion) producto).getPeriodicidad();

			}
		}

		return precioRetorno;
	}

	public void hacerAnual() {

		this.esAnual = true;
	}

	public boolean esAnual() {

		return this.esAnual;
	}

}
