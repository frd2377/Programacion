package ejemplo1_Arraylist;

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
			System.out.println("REGISTRO DE VEHICULO\n1.-Registrar modelo\n2.-Registrar codigo\n3.-Registrar precio\n4.-Registrar Salir\nEliga una opcion");
			System.out.print(">> ");
			String opcion = scanner.nextLine();
			switch (opcion.toString()) {
				case "1":
					System.out.println("Modelo: ");
					String modeloNom = scanner.next();
					modelos.add(modeloNom);
					break;
				case "2":
					System.out.println("Modelo: ");
					String codigosVal = scanner.next();
					codigos.add(Double.parseDouble(codigosVal));
					break;
				case "3":
				System.out.println("Modelo: ");
					String precioVal = scanner.next();
					precios.add(Double.parseDouble(precioVal));
					break;
				case "4":
					System.out.println("Saliendo");
					salir = false;
					scanner.close();
					break;
				default:
					System.out.println("error");
					break;
			}
		}
    }
}

