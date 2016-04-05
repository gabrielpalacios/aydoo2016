package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Eleccion {

	private List<Provincia> provincias;
	private List<Candidato> candidatos;

	public Eleccion() {

		this.candidatos = new LinkedList<Candidato>();
		this.provincias = new LinkedList<Provincia>();
	}

	public void cargaCandidato(Candidato candidato) {

		this.candidatos.add(candidato);
	}

	public boolean esCandidatoValido(Candidato candidato) {

		return this.candidatos.contains(candidato);
	}

	public int getCantidadDeCandidatos() {

		return this.candidatos.size();
	}

	public void cargaProvincia(Provincia provincia) {

		this.provincias.add(provincia);
	}

	public boolean esProvinciaValida(Provincia provincia) {

		return this.provincias.contains(provincia);
	}

	public int getCantidadDeProvincias() {

		return this.provincias.size();
	}

	public boolean votar(Voto voto) throws Exception {

		Provincia provincia = voto.getProvincia();
		Candidato candidato = voto.getCandidato();
		Partido partidoDelVoto = candidato.getPartido();

		// System.out.println(partidoDelCandidatoDelVoto.getNombre() +
		// candidatoDelVoto.getNombre() + provinciaDelVoto.getNombre() );

		if (this.esCandidatoValido(candidato)
				&& this.esProvinciaValida(provincia)) {

			int posProvincia = this.provincias
					.indexOf(provincia);
			this.provincias.get(posProvincia)
					.sumarVotoAlPartidoEnProvincia(
							partidoDelVoto, voto);

			int posCandidato = this.candidatos
					.indexOf(candidato);
			this.candidatos.get(posCandidato).sumarVoto(
					voto);

			return true;
		} 
		else 
		{
			return false;
		}
	}	
	
	public Partido getPartidoMasVotadoProvinciaDada(Provincia provincia) {

		Partido retorno = null;
		int posicionProvincia = this.provincias
				.indexOf(provincia);

		retorno = this.provincias.get(posicionProvincia)
				.getPartidoConMasVotos();
		return retorno;
	}

	public Candidato getCandidatoMasVotadoNacional() {
		
		int cantidadVotos = 0;
		Candidato candidatoMasVotado = null;
		ListIterator<Candidato> recorridoCandidatos = this.candidatos
				.listIterator();
		
		while (recorridoCandidatos.hasNext()) {

			Candidato c = recorridoCandidatos.next();

			if (c.getCantidadVotosSacados() > cantidadVotos) {

				candidatoMasVotado = c;
				cantidadVotos = c.getCantidadVotosSacados();
			}
		}
		return candidatoMasVotado;
	}



}
