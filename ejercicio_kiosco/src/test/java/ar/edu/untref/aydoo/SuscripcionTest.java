package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {

	@Test(expected = Exception.class)
	public void LibrosNOSePuedeAProductos() throws Exception {

		Producto malena = new Libro("malena", 223.0);
		Suscripcion suscripcion = new Suscripcion();
		suscripcion.agregarProducto(malena);
	}

	@Test(expected = Exception.class)
	public void ArticuloDeLibreriaNOSePuedeAProductos() throws Exception {

		Producto malena = new ArticuloDeLibreria("malena", 223.0);
		Suscripcion suscripcion = new Suscripcion();
		suscripcion.agregarProducto(malena);
	}

	@Test
	public void controlaTieneSuscripcionRevistaCargada() throws Exception {

		Producto parati = new Revista("parati", 80.0);
		Suscripcion suscripcion = new Suscripcion();
		suscripcion.agregarProducto(parati);

		Assert.assertTrue(suscripcion.contiene(parati));
	}

	@Test
	public void cargarNroMes12Suscripcion() {

		Suscripcion suscripcion = new Suscripcion();
		suscripcion.setNroMes(12);

		Assert.assertEquals(12, suscripcion.getNroMes());
	}

	@Test
	public void suscripcionNoAnualYPrecioRevista() throws Exception {

		Producto barcelona = new Revista("barcelona", 30.0);
		Suscripcion suscripcion = new Suscripcion();
		((Revista) barcelona).setPeriodicidad(2);
		// queda sin suscripcion anual
		suscripcion.agregarProducto(barcelona);

		Assert.assertEquals(60.0, suscripcion.getPrecio(), 0.0);
	}

	@Test
	public void suscripcionAnualYPrecioRevista() throws Exception {

		Producto barcelona = new Revista("barcelona", 30.0);
		Suscripcion suscripcion = new Suscripcion();
		((Revista) barcelona).setPeriodicidad(2);
	
		suscripcion.agregarProducto(barcelona);
		suscripcion.activarAnualidad();

		Assert.assertEquals(48.0, suscripcion.getPrecio(), 0.0);
	}
	
	@Test
	public void suscripcionNoAnualYPrecioDiario() throws Exception {

		Producto pagina12 = new Periodico("pagina/d12", 10.0);
		Suscripcion suscripcion = new Suscripcion();
		((Periodico) pagina12).setPeriodicidad(30);
		// queda sin suscripcion anual
		suscripcion.agregarProducto(pagina12);

		Assert.assertEquals(300.0, suscripcion.getPrecio(), 0.0);
	}

}
