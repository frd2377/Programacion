package aerolinea;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Integer cedula;
	public static void main(String[] args) {
		Boleto boleto;
		ArrayList<Boleto> boletosComprados = new ArrayList<Boleto>();
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		while(true) {
			System.out.println("Aerolinea: ");
			System.out.println("1)Registrar\n2)Lista\n3)Consultar\n0)Salir: ");
			String opcion = input.next();
			if (opcion.equals("1")) {
				System.out.println("Pais de origen:");
				String pais_origen = input.next();
				System.out.println("Pais destino: ");
				String pais_destino = input.next();
				System.out.println("Nombre: ");
				String nombre = input.next();
				System.out.println("Cedula: ");
				cedula = input.nextInt();
				boleto = new Boleto(pais_origen, pais_destino, random.nextInt(1000), new Date(), new Date(), random.nextInt(100),new Pasajero(nombre, cedula));
				boletosComprados.add(boleto);
				System.out.println("Boleto comprado");
			}else if(opcion.equals("2")){
				for (Boleto bol : boletosComprados) {
					System.out.println(bol.toString());
				}
			}else if (opcion.equals("3")) {
				System.out.println("Cedula: ");
				cedula = input.nextInt();
				for (Boleto bol : boletosComprados) {
					if (bol.getCedula().equals(cedula)) {
						System.out.println(bol.toString());
					}
				}
			}else if(opcion.equals("0")) {
				System.out.println("Saliendo...");
				input.close();
				break;
			}
			System.out.println("");
		}
	}
}
