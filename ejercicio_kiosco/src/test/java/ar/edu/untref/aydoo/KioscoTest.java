package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class KioscoTest {

	@Test
	public void kioscoAgregaCliente() {

		Kiosco kiosco = new Kiosco();
		Cliente cliente = new Cliente("gabriel", "zulema 12, rosario");
		kiosco.agregarCliente(cliente);

		Assert.assertTrue(kiosco.esClienteHabitual(cliente));
	}
	
	@Test
	public void kioscoEjemploSitioCaso1() throws Exception {

		Kiosco kiosco = new Kiosco();
		Cliente cliente = new Cliente("gabriel", "zulema 12, rosario");
		kiosco.agregarCliente(cliente);
		Compra compra = new Compra();

		// listado de cosas que quiere comprar:
		Producto libroHobbit = new Libro("Hobbit", 50.0);
		Producto lapicera1 = new ArticuloDeLibreria("lapicera negra", 5.0);
		Producto lapicera2 = new ArticuloDeLibreria("lapicera negra", 5.0);
		Producto revistaGrafico = new Revista("El Grafico", 30.0);
		((Revista) revistaGrafico).setPeriodicidad(1);
		compra.agregarProducto(libroHobbit);
		compra.agregarProducto(lapicera1);
		compra.agregarProducto(lapicera2);
		compra.agregarProducto(revistaGrafico);

		compra.setNroMes(8); // digo que es la compra en agosto
		cliente.sumarCompra(compra);

		Assert.assertEquals(92.1, kiosco.calcularMontoACobrar(8, cliente), 0.000);
	}

	@Test
	public void kioscoEjemploSitioCaso2() throws Exception {

		Kiosco kiosco = new Kiosco();
		Cliente cliente = new Cliente("gabriel", "zulema 12, rosario");
		kiosco.agregarCliente(cliente);

		Compra compra = new Compra();
		compra.setNroMes(3); // digo que es la compra en mayo

		Compra compraConSuscripcion = new Suscripcion(); 
		
		((Suscripcion) compraConSuscripcion).activarAnualidad();

		Producto barcelona = new Revista("Barcelona", 20.0);
		((Revista) barcelona).setPeriodicidad(2);

		Producto pagina12 = new Periodico("pagina 12", 12.0);
		((Periodico) pagina12).setPeriodicidad(30);
		compra.agregarProducto(pagina12);
		compraConSuscripcion.agregarProducto(barcelona);

		cliente.sumarCompra(compra);
		cliente.sumarCompra(compraConSuscripcion);

		double valor = kiosco.calcularMontoACobrar(3, cliente);
		Assert.assertEquals(44.0, valor, 0.000);
	}

	@Test
	public void solo1SubcripcionAnualaBarcelona() throws Exception {

		Kiosco kiosco = new Kiosco();
		Cliente cliente = new Cliente("gabriel", "zulema 12, rosario");
		kiosco.agregarCliente(cliente);

		Compra compra = new Compra();
		compra.setNroMes(1); // digo que es la compra en enero

		Compra compraConSuscripcion = new Suscripcion(); 
		((Suscripcion) compraConSuscripcion).activarAnualidad();

		Producto barcelona = new Revista("Barcelona", 20.0);
		((Revista) barcelona).setPeriodicidad(2);

		compraConSuscripcion.agregarProducto(barcelona);

		cliente.sumarCompra(compraConSuscripcion);

		double valor = kiosco.calcularMontoACobrar(1, cliente);
		Assert.assertEquals(32.0, valor, 0.000);
	}

	@Test
	public void solo1SubcripcionNoAnualaBarcelona() throws Exception {

		Kiosco kiosco = new Kiosco();
		Cliente cliente = new Cliente("gabriel", "zulema 12, rosario");
		kiosco.agregarCliente(cliente);

		Compra compra = new Compra();
		compra.setNroMes(3); // digo que es la compra en mayo

		Compra compraConSuscripcion = new Suscripcion(); 

		Producto barcelona = new Revista("Barcelona", 20.0);
		((Revista) barcelona).setPeriodicidad(2);

		compraConSuscripcion.agregarProducto(barcelona);
		
		cliente.sumarCompra(compraConSuscripcion);

		double valor = kiosco.calcularMontoACobrar(3, cliente);
		Assert.assertEquals(40.0, valor, 0.000);
	}

	

}
