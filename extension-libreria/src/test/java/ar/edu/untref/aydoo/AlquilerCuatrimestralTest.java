package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerCuatrimestralTest {

	private Libreria miLibreria;
	private Cliente cliente;
	private Libro elHobbit;
	private Compra comprasMayo;

	@Before
	public void inicializar() throws Exception {

		miLibreria = new Libreria("Cuspide", "");
		cliente = new Cliente("pepe", "lujan 12");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasMayo = new Compra(Mes.MAYO);

	}

	@Test
	public void getPeriodoDelAlquiler() throws Exception {

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler El Hobbit", 1, 1);
		alquilerDelHobbit.setPeriodoDelAlquiler(2);

		Assert.assertEquals(2, alquilerDelHobbit.getPeriodoDelAlquiler(), 0);
	}

	@Test
	public void getLibroAlquiladogetNombre() throws Exception {

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler de El Hobbit", 0, 10);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}

	@Test(expected = RuntimeException.class)
	public void alquila44cuatris() throws Exception {

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral(
				"Alquiler 44 cuatris de El Hobbit", 0, 0);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(44);
	}
}
