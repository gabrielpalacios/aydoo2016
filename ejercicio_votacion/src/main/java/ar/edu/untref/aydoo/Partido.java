package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

	private String nombrePartido;
	private List<Candidato> candidatos = new LinkedList<Candidato>();
	private List<Voto> votos = new LinkedList<Voto>();

	public String getNombre() {
		return nombrePartido;
	}

	public void setNombre(String nombreCargar) {
		this.nombrePartido = nombreCargar;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votosCargar) {
		this.votos = votosCargar;
	}
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatosCargar) {
		this.candidatos = candidatosCargar;
	}
	
	
	public Partido(String nombrePartido) {
		this.setNombre(nombrePartido);
	}

	public boolean esCandidatoValido(Candidato candidato){		
		return this.candidatos.contains(candidato);
	}

	public void sumarVoto(Voto voto) {
		this.votos.add(voto);
	}

	public int getCantidadVotosSacados() {
		return this.votos.size();
	}

	public void incorporarCandidato(Candidato candidato){		
		this.candidatos.add(candidato);
	}




}
