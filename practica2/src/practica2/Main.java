package practica2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Juguete> inventario = new ArrayList<Juguete>();
		String nombreJuguete;
		Long idEmpresa;
		inventario.add(new Juguete(123L, "Hasbro", "juguete1", 34.0, 15));
		inventario.add(new Juguete(456L, "BandaiNamco", "juguete2", 70.50, 10));
		
		Scanner input = new Scanner(System.in);
		Boolean salir = false;
		while(!salir) {
			Boolean encontrado = false;
			System.out.println("==Juguetería==\r\n"
					+ "1.Ingresar nueva adquisisión\r\n"
					+ "2.Listar Juguetes en Inventario\r\n"
					+ "3.Vender Juguetes\r\n"
					+ "4.Stock de Productos\r\n"
					+ "0.Salir\r\n"
					+ "Ingrese una Opción");
			String opcion = input.next();
			
		
			switch (opcion) {
			case "1":
				System.out.println("Identificador: ");
				idEmpresa = input.nextLong();
				System.out.println("Fabricante: ");
				String nombreEmpresa = input.next();
				System.out.println("Nombre del juguete: ");
				nombreJuguete = input.next();
				System.out.println("Precio: ");
				Double precio = input.nextDouble();
				System.out.println("Cantidad: ");
				Integer cantidad = input.nextInt();
				
				for (Juguete juguete : inventario) {
					if (idEmpresa.equals(juguete.getID()) || nombreJuguete.equals(juguete.getNombre())) {
						encontrado = true;
					}
				}
				
				if (encontrado) {
					System.out.println("Producto ya en almacen");
				}else {
					inventario.add(new Juguete(idEmpresa, nombreEmpresa, nombreJuguete, precio, cantidad));
					System.out.println("Producto ingresado con exito");
				}
				
				break;
			case "2":
				for (Juguete juguete : inventario) {
					juguete.mostrarDatos();
				}
				break;
			case "3":
				System.out.println("Nombre del juguete: ");
				nombreJuguete = input.next();
				System.out.println("Cantidad a comprar: ");
				Integer cantidadComprar = input.nextInt();
				for (Juguete juguete : inventario) {
					if (juguete.getNombre().equals(nombreJuguete) && cantidadComprar <= juguete.getStock()) {
						juguete.reStock(juguete.getStock()-cantidadComprar);
						juguete.ventas(cantidadComprar);
						encontrado=true;
					}
				}
				
				if(!encontrado) {
					System.out.println("Producto fuera de stock");
				}
				
				break;
			case "4":
				System.out.println("Identificador del Producto: ");
				idEmpresa = input.nextLong();
				System.out.println("Nombre del Juguete: ");
				nombreJuguete = input.next();
				System.out.println("Unidades a agregar: ");
				Integer unidadesAgregar = input.nextInt();
				for (Juguete juguete : inventario) {
					if (idEmpresa.equals(juguete.getID()) && nombreJuguete.equals(juguete.getNombre()) && juguete.getStock().equals(0)) {
						juguete.reStock(unidadesAgregar);
						encontrado = true;
					}
				}
				
				if(encontrado) {
					System.out.println("Pedido Procesado, Entregados y listos para la venta: #"+unidadesAgregar+" unidades");
				}else {
					System.out.println("Producto aun en stock");
				}
				break;
			case "0":
				System.out.println("Desea salir s/n: ");
				String res = input.next();
				if (res.equals("s")) {
					System.out.println("Gracias por usar nuestros servicios");
					salir = true;
					input.close();
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
	}
}
