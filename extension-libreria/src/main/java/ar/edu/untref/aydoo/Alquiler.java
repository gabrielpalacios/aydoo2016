package ar.edu.untref.aydoo;

public class Alquiler extends Producto {

	public Alquiler(String nombreLibroAlquilado, Double precioLibroAlquilado) throws Exception {
		super(nombreLibroAlquilado, precioLibroAlquilado);
	}

	private Producto libroAlquilado;
	private int precioPorPeriodo;
	private int periodoDelAlquiler;

	public Producto getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Producto libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public int getPrecioPorPeriodo() {
		return precioPorPeriodo;
	}

	public void setPrecioPorPeriodo(int precioDiario) {
		if(precioDiario > 0){
			this.precioPorPeriodo = precioDiario;		
		}else{
			throw new RuntimeException("El precio no puede ser negativo");
		}
	}

	public int getPeriodoDelAlquiler() {
		return this.periodoDelAlquiler;
	}

	public void setPeriodoDelAlquiler(int periodoDelAlquiler) {
		this.periodoDelAlquiler = periodoDelAlquiler;
	}

}
