package ar.edu.untref.aydoo;

public class AlquilerLibro extends Producto {

	public AlquilerLibro(String nombreLibroAlquilado, Double precioLibroAlquilado) throws Exception {
		super(nombreLibroAlquilado, precioLibroAlquilado);
	}

	private Libro libroAlquilado;
	private int precioPorPeriodo;
	private int periodoDelAlquiler;

	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public int getPrecioPorPeriodo() {
		return precioPorPeriodo;
	}

	public void setPrecioPorPeriodo(int precioDiario) {
		this.precioPorPeriodo = precioDiario;
	}

	public int getPeriodoDelAlquiler() {
		return this.periodoDelAlquiler;
	}

	public void setPeriodoDelAlquiler(int periodoDelAlquiler) {
		this.periodoDelAlquiler = periodoDelAlquiler;
	}

}
