package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProvinciaTest {

	@Test
	public void cargaDeUnaProvincia(){

		Provincia jujuy = new Provincia("jujuy");

		Assert.assertEquals("jujuy", jujuy.getNombre());
	}
	
	@Test
	public void chequearPartidoEnProvincia(){

		Provincia formosa = new Provincia("formosa");
		Partido jubilados = new Partido("jubilados");	
		Partido heroes = new Partido("heroes");	
		formosa.cargaPartido(jubilados);

		Assert.assertFalse(formosa.tienePartido(heroes));
	}

	@Test
	public void provinciaVaciaDePartido(){

		Provincia santafe = new Provincia("santafe");
		Partido pro = new Partido("pro");

		Assert.assertFalse(santafe.tienePartido(pro));
	}

	@Test
	public void provinciaPartidoOK(){

		Partido pj = new Partido("pj");
		Provincia sanjuan = new Provincia("sanjuan");
		sanjuan.cargaPartido(pj);

		Assert.assertTrue(sanjuan.tienePartido(pj));
	}
}
