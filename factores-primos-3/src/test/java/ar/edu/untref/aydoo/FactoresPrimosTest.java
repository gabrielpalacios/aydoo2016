package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class FactoresPrimosTest {
	@Test
	public void testFactorizacionNumero_90() {
		Vector<Integer> vectorObtenido = FactoresPrimos.factor(90);
		Vector<Integer> vectorEsperado = new Vector<Integer>(4);
		vectorEsperado.add(2);
		vectorEsperado.add(3);
		vectorEsperado.add(3);
		vectorEsperado.add(5);
		Assert.assertEquals("Prueba exitosa", vectorEsperado, vectorObtenido);
	}

	@Test
	public void testFactorizacionNumero_360() {
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

	@Test
	public void testSoloNroIdemPretty() {
		String[] args = { "360" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("testSoloNroIdemPretty: " + recibo);
		String esperado = "Factores primos 360: 2 2 2 3 3 5 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void test2MasPretty() {
		String[] args = { "360", "--format=pretty" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Factores primos 360: 2 2 2 3 3 5 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void test3quietSinNadaMasSeriaIdemAsc() {
		String[] args = { "360", "--format=quiet" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test3quietSinNadaMasSeriaIdemDesc: " + recibo);
		String esperado = "2" + "\n" + "2" + "\n" + "2" + "\n" + "3" + "\n" + "3" + "\n" + "5" + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void test4quietSortDes() {
		String[] args = { "360", "--format=quiet", "--sort:des" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test4quietSortDes: " + recibo);
		String esperado = "5" + "\n" + "3" + "\n" + "3" + "\n" + "2" + "\n" + "2" + "\n" + "2" + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void test5quietSortAsc() {
		String[] args = { "360", "--format=quiet", "--sort:asc" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test5quietSortAsc: " + recibo);
		String esperado = "2" + "\n" + "2" + "\n" + "2" + "\n" + "3" + "\n" + "3" + "\n" + "5" + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testQuietSortAscSalidaQuiet() {
		String[] args = { "360", "--output-file=salidaquiet.txt", "--format=quiet", "--sort:asc" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("testQuietSortAscSalidaQuiet: " + recibo);
		String esperado = "";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void test6MasPrettyOutput() {
		String[] args = { "360", "--format=pretty", "--output-file=salida.txt" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test6MasPrettyOutput: " + recibo);
		String esperado = "";
		Assert.assertEquals(esperado, recibo);
	}

	@AfterClass
	public static void test7leertest6() {
		String recibo = "";
		String reciboQuiet = "";
		// The name of the file to open.
		String fileName = "salida.txt";
		String fileNameQuiet = "salidaquiet.txt";
		// This will reference one line at a time
		String line = null;
		String line2 = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			FileReader fileReaderQuiet = new FileReader(fileNameQuiet);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedReader bufferedReaderQuiet = new BufferedReader(fileReaderQuiet);
			while ((line = bufferedReader.readLine()) != null) {
				recibo += line;
			}
			while ((line2 = bufferedReaderQuiet.readLine()) != null) {
				reciboQuiet += line2 + "\n";
			}
			recibo += "\n";
			// Always close files.
			bufferedReader.close();
			bufferedReaderQuiet.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		System.out.println("test7leertest6recibo: " + recibo);
		System.out.println("test7leertest6reciboQuiet: " + reciboQuiet);
		String esperado = "Factores primos 360: 2 2 2 3 3 5 " + "\n";
		String esperado2Quiet = "2" + "\n" + "2" + "\n" + "2" + "\n" + "3" + "\n" + "3" + "\n" + "5" + "\n";
		Assert.assertEquals(esperado, recibo);
		Assert.assertEquals(esperado2Quiet, reciboQuiet);
	}

	@Test
	public void testSortAscQuiet() {
		String[] args = { "360", "--sort:asc", "--format=quiet" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test5quietSortAsc: " + recibo);
		String esperado = "2" + "\n" + "2" + "\n" + "2" + "\n" + "3" + "\n" + "3" + "\n" + "5" + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testSortDesQuiet() {
		String[] args = { "360", "--sort:des", "--format=quiet" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test4quietSortDes: " + recibo);
		String esperado = "5" + "\n" + "3" + "\n" + "3" + "\n" + "2" + "\n" + "2" + "\n" + "2" + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testPrettyAsc() {
		String[] args = { "360", "--format=pretty", "--sort:asc" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Factores primos 360: 2 2 2 3 3 5 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testAscPretty() {
		String[] args = { "360", "--sort:asc", "--format=pretty" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Factores primos 360: 2 2 2 3 3 5 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testPrettyDes() {
		String[] args = { "360", "--format=pretty", "--sort:DES" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Factores primos 360: 5 3 3 2 2 2 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testDesPretty() {
		String[] args = { "360", "--sort:DES", "--format=pretty" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Factores primos 360: 5 3 3 2 2 2 " + "\n";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testDesPrettySaraza() {
		String[] args = { "360", "--sort:DES", "--format=prettySaraza" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test2MasPretty: " + recibo);
		String esperado = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		Assert.assertEquals(esperado, recibo);
	}

	@Test
	public void testSortQuietAscLALA() {
		String[] args = { "360", "--format=quiet", "--sort:ascLALA" };
		String recibo = Program.obtenerFactoresPrimos(args);
		System.out.println("test5quietSortAsc: " + recibo);
		String esperado = "Formato no aceptado. Las opciones de sort posibles son: asc o des.";
		Assert.assertEquals(esperado, recibo);
	}
}
