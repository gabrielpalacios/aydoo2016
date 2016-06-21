package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerDiarioTest {

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
	public void alquilerDiarioRegistraLibroAlquilado() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 5 dias", 1, 1);
		alquilerDelHobbit.setDiasDelAlquiler(5);

		Assert.assertEquals(5, alquilerDelHobbit.getPeriodoDelAlquiler(), 0);
	}

	@Test
	public void alquilerDiarioRegistraDiasDelAlquiler() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler El Hobbit", 1, 1);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}

	@Test
	public void alquilaHobbitPor3Dias() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 3 dias", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		comprasMayo.agregarProducto(alquilerDelHobbit);
		cliente.agregarCompra(comprasMayo);
		miLibreria.agregarCliente(cliente);

		Assert.assertEquals(30.0, miLibreria.calcularMontoACobrar(cliente, Mes.MAYO), 0.1);
	}

	@Test
	public void alquilaHobbitPor24Dias() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 24 dias", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(24);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		comprasMayo.agregarProducto(alquilerDelHobbit);
		cliente.agregarCompra(comprasMayo);
		miLibreria.agregarCliente(cliente);

		Assert.assertEquals(240.0, miLibreria.calcularMontoACobrar(cliente, Mes.MAYO), 0.1);
	}

	@Test(expected = RuntimeException.class)
	public void alquilarPorMenosDe3DiasNoSePuede() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 2 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(2);
	}

	@Test(expected = RuntimeException.class)
	public void alquilarPorMasDe25DiasNoSePuede() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 26 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(26);
	}

	@Test(expected = RuntimeException.class)
	public void alquilarConDiasNegativosNoSePuede() throws Exception {

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por -6 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(-6);
	}
}
