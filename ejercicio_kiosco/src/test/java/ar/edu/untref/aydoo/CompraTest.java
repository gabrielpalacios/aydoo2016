package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {

	@Test
	public void contieneLibro() throws Exception {

		Compra compra = new Compra();
		Producto papa = new Libro("papa", 1.0);

		compra.agregarProducto(papa);

		Assert.assertTrue(compra.contiene(papa));
	}
	
	@Test
	public void mes11() {

		Compra compra = new Compra();
		compra.setNroMes(11);

		Assert.assertEquals(11, compra.getNroMes());
	}
}
