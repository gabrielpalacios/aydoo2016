package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {

	//comportamiento idem periodico:
	@Test(expected=Exception.class)
	public void periodicidadNegativa() throws Exception {

		Revista vlarin = new Revista(null, 0.0);
		vlarin.setPeriodicidad(-4);
	}

	@Test
	public void pagina12a30() throws Exception {

		Revista pagina12 = new Revista(null, 0.0);
		pagina12.setPeriodicidad(30);

		Assert.assertEquals(30, pagina12.getPeriodicidad(), 0.0);
	}

	@Test
	public void seAgregaNombreAlRevistaAlSerCreado() throws Exception {

		Revista pagina12 = new Revista("pagina 12", 0.0);
		pagina12.setPeriodicidad(2);
		Assert.assertEquals("pagina 12", pagina12.getNombre());
	}
}
