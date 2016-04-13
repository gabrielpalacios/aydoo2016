package ar.edu.untref.aydoo;

public class Periodico extends Producto {

	private int periodicidad;

	public Periodico(String nombre, Double precio) throws Exception {
		//llamo super
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
