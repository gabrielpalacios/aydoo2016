package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private int nroMes;
	protected List<Producto> productosComprados;

	public Compra() {
		this.productosComprados = new ArrayList<Producto>(); // con un producto
																// vacio!
	}

	public void setNroMes(int mes) {

		this.nroMes = mes;
	}

	public int getNroMes() {

		return this.nroMes;
	}

	public Double getPrecio() {
		Double precioCalculado;
		precioCalculado = 0.0;
		for (Producto produ : this.productosComprados) {
			precioCalculado = produ.getPrecio() + precioCalculado;
		}
		return precioCalculado;
	}

	public boolean contiene(Producto unProducto) {

		return this.productosComprados.contains(unProducto);
	}

	public void agregarProducto(Producto unProducto) throws Exception {

		this.productosComprados.add(unProducto);
	}

}
