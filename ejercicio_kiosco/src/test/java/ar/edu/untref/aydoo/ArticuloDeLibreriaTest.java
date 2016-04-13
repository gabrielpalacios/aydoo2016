package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

	@Test
	public void lapizSacarIVA() throws Exception {

		ArticuloDeLibreria lapiz = new ArticuloDeLibreria(null, 10.0);

		Assert.assertEquals(12.1, lapiz.getPrecio(), 0.0);
	}
	
	@Test
	public void lapizConIVA() throws Exception {

		ArticuloDeLibreria lapiz = new ArticuloDeLibreria(null, 10.0);

		Assert.assertEquals(2.1, lapiz.getMontoIva(), 0.0);
	}

	@Test
	public void bicMonmbre() throws Exception {

		ArticuloDeLibreria lapicera = new ArticuloDeLibreria("bic", 4.0);
		Assert.assertEquals("bic", lapicera.getNombre());
	}
}
