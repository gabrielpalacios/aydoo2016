package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Program {

	public static void main(String[] args) {

		System.out.print(obtenerFactoresPrimos(args));
	}

	public static String obtenerFactoresPrimos(String[] args) {
		List<String> lista = new ArrayList<String>();
		// carga lista:
		String nombreArchivo = "";
		String nombreFormat = "";
		String nombreSort = "";
		for (int i = 0; i < args.length; i++) {
			if (args[i].toLowerCase().startsWith("--output-file=")) {
				nombreArchivo = args[i].substring(14, args[i].length());
			} else {
				lista.add(args[i].toLowerCase());
			}
			// acumulando....
			if (args[i].toLowerCase().startsWith("--format=")) {
				nombreFormat = args[i].substring(9, args[i].length());
			}
			if (args[i].toLowerCase().startsWith("--sort:")) {
				nombreSort = args[i].substring(7, args[i].length());
			}
		}
		String devolucion = "";
		String devolucionTemp = "";

		if (args.length == 0) {
			devolucion = "Error! Ingrese el numero (para ver sus factores primos) por linea de comando";
			return devolucion;
		}
		// validar entradas y si estan mal rebotarlas
		if (!nombreFormat.equalsIgnoreCase("pretty") && !nombreFormat.equalsIgnoreCase("quiet") && !nombreFormat.equalsIgnoreCase("")) {
			devolucion = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
			return devolucion;
		}
		if (!nombreSort.equalsIgnoreCase("asc") && !nombreSort.equalsIgnoreCase("des") && !nombreSort.equalsIgnoreCase("")) {
			devolucion = "Formato no aceptado. Las opciones de sort posibles son: asc o des.";
			return devolucion;
		}

		int numero = Integer.parseInt(args[0]);
		Vector<Integer> vectorObtenido = FactoresPrimos.factor(numero);
		// ya los tengo en vector
		if ((lista.size() == 1) || (lista.size() == 2 && lista.contains("--format=pretty"))
				|| (lista.contains("--format=pretty") && lista.contains("--sort:asc"))) {

			devolucion = "Factores primos " + numero + ": ";
			for (int i = 0; i < vectorObtenido.size(); i++) {
				devolucionTemp += vectorObtenido.get(i).intValue() + " ";
			}
			devolucion = devolucion + devolucionTemp + "\n";
		} else {
			if ((lista.contains("--format=pretty") && lista.contains("--sort:des"))) {
				// invertido pretty
				devolucion = "Factores primos " + numero + ": ";
				int tamano = vectorObtenido.size();
				for (int i = 0; i < vectorObtenido.size(); i++) {
					devolucionTemp += vectorObtenido.get(tamano - i - 1).intValue() + " ";
				}
				devolucion = devolucion + devolucionTemp + "\n";
			}
			if ((lista.size() == 2 && lista.contains("--format=quiet")) || (lista.contains("--format=quiet") && lista.contains("--sort:asc"))) {

				for (int i = 0; i < vectorObtenido.size(); i++) {
					devolucionTemp += vectorObtenido.get(i).intValue() + "\n";
				}
				devolucion = devolucion + devolucionTemp;
			} else {
				if (lista.contains("--format=quiet") && lista.contains("--sort:des")) {
					// solo quiet desc
					int tamano = vectorObtenido.size();
					for (int i = 0; i < vectorObtenido.size(); i++) {
						devolucionTemp += vectorObtenido.get(tamano - i - 1).intValue() + "\n";
					}
					devolucion = devolucion + devolucionTemp;
				}
			}
		}
		if (nombreArchivo != "") {

			imprimirFile(nombreArchivo, devolucion);
			devolucion = "";
		}
		return devolucion;
	}

	private static void imprimirFile(String nombreArchivo, String devolucion) {
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(nombreArchivo);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(devolucion);
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + nombreArchivo + "'");
		}
	}
}
