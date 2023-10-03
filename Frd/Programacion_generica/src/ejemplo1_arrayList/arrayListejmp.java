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
		while (true) {
			System.out.println("REGISTRO DE VEHICULO\n1.-Registrar modelo\n2.-Registrar codigo\n3.-Registrar precio\n4.-Registrar Salir\nEliga una opcion");
			System.out.print(">> ");
			String opcion = scanner.nextLine();
			switch (opcion.toString()) {
				case "1":
					System.out.println("Modelo: ");
					String modeloNom = scanner.nextLine();
					modelos.add(modeloNom);
					break;
				case "2":
					System.out.println("Modelo: ");
					Double codigosVal = scanner.nextDouble();
					codigos.add(codigosVal);
					break;
				case "3":
				System.out.println("Modelo: ");
					Double precioVal = scanner.nextDouble();
					precios.add(precioVal);
					break;
				case "4":
					System.out.println("Saliendo");
					break;
				default:
					System.out.println("error");
					break;
			}
			if (opcion == "4") {
				scanner.close();
				break;
			}
		}
    }
}
