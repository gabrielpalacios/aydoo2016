package ar.edu.untref.aydoo;

public class Producto {

	private String nombre;
	private Double precio;
	private boolean soportaSuscripcion;

	public boolean getSoportaSuscripcion() {
		return soportaSuscripcion;
	}

	public void setSoportaSuscripcion(boolean soportaSuscripcion) {
		this.soportaSuscripcion = soportaSuscripcion;
	}

	public Producto(String nombre, Double precio) throws Exception {

		this.setNombre(nombre);
		this.setPrecio(precio);
		this.soportaSuscripcion = false;
	}

	public void setNombre(String string) {

		this.nombre = string;
	}

	public String getNombre() {

		return this.nombre;
	}

	public void setPrecio(Double precio) throws Exception {

		if (precio < 0) {

			throw new Exception("No se puede poner precio negativo a un producto");
		}

		this.precio = precio;
	}

	public Double getPrecio() {

		return this.precio;
	}

}
