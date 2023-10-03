package ejemplo1_arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arrayListejmp {
	public static void main(String[] args) {
		List<String> modelos = new ArrayList<String>();
		ArrayList<Double> codigos = new ArrayList<Double>();
		ArrayList<Double> precios = new ArrayList<Double>();

		Scanner scanner = new Scanner(System.in);
		Boolean salir = true;
		while (salir) {
			System.out.println(
					"REGISTRO DE VEHICULO\n1.-Registrar modelo\n2.-Registrar codigo\n3.-Registrar precio\n4.-Registrar Salir\nEliga una opcion");
			System.out.print(">> ");
			String opcion = scanner.nextLine();
			switch (opcion.toString()) {
				case "1":
					System.out.println("Modelo: ");
					String modeloNom = scanner.nextLine();
					modelos.add(modeloNom);
					break;
				case "2":
					System.out.println("Codigos: ");
					String codigosVal = scanner.nextLine();
					codigos.add(Double.parseDouble(codigosVal));
					break;
				case "3":
					System.out.println("Precios: ");
					String precioVal = scanner.nextLine();
					precios.add(Double.parseDouble(precioVal));
					break;
				case "4":
					System.out.println("Saliendo");
					salir = false;
					scanner.close();
					break;
				default:
					for (String modelo : modelos) {
						System.out.println(modelo);
					}
					for (Double codigo : codigos) {
						System.out.println(codigo);
					}
					for (Double precio : precios) {
						System.out.println(precio);
					}
					break;
			}
		}
	}
}

