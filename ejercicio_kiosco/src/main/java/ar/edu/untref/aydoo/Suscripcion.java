package ar.edu.untref.aydoo;

public class Suscripcion extends Compra {

	private Boolean anualidad;

	public Suscripcion() {
		super();
		// predetemino
		this.anualidad = false;
	}

	public void activarAnualidad() {
		this.anualidad = true;
	}

	public boolean getAnualidad() {
		return this.anualidad;
	}

	public void agregarProducto(Producto unProducto) throws Exception {
		// TODOO: control tipo... creo con instanceof hacerlo
		if (unProducto instanceof ArticuloDeLibreria || unProducto instanceof Libro) {
			throw new Exception("art de libreria o libro NO pueden tenet suscripcion");
		}
		// continuando sin entrar al if:
		super.agregarProducto(unProducto);
	}

	private Double calcularCualEsPrecioFinal() {
		Double precioAcalcular = 0.0;
		for (Producto produ : this.productosComprados) {
			if (produ instanceof Periodico) {
				precioAcalcular = (((Periodico) produ).getPeriodicidad() * produ.getPrecio());
			} else {
				precioAcalcular = (((Revista) produ).getPeriodicidad() * produ.getPrecio());
			}
		}
		return precioAcalcular;
	}
	
	public Double getPrecio() {
		Double precio = calcularCualEsPrecioFinal();
		if (!this.getAnualidad()) {
			return precio;
		} else {
			return precio * 0.8;
		}
	}
}
