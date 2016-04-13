package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {

	@Test
	public void precioAlLibro() throws Exception{

		Libro hola = new Libro("hola", 725.0);
		Assert.assertEquals(725.0, hola.getPrecio(), 0.0);
	}

	@Test
	public void nombreAlLibro1() throws Exception {

		Libro hola = new Libro("hola susana", 725.0);
		Assert.assertEquals("hola susana", hola.getNombre());
	}
	
	@Test
	public void nombreAlLibro2() throws Exception{

		Libro hola = new Libro(null, 725.0);
		hola.setNombre("hola susana");
		Assert.assertEquals("hola susana", hola.getNombre());
	}
}
