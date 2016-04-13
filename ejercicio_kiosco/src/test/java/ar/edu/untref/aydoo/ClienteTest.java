package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	
	@Test
	public void clienteAgregaSuscripcionASuListaDeCompras() throws Exception{

		Suscripcion suscripcion = new Suscripcion();
		Cliente cliente = new Cliente("gg", "hh 77");
		cliente.sumarCompra(suscripcion);

		Assert.assertTrue(cliente.contieneCompraDeterminada(suscripcion));
	}

	@Test
	public void clienteContieneCompra() {

		Cliente cliente = new Cliente("gg", "hh 77");
		Compra compra1 = new Compra();
		compra1.setNroMes(12);
		Compra compra2 = new Compra();
		compra2.setNroMes(3);
	
		cliente.sumarCompra(compra1);
		cliente.sumarCompra(compra2);

		List<Compra> comprasDeJulio;
		comprasDeJulio = cliente.getItemsCompradosEnMes(3);

		Assert.assertTrue(comprasDeJulio.contains(compra2));
	}

	@Test
	public void direccionCliente(){

		Cliente cliente = new Cliente("gg", "hh 77");

		Assert.assertEquals("hh 77", cliente.getDireccion());
	}

	@Test
	public void clienteCompra() throws Exception{

		Cliente cliente = new Cliente("gg", "hh 77");
		Compra compra = new Compra();
		compra.setNroMes(6);
		cliente.sumarCompra(compra);

		Assert.assertTrue(cliente.contieneCompraDeterminada(compra));
	}

	
}
