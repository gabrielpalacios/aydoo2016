package ar.edu.untref.aydoo;

public class AlquilerDiario extends Alquiler {

	public AlquilerDiario(String nombre, double precio, int precioDiario) throws Exception {
		super(nombre, precio);
		super.setPrecioPorPeriodo(precioDiario);
	}

	public void setDiasDelAlquiler(int numeroDeDias) throws Exception  {

		if (numeroDeDias < 3 || numeroDeDias > 25) {
			throw new RuntimeException("El numero de dias no puede ser menor a 3 o mayor a 25");
		}
		super.setPeriodoDelAlquiler(numeroDeDias);
		super.setPrecio(((Double) (super.getPeriodoDelAlquiler() + 0.0) * (Double) (super.getPrecioPorPeriodo() + 0.0)));
	}

}
