package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {
	
	@Test
	public void partidoConUnCandidato(){

		Partido isis = new Partido("isis");		
		Candidato segovia = new Candidato("segovia", isis);

		Assert.assertTrue(isis.esCandidatoValido(segovia));		
	}

	@Test
	public void partidoCreacionYVerNombre(){

		Partido isis = new Partido("isis");		
	
		Assert.assertEquals("isis", isis.getNombre());
	}

	@Test
	public void partidoIsisConUnVoto(){
		
		Partido isis = new Partido("isis");		
		Candidato segovia = new Candidato("segovia", isis);
		Provincia bsas = new Provincia("bsas");		
		Voto unVoto = new Voto(segovia, bsas);
		
		isis.sumarVoto(unVoto);
		
		Assert.assertEquals(1, isis.getCantidadVotosSacados());
	}
	
}
