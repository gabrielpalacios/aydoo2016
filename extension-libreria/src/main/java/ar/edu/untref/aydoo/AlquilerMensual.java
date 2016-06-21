package ar.edu.untref.aydoo;

public class AlquilerMensual extends Alquiler {

	public AlquilerMensual(String nombre, double precio, int precioDiario) throws Exception {
		super(nombre, precio);
		super.setPrecioPorPeriodo(precioDiario);
	}

	public void setMesesDelAlquiler(int numeroDeMeses) throws Exception {

		if (numeroDeMeses < 1 || numeroDeMeses > 3) {
			throw new RuntimeException("El numero de meses no puede ser menor a 1 o mayor a 3");
		}
		super.setPeriodoDelAlquiler(numeroDeMeses);
		super.setPrecio(((Double) (super.getPeriodoDelAlquiler() + 0.0) * (Double) (super.getPrecioPorPeriodo() + 0.0)));
	}

}
