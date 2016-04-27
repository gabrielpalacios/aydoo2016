package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerLibroMensualTest {

	private Libreria miLibreria;
	private Cliente cliente;
	private Libro elHobbit;
	private Compra comprasMayo;

	@Before
	public void inicio() throws Exception {

		miLibreria = new Libreria("Cuspide", "");
		cliente = new Cliente("pepe", "lujan 12");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasMayo = new Compra(Mes.MAYO);
	}

	@Test
	public void alquilerMensual() throws Exception {

		AlquilerLibroMensual alquilerDelHobbit = new AlquilerLibroMensual("Alquiler Mensual", 0, 10);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}

	@Test
	public void alquiler3Meses() throws Exception {

		AlquilerLibroMensual alquilerDelHobbit = new AlquilerLibroMensual("Alquiler 3 meses", 0, 20);
		alquilerDelHobbit.setMesesDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		comprasMayo.agregarProducto(alquilerDelHobbit);
		cliente.agregarCompra(comprasMayo);
		miLibreria.agregarCliente(cliente);

		Assert.assertEquals(60.0, miLibreria.calcularMontoACobrar(cliente, Mes.MAYO), 0.1);
	}

	@Test(expected = Exception.class)
	public void alquilarMalPor20meses() throws Exception {

		AlquilerLibroMensual alquilerDelHobbit = new AlquilerLibroMensual("Alquiler por 20 messes", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(20);
	}

}
