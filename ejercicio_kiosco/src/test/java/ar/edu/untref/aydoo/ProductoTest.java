package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

	@Test(expected=Exception.class)
	public void noValePrecioNegativo() throws Exception{

		Producto test = new Producto(null, 0.00);
		test.setPrecio(-81.9);
	}
	
	@Test
	public void nombreProducto() throws Exception {

		Producto test = new Producto("prod. test.", 0.00);
		Assert.assertEquals("prod. test.", test.getNombre());
	}

	@Test
	public void precioProducto() throws Exception {

		Producto test = new Producto(null, 987.0);
		Assert.assertEquals(987.0, test.getPrecio(), 0.00);
	}
	
	@Test
	public void nombreProductoSetter() throws Exception {	

		Producto test = new Producto(null, 0.00);
		test.setNombre("prod. test.2");
		Assert.assertEquals("prod. test.2", test.getNombre());
	}

	@Test
	public void precioProductoSetter() throws Exception {		

		Producto test = new Producto(null, 0.00);
		test.setPrecio(9844.10);
		Assert.assertEquals(9844.10, test.getPrecio(), 0.00);
	}
}
