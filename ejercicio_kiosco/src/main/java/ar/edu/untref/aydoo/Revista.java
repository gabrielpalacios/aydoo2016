package ar.edu.untref.aydoo;

public class Revista extends Producto {

	private int periodicidad;

	public Revista(String nombre, Double precio) throws Exception {
		super(nombre, precio);
	}

	public int getPeriodicidad() {

		return this.periodicidad;
	}
	
	public void setPeriodicidad(int periodicidad) throws Exception {
		if (periodicidad <= 0) {
			throw new Exception("La periodicidad no puede ser 0 o negativa!");
		} else {
			this.periodicidad = periodicidad;
		}
	}
}
