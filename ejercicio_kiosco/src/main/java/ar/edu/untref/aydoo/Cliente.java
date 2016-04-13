package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String direccion;
	private List<Compra> itemsComprados;

	public Cliente(String nombre, String direccion) {

		this.setNombre(nombre);
		this.setDireccion(direccion);
		//creo vacia....
		this.itemsComprados = new ArrayList<Compra>();
	}

	public List<Compra> getItemsCompradosEnMes(int mes) {

		List<Compra> itemsCompradosEnMes = new ArrayList<Compra>();

		for(Compra unaCompra : this.itemsComprados){
			if(unaCompra.getNroMes()  == 0   || unaCompra.getNroMes() == mes){
				itemsCompradosEnMes.add(unaCompra);
			}
		}
		return itemsCompradosEnMes;
	}
	
	public void sumarCompra(Compra compra) {

		this.itemsComprados.add(compra);
	}

	public boolean contieneCompraDeterminada(Compra compraDeterminada) {

		return this.itemsComprados.contains(compraDeterminada);
	}

	
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getNombre() {

		return this.nombre;
	}

	public void setDireccion(String direccion) {

		this.direccion = direccion;
	}

	public String getDireccion() {

		return this.direccion;
	}

	
	

}
