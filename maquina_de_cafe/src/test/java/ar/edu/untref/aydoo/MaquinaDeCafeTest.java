package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class MaquinaDeCafeTest {
	

	@Test
	public void testCafeteroSoloAgregoCafe(){
		
		
		Vaso vaso = new Vaso();
		Cafetero cafetero = new Cafetero();
		cafetero.prepararEnEsteVaso(vaso);
		
		Assert.assertTrue("Cafetero puso cafe al vaso", vaso.getCafe());
	}
	
	@Test
	public void testLecheroSoloAgregoLeche(){
		
	
		Vaso vaso = new Vaso();
		Lechero lechero = new Lechero();
		
		lechero.prepararEnEsteVaso(vaso);
				Assert.assertTrue("Lechero puso leche al vaso", vaso.getLeche());
	}
	
	@Test
	public void testExpendedoraPreparoCafeConLeche0DeAzucar (){
		
		MaquinaExpendedoraDeBebidas expendedora = new MaquinaExpendedoraDeBebidas();
		Vaso vaso = expendedora.hacerCafeConLecheConNDeAzucar(0);
		
		
		Assert.assertTrue("Cafetero puso cafe al vaso", vaso.getCafe());
		Assert.assertTrue("Lechero puso leche al vaso", vaso.getLeche());
		Assert.assertEquals("Azucarero puso 0 de azucar al vaso", 0, vaso.getAzucar());
	}
	
	@Test
	public void testExpendedoraPreparoCafeConLeche4DeAzucar (){
		
		MaquinaExpendedoraDeBebidas expendedora = new MaquinaExpendedoraDeBebidas();
		Vaso vaso = expendedora.hacerCafeConLecheConNDeAzucar(4);
		
		
		Assert.assertTrue("Cafetero puso cafe al vaso", vaso.getCafe());
		Assert.assertTrue("Lechero puso leche al vaso", vaso.getLeche());
		Assert.assertEquals("Azucarero puso 4 de azucar al vaso", 4, vaso.getAzucar());
	}
	
	@Test
	public void testFalsaAzucarAlVaso(){
		Vaso vaso = new Vaso();
		Azucarero azucarero =  new Azucarero();
		
		azucarero.ponerNEnEsteVaso (0, vaso);
		
		Assert.assertEquals("Azucarero no agrega azucar", 0, vaso.getAzucar());
	}
	
	
	
}
