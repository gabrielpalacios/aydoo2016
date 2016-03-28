package ar.edu.untref.aydoo;

import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

public class FactoresPrimosTest{

	@Test
	public void testFactorizacionNumero_90(){
		
		Vector<Integer> vectorObtenido = FactoresPrimos.factor(90);
		
		Vector<Integer> vectorEsperado = new Vector<Integer>(4);
		vectorEsperado.add(2);
		vectorEsperado.add(3);
		vectorEsperado.add(3);
		vectorEsperado.add(5);
		Assert.assertEquals("Prueba exitosa", vectorEsperado, vectorObtenido);
	}
	
	@Test
	public void testFactorizacionNumero_360(){
		

		Vector<Integer> vectorObtenido = FactoresPrimos.factor(360);
		
		Vector<Integer> vectorEsperado = new Vector<Integer>();
		vectorEsperado.add(2);
		vectorEsperado.add(2);
		vectorEsperado.add(2);
		vectorEsperado.add(3);
		vectorEsperado.add(3);
		vectorEsperado.add(5);
		Assert.assertEquals("Prueba exitosa", vectorEsperado, vectorObtenido);
	}

	
}
