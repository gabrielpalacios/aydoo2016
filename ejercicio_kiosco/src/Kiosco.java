package ar.edu.untref.aydoo;

import java.util.List;
import java.util.ArrayList;

public class Kiosco {

	private List<Cliente> clientesHabituales;

	public Kiosco() {
		this.clientesHabituales = new ArrayList<Cliente>();
	}

	public Double calcularMontoACobrar(int mes, Cliente cliente) {

		List<Compra> comprasMes = cliente.getItemsCompradosEnMes(mes);
		Double contador = 0.0;
		for(Compra unaCompra : comprasMes){
			contador = unaCompra.getPrecio() + contador;
		}
		return contador;
	}
	
	public void agregarCliente(Cliente cliente) {

		this.clientesHabituales.add(cliente);
	}

	public Boolean esClienteHabitual(Cliente cliente) {

		return this.clientesHabituales.contains(cliente);
	}

}
