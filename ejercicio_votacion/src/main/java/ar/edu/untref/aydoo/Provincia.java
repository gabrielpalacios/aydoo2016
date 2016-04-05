package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Provincia {

	private String nombreProvincia;
	private List<Partido> partidos = new LinkedList<Partido>();

	public String getNombre() {
		return nombreProvincia;
	}

	public void setNombre(String nombre) {
		this.nombreProvincia = nombre.toLowerCase();
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidosCargar)
	{
		this.partidos = partidosCargar;
	}
	
	public Provincia(String prov) {
		this.setNombre(prov);
	}

	public boolean tienePartido(Partido partido){
		return this.partidos.contains(partido);
	}

	public void sumarVotoAlPartidoEnProvincia(Partido partido, Voto voto) {
		//-----------------------------------------------
		
			int posicion = 0;
			posicion = this.partidos.indexOf(partido);
			Partido p = null;
			p = this.partidos.get(posicion);
			p.sumarVoto(voto);
		
	}	

	public Partido getPartido(Partido partido){

		Partido partidoObtenido = null;

		if(this.tienePartido(partido)){

			int posicionDelPartidoEnLaColeccion = this.partidos.indexOf(partido);
			partidoObtenido = this.partidos.get(posicionDelPartidoEnLaColeccion);
		}

		return partidoObtenido;
	}

	public void cargaPartido(Partido partido){		
		this.partidos.add(partido);
	}


	public Partido getPartidoConMasVotos(){
		//esto le pide a la provincia instanciada, que le diga el partido con + votos
		ListIterator<Partido> recorridoPartidos = this.partidos.listIterator();
		Partido partidoConMasVotos = null;
		int cantidadVotos = 0;

		while(recorridoPartidos.hasNext()){
			
			Partido p = recorridoPartidos.next();

			if(p.getCantidadVotosSacados() > cantidadVotos){ 

				partidoConMasVotos = p;

				cantidadVotos = p.getCantidadVotosSacados();
			}
		}

		return partidoConMasVotos;
	}



}
