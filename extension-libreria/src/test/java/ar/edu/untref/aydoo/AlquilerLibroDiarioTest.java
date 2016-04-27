package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerLibroDiarioTest {

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

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler por 5 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(5);

		Assert.assertEquals(5, alquilerDelHobbit.getPeriodoDelAlquiler(), 0);
	}

	@Test
	public void alquilerDiarioRegistraDiasDelAlquiler() throws Exception {

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler El Hobbit", 0, 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}

	@Test
	public void alquilaHobbitPor3Dias() throws Exception {

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler por 3 dias", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		comprasMayo.agregarProducto(alquilerDelHobbit);
		cliente.agregarCompra(comprasMayo);
		miLibreria.agregarCliente(cliente);

		Assert.assertEquals(30.0, miLibreria.calcularMontoACobrar(cliente, Mes.MAYO), 0.1);
	}

	@Test
	public void alquilaHobbitPor24Dias() throws Exception {

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler por 24 dias", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(24);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		comprasMayo.agregarProducto(alquilerDelHobbit);
		cliente.agregarCompra(comprasMayo);
		miLibreria.agregarCliente(cliente);

		Assert.assertEquals(240.0, miLibreria.calcularMontoACobrar(cliente, Mes.MAYO), 0.1);
	}

	@Test(expected = Exception.class)
	public void alquilarMenosDe3Dias() throws Exception {

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler por 2 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(2);
	}

	@Test(expected = Exception.class)
	public void alquilaMasDe25Dias() throws Exception {

		AlquilerLibroDiario alquilerDelHobbit = new AlquilerLibroDiario("Alquiler por 26 dias", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(26);
	}
}
