package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Candidato {

	private String nombreCandidato;
	private Partido suPartido;
	private List<Voto> votosSacados = new LinkedList<Voto>();


	public String getNombre() {
		return nombreCandidato;
	}

	public void setNombre(String nombre) {
		this.nombreCandidato = nombre;
	}

	public Partido getPartido() {
		return suPartido;
	}

	public void setPartido(Partido partido) {
		this.suPartido = partido;		
	}
	
	public Candidato(String string, Partido partido) {
		this.setNombre(string);
		this.setPartido(partido);
		this.suPartido.incorporarCandidato(this);
	}
	
	public void sumarVoto(Voto voto) {
		this.votosSacados.add(voto);
	}	
	
	public int getCantidadVotosSacados() {
		return this.votosSacados.size();
	}
	

	public List<Voto> getColeccionVotosSacados() {
		return votosSacados;
	}

	public void setColeccionVotosSacados(List<Voto> coleccionVotos) {
		this.votosSacados = coleccionVotos;
	}

}
