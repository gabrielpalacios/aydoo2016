package ar.edu.untref.aydoo;

public class Voto {

	private Candidato unCandidato;
	private Provincia unaProvincia;

	public void setCandidato(Candidato candidato) {
		this.unCandidato = candidato;		
	}
	
	public Candidato getCandidato() {
		return unCandidato;
	}

	public void setProvincia(Provincia provincia) {
		this.unaProvincia = provincia;
	}

	public Provincia getProvincia() {
		return unaProvincia;
	}
	
	public Voto(Candidato candidato, Provincia provincia) {
	
		this.setCandidato(candidato);		
		this.setProvincia(provincia);	
	}
	


	
}
