package ar.edu.untref.aydoo;
import java.util.Vector;

public class Program {

	public static void main(String[] args) {

		if (args.length != 0) {

			int numero = Integer.parseInt(args[0]);
			Vector<Integer> vectorObtenido = FactoresPrimos.factor(numero);
			// ya los tengo en vector


			// 1ero
			if (args.length == 1 || args[1].equalsIgnoreCase("--format=pretty")) {

				System.out.print("Factores primos " + numero + ": ");
				for (int i = 0; i < vectorObtenido.size(); i++) {
					System.out.print(vectorObtenido.get(i).intValue() + " ");
				}

				System.out.print("\n");
			} else

			{
				// 2do
				if (args[1].equalsIgnoreCase("--format=quiet")) {

					int tamano = vectorObtenido.size();
					for (int i = 0; i < vectorObtenido.size(); i++) {
						System.out.println(vectorObtenido.get(tamano - i -1)
								.intValue() + " ");
					}
				} else {

					System.out
							.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
				}
			}
		} else {

			System.out
					.println("Error! Ingrese el numero (para ver sus factores primos) por linea de comando");

		}
	}
}
