package ar.edu.untref.aydoo;

public class Producto {

	private String nombre;
	private Double precio;

	public Producto(String nombre, Double precio) throws Exception {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String string) {
		this.nombre = string;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) throws Exception {
		if (precio >= 0) {
			this.precio = precio;
		} else {
			throw new Exception("Error: Producto con precio negativo");
		}

	}
}
