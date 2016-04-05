package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

	private Eleccion eleccionGeneral;

	// globales:
	// provincias
	private Provincia bsas = new Provincia("bsas");
	private Provincia sanluis = new Provincia("sanluis");
	private Provincia salta = new Provincia("salta");

	// partidos
	private Partido fit = new Partido("fit");
	private Partido cambiemos = new Partido("cambiemos");

	// candidatos
	private Candidato altamira = new Candidato("altamira", fit);
	private Candidato delcano = new Candidato("delcano", fit);
	private Candidato macri = new Candidato("macri", cambiemos);

	@Before
	public void cargaDeDatos() {

		eleccionGeneral = new Eleccion();

		eleccionGeneral.cargaProvincia(bsas);
		eleccionGeneral.cargaProvincia(sanluis);
		eleccionGeneral.cargaProvincia(salta);

		bsas.cargaPartido(fit);
		bsas.cargaPartido(cambiemos);
		sanluis.cargaPartido(fit);
		sanluis.cargaPartido(cambiemos);
		salta.cargaPartido(fit);
		salta.cargaPartido(cambiemos);

		eleccionGeneral.cargaCandidato(altamira);
		eleccionGeneral.cargaCandidato(macri);
		eleccionGeneral.cargaCandidato(delcano);

	}

	 
	
	
	@Test
	public void unicoVotoRealizado() throws Exception {

		Voto voto = new Voto(altamira, sanluis);
		eleccionGeneral.votar(voto);

		Assert.assertEquals(1, altamira.getCantidadVotosSacados());
	}
}