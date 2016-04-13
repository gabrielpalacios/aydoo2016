package ar.edu.untref.aydoo;

public class Libro extends Producto {
	//por ahora solo constructor:
	public Libro(String nombre, Double precio) throws Exception {
        //		llamo al Super!
		super(nombre, precio);
	}
}
