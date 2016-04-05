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
	public void votosMismoCandidatoVariasProvincias() throws Exception {

		Voto voto1 = new Voto(macri, bsas);
		Voto voto2 = new Voto(macri, bsas);
		Voto voto5 = new Voto(macri, sanluis);
		Voto voto6 = new Voto(macri, sanluis);
		Voto voto7 = new Voto(macri, sanluis);
		Voto voto8 = new Voto(macri, sanluis);
		Voto voto9 = new Voto(macri, salta);

		eleccionGeneral.votar(voto1);
		eleccionGeneral.votar(voto2);
		eleccionGeneral.votar(voto5);
		eleccionGeneral.votar(voto6);
		eleccionGeneral.votar(voto7);
		eleccionGeneral.votar(voto8);
		eleccionGeneral.votar(voto9);

		Assert.assertEquals(7, macri.getCantidadVotosSacados());
	}
	
	
	
	
	@Test
	public void unicoVotoRealizado() throws Exception {

		Voto voto = new Voto(altamira, sanluis);
		eleccionGeneral.votar(voto);

		Assert.assertEquals(1, altamira.getCantidadVotosSacados());
	}
	
	
	@Test
	public void partidoMasVotadoEnSalta() throws Exception {

		Voto voto1 = new Voto(altamira, salta);
		Voto voto2 = new Voto(altamira, salta);
		Voto voto3 = new Voto(delcano, salta);
		Voto voto4 = new Voto(macri, salta);
		Voto voto5 = new Voto(macri, salta);
		Voto voto6 = new Voto(delcano, salta);
		Voto voto7 = new Voto(macri, salta);
		Voto voto8 = new Voto(altamira, salta);
		Voto voto9 = new Voto(macri, salta);

		eleccionGeneral.votar(voto1);
		eleccionGeneral.votar(voto2);
		eleccionGeneral.votar(voto3);
		eleccionGeneral.votar(voto4);
		eleccionGeneral.votar(voto5);
		eleccionGeneral.votar(voto6);
		eleccionGeneral.votar(voto7);
		eleccionGeneral.votar(voto8);
		eleccionGeneral.votar(voto9);

		Assert.assertEquals(fit,
				eleccionGeneral.getPartidoMasVotadoProvinciaDada(salta));
	}
	
		@Test
	public void candidatoMasVotadoNacional() throws Exception {

		Voto voto1 = new Voto(altamira, bsas);
		Voto voto2 = new Voto(altamira, salta);
		Voto voto3 = new Voto(macri, sanluis);
		Voto voto4 = new Voto(macri, sanluis);
		Voto voto5 = new Voto(delcano, sanluis);
		Voto voto6 = new Voto(macri, bsas);
		Voto voto10 = new Voto(delcano, sanluis);
		Voto voto11 = new Voto(altamira, bsas);
		Voto voto12 = new Voto(altamira, bsas);
		Voto voto13 = new Voto(delcano, salta);
		Voto voto14 = new Voto(altamira, sanluis);

		eleccionGeneral.votar(voto1);
		eleccionGeneral.votar(voto2);
		eleccionGeneral.votar(voto3);
		eleccionGeneral.votar(voto4);
		eleccionGeneral.votar(voto5);
		eleccionGeneral.votar(voto6);
		eleccionGeneral.votar(voto10);
		eleccionGeneral.votar(voto11);
		eleccionGeneral.votar(voto12);
		eleccionGeneral.votar(voto13);
		eleccionGeneral.votar(voto14);

		Assert.assertEquals(altamira,
				eleccionGeneral.getCandidatoMasVotadoNacional());
	}

	
}