package ar.edu.untref.aydoo;

public class AlquilerLibroMensual extends AlquilerLibro {

	public AlquilerLibroMensual(String nombre, double precio, int precioDiario) throws Exception {
		super(nombre, precio);
		super.setPrecioPorPeriodo(precioDiario);
	}

	public void setMesesDelAlquiler(int numeroDeMeses) throws Exception {

		if (numeroDeMeses < 1 || numeroDeMeses > 3) {
			throw new Exception();
		}
		super.setPeriodoDelAlquiler(numeroDeMeses);
		super.setPrecio(((Double) (super.getPeriodoDelAlquiler() + 0.0) * (Double) (super.getPrecioPorPeriodo() + 0.0)));
	}

}
