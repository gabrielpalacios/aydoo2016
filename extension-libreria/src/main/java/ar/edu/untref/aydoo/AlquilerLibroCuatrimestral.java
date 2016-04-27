package ar.edu.untref.aydoo;

public class AlquilerLibroCuatrimestral extends AlquilerLibro {

	public AlquilerLibroCuatrimestral(String nombre, double precio, int precioMensual) throws Exception {
		super(nombre, precio);
		super.setPrecioPorPeriodo(precioMensual);
	}

	public void setCuatrimestresDelAlquiler(int numeroDeCuatrimestres) throws Exception {

		if (numeroDeCuatrimestres < 1 || numeroDeCuatrimestres > 2) {
			throw new Exception();
		}
		super.setPeriodoDelAlquiler(numeroDeCuatrimestres);
		super.setPrecio(((Double) (super.getPeriodoDelAlquiler() + 0.0) * 4.0 * 0.9 * (Double) (super
				.getPrecioPorPeriodo() + 0.0)));
	}
}