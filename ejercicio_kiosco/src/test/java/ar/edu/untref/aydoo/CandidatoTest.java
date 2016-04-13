package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {
	
	@Test
	public void candidatoGomezAlPartido(){
		
		Partido sabio = new Partido("sabio");		
		Candidato gomez = new Candidato("gomez", sabio);
		
		Assert.assertTrue(gomez.getPartido().getCandidatos().contains(gomez));
	}
	
	@Test
	public void candidatoConNombre(){
		
		Partido isis = new Partido("isis");		
		Candidato segovia = new Candidato("segovia", isis);
		
		Assert.assertEquals("segovia", segovia.getNombre());
	}
	
	@Test
	public void candidatoConPartido(){
		
		Partido isis = new Partido("isis");		
		Candidato segovia = new Candidato("segovia", isis);
		
		Assert.assertEquals(isis, segovia.getPartido());
	}
}
